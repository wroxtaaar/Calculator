#!/usr/bin/env python3
"""Turn an apktool-decoded Vivo Calculator (./work) into a standalone, trimmed-down clone.

Run from the repository root by .github/workflows/repackage-vivo-calculator.yml.
Environment: NEW_PKG, APP_LABEL, optional WORK_DIR (default "work").
"""
import os
import pathlib
import re
import sys
import xml.etree.ElementTree as ET

NEW_PKG = os.environ["NEW_PKG"]
APP_LABEL = os.environ["APP_LABEL"]
WORK = pathlib.Path(os.environ.get("WORK_DIR", "work"))

ANDROID_NS = "http://schemas.android.com/apk/res/android"
HELPER_CLASS = "com.mycalc.vivoclone.mods.Boot"

# Screens and providers that only exist for the exchange-rate feature.
REMOVE_ACTIVITIES = {
    "com.vivo.calculator.ExchangeActivity",
    "com.vivo.calculator.exchangelist.CountryList",
    "com.vivo.calculator.exchangelist.CountryListSearchResult",
}
REMOVE_PROVIDERS = {"com.vivo.calculator.helper.CountryProvide"}

# Toggle buttons that lead to scientific mode and to the exchange screen.
HIDDEN_VIEW_IDS = ("calculator_mode_toge_button", "exchange_toge_button")


def a(name):
    return "{%s}%s" % (ANDROID_NS, name)


def patch_manifest():
    path = WORK / "AndroidManifest.xml"
    text = path.read_text(encoding="utf-8")
    if 'package="com.vivo.calculator"' not in text:
        sys.exit("unexpected manifest: package attribute not found")

    text = text.replace('package="com.vivo.calculator"', 'package="%s"' % NEW_PKG, 1)
    # would clash with the system calculator's own permission and block installation
    text = text.replace(
        "com.vivo.abe.permission.exidentifier.provider",
        "%s.permission.exidentifier.provider" % NEW_PKG,
    )
    # don't compete with the system calculator for "open a calculator" requests
    text = re.sub(
        r'\s*<category android:name="android.intent.category.APP_CALCULATOR"\s*/>', "", text
    )
    path.write_text(text, encoding="utf-8")

    ET.register_namespace("android", ANDROID_NS)
    tree = ET.parse(path)
    app = tree.getroot().find("application")
    if app is None:
        sys.exit("manifest has no <application>")

    removed = []
    for element in list(app):
        name = element.get(a("name"))
        if (element.tag == "activity" and name in REMOVE_ACTIVITIES) or (
            element.tag == "provider" and name in REMOVE_PROVIDERS
        ):
            app.remove(element)
            removed.append(name)

    locked = False
    for element in app.findall("activity"):
        if element.get(a("name")) == "com.vivo.calculator.Calculator":
            # landscape is what switches the calculator to scientific mode
            element.set(a("screenOrientation"), "portrait")
            locked = True

    # starts the add-on (history count, keeps buttons hidden)
    helper = ET.SubElement(app, "provider")
    helper.set(a("name"), HELPER_CLASS)
    helper.set(a("authorities"), "%s.boot" % NEW_PKG)
    helper.set(a("exported"), "false")
    helper.set(a("initOrder"), "1000")

    tree.write(path, encoding="utf-8", xml_declaration=True)
    print("manifest: package ->", NEW_PKG)
    print("manifest: removed", len(removed), "component(s):", ", ".join(removed) or "none")
    print("manifest: Calculator locked to portrait:", locked)
    if len(removed) != len(REMOVE_ACTIVITIES) + len(REMOVE_PROVIDERS):
        print("WARNING: expected to remove %d components" % (len(REMOVE_ACTIVITIES) + len(REMOVE_PROVIDERS)))
    if not locked:
        sys.exit("Calculator activity not found in manifest")


def hide_buttons_in_layouts():
    ids = "|".join(HIDDEN_VIEW_IDS)
    start_tag = re.compile(r'<[\w.]+\s[^<>]*?android:id="@\+?id/(?:%s)"[^<>]*>' % ids)
    total = 0
    files = 0
    main_layout_hit = False
    for path in sorted(WORK.glob("res/layout*/*.xml")):
        text = path.read_text(encoding="utf-8")
        if not any(i in text for i in HIDDEN_VIEW_IDS):
            continue

        def make_gone(match):
            tag = match.group(0)
            if re.search(r'android:visibility="[^"]*"', tag):
                return re.sub(r'android:visibility="[^"]*"', 'android:visibility="gone"', tag)
            return re.sub(r"^(<[\w.]+)", r'\1 android:visibility="gone"', tag)

        new_text, count = start_tag.subn(make_gone, text)
        if count:
            path.write_text(new_text, encoding="utf-8")
            total += count
            files += 1
            if path.parent.name == "layout" and path.name == "activity_calculator_port.xml":
                main_layout_hit = True
    print("layouts: hid %d button(s) in %d file(s)" % (total, files))
    if not main_layout_hit:
        sys.exit("activity_calculator_port.xml was not patched, layout format is not what was expected")


def set_launcher_label():
    changed = 0
    for path in WORK.glob("res/values*/strings.xml"):
        text = path.read_text(encoding="utf-8")
        new_text = re.sub(
            r'(<string name="app_name">)[^<]*(</string>)',
            lambda m: m.group(1) + APP_LABEL + m.group(2),
            text,
        )
        if new_text != text:
            path.write_text(new_text, encoding="utf-8")
            changed += 1
    print("label: set to %r in %d strings file(s)" % (APP_LABEL, changed))


if __name__ == "__main__":
    patch_manifest()
    hide_buttons_in_layouts()
    set_launcher_label()
