package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: TextDrawableHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f3142c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private h1.d f3145f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextPaint f3140a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h1.f f3141b = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3143d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WeakReference<b> f3144e = new WeakReference<>(null);

    /* JADX INFO: compiled from: TextDrawableHelper.java */
    class a extends h1.f {
        a() {
        }

        @Override // h1.f
        public void a(int i3) {
            k.this.f3143d = true;
            b bVar = (b) k.this.f3144e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // h1.f
        public void b(Typeface typeface, boolean z2) {
            if (z2) {
                return;
            }
            k.this.f3143d = true;
            b bVar = (b) k.this.f3144e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: TextDrawableHelper.java */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public k(b bVar) {
        g(bVar);
    }

    private float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f3140a.measureText(charSequence, 0, charSequence.length());
    }

    public h1.d d() {
        return this.f3145f;
    }

    public TextPaint e() {
        return this.f3140a;
    }

    public float f(String str) {
        if (!this.f3143d) {
            return this.f3142c;
        }
        float fC = c(str);
        this.f3142c = fC;
        this.f3143d = false;
        return fC;
    }

    public void g(b bVar) {
        this.f3144e = new WeakReference<>(bVar);
    }

    public void h(h1.d dVar, Context context) {
        if (this.f3145f != dVar) {
            this.f3145f = dVar;
            if (dVar != null) {
                dVar.o(context, this.f3140a, this.f3141b);
                b bVar = this.f3144e.get();
                if (bVar != null) {
                    this.f3140a.drawableState = bVar.getState();
                }
                dVar.n(context, this.f3140a, this.f3141b);
                this.f3143d = true;
            }
            b bVar2 = this.f3144e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void i(boolean z2) {
        this.f3143d = z2;
    }

    public void j(Context context) {
        this.f3145f.n(context, this.f3140a, this.f3141b);
    }
}
