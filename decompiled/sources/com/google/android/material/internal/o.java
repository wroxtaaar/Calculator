package com.google.android.material.internal;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import e0.c0;
import e0.t;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: compiled from: ViewUtils.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f3150b;

        a(View view) {
            this.f3150b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.f3150b.getContext().getSystemService("input_method")).showSoftInput(this.f3150b, 1);
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    class b implements e0.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f3151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f3152b;

        b(d dVar, e eVar) {
            this.f3151a = dVar;
            this.f3152b = eVar;
        }

        @Override // e0.p
        public c0 a(View view, c0 c0Var) {
            return this.f3151a.a(view, c0Var, new e(this.f3152b));
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            t.j0(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    public interface d {
        c0 a(View view, c0 c0Var, e eVar);
    }

    public static void a(View view, d dVar) {
        t.x0(view, new b(dVar, new e(t.G(view), view.getPaddingTop(), t.F(view), view.getPaddingBottom())));
        g(view);
    }

    public static float b(Context context, int i3) {
        return TypedValue.applyDimension(1, i3, context.getResources().getDisplayMetrics());
    }

    public static Integer c(View view) {
        if (view.getBackground() instanceof ColorDrawable) {
            return Integer.valueOf(((ColorDrawable) view.getBackground()).getColor());
        }
        return null;
    }

    public static float d(View view) {
        float fW = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fW += t.w((View) parent);
        }
        return fW;
    }

    public static boolean e(View view) {
        return t.B(view) == 1;
    }

    public static PorterDuff.Mode f(int i3, PorterDuff.Mode mode) {
        if (i3 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i3 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i3 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i3) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void g(View view) {
        if (t.R(view)) {
            t.j0(view);
        } else {
            view.addOnAttachStateChangeListener(new c());
        }
    }

    public static void h(View view) {
        view.requestFocus();
        view.post(new a(view));
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3154b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3155c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3156d;

        public e(int i3, int i4, int i5, int i6) {
            this.f3153a = i3;
            this.f3154b = i4;
            this.f3155c = i5;
            this.f3156d = i6;
        }

        public e(e eVar) {
            this.f3153a = eVar.f3153a;
            this.f3154b = eVar.f3154b;
            this.f3155c = eVar.f3155c;
            this.f3156d = eVar.f3156d;
        }
    }
}
