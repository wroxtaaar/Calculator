package com.vos.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.FloatProperty;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Locale;
import y1.c;
import y1.h;

/* JADX INFO: loaded from: classes.dex */
public class VRadialTimePickerView extends View {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static final int[] f4381b0 = {12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static final int[] f4382c0 = {0, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final int[] f4383d0 = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55};

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static final int[] f4384e0 = new int[361];

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static final float[] f4385f0 = new float[12];

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static final float[] f4386g0 = new float[12];
    private ObjectAnimator A;
    private float B;
    private boolean C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private String[] Q;
    private String[] R;
    private String[] S;
    private int T;
    private float U;
    private b V;
    private boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    boolean f4387a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FloatProperty<VRadialTimePickerView> f4392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String[] f4393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String[] f4394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String[] f4395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String[] f4396j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Paint[] f4397k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Paint f4398l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Paint[] f4399m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Paint f4400n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Typeface f4401o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int[] f4402p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int[] f4403q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int[] f4404r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final float[][] f4405s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final float[][] f4406t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final float[] f4407u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final float[] f4408v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int[] f4409w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Path f4410x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f4411y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f4412z;

    class a extends FloatProperty<VRadialTimePickerView> {
        a(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(VRadialTimePickerView vRadialTimePickerView) {
            return Float.valueOf(vRadialTimePickerView.B);
        }

        @Override // android.util.FloatProperty
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(VRadialTimePickerView vRadialTimePickerView, float f3) {
            vRadialTimePickerView.B = f3;
            vRadialTimePickerView.invalidate();
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object obj, Float f3) {
            super.set(obj, f3);
        }
    }

    interface b {
        void a(int i3, int i4, boolean z2);
    }

    static {
        y();
        double d3 = 1.5707963267948966d;
        for (int i3 = 0; i3 < 12; i3++) {
            f4385f0[i3] = (float) Math.cos(d3);
            f4386g0[i3] = (float) Math.sin(d3);
            d3 += 0.5235987755982988d;
        }
    }

    public VRadialTimePickerView(Context context) {
        super(context, null);
        this.f4392f = new a("hoursToMinutes");
        this.f4393g = new String[12];
        this.f4394h = new String[12];
        this.f4395i = new String[12];
        this.f4396j = new String[12];
        this.f4397k = new Paint[2];
        this.f4398l = new Paint();
        this.f4399m = new Paint[3];
        this.f4400n = new Paint();
        this.f4402p = new int[3];
        this.f4403q = new int[3];
        this.f4404r = new int[3];
        this.f4405s = (float[][]) Array.newInstance((Class<?>) float.class, 2, 12);
        this.f4406t = (float[][]) Array.newInstance((Class<?>) float.class, 2, 12);
        this.f4407u = new float[12];
        this.f4408v = new float[12];
        this.f4409w = new int[2];
        this.f4410x = new Path();
        this.W = true;
        this.f4387a0 = false;
    }

    private void A(int i3, boolean z2) {
        b bVar;
        this.f4409w[1] = (i3 % 60) * 6;
        invalidate();
        if (!z2 || (bVar = this.V) == null) {
            return;
        }
        bVar.a(1, i3, false);
    }

    private static int B(int i3, int i4) {
        int i5 = (i3 / 30) * 30;
        int i6 = i5 + 30;
        if (i4 != 1) {
            if (i4 == -1) {
                return i3 == i5 ? i5 - 30 : i5;
            }
            if (i3 - i5 < i6 - i3) {
                return i5;
            }
        }
        return i6;
    }

    private static int C(int i3) {
        int[] iArr = f4384e0;
        if (iArr == null) {
            return -1;
        }
        return iArr[i3];
    }

    private void c(boolean z2, long j3) {
        float f3 = z2 ? 0.0f : 1.0f;
        if (this.B != f3) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, this.f4392f, f3);
            this.A = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setAutoCancel(true);
            this.A.setDuration(j3);
            this.A.start();
            return;
        }
        ObjectAnimator objectAnimator = this.A;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.A.cancel();
        this.A = null;
    }

    private static void e(Paint paint, float f3, float f4, float f5, float f6, float[] fArr, float[] fArr2) {
        paint.setTextSize(f6);
        float fDescent = f5 - ((paint.descent() + paint.ascent()) / 2.0f);
        for (int i3 = 0; i3 < 12; i3++) {
            fArr[i3] = f4 - (f4385f0[i3] * f3);
            fArr2[i3] = fDescent - (f4386g0[i3] * f3);
        }
    }

    private void f() {
        e(this.f4397k[0], this.M - this.f4404r[0], this.K, this.L, this.f4403q[0], this.f4405s[0], this.f4406t[0]);
        if (this.f4411y) {
            e(this.f4397k[0], this.M - this.f4404r[2], this.K, this.L, this.f4403q[2], this.f4407u, this.f4408v);
        }
    }

    private void g() {
        e(this.f4397k[1], this.M - this.f4404r[1], this.K, this.L, this.f4403q[1], this.f4405s[1], this.f4406t[1]);
    }

    private void h(Canvas canvas, float f3) {
        this.f4398l.setAlpha((int) ((f3 * 255.0f) + 0.5f));
        canvas.drawCircle(this.K, this.L, this.G, this.f4398l);
    }

    private void i(Canvas canvas) {
        canvas.drawCircle(this.K, this.L, this.M, this.f4400n);
    }

    private void j(Canvas canvas, Path path, float f3) {
        int i3 = (int) (((1.0f - this.B) * 255.0f * f3) + 0.5f);
        if (i3 > 0) {
            canvas.save();
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            k(canvas, i3, false);
            canvas.restore();
            canvas.save();
            canvas.clipPath(path, Region.Op.INTERSECT);
            k(canvas, i3, true);
            canvas.restore();
        }
    }

    private void k(Canvas canvas, int i3, boolean z2) {
        String[] strArr;
        this.f4388b = true;
        this.f4389c = false;
        o(canvas, this.f4403q[0], this.f4401o, this.f4402p[0], this.Q, this.f4405s[0], this.f4406t[0], this.f4397k[0], i3, z2 && !this.C, this.f4409w[0], z2);
        if (!this.f4411y || (strArr = this.R) == null) {
            return;
        }
        o(canvas, this.f4403q[2], this.f4401o, this.f4402p[2], strArr, this.f4407u, this.f4408v, this.f4397k[0], i3, z2 && this.C, this.f4409w[0], z2);
    }

    private void l(Canvas canvas, Path path, float f3) {
        int i3 = (int) ((this.B * 255.0f * f3) + 0.5f);
        if (i3 > 0) {
            canvas.save();
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            m(canvas, i3, false);
            canvas.restore();
            canvas.save();
            canvas.clipPath(path, Region.Op.INTERSECT);
            m(canvas, i3, true);
            canvas.restore();
        }
    }

    private void m(Canvas canvas, int i3, boolean z2) {
        this.f4388b = false;
        this.f4389c = true;
        o(canvas, this.f4403q[1], this.f4401o, this.f4402p[1], this.S, this.f4405s[1], this.f4406t[1], this.f4397k[1], i3, z2, this.f4409w[1], z2);
    }

    private void n(Canvas canvas, Path path) {
        int i3 = this.C ? 2 : 0;
        int[] iArr = this.f4404r;
        int i4 = iArr[i3];
        int[] iArr2 = this.f4409w;
        int i5 = i3 % 2;
        int i6 = iArr2[i5];
        float f3 = iArr2[i5] % 30 != 0 ? 1.0f : 0.0f;
        int i7 = iArr[1];
        int i8 = iArr2[1];
        float f4 = iArr2[1] % 30 == 0 ? 0.0f : 1.0f;
        int i9 = this.D;
        float fB = this.M - x2.b.b(i4, i7, this.B);
        double radians = Math.toRadians(x2.b.c(i6, i8, this.B));
        float fSin = this.K + (((float) Math.sin(radians)) * fB);
        float fCos = this.L - (((float) Math.cos(radians)) * fB);
        Paint paint = this.f4399m[0];
        paint.setColor(this.H);
        float f5 = i9;
        canvas.drawCircle(fSin, fCos, f5, paint);
        if (path != null) {
            path.reset();
            path.addCircle(fSin, fCos, f5, Path.Direction.CCW);
        }
        float fB2 = x2.b.b(f3, f4, this.B);
        if (fB2 > 0.0f) {
            Paint paint2 = this.f4399m[1];
            paint2.setColor(this.I);
            canvas.drawCircle(fSin, fCos, this.F * fB2, paint2);
        }
        double dSin = Math.sin(radians);
        double dCos = Math.cos(radians);
        float f6 = fB - f5;
        int i10 = this.K;
        int i11 = this.G;
        double d3 = f6;
        float f7 = i10 + ((int) (((double) i11) * dSin)) + ((int) (dSin * d3));
        float f8 = (this.L - ((int) (((double) i11) * dCos))) - ((int) (d3 * dCos));
        Paint paint3 = this.f4399m[2];
        paint3.setColor(this.H);
        paint3.setStrokeWidth(this.E);
        canvas.drawLine(this.K, this.L, f7, f8, paint3);
    }

    private void o(Canvas canvas, float f3, Typeface typeface, int i3, String[] strArr, float[] fArr, float[] fArr2, Paint paint, int i4, boolean z2, int i5, boolean z3) {
        paint.setTextSize(f3);
        paint.setTypeface(typeface);
        float f4 = i5 / 30.0f;
        int i6 = (int) f4;
        int iCeil = ((int) Math.ceil(f4)) % 12;
        int i7 = 0;
        while (i7 < 12) {
            boolean z4 = i6 == i7 || iCeil == i7;
            if (!z3 || z4) {
                int iIntValue = Integer.valueOf(strArr[i7]).intValue();
                int currentHour = getCurrentHour();
                if (!this.C && currentHour == 0) {
                    currentHour = 12;
                }
                int i8 = (z4 && ((this.f4388b && iIntValue == currentHour) || (this.f4389c && iIntValue == getCurrentMinute()))) ? this.J : i3;
                paint.setColor(i8);
                paint.setAlpha(u(i8, i4));
                canvas.drawText(strArr[i7], fArr[i7], fArr2[i7], paint);
            }
            i7++;
        }
    }

    private int p(float f3, float f4, boolean z2) {
        int i3;
        int i4;
        if (this.f4411y && this.f4412z) {
            i4 = this.N;
            i3 = this.O;
        } else {
            int i5 = this.M - this.f4404r[!this.f4412z ? 1 : 0];
            int i6 = this.D;
            int i7 = i5 - i6;
            i3 = i5 + i6;
            i4 = i7;
        }
        double d3 = f3 - this.K;
        double d4 = f4 - this.L;
        double dSqrt = Math.sqrt((d3 * d3) + (d4 * d4));
        if (dSqrt < i4) {
            return -1;
        }
        if (z2 && dSqrt > i3) {
            return -1;
        }
        int degrees = (int) (Math.toDegrees(Math.atan2(d4, d3) + 1.5707963267948966d) + 0.5d);
        return degrees < 0 ? degrees + 360 : degrees;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0016, code lost:
    
        if (r2.T == 1) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return r3 + 12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
    
        if (r3 != 0) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int q(int r3, boolean r4) {
        /*
            r2 = this;
            int r3 = r3 / 30
            r0 = 12
            int r3 = r3 % r0
            boolean r1 = r2.f4411y
            if (r1 == 0) goto L13
            if (r4 != 0) goto Le
            if (r3 != 0) goto Le
            goto L1c
        Le:
            if (r4 == 0) goto L1b
            if (r3 == 0) goto L1b
            goto L18
        L13:
            int r2 = r2.T
            r4 = 1
            if (r2 != r4) goto L1b
        L18:
            int r0 = r3 + 12
            goto L1c
        L1b:
            r0 = r3
        L1c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vos.widget.VRadialTimePickerView.q(int, boolean):int");
    }

    private boolean r(int i3) {
        return this.f4411y && (i3 == 0 || i3 > 12);
    }

    private boolean s(float f3, float f4) {
        if (!this.f4411y || !this.f4412z) {
            return false;
        }
        double d3 = f3 - this.K;
        double d4 = f4 - this.L;
        return Math.sqrt((d3 * d3) + (d4 * d4)) <= ((double) this.P);
    }

    private int t(int i3) {
        return i3 / 6;
    }

    private int u(int i3, int i4) {
        return (int) ((((double) Color.alpha(i3)) * (((double) i4) / 255.0d)) + 0.5d);
    }

    private boolean v(float f3, float f4, boolean z2, boolean z3) {
        int currentMinute;
        boolean z4;
        int i3;
        boolean zS = s(f3, f4);
        int iP = p(f3, f4, false);
        if (iP == -1) {
            return false;
        }
        c(this.f4412z, 60L);
        if (this.f4412z) {
            int iB = B(iP, 0) % 360;
            z4 = (this.C == zS && this.f4409w[0] == iB) ? false : true;
            this.C = zS;
            this.f4409w[0] = iB;
            currentMinute = getCurrentHour();
            i3 = 0;
        } else {
            int iC = C(iP) % 360;
            int[] iArr = this.f4409w;
            boolean z5 = iArr[1] != iC;
            iArr[1] = iC;
            currentMinute = getCurrentMinute();
            z4 = z5;
            i3 = 1;
        }
        if (!z4 && !z2 && !z3) {
            return false;
        }
        b bVar = this.V;
        if (bVar != null) {
            bVar.a(i3, currentMinute, z3);
        }
        if (z4 || z2) {
            performHapticFeedback(4);
            invalidate();
        }
        return true;
    }

    private void w() {
        if (this.f4411y) {
            this.Q = this.f4394h;
            this.R = this.f4395i;
        } else {
            String[] strArr = this.f4393g;
            this.Q = strArr;
            this.R = strArr;
        }
        this.S = this.f4396j;
    }

    private void x() {
        for (int i3 = 0; i3 < 12; i3++) {
            String[] strArr = this.f4393g;
            int[] iArr = f4381b0;
            strArr[i3] = String.format("%d", Integer.valueOf(iArr[i3]));
            this.f4395i[i3] = String.format("%02d", Integer.valueOf(f4382c0[i3]));
            this.f4394h[i3] = String.format("%d", Integer.valueOf(iArr[i3]));
            this.f4396j[i3] = String.format("%02d", Integer.valueOf(f4383d0[i3]));
        }
    }

    private static void y() {
        int i3 = 1;
        int i4 = 8;
        int i5 = 0;
        for (int i6 = 0; i6 < 361; i6++) {
            f4384e0[i6] = i5;
            if (i3 == i4) {
                i5 += 6;
                i4 = i5 == 360 ? 7 : i5 % 30 == 0 ? 14 : 4;
                i3 = 1;
            } else {
                i3++;
            }
        }
    }

    private void z(int i3, boolean z2, boolean z3) {
        b bVar;
        this.f4409w[0] = (i3 % 12) * 30;
        int i4 = (i3 == 0 || i3 % 24 < 12) ? 0 : 1;
        boolean zR = r(i3);
        if (this.T != i4 || this.C != zR) {
            this.T = i4;
            this.C = zR;
            w();
        }
        invalidate();
        if (!z2 || (bVar = this.V) == null) {
            return;
        }
        bVar.a(0, i3, z3);
    }

    void d(AttributeSet attributeSet, int i3, int i4) {
        Context context = getContext();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.VRadialTimePickerView, i3, i4);
        this.f4390d = typedArrayObtainStyledAttributes.getColor(h.VRadialTimePickerView_vigour_numbersTextColor, 0);
        int color = typedArrayObtainStyledAttributes.getColor(h.VRadialTimePickerView_vigour_numbersInnerTextColor, 0);
        this.f4391e = color;
        int[] iArr = this.f4402p;
        iArr[0] = this.f4390d;
        iArr[2] = color;
        iArr[1] = iArr[0];
        int color2 = typedArrayObtainStyledAttributes.getColor(h.VRadialTimePickerView_vigour_numbersSelectorColor, 0);
        int color3 = typedArrayObtainStyledAttributes.getColor(h.VRadialTimePickerView_vigour_numberSelectorDotColor, 0);
        this.J = typedArrayObtainStyledAttributes.getColor(h.VRadialTimePickerView_vigour_numberSelectorTextColor, 0);
        this.f4398l.setColor(color2);
        this.H = color2;
        this.I = color3;
        this.f4400n.setColor(typedArrayObtainStyledAttributes.getColor(h.VRadialTimePickerView_vigour_numbersBackgroundColor, context.getColor(y1.b.vigour_vtimepicker_default_numbers_background_color)));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getAmOrPm() {
        return this.T;
    }

    public int getCurrentHour() {
        return q(this.f4409w[0], this.C);
    }

    public int getCurrentItemShowing() {
        return !this.f4412z ? 1 : 0;
    }

    public int getCurrentMinute() {
        return t(this.f4409w[1]);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f3 = this.W ? 1.0f : this.U;
        i(canvas);
        Path path = this.f4410x;
        n(canvas, path);
        j(canvas, path, f3);
        l(canvas, path, f3);
        h(canvas, f3);
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        if (z2) {
            this.K = getWidth() / 2;
            int height = getHeight() / 2;
            this.L = height;
            int iMin = Math.min(this.K, height);
            this.M = iMin;
            int[] iArr = this.f4404r;
            int i7 = iMin - iArr[2];
            int i8 = this.D;
            this.N = i7 - i8;
            this.O = (iMin - iArr[0]) + i8;
            this.P = iMin - ((iArr[0] + iArr[2]) / 2);
            f();
            g();
        }
    }

    @Override // android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i3) {
        if (isEnabled()) {
            return p(motionEvent.getX(), motionEvent.getY(), false) != -1 ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i3);
        }
        return null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (!this.W) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 2 || actionMasked == 1 || actionMasked == 0) {
            boolean z3 = false;
            if (actionMasked == 0) {
                this.f4387a0 = false;
            } else {
                if (actionMasked == 1) {
                    if (this.f4387a0) {
                        z2 = true;
                    } else {
                        z2 = true;
                        z3 = true;
                    }
                }
                this.f4387a0 = v(motionEvent.getX(), motionEvent.getY(), z3, z2) | this.f4387a0;
            }
            z2 = false;
            this.f4387a0 = v(motionEvent.getX(), motionEvent.getY(), z3, z2) | this.f4387a0;
        }
        return true;
    }

    public void setCurrentHour(int i3) {
        z(i3, true, false);
    }

    public void setCurrentMinute(int i3) {
        A(i3, true);
    }

    public void setInputEnabled(boolean z2) {
        this.W = z2;
        invalidate();
    }

    public void setOnValueSelectedListener(b bVar) {
        this.V = bVar;
    }

    public VRadialTimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, y1.a.VRadialTimePickerViewStyle);
    }

    public VRadialTimePickerView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public VRadialTimePickerView(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f4392f = new a("hoursToMinutes");
        this.f4393g = new String[12];
        this.f4394h = new String[12];
        this.f4395i = new String[12];
        this.f4396j = new String[12];
        Paint[] paintArr = {new Paint(), new Paint()};
        this.f4397k = paintArr;
        Paint paint = new Paint();
        this.f4398l = paint;
        Paint[] paintArr2 = {new Paint(), new Paint(), new Paint()};
        this.f4399m = paintArr2;
        Paint paint2 = new Paint();
        this.f4400n = paint2;
        this.f4402p = new int[3];
        this.f4403q = new int[]{resources.getDimensionPixelSize(i), resources.getDimensionPixelSize(i), resources.getDimensionPixelSize(c.vigour_timepicker_text_size_inner)};
        this.f4404r = new int[]{resources.getDimensionPixelSize(i), resources.getDimensionPixelSize(i), resources.getDimensionPixelSize(c.vigour_timepicker_text_inset_inner)};
        this.f4405s = (float[][]) Array.newInstance((Class<?>) float.class, 2, 12);
        this.f4406t = (float[][]) Array.newInstance((Class<?>) float.class, 2, 12);
        this.f4407u = new float[12];
        this.f4408v = new float[12];
        this.f4409w = new int[2];
        this.f4410x = new Path();
        this.W = true;
        this.f4387a0 = false;
        d(attributeSet, i3, i4);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        this.U = typedValue.getFloat();
        this.f4401o = Typeface.create("sans-serif-medium", 0);
        paintArr[0].setAntiAlias(true);
        paintArr[0].setTextAlign(Paint.Align.CENTER);
        paintArr[1].setAntiAlias(true);
        paintArr[1].setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paintArr2[0].setAntiAlias(true);
        paintArr2[1].setAntiAlias(true);
        paintArr2[2].setAntiAlias(true);
        paintArr2[2].setStrokeWidth(2.0f);
        paint2.setAntiAlias(true);
        Resources resources = getResources();
        this.D = resources.getDimensionPixelSize(c.vigour_timepicker_selector_radius);
        this.E = resources.getDimensionPixelSize(c.vigour_timepicker_selector_stroke);
        this.F = resources.getDimensionPixelSize(c.vigour_timepicker_selector_dot_radius);
        this.G = resources.getDimensionPixelSize(c.vigour_timepicker_center_dot_radius);
        int i5 = c.vigour_timepicker_text_size_normal;
        int i6 = c.vigour_timepicker_text_inset_normal;
        this.f4412z = true;
        this.B = 0.0f;
        this.f4411y = false;
        this.T = 0;
        x();
        w();
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        int i7 = calendar.get(11);
        int i8 = calendar.get(12);
        z(i7, false, false);
        A(i8, false);
        setHapticFeedbackEnabled(true);
    }
}
