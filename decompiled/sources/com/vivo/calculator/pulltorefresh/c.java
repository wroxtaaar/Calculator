package com.vivo.calculator.pulltorefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.vivo.calculator.R;

/* JADX INFO: compiled from: LoadingLayout.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
public abstract class c extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Interpolator f4165e = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FrameLayout f4166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f.e f4167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f.k f4168d;

    /* JADX INFO: compiled from: LoadingLayout.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4169a;

        static {
            int[] iArr = new int[f.k.values().length];
            f4169a = iArr;
            try {
                iArr[f.k.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4169a[f.k.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(Context context, f.e eVar, f.k kVar, TypedArray typedArray) {
        super(context);
        this.f4167c = eVar;
        this.f4168d = kVar;
        if (eVar == f.e.PULL_FROM_START) {
            LayoutInflater.from(context).inflate(R.layout.pull_to_refresh_header_vertical, this);
        }
        this.f4166b = (FrameLayout) findViewById(R.id.fl_inner);
    }

    public final void a(float f3) {
        b(f3);
    }

    protected abstract void b(float f3);

    public final void c() {
        d();
    }

    protected abstract void d();

    public final void e() {
        f();
    }

    protected abstract void f();

    public final void g() {
        h();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public final int getContentSize() {
        return a.f4169a[this.f4168d.ordinal()] != 1 ? this.f4166b.getHeight() : this.f4166b.getWidth();
    }

    protected abstract int getDefaultDrawableResId();

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    protected abstract void h();

    public final void i() {
        j();
    }

    protected abstract void j();

    public final void setHeight(int i3) {
        getLayoutParams().height = i3;
        requestLayout();
    }

    public final void setWidth(int i3) {
        getLayoutParams().width = i3;
        requestLayout();
    }
}
