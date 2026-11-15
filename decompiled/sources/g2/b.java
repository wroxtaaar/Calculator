package g2;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;
import com.vivo.calculator.BBKCalculatorApplication;
import com.vivo.seckeysdk.BuildConfig;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import vivo.util.VLog;

/* JADX INFO: compiled from: CalculatorUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4760a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4761b = "yes".equals(g.b("ro.vivo.product.overseas", BuildConfig.FLAVOR));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f4762c = e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f4763d = z();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f4764e = "2212";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f4765f = "2b";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f4766g = "221A";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f4767h = "28";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f4768i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f4769j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Toast f4770k = null;

    /* JADX INFO: compiled from: CalculatorUtils.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f4771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DisplayCutout f4772c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f4773d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f4774e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f4775f;

        a(View view, DisplayCutout displayCutout, int i3, boolean z2, Context context) {
            this.f4771b = view;
            this.f4772c = displayCutout;
            this.f4773d = i3;
            this.f4774e = z2;
            this.f4775f = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            DisplayCutout displayCutout;
            List<Rect> boundingRects;
            int safeInsetRight;
            int[] iArr = new int[2];
            this.f4771b.getLocationOnScreen(iArr);
            if (Build.VERSION.SDK_INT <= 30 || (displayCutout = this.f4772c) == null || (boundingRects = displayCutout.getBoundingRects()) == null || boundingRects.size() == 0) {
                return;
            }
            int safeInsetLeft = 0;
            if (3 == this.f4773d && iArr[0] > b.k()) {
                safeInsetRight = this.f4772c.getSafeInsetRight();
            } else if (1 == this.f4773d && iArr[0] == 0) {
                safeInsetLeft = this.f4774e ? this.f4772c.getSafeInsetLeft() - b.f(this.f4775f, 20.0f) : this.f4772c.getSafeInsetLeft();
                safeInsetRight = 0;
            } else {
                safeInsetRight = 0;
            }
            VLog.d("BBKCalculator/CalculatorUtils", "setLayoutPadding paddingLeft = " + safeInsetLeft + ", paddingRight = " + safeInsetRight);
            View view = this.f4771b;
            view.setPadding(safeInsetLeft, view.getPaddingTop(), safeInsetRight, this.f4771b.getPaddingBottom());
        }
    }

    public static void A(Context context, View view, int i3, DisplayCutout displayCutout, boolean z2) {
        view.postOnAnimationDelayed(new a(view, displayCutout, i3, z2, context), 50L);
    }

    public static void B(Context context, int i3) {
        VLog.d("BBKCalculator/CalculatorUtils", "showToast : mToast = " + f4770k + " , resId = " + i3);
        Toast toast = f4770k;
        if (toast == null) {
            f4770k = Toast.makeText(context.getApplicationContext(), i3, 0);
        } else {
            toast.setText(i3);
        }
        f4770k.show();
    }

    public static String C(String str, int i3, int i4) {
        try {
            return str.substring(i3, i4);
        } catch (StringIndexOutOfBoundsException e3) {
            VLog.d("BBKCalculator/CalculatorUtils", "subString , e : " + e3.getMessage());
            return BuildConfig.FLAVOR;
        }
    }

    public static String D(String str) {
        VLog.d("BBKCalculator/CalculatorUtils", "translateExpToOrd start,value:" + str);
        try {
            str = new BigDecimal(str).toPlainString();
        } catch (Exception e3) {
            VLog.d("BBKCalculator/CalculatorUtils", "translateExpToOrd exception:" + e3.getMessage());
        }
        VLog.d("BBKCalculator/CalculatorUtils", "translateExpToOrd end,value:" + str);
        return str;
    }

    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                VLog.d("BBKCalculator/CalculatorUtils", "checkAppExist");
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException e3) {
                VLog.d("BBKCalculator/CalculatorUtils", "check app:" + str + ",excepiton :" + e3.getMessage());
            }
        }
        return false;
    }

    public static boolean b(Context context) {
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "theme_customization_overlay_packages");
            return "1".equals((string == null ? new JSONObject() : new JSONObject(string)).optString("material_you_overlay_enable"));
        } catch (JSONException e3) {
            VLog.i("BBKCalculator/CalculatorUtils", "Failed to parse THEME_CUSTOMIZATION_OVERLAY_PACKAGES.", e3);
            return false;
        }
    }

    public static String c(String str) {
        return (TextUtils.isEmpty(str) || Locale.getDefault().toString().startsWith("ar_")) ? str : v(str, ",", ".", f4763d, f4762c);
    }

    public static String d(String str) {
        return (TextUtils.isEmpty(str) || Locale.getDefault().toString().startsWith("ar_")) ? str : v(str, f4763d, f4762c, ",", ".");
    }

    public static String e() {
        VLog.d("BBKCalculator/CalculatorUtils", "dotConvertToLocal getDefault:" + Locale.getDefault().toString());
        String strValueOf = !Locale.getDefault().toString().startsWith("ar_") ? String.valueOf(((DecimalFormat) DecimalFormat.getInstance(Locale.getDefault())).getDecimalFormatSymbols().getDecimalSeparator()) : ".";
        VLog.d("BBKCalculator/CalculatorUtils", "dotConvertToLocal :" + strValueOf);
        return strValueOf;
    }

    public static int f(Context context, float f3) {
        return (int) ((f3 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String g(String str) {
        if ((str == null ? 0 : str.length()) <= 0) {
            return str;
        }
        char cCharAt = str.charAt(str.length() - 1);
        return ("×".equals(String.valueOf(cCharAt)) || "÷".equals(String.valueOf(cCharAt))) ? str.substring(0, str.length() - 1) : str;
    }

    public static int h(float f3, int i3) {
        return (Math.min(255, Math.max(0, (int) (f3 * 255.0f))) << 24) + (i3 & 16777215);
    }

    public static String i() {
        return new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
    }

    public static int j() {
        int i3 = 1;
        try {
            i3 = Settings.Secure.getInt(BBKCalculatorApplication.a().getContentResolver(), "vivo_settings_density_index", 1);
            VLog.d("BBKCalculator/CalculatorUtils", "isMaxDisplaySizeTap .displaySizeTap : " + i3);
            return i3;
        } catch (Exception e3) {
            VLog.d("BBKCalculator/CalculatorUtils", "isMaxDefaultSizeTap exception:" + e3.getMessage());
            return i3;
        }
    }

    public static int k() {
        int identifier;
        BBKCalculatorApplication bBKCalculatorApplicationA = BBKCalculatorApplication.a();
        int i3 = Settings.Secure.getInt(bBKCalculatorApplicationA.getContentResolver(), "navigation_gesture_on", 0);
        if (i3 == 0) {
            if (f4768i < 0 && (identifier = bBKCalculatorApplicationA.getResources().getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
                f4768i = bBKCalculatorApplicationA.getResources().getDimensionPixelSize(identifier);
            }
            return f4768i;
        }
        if (i3 == 1 || i3 != 3 || Settings.Secure.getInt(bBKCalculatorApplicationA.getContentResolver(), "navigation_home_indicator_icon_style", 0) == 12) {
            return 0;
        }
        if (f4769j < 0) {
            Object objInvoke = null;
            try {
                Method declaredMethod = Class.forName("android.util.FtDeviceInfo").getDeclaredMethod("getGestureBarHeight", Context.class);
                declaredMethod.setAccessible(true);
                objInvoke = declaredMethod.invoke(null, bBKCalculatorApplicationA);
            } catch (ClassNotFoundException unused) {
                VLog.e("BBKCalculator/CalculatorUtils", "<InVokeMethodWithVoidArgs>,ClassNotFoundException");
            } catch (IllegalAccessException unused2) {
                VLog.e("BBKCalculator/CalculatorUtils", "<InVokeMethodWithVoidArgs>,IllegalAccessException");
            } catch (NoSuchMethodException unused3) {
                VLog.e("BBKCalculator/CalculatorUtils", "<InVokeMethodWithVoidArgs>,NoSuchMethodException");
            } catch (InvocationTargetException unused4) {
                VLog.e("BBKCalculator/CalculatorUtils", "<InVokeMethodWithVoidArgs>,InvocationTargetException");
            }
            if (objInvoke == null) {
                f4769j = 0;
            } else {
                f4769j = ((Integer) objInvoke).intValue();
            }
        }
        return f4769j;
    }

    public static StateListDrawable l(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[0], drawable);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawable2);
        return stateListDrawable;
    }

    public static float m(Context context, float f3) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f3);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        return fontMetrics.bottom - fontMetrics.top;
    }

    public static boolean n() {
        int i3 = -1;
        try {
            i3 = Settings.Secure.getInt(BBKCalculatorApplication.a().getContentResolver(), "vivo_settings_density_index", 1);
            VLog.d("BBKCalculator/CalculatorUtils", "isAboveDefaultSizeTap .displaySizeTap : " + i3);
        } catch (Exception e3) {
            VLog.d("BBKCalculator/CalculatorUtils", "isAboveDefaultSizeTap exception:" + e3.getMessage());
        }
        return i3 > 1;
    }

    public static boolean o(Context context) {
        try {
            return ((String) Class.forName("android.util.FtDeviceInfo").getDeclaredMethod("getDeviceType", new Class[0]).invoke(null, new Object[0])).equals("foldable") && !p(context);
        } catch (ClassNotFoundException | NoSuchMethodError | NoSuchMethodException e3) {
            VLog.e("BBKCalculator/CalculatorUtils", "no static method getDeviceType", e3);
            return false;
        } catch (IllegalAccessException e4) {
            VLog.e("BBKCalculator/CalculatorUtils", "no static method getDeviceType IllegalAccessException ", e4);
            return false;
        } catch (InvocationTargetException e5) {
            VLog.e("BBKCalculator/CalculatorUtils", "no static method getDeviceType InvocationTargetException ", e5);
            return false;
        }
    }

    private static boolean p(Context context) {
        Display display = ((DisplayManager) context.getSystemService("display")).getDisplay(0);
        try {
            Field declaredField = Display.class.getDeclaredField("mDisplayInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(display);
            Field declaredField2 = Class.forName("android.view.DisplayInfo").getDeclaredField("uniqueId");
            declaredField2.setAccessible(true);
            String str = (String) declaredField2.get(obj);
            if (str == null) {
                return false;
            }
            return "local:secondary".equals(str);
        } catch (Exception e3) {
            VLog.d("BBKCalculator/CalculatorUtils", "isFolderState Exception:" + e3.getMessage());
            return false;
        }
    }

    public static boolean q(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean r(String str) {
        if (str == null) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i3 = 0;
        char c3 = 0;
        while (i3 < length) {
            char c4 = charArray[i3];
            if (!h.b(String.valueOf(c4)) && !"×".equals(String.valueOf(c4)) && !"÷".equals(String.valueOf(c4)) && !"(".equals(String.valueOf(c4)) && !")".equals(String.valueOf(c4)) && ((!"-".equals(String.valueOf(c4)) && !"−".equals(String.valueOf(c4))) || (!"(".equals(String.valueOf(c3)) && !"\u0000".equals(String.valueOf(c3))))) {
                return false;
            }
            i3++;
            c3 = c4;
        }
        return true;
    }

    public static boolean s(Context context) {
        return Build.VERSION.SDK_INT > 29 && a(context, "com.vivo.smartmultiwindow");
    }

    public static boolean t(Context context) {
        AccessibilityManager accessibilityManager;
        return context != null && (accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility")) != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled();
    }

    public static boolean u(Context context) {
        Window window = ((Activity) context).getWindow();
        try {
            Class<?> cls = window.getClass();
            Method method = null;
            if (cls.getSuperclass() != null) {
                for (Method method2 : cls.getSuperclass().getDeclaredMethods()) {
                    if ("getWindowControllerCallback".equals(method2.getName())) {
                        method = method2;
                    }
                }
            }
            if (method == null) {
                VLog.e("BBKCalculator/CalculatorUtils", "<isWindowModeFreeForm> registerActivityObserver not implement in IActivityManager");
                return false;
            }
            Object objInvoke = method.invoke(window, new Object[0]);
            if (objInvoke == null) {
                return false;
            }
            for (Method method3 : objInvoke.getClass().getDeclaredMethods()) {
                if ("isInVivoFreeformMode".equals(method3.getName())) {
                    method = method3;
                }
            }
            if (method != null) {
                return ((Boolean) method.invoke(objInvoke, new Object[0])).booleanValue();
            }
            return false;
        } catch (Exception e3) {
            VLog.e("BBKCalculator/CalculatorUtils", "<isWindowModeFreeForm> registerActivityObserver-e = ", e3);
            return false;
        }
    }

    public static String v(String str, String str2, String str3, String str4, String str5) {
        Matcher matcher = Pattern.compile(str2 + "|" + str3).matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            if (matcher.group().equals(str2)) {
                matcher.appendReplacement(stringBuffer, str4);
            } else if (matcher.group().equals(str3)) {
                matcher.appendReplacement(stringBuffer, str5);
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static String w(Context context, String str) {
        if (TextUtils.isEmpty(str) || !t(context)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        String hexString = Integer.toHexString(cCharAt);
        if (!hexString.equalsIgnoreCase(f4767h)) {
            if (hexString.equals(f4764e)) {
                sb.append(context.getString(com.vivo.calculator.R.string.description_minus_sign));
            } else if (hexString.equalsIgnoreCase(f4766g)) {
                sb.append(context.getString(com.vivo.calculator.R.string.description_sqrt));
            } else {
                sb.append(cCharAt);
            }
        }
        char[] charArray = str.substring(1, str.length()).toCharArray();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            char c3 = charArray[i3];
            String hexString2 = Integer.toHexString(c3);
            if (hexString2.equals(f4764e)) {
                if (i3 == 0) {
                    if (hexString.equalsIgnoreCase(f4767h)) {
                        sb.append(context.getString(com.vivo.calculator.R.string.description_minus_sign));
                    } else {
                        sb.append(context.getString(com.vivo.calculator.R.string.description_minus));
                    }
                } else if (Integer.toHexString(charArray[i3 - 1]).equalsIgnoreCase(f4767h)) {
                    sb.append(context.getString(com.vivo.calculator.R.string.description_minus_sign));
                } else {
                    sb.append(context.getString(com.vivo.calculator.R.string.description_minus));
                }
            } else if (hexString2.equalsIgnoreCase(f4765f)) {
                sb.append(context.getString(com.vivo.calculator.R.string.description_plus));
            } else if (hexString2.equalsIgnoreCase(f4766g)) {
                sb.append(context.getString(com.vivo.calculator.R.string.description_sqrt));
            } else if (!hexString2.equalsIgnoreCase(f4767h)) {
                sb.append(c3);
            }
        }
        return sb.toString();
    }

    public static String x(double d3, int i3) {
        return new BigDecimal(d3).setScale(i3, 4).toPlainString();
    }

    public static void y(Context context, boolean z2) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.putBoolean("radflag", z2);
        editorEdit.apply();
    }

    public static String z() {
        VLog.d("BBKCalculator/CalculatorUtils", "sepConvertToLocal getDefault:" + Locale.getDefault().toString());
        String strValueOf = !Locale.getDefault().toString().startsWith("ar_") ? String.valueOf(((DecimalFormat) DecimalFormat.getInstance(Locale.getDefault())).getDecimalFormatSymbols().getGroupingSeparator()) : ",";
        VLog.d("BBKCalculator/CalculatorUtils", "sepConvertToLocal :" + strValueOf);
        return strValueOf;
    }
}
