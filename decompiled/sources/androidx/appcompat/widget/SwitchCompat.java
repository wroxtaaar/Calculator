package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    private static final Property<SwitchCompat, Float> O = new a(Float.class, "thumbPos");
    private static final int[] P = {R.attr.state_checked};
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private final TextPaint G;
    private ColorStateList H;
    private Layout I;
    private Layout J;
    private TransformationMethod K;
    ObjectAnimator L;
    private final y M;
    private final Rect N;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Drawable f443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ColorStateList f444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PorterDuff.Mode f445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ColorStateList f449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PorterDuff.Mode f450i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f451j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f452k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f453l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f454m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f455n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f456o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f457p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CharSequence f458q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f459r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f460s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f461t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f462u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f463v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private VelocityTracker f464w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f465x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    float f466y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f467z;

    class a extends Property<SwitchCompat, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f466y);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f3) {
            switchCompat.setThumbPosition(f3.floatValue());
        }
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    private void a(boolean z2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, O, z2 ? 1.0f : 0.0f);
        this.L = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.L.setAutoCancel(true);
        }
        this.L.start();
    }

    private void b() {
        Drawable drawable = this.f443b;
        if (drawable != null) {
            if (this.f446e || this.f447f) {
                Drawable drawableMutate = x.a.r(drawable).mutate();
                this.f443b = drawableMutate;
                if (this.f446e) {
                    x.a.o(drawableMutate, this.f444c);
                }
                if (this.f447f) {
                    x.a.p(this.f443b, this.f445d);
                }
                if (this.f443b.isStateful()) {
                    this.f443b.setState(getDrawableState());
                }
            }
        }
    }

    private void c() {
        Drawable drawable = this.f448g;
        if (drawable != null) {
            if (this.f451j || this.f452k) {
                Drawable drawableMutate = x.a.r(drawable).mutate();
                this.f448g = drawableMutate;
                if (this.f451j) {
                    x.a.o(drawableMutate, this.f449h);
                }
                if (this.f452k) {
                    x.a.p(this.f448g, this.f450i);
                }
                if (this.f448g.isStateful()) {
                    this.f448g.setState(getDrawableState());
                }
            }
        }
    }

    private void d() {
        ObjectAnimator objectAnimator = this.L;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private static float f(float f3, float f4, float f5) {
        if (f3 < f4) {
            return f4;
        }
        return f3 > f5 ? f5 : f3;
    }

    private boolean g(float f3, float f4) {
        if (this.f443b == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f443b.getPadding(this.N);
        int i3 = this.D;
        int i4 = this.f461t;
        int i5 = i3 - i4;
        int i6 = (this.C + thumbOffset) - i4;
        int i7 = this.B + i6;
        Rect rect = this.N;
        return f3 > ((float) i6) && f3 < ((float) (((i7 + rect.left) + rect.right) + i4)) && f4 > ((float) i5) && f4 < ((float) (this.F + i4));
    }

    private boolean getTargetCheckedState() {
        return this.f466y > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((c1.b(this) ? 1.0f - this.f466y : this.f466y) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f448g;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.N;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f443b;
        Rect rectD = drawable2 != null ? e0.d(drawable2) : e0.f579c;
        return ((((this.f467z - this.B) - rect.left) - rect.right) - rectD.left) - rectD.right;
    }

    private Layout h(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.K;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.G;
        return new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void k(int i3, int i4) {
        Typeface typeface;
        if (i3 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i3 != 2) {
            typeface = i3 != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        j(typeface, i4);
    }

    private void l(MotionEvent motionEvent) {
        this.f460s = 0;
        boolean targetCheckedState = true;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z2) {
            this.f464w.computeCurrentVelocity(1000);
            float xVelocity = this.f464w.getXVelocity();
            if (Math.abs(xVelocity) <= this.f465x) {
                targetCheckedState = getTargetCheckedState();
            } else if (!c1.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                targetCheckedState = false;
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        e(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i3;
        int i4;
        Rect rect = this.N;
        int i5 = this.C;
        int i6 = this.D;
        int i7 = this.E;
        int i8 = this.F;
        int thumbOffset = getThumbOffset() + i5;
        Drawable drawable = this.f443b;
        Rect rectD = drawable != null ? e0.d(drawable) : e0.f579c;
        Drawable drawable2 = this.f448g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i9 = rect.left;
            thumbOffset += i9;
            if (rectD != null) {
                int i10 = rectD.left;
                if (i10 > i9) {
                    i5 += i10 - i9;
                }
                int i11 = rectD.top;
                int i12 = rect.top;
                i3 = i11 > i12 ? (i11 - i12) + i6 : i6;
                int i13 = rectD.right;
                int i14 = rect.right;
                if (i13 > i14) {
                    i7 -= i13 - i14;
                }
                int i15 = rectD.bottom;
                int i16 = rect.bottom;
                if (i15 > i16) {
                    i4 = i8 - (i15 - i16);
                }
                this.f448g.setBounds(i5, i3, i7, i4);
            } else {
                i3 = i6;
            }
            i4 = i8;
            this.f448g.setBounds(i5, i3, i7, i4);
        }
        Drawable drawable3 = this.f443b;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i17 = thumbOffset - rect.left;
            int i18 = thumbOffset + this.B + rect.right;
            this.f443b.setBounds(i17, i6, i18, i8);
            Drawable background = getBackground();
            if (background != null) {
                x.a.l(background, i17, i6, i18, i8);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f3, float f4) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f3, f4);
        }
        Drawable drawable = this.f443b;
        if (drawable != null) {
            x.a.k(drawable, f3, f4);
        }
        Drawable drawable2 = this.f448g;
        if (drawable2 != null) {
            x.a.k(drawable2, f3, f4);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f443b;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f448g;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!c1.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f467z;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f455n : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (c1.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f467z;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f455n : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.f459r;
    }

    public boolean getSplitTrack() {
        return this.f456o;
    }

    public int getSwitchMinWidth() {
        return this.f454m;
    }

    public int getSwitchPadding() {
        return this.f455n;
    }

    public CharSequence getTextOff() {
        return this.f458q;
    }

    public CharSequence getTextOn() {
        return this.f457p;
    }

    public Drawable getThumbDrawable() {
        return this.f443b;
    }

    public int getThumbTextPadding() {
        return this.f453l;
    }

    public ColorStateList getThumbTintList() {
        return this.f444c;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f445d;
    }

    public Drawable getTrackDrawable() {
        return this.f448g;
    }

    public ColorStateList getTrackTintList() {
        return this.f449h;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f450i;
    }

    public void i(Context context, int i3) {
        w0 w0VarT = w0.t(context, i3, a.j.TextAppearance);
        ColorStateList colorStateListC = w0VarT.c(a.j.TextAppearance_android_textColor);
        if (colorStateListC != null) {
            this.H = colorStateListC;
        } else {
            this.H = getTextColors();
        }
        int iF = w0VarT.f(a.j.TextAppearance_android_textSize, 0);
        if (iF != 0) {
            float f3 = iF;
            if (f3 != this.G.getTextSize()) {
                this.G.setTextSize(f3);
                requestLayout();
            }
        }
        k(w0VarT.k(a.j.TextAppearance_android_typeface, -1), w0VarT.k(a.j.TextAppearance_android_textStyle, -1));
        if (w0VarT.a(a.j.TextAppearance_textAllCaps, false)) {
            this.K = new f.a(getContext());
        } else {
            this.K = null;
        }
        w0VarT.w();
    }

    public void j(Typeface typeface, int i3) {
        if (i3 <= 0) {
            this.G.setFakeBoldText(false);
            this.G.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i3) : Typeface.create(typeface, i3);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int i4 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i3;
            this.G.setFakeBoldText((i4 & 1) != 0);
            this.G.setTextSkewX((i4 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f443b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f448g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.L;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.L.end();
        this.L = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(iArrOnCreateDrawableState, P);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.N;
        Drawable drawable = this.f448g;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i3 = this.D;
        int i4 = this.F;
        int i5 = i3 + rect.top;
        int i6 = i4 - rect.bottom;
        Drawable drawable2 = this.f443b;
        if (drawable != null) {
            if (!this.f456o || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectD = e0.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectD.left;
                rect.right -= rectD.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.I : this.J;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.H;
            if (colorStateList != null) {
                this.G.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.G.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i5 + i6) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.f457p : this.f458q;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (TextUtils.isEmpty(text)) {
            accessibilityNodeInfo.setText(charSequence);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append(' ');
        sb.append(charSequence);
        accessibilityNodeInfo.setText(sb);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int iMax;
        int width;
        int paddingLeft;
        int i7;
        int paddingTop;
        int height;
        super.onLayout(z2, i3, i4, i5, i6);
        int iMax2 = 0;
        if (this.f443b != null) {
            Rect rect = this.N;
            Drawable drawable = this.f448g;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectD = e0.d(this.f443b);
            iMax = Math.max(0, rectD.left - rect.left);
            iMax2 = Math.max(0, rectD.right - rect.right);
        } else {
            iMax = 0;
        }
        if (c1.b(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.f467z + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.f467z) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity != 16) {
            if (gravity != 80) {
                paddingTop = getPaddingTop();
                i7 = this.A;
            } else {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.A;
            }
            this.C = paddingLeft;
            this.D = paddingTop;
            this.F = height;
            this.E = width;
        }
        int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        i7 = this.A;
        paddingTop = paddingTop2 - (i7 / 2);
        height = i7 + paddingTop;
        this.C = paddingLeft;
        this.D = paddingTop;
        this.F = height;
        this.E = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i3, int i4) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.f459r) {
            if (this.I == null) {
                this.I = h(this.f457p);
            }
            if (this.J == null) {
                this.J = h(this.f458q);
            }
        }
        Rect rect = this.N;
        Drawable drawable = this.f443b;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f443b.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f443b.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.B = Math.max(this.f459r ? Math.max(this.I.getWidth(), this.J.getWidth()) + (this.f453l * 2) : 0, intrinsicWidth);
        Drawable drawable2 = this.f448g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f448g.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f443b;
        if (drawable3 != null) {
            Rect rectD = e0.d(drawable3);
            iMax = Math.max(iMax, rectD.left);
            iMax2 = Math.max(iMax2, rectD.right);
        }
        int iMax3 = Math.max(this.f454m, (this.B * 2) + iMax + iMax2);
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f467z = iMax3;
        this.A = iMax4;
        super.onMeasure(i3, i4);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f457p : this.f458q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0089  */
    /* JADX WARN: Code duplicated, block: B:36:0x008d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0094  */
    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f3;
        this.f464w.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            if (isEnabled() && g(x3, y3)) {
                this.f460s = 1;
                this.f462u = x3;
                this.f463v = y3;
            }
        } else if (actionMasked == 1) {
            if (this.f460s == 2) {
                l(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.f460s = 0;
            this.f464w.clear();
        } else if (actionMasked == 2) {
            int i3 = this.f460s;
            if (i3 == 1) {
                float x4 = motionEvent.getX();
                float y4 = motionEvent.getY();
                if (Math.abs(x4 - this.f462u) > this.f461t || Math.abs(y4 - this.f463v) > this.f461t) {
                    this.f460s = 2;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    this.f462u = x4;
                    this.f463v = y4;
                    return true;
                }
            } else if (i3 == 2) {
                float x5 = motionEvent.getX();
                int thumbScrollRange = getThumbScrollRange();
                float f4 = x5 - this.f462u;
                if (thumbScrollRange != 0) {
                    f3 = f4 / thumbScrollRange;
                } else {
                    f3 = f4 > 0.0f ? 1.0f : -1.0f;
                }
                if (c1.b(this)) {
                    f3 = -f3;
                }
                float f5 = f(this.f466y + f3, 0.0f, 1.0f);
                if (f5 != this.f466y) {
                    this.f462u = x5;
                    setThumbPosition(f5);
                }
                return true;
            }
        } else if (actionMasked == 3) {
            if (this.f460s == 2) {
                l(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.f460s = 0;
            this.f464w.clear();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        super.setChecked(z2);
        boolean zIsChecked = isChecked();
        if (getWindowToken() != null && e0.t.S(this)) {
            a(zIsChecked);
        } else {
            d();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setShowText(boolean z2) {
        if (this.f459r != z2) {
            this.f459r = z2;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z2) {
        this.f456o = z2;
        invalidate();
    }

    public void setSwitchMinWidth(int i3) {
        this.f454m = i3;
        requestLayout();
    }

    public void setSwitchPadding(int i3) {
        this.f455n = i3;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.G.getTypeface() == null || this.G.getTypeface().equals(typeface)) && (this.G.getTypeface() != null || typeface == null)) {
            return;
        }
        this.G.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        this.f458q = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.f457p = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f443b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f443b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f3) {
        this.f466y = f3;
        invalidate();
    }

    public void setThumbResource(int i3) {
        setThumbDrawable(c.a.d(getContext(), i3));
    }

    public void setThumbTextPadding(int i3) {
        this.f453l = i3;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f444c = colorStateList;
        this.f446e = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f445d = mode;
        this.f447f = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f448g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f448g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i3) {
        setTrackDrawable(c.a.d(getContext(), i3));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f449h = colorStateList;
        this.f451j = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f450i = mode;
        this.f452k = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f443b || drawable == this.f448g;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f444c = null;
        this.f445d = null;
        this.f446e = false;
        this.f447f = false;
        this.f449h = null;
        this.f450i = null;
        this.f451j = false;
        this.f452k = false;
        this.f464w = VelocityTracker.obtain();
        this.N = new Rect();
        r0.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.G = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = a.j.SwitchCompat;
        w0 w0VarV = w0.v(context, attributeSet, iArr, i3, 0);
        e0.t.k0(this, context, iArr, attributeSet, w0VarV.r(), i3, 0);
        Drawable drawableG = w0VarV.g(a.j.SwitchCompat_android_thumb);
        this.f443b = drawableG;
        if (drawableG != null) {
            drawableG.setCallback(this);
        }
        Drawable drawableG2 = w0VarV.g(a.j.SwitchCompat_track);
        this.f448g = drawableG2;
        if (drawableG2 != null) {
            drawableG2.setCallback(this);
        }
        this.f457p = w0VarV.p(a.j.SwitchCompat_android_textOn);
        this.f458q = w0VarV.p(a.j.SwitchCompat_android_textOff);
        this.f459r = w0VarV.a(a.j.SwitchCompat_showText, true);
        this.f453l = w0VarV.f(a.j.SwitchCompat_thumbTextPadding, 0);
        this.f454m = w0VarV.f(a.j.SwitchCompat_switchMinWidth, 0);
        this.f455n = w0VarV.f(a.j.SwitchCompat_switchPadding, 0);
        this.f456o = w0VarV.a(a.j.SwitchCompat_splitTrack, false);
        ColorStateList colorStateListC = w0VarV.c(a.j.SwitchCompat_thumbTint);
        if (colorStateListC != null) {
            this.f444c = colorStateListC;
            this.f446e = true;
        }
        PorterDuff.Mode modeE = e0.e(w0VarV.k(a.j.SwitchCompat_thumbTintMode, -1), null);
        if (this.f445d != modeE) {
            this.f445d = modeE;
            this.f447f = true;
        }
        if (this.f446e || this.f447f) {
            b();
        }
        ColorStateList colorStateListC2 = w0VarV.c(a.j.SwitchCompat_trackTint);
        if (colorStateListC2 != null) {
            this.f449h = colorStateListC2;
            this.f451j = true;
        }
        PorterDuff.Mode modeE2 = e0.e(w0VarV.k(a.j.SwitchCompat_trackTintMode, -1), null);
        if (this.f450i != modeE2) {
            this.f450i = modeE2;
            this.f452k = true;
        }
        if (this.f451j || this.f452k) {
            c();
        }
        int iN = w0VarV.n(a.j.SwitchCompat_switchTextAppearance, 0);
        if (iN != 0) {
            i(context, iN);
        }
        y yVar = new y(this);
        this.M = yVar;
        yVar.m(attributeSet, i3);
        w0VarV.w();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f461t = viewConfiguration.getScaledTouchSlop();
        this.f465x = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }
}
