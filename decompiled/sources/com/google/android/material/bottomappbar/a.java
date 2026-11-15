package com.google.android.material.bottomappbar;

import k1.f;
import k1.m;

/* JADX INFO: compiled from: BottomAppBarTopEdgeTreatment.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends f implements Cloneable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f2638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f2639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f2640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f2641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f2642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f2643g;

    @Override // k1.f
    public void b(float f3, float f4, float f5, m mVar) {
        float f6;
        float f7;
        float f8 = this.f2640d;
        if (f8 == 0.0f) {
            mVar.m(f3, 0.0f);
            return;
        }
        float f9 = ((this.f2639c * 2.0f) + f8) / 2.0f;
        float f10 = f5 * this.f2638b;
        float f11 = f4 + this.f2642f;
        float f12 = (this.f2641e * f5) + ((1.0f - f5) * f9);
        if (f12 / f9 >= 1.0f) {
            mVar.m(f3, 0.0f);
            return;
        }
        float f13 = this.f2643g;
        float f14 = f13 * f5;
        boolean z2 = f13 == -1.0f || Math.abs((f13 * 2.0f) - f8) < 0.1f;
        if (z2) {
            f6 = f12;
            f7 = 0.0f;
        } else {
            f7 = 1.75f;
            f6 = 0.0f;
        }
        float f15 = f9 + f10;
        float f16 = f6 + f10;
        float fSqrt = (float) Math.sqrt((f15 * f15) - (f16 * f16));
        float f17 = f11 - fSqrt;
        float f18 = f11 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f16));
        float f19 = (90.0f - degrees) + f7;
        mVar.m(f17, 0.0f);
        float f20 = f10 * 2.0f;
        mVar.a(f17 - f10, 0.0f, f17 + f10, f20, 270.0f, degrees);
        if (z2) {
            mVar.a(f11 - f9, (-f9) - f6, f11 + f9, f9 - f6, 180.0f - f19, (f19 * 2.0f) - 180.0f);
        } else {
            float f21 = this.f2639c;
            float f22 = f14 * 2.0f;
            float f23 = f11 - f9;
            mVar.a(f23, -(f14 + f21), f23 + f21 + f22, f21 + f14, 180.0f - f19, ((f19 * 2.0f) - 180.0f) / 2.0f);
            float f24 = f11 + f9;
            float f25 = this.f2639c;
            mVar.m(f24 - ((f25 / 2.0f) + f14), f25 + f14);
            float f26 = this.f2639c;
            mVar.a(f24 - (f22 + f26), -(f14 + f26), f24, f26 + f14, 90.0f, f19 - 90.0f);
        }
        mVar.a(f18 - f10, 0.0f, f18 + f10, f20, 270.0f - degrees, degrees);
        mVar.m(f3, 0.0f);
    }

    float c() {
        return this.f2641e;
    }

    public float d() {
        return this.f2643g;
    }

    float e() {
        return this.f2639c;
    }

    float f() {
        return this.f2638b;
    }

    public float g() {
        return this.f2640d;
    }

    void h(float f3) {
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f2641e = f3;
    }

    public void i(float f3) {
        this.f2643g = f3;
    }

    void j(float f3) {
        this.f2639c = f3;
    }

    void k(float f3) {
        this.f2638b = f3;
    }

    public void l(float f3) {
        this.f2640d = f3;
    }

    void m(float f3) {
        this.f2642f = f3;
    }
}
