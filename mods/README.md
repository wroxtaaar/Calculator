# mods/

Files in this folder are copied over the decoded original app right before it is rebuilt
(see `.github/workflows/repackage-vivo-calculator.yml`). The paths mirror the decoded app, so:

| To change            | Put the edited file at                      | Copy it from                                   |
|----------------------|---------------------------------------------|------------------------------------------------|
| a colour             | `mods/res/values/colors.xml`                | `decompiled/resources/res/values/colors.xml`   |
| dark-mode colour     | `mods/res/values-night/colors.xml`          | `decompiled/resources/res/values-night/...`    |
| a size or margin     | `mods/res/values/dimens.xml`                | `decompiled/resources/res/values/dimens.xml`   |
| a layout             | `mods/res/layout/activity_calculator_port.xml` | `decompiled/resources/res/layout/...`       |
| a key or icon shape  | `mods/res/drawable/<name>.xml`              | `decompiled/resources/res/drawable/...`        |

Only put the files you actually changed here; everything else stays original.
Pushing a change under `mods/` rebuilds the APK automatically.

Logic changes need smali (`mods/smali/...`), which is much harder to edit than resources.
