package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
/* JADX INFO: loaded from: classes.dex */
class a0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final RectF f518l = new RectF();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap<String, Method> f519m = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static ConcurrentHashMap<String, Field> f520n = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f521a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f522b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f523c = -1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f524d = -1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f525e = -1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f526f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f527g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextPaint f528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TextView f529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Context f530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final c f531k;

    /* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
    private static class a extends c {
        a() {
        }

        @Override // androidx.appcompat.widget.a0.c
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) a0.r(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
    private static class b extends a {
        b() {
        }

        @Override // androidx.appcompat.widget.a0.a, androidx.appcompat.widget.a0.c
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.a0.c
        boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    /* JADX INFO: compiled from: AppCompatTextViewAutoSizeHelper.java */
    private static class c {
        c() {
        }

        void a(StaticLayout.Builder builder, TextView textView) {
        }

        boolean b(TextView textView) {
            return ((Boolean) a0.r(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    a0(TextView textView) {
        this.f529i = textView;
        this.f530j = textView.getContext();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            this.f531k = new b();
        } else if (i3 >= 23) {
            this.f531k = new a();
        } else {
            this.f531k = new c();
        }
    }

    private void A(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = typedArray.getDimensionPixelSize(i3, -1);
            }
            this.f526f = c(iArr);
            B();
        }
    }

    private boolean B() {
        int[] iArr = this.f526f;
        int length = iArr.length;
        boolean z2 = length > 0;
        this.f527g = z2;
        if (z2) {
            this.f521a = 1;
            this.f524d = iArr[0];
            this.f525e = iArr[length - 1];
            this.f523c = -1.0f;
        }
        return z2;
    }

    private boolean C(int i3, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f529i.getText();
        TransformationMethod transformationMethod = this.f529i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f529i)) != null) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f529i.getMaxLines() : -1;
        q(i3);
        StaticLayout staticLayoutE = e(text, (Layout.Alignment) r(this.f529i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (staticLayoutE.getLineCount() <= maxLines && staticLayoutE.getLineEnd(staticLayoutE.getLineCount() - 1) == text.length())) && ((float) staticLayoutE.getHeight()) <= rectF.bottom;
    }

    private boolean D() {
        return !(this.f529i instanceof k);
    }

    private void E(float f3, float f4, float f5) throws IllegalArgumentException {
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f3 + "px) is less or equal to (0px)");
        }
        if (f4 <= f3) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f4 + "px) is less or equal to minimum auto-size text size (" + f3 + "px)");
        }
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f5 + "px) is less or equal to (0px)");
        }
        this.f521a = 1;
        this.f524d = f3;
        this.f525e = f4;
        this.f523c = f5;
        this.f527g = false;
    }

    private static <T> T a(Object obj, String str, T t3) {
        try {
            Field fieldO = o(str);
            return fieldO == null ? t3 : (T) fieldO.get(obj);
        } catch (IllegalAccessException e3) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e3);
            return t3;
        }
    }

    private int[] c(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i3 : iArr) {
            if (i3 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i3)) < 0) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = ((Integer) arrayList.get(i4)).intValue();
        }
        return iArr2;
    }

    private void d() {
        this.f521a = 0;
        this.f524d = -1.0f;
        this.f525e = -1.0f;
        this.f523c = -1.0f;
        this.f526f = new int[0];
        this.f522b = false;
    }

    private StaticLayout f(CharSequence charSequence, Layout.Alignment alignment, int i3, int i4) {
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f528h, i3);
        StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(this.f529i.getLineSpacingExtra(), this.f529i.getLineSpacingMultiplier()).setIncludePad(this.f529i.getIncludeFontPadding()).setBreakStrategy(this.f529i.getBreakStrategy()).setHyphenationFrequency(this.f529i.getHyphenationFrequency());
        if (i4 == -1) {
            i4 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i4);
        try {
            this.f531k.a(builderObtain, this.f529i);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return builderObtain.build();
    }

    private StaticLayout g(CharSequence charSequence, Layout.Alignment alignment, int i3) {
        return new StaticLayout(charSequence, this.f528h, i3, alignment, ((Float) a(this.f529i, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) a(this.f529i, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) a(this.f529i, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    private StaticLayout h(CharSequence charSequence, Layout.Alignment alignment, int i3) {
        return new StaticLayout(charSequence, this.f528h, i3, alignment, this.f529i.getLineSpacingMultiplier(), this.f529i.getLineSpacingExtra(), this.f529i.getIncludeFontPadding());
    }

    private int i(RectF rectF) {
        int length = this.f526f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i3 = 0;
        int i4 = 1;
        int i5 = length - 1;
        while (true) {
            int i6 = i4;
            int i7 = i3;
            i3 = i6;
            while (i3 <= i5) {
                int i8 = (i3 + i5) / 2;
                if (C(this.f526f[i8], rectF)) {
                    i4 = i8 + 1;
                } else {
                    i7 = i8 - 1;
                    i5 = i7;
                }
            }
            return this.f526f[i7];
        }
    }

    private static Field o(String str) {
        try {
            Field declaredField = f520n.get(str);
            if (declaredField == null && (declaredField = TextView.class.getDeclaredField(str)) != null) {
                declaredField.setAccessible(true);
                f520n.put(str, declaredField);
            }
            return declaredField;
        } catch (NoSuchFieldException e3) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e3);
            return null;
        }
    }

    private static Method p(String str) {
        try {
            Method declaredMethod = f519m.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                f519m.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e3) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e3);
            return null;
        }
    }

    static <T> T r(Object obj, String str, T t3) {
        try {
            return (T) p(str).invoke(obj, new Object[0]);
        } catch (Exception e3) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e3);
            return t3;
        }
    }

    private void x(float f3) {
        if (f3 != this.f529i.getPaint().getTextSize()) {
            this.f529i.getPaint().setTextSize(f3);
            boolean zIsInLayout = Build.VERSION.SDK_INT >= 18 ? this.f529i.isInLayout() : false;
            if (this.f529i.getLayout() != null) {
                this.f522b = false;
                try {
                    Method methodP = p("nullLayouts");
                    if (methodP != null) {
                        methodP.invoke(this.f529i, new Object[0]);
                    }
                } catch (Exception e3) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e3);
                }
                if (zIsInLayout) {
                    this.f529i.forceLayout();
                } else {
                    this.f529i.requestLayout();
                }
                this.f529i.invalidate();
            }
        }
    }

    private boolean z() {
        if (D() && this.f521a == 1) {
            if (!this.f527g || this.f526f.length == 0) {
                int iFloor = ((int) Math.floor((this.f525e - this.f524d) / this.f523c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i3 = 0; i3 < iFloor; i3++) {
                    iArr[i3] = Math.round(this.f524d + (i3 * this.f523c));
                }
                this.f526f = c(iArr);
            }
            this.f522b = true;
        } else {
            this.f522b = false;
        }
        return this.f522b;
    }

    void b() {
        if (s()) {
            if (this.f522b) {
                if (this.f529i.getMeasuredHeight() <= 0 || this.f529i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f531k.b(this.f529i) ? 1048576 : (this.f529i.getMeasuredWidth() - this.f529i.getTotalPaddingLeft()) - this.f529i.getTotalPaddingRight();
                int height = (this.f529i.getHeight() - this.f529i.getCompoundPaddingBottom()) - this.f529i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f518l;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float fI = i(rectF);
                    if (fI != this.f529i.getTextSize()) {
                        y(0, fI);
                    }
                }
            }
            this.f522b = true;
        }
    }

    StaticLayout e(CharSequence charSequence, Layout.Alignment alignment, int i3, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 23) {
            return f(charSequence, alignment, i3, i4);
        }
        return i5 >= 16 ? h(charSequence, alignment, i3) : g(charSequence, alignment, i3);
    }

    int j() {
        return Math.round(this.f525e);
    }

    int k() {
        return Math.round(this.f524d);
    }

    int l() {
        return Math.round(this.f523c);
    }

    int[] m() {
        return this.f526f;
    }

    int n() {
        return this.f521a;
    }

    void q(int i3) {
        TextPaint textPaint = this.f528h;
        if (textPaint == null) {
            this.f528h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f528h.set(this.f529i.getPaint());
        this.f528h.setTextSize(i3);
    }

    boolean s() {
        return D() && this.f521a != 0;
    }

    void t(AttributeSet attributeSet, int i3) {
        int resourceId;
        Context context = this.f530j;
        int[] iArr = a.j.AppCompatTextView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, 0);
        TextView textView = this.f529i;
        e0.t.k0(textView, textView.getContext(), iArr, attributeSet, typedArrayObtainStyledAttributes, i3, 0);
        int i4 = a.j.AppCompatTextView_autoSizeTextType;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            this.f521a = typedArrayObtainStyledAttributes.getInt(i4, 0);
        }
        int i5 = a.j.AppCompatTextView_autoSizeStepGranularity;
        float dimension = typedArrayObtainStyledAttributes.hasValue(i5) ? typedArrayObtainStyledAttributes.getDimension(i5, -1.0f) : -1.0f;
        int i6 = a.j.AppCompatTextView_autoSizeMinTextSize;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(i6) ? typedArrayObtainStyledAttributes.getDimension(i6, -1.0f) : -1.0f;
        int i7 = a.j.AppCompatTextView_autoSizeMaxTextSize;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(i7) ? typedArrayObtainStyledAttributes.getDimension(i7, -1.0f) : -1.0f;
        int i8 = a.j.AppCompatTextView_autoSizePresetSizes;
        if (typedArrayObtainStyledAttributes.hasValue(i8) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i8, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            A(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!D()) {
            this.f521a = 0;
            return;
        }
        if (this.f521a == 1) {
            if (!this.f527g) {
                DisplayMetrics displayMetrics = this.f530j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                E(dimension2, dimension3, dimension);
            }
            z();
        }
    }

    void u(int i3, int i4, int i5, int i6) throws IllegalArgumentException {
        if (D()) {
            DisplayMetrics displayMetrics = this.f530j.getResources().getDisplayMetrics();
            E(TypedValue.applyDimension(i6, i3, displayMetrics), TypedValue.applyDimension(i6, i4, displayMetrics), TypedValue.applyDimension(i6, i5, displayMetrics));
            if (z()) {
                b();
            }
        }
    }

    void v(int[] iArr, int i3) throws IllegalArgumentException {
        if (D()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i3 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f530j.getResources().getDisplayMetrics();
                    for (int i4 = 0; i4 < length; i4++) {
                        iArrCopyOf[i4] = Math.round(TypedValue.applyDimension(i3, iArr[i4], displayMetrics));
                    }
                }
                this.f526f = c(iArrCopyOf);
                if (!B()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f527g = false;
            }
            if (z()) {
                b();
            }
        }
    }

    void w(int i3) {
        if (D()) {
            if (i3 == 0) {
                d();
                return;
            }
            if (i3 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i3);
            }
            DisplayMetrics displayMetrics = this.f530j.getResources().getDisplayMetrics();
            E(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (z()) {
                b();
            }
        }
    }

    void y(int i3, float f3) {
        Context context = this.f530j;
        x(TypedValue.applyDimension(i3, f3, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
