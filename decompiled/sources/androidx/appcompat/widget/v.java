package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: compiled from: AppCompatSeekBarHelper.java */
/* JADX INFO: loaded from: classes.dex */
class v extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SeekBar f783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ColorStateList f785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f788i;

    v(SeekBar seekBar) {
        super(seekBar);
        this.f785f = null;
        this.f786g = null;
        this.f787h = false;
        this.f788i = false;
        this.f783d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f784e;
        if (drawable != null) {
            if (this.f787h || this.f788i) {
                Drawable drawableR = x.a.r(drawable.mutate());
                this.f784e = drawableR;
                if (this.f787h) {
                    x.a.o(drawableR, this.f785f);
                }
                if (this.f788i) {
                    x.a.p(this.f784e, this.f786g);
                }
                if (this.f784e.isStateful()) {
                    this.f784e.setState(this.f783d.getDrawableState());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.r
    void c(AttributeSet attributeSet, int i3) {
        super.c(attributeSet, i3);
        Context context = this.f783d.getContext();
        int[] iArr = a.j.AppCompatSeekBar;
        w0 w0VarV = w0.v(context, attributeSet, iArr, i3, 0);
        SeekBar seekBar = this.f783d;
        e0.t.k0(seekBar, seekBar.getContext(), iArr, attributeSet, w0VarV.r(), i3, 0);
        Drawable drawableH = w0VarV.h(a.j.AppCompatSeekBar_android_thumb);
        if (drawableH != null) {
            this.f783d.setThumb(drawableH);
        }
        j(w0VarV.g(a.j.AppCompatSeekBar_tickMark));
        int i4 = a.j.AppCompatSeekBar_tickMarkTintMode;
        if (w0VarV.s(i4)) {
            this.f786g = e0.e(w0VarV.k(i4, -1), this.f786g);
            this.f788i = true;
        }
        int i5 = a.j.AppCompatSeekBar_tickMarkTint;
        if (w0VarV.s(i5)) {
            this.f785f = w0VarV.c(i5);
            this.f787h = true;
        }
        w0VarV.w();
        f();
    }

    void g(Canvas canvas) {
        if (this.f784e != null) {
            int max = this.f783d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f784e.getIntrinsicWidth();
                int intrinsicHeight = this.f784e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i4 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f784e.setBounds(-i3, -i4, i3, i4);
                float width = ((this.f783d.getWidth() - this.f783d.getPaddingLeft()) - this.f783d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f783d.getPaddingLeft(), this.f783d.getHeight() / 2);
                for (int i5 = 0; i5 <= max; i5++) {
                    this.f784e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    void h() {
        Drawable drawable = this.f784e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f783d.getDrawableState())) {
            this.f783d.invalidateDrawable(drawable);
        }
    }

    void i() {
        Drawable drawable = this.f784e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f784e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f784e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f783d);
            x.a.m(drawable, e0.t.B(this.f783d));
            if (drawable.isStateful()) {
                drawable.setState(this.f783d.getDrawableState());
            }
            f();
        }
        this.f783d.invalidate();
    }
}
