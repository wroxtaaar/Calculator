package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TextViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: compiled from: TextViewCompat.java */
    private static class a implements ActionMode.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ActionMode.Callback f1217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextView f1218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Class<?> f1219c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Method f1220d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f1221e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f1222f = false;

        a(ActionMode.Callback callback, TextView textView) {
            this.f1217a = callback;
            this.f1218b = textView;
        }

        private Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent b(ResolveInfo resolveInfo, TextView textView) {
            Intent intentPutExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !d(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return intentPutExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        private List<ResolveInfo> c(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(a(), 0)) {
                if (e(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        private boolean d(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        private boolean e(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            return str == null || context.checkSelfPermission(str) == 0;
        }

        private void f(Menu menu) {
            Context context = this.f1218b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f1222f) {
                this.f1222f = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f1219c = cls;
                    this.f1220d = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.f1221e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f1219c = null;
                    this.f1220d = null;
                    this.f1221e = false;
                }
            }
            try {
                Method declaredMethod = (this.f1221e && this.f1219c.isInstance(menu)) ? this.f1220d : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List<ResolveInfo> listC = c(context, packageManager);
                for (int i3 = 0; i3 < listC.size(); i3++) {
                    ResolveInfo resolveInfo = listC.get(i3);
                    menu.add(0, 0, i3 + 100, resolveInfo.loadLabel(packageManager)).setIntent(b(resolveInfo, this.f1218b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f1217a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f1217a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f1217a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            f(menu);
            return this.f1217a.onPrepareActionMode(actionMode, menu);
        }
    }

    public static Drawable[] a(TextView textView) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (i3 < 17) {
            return textView.getCompoundDrawables();
        }
        boolean z2 = textView.getLayoutDirection() == 1;
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (z2) {
            Drawable drawable = compoundDrawables[2];
            Drawable drawable2 = compoundDrawables[0];
            compoundDrawables[0] = drawable;
            compoundDrawables[2] = drawable2;
        }
        return compoundDrawables;
    }

    public static int b(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int c(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    private static int d(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    private static TextDirectionHeuristic e(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            return (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        boolean z2 = textView.getLayoutDirection() == 1;
        switch (textView.getTextDirection()) {
            case 2:
                return TextDirectionHeuristics.ANYRTL_LTR;
            case 3:
                return TextDirectionHeuristics.LTR;
            case 4:
                return TextDirectionHeuristics.RTL;
            case 5:
                return TextDirectionHeuristics.LOCALE;
            case 6:
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            case 7:
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            default:
                return z2 ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
    }

    public static c0.c.a f(TextView textView) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            return new c0.c.a(textView.getTextMetricsParams());
        }
        c0.c.a.C0032a c0032a = new c0.c.a.C0032a(new TextPaint(textView.getPaint()));
        if (i3 >= 23) {
            c0032a.b(textView.getBreakStrategy());
            c0032a.c(textView.getHyphenationFrequency());
        }
        if (i3 >= 18) {
            c0032a.d(e(textView));
        }
        return c0032a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(TextView textView, ColorStateList colorStateList) {
        d0.i.c(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintList(colorStateList);
        } else if (textView instanceof k) {
            ((k) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void h(TextView textView, PorterDuff.Mode mode) {
        d0.i.c(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintMode(mode);
        } else if (textView instanceof k) {
            ((k) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void i(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
            return;
        }
        if (i3 < 17) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
            return;
        }
        boolean z2 = textView.getLayoutDirection() == 1;
        Drawable drawable5 = z2 ? drawable3 : drawable;
        if (!z2) {
            drawable = drawable3;
        }
        textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
    }

    public static void j(TextView textView, int i3) {
        d0.i.b(i3);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 28) {
            textView.setFirstBaselineToTopHeight(i3);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i5 = (i4 < 16 || textView.getIncludeFontPadding()) ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i3 > Math.abs(i5)) {
            textView.setPadding(textView.getPaddingLeft(), i3 + i5, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void k(TextView textView, int i3) {
        d0.i.b(i3);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i4 = (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i3 > Math.abs(i4)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i3 - i4);
        }
    }

    public static void l(TextView textView, int i3) {
        d0.i.b(i3);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i3 != fontMetricsInt) {
            textView.setLineSpacing(i3 - fontMetricsInt, 1.0f);
        }
    }

    public static void m(TextView textView, c0.c cVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(cVar.b());
        } else {
            if (!f(textView).a(cVar.a())) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
            textView.setText(cVar);
        }
    }

    public static void n(TextView textView, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i3);
        } else {
            textView.setTextAppearance(textView.getContext(), i3);
        }
    }

    public static void o(TextView textView, c0.c.a aVar) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 18) {
            textView.setTextDirection(d(aVar.d()));
        }
        if (i3 >= 23) {
            textView.getPaint().set(aVar.e());
            textView.setBreakStrategy(aVar.b());
            textView.setHyphenationFrequency(aVar.c());
        } else {
            float textScaleX = aVar.e().getTextScaleX();
            textView.getPaint().set(aVar.e());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
        }
    }

    public static ActionMode.Callback p(TextView textView, ActionMode.Callback callback) {
        int i3 = Build.VERSION.SDK_INT;
        return (i3 < 26 || i3 > 27 || (callback instanceof a)) ? callback : new a(callback, textView);
    }
}
