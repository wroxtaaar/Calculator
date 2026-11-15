package com.vivo.toastthumb;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ToastThumb extends t2.d {
    private boolean A;
    private Context B;
    private boolean C;
    private long D;
    private Handler E;
    private b F;
    private d G;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private PopupWindow f4312r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private FrameLayout f4313s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private c f4314t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f4315u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4316v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f4317w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f4318x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f4319y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f4320z;

    private class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ToastThumb.this.f4312r.isShowing() && ToastThumb.this.C) {
                ToastThumb.this.f4312r.dismiss();
            }
        }
    }

    public interface c {
        View a(ToastThumb toastThumb, int i3);
    }

    private class d extends TextView implements c {
        d(Context context) {
            super(context, null, 0, t2.b.Widget_Vigour_ToastText_Light);
        }

        @Override // com.vivo.toastthumb.ToastThumb.c
        public View a(ToastThumb toastThumb, int i3) {
            if (i3 < toastThumb.getHeader().size() || i3 >= toastThumb.getAlphabet().size() + toastThumb.getHeader().size()) {
                return null;
            }
            setText(toastThumb.getAlphabet().get(i3 - toastThumb.getHeader().size()));
            return this;
        }
    }

    public ToastThumb(Context context) {
        this(context, null);
    }

    private void j() {
        if (this.f4312r.isShowing()) {
            if (this.C) {
                this.E.postDelayed(this.F, this.D);
            } else {
                this.f4312r.dismiss();
            }
        }
    }

    private boolean k() {
        return this.f4312r.isShowing();
    }

    private void l() {
        View viewA;
        this.A = false;
        c cVar = this.f4314t;
        if (cVar == null || (viewA = cVar.a(this, this.f4315u)) == null) {
            return;
        }
        this.f4313s.removeAllViews();
        this.f4313s.addView(viewA, -2, -2);
        this.A = true;
    }

    private void m() {
        int[] iArr = new int[2];
        l();
        n(iArr);
        if (!this.A) {
            j();
            return;
        }
        if (!k()) {
            this.f4312r.showAsDropDown(this, iArr[0], iArr[1]);
        }
        if (!this.C || this.f4320z) {
            return;
        }
        this.E.removeCallbacks(this.F);
        this.E.postDelayed(this.F, this.D);
    }

    private void n(int[] iArr) {
        Objects.requireNonNull(iArr);
        if (getLayoutDirection() == 1) {
            iArr[0] = Math.abs(this.f4316v);
        } else {
            this.f4313s.measure(0, 0);
            iArr[0] = (-Math.abs(this.f4316v)) - this.f4313s.getMeasuredWidth();
        }
        int i3 = this.f4319y;
        int i4 = this.f4317w;
        if (i3 >= i4) {
            iArr[1] = -(i3 - i4);
        } else {
            iArr[1] = i4 - i3;
        }
    }

    private void o() {
        int[] iArr = new int[2];
        l();
        n(iArr);
        if (!this.A) {
            j();
            return;
        }
        if (k()) {
            this.f4312r.update(this, iArr[0], iArr[1], -1, -1);
            if (!this.C || this.f4320z) {
                return;
            }
            this.E.removeCallbacks(this.F);
            this.E.postDelayed(this.F, this.D);
        }
    }

    @Override // t2.d
    protected void e(MotionEvent motionEvent, int i3) {
        super.e(motionEvent, i3);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return;
                    }
                }
            }
            this.f4320z = false;
            j();
            return;
        }
        this.f4320z = true;
        if (i3 >= 0) {
            this.f4315u = i3;
            if (k()) {
                o();
            } else {
                m();
            }
        }
    }

    public TextView getToastTextView() {
        return this.G;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.C) {
            this.E.removeCallbacks(this.F);
        }
        super.onDetachedFromWindow();
    }

    @Override // t2.d, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        this.f4319y = i6 - i4;
        this.f4318x = i5 - i3;
        super.onLayout(z2, i3, i4, i5, i6);
        o();
    }

    public void setShowListener(c cVar) {
        this.f4314t = cVar;
    }

    public void setToastDelayedTime(long j3) {
        if (j3 <= 0) {
            this.C = false;
        } else {
            this.C = true;
            this.D = j3;
        }
    }

    public ToastThumb(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4312r = null;
        this.f4313s = null;
        this.f4314t = null;
        this.f4315u = 0;
        this.f4316v = 30;
        this.f4317w = 40;
        this.f4318x = 0;
        this.f4319y = 0;
        this.f4320z = false;
        this.A = false;
        this.B = null;
        this.C = true;
        this.D = 100L;
        this.E = new Handler();
        this.F = new b();
        this.G = null;
        this.B = context;
        this.f4316v = (int) (context.getResources().getDisplayMetrics().density * 30.0f);
        this.f4317w = (int) (context.getResources().getDisplayMetrics().density * 40.0f);
        this.f4313s = new FrameLayout(context);
        PopupWindow popupWindow = new PopupWindow(this.f4313s, -2, -2);
        this.f4312r = popupWindow;
        popupWindow.setAnimationStyle(0);
        d dVar = new d(this.B);
        this.G = dVar;
        setShowListener(dVar);
    }
}
