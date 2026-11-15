package com.vivo.calculator.pulltorefresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.vivo.calculator.BBKCalculatorApplication;
import com.vivo.seckeysdk.BuildConfig;
import vivo.util.VLog;

/* JADX INFO: compiled from: OverScrollDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final b f4170l = new a();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final e.a f4171m = a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f4173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f4174c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f4176e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c f4178g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b f4181j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private InterfaceC0049d f4182k;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4175d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4177f = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f4179h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f4180i = true;

    /* JADX INFO: compiled from: OverScrollDelegate.java */
    class a extends b {
        a() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: OverScrollDelegate.java */
    private static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final float f4183a = Resources.getSystem().getDisplayMetrics().density;

        private b() {
        }

        public void a(float f3, Canvas canvas, View view) {
        }

        public void b(float f3, Canvas canvas, View view) {
        }

        public void c(float f3, Canvas canvas, View view) {
            int iRound = Math.round(f3 * 0.36f);
            if (!(view.getContext() instanceof BBKCalculatorApplication)) {
                view.setTranslationY(iRound);
                return;
            }
            if (PullToRefreshScrollView.getmFlag() == 1) {
                if (iRound > 0) {
                    view.setTranslationY(iRound);
                }
            } else if (PullToRefreshScrollView.getmFlag() != 2) {
                view.setTranslationY(iRound);
            } else if (iRound < 0) {
                view.setTranslationY(iRound);
            }
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: OverScrollDelegate.java */
    public interface c {
        boolean b(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z2);

        void c(Canvas canvas);

        View getOverScrollableView();
    }

    /* JADX INFO: renamed from: com.vivo.calculator.pulltorefresh.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OverScrollDelegate.java */
    interface InterfaceC0049d {
        void a(int i3, int i4);
    }

    public d(c cVar) {
        View overScrollableView = cVar.getOverScrollableView();
        this.f4174c = overScrollableView;
        overScrollableView.setOverScrollMode(2);
        this.f4178g = cVar;
        Context context = overScrollableView.getContext();
        this.f4173b = new e();
        this.f4172a = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.f4181j = f4170l;
    }

    private static e.a a() {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(0.05f, 0.8f, 0.09f, 1.2f, 0.21f, 0.88f);
        path.cubicTo(0.48f, 0.1f, 0.72f, 0.02f, 1.0f, 0.0f);
        return new e.a(path);
    }

    private boolean c() {
        return this.f4175d == 2;
    }

    private void d(int i3) {
        this.f4176e = i3 > 0 ? -1.0f : 1.0f;
        float f3 = i3 * 0.07f;
        VLog.d("OverScrollDelegate", "velocityY->" + i3 + " overY->" + f3);
        this.f4173b.c(f3, 630, f4171m);
        k(4);
        this.f4174c.invalidate();
    }

    private boolean f(MotionEvent motionEvent) {
        return c();
    }

    private boolean h(MotionEvent motionEvent) {
        return c();
    }

    private void k(int i3) {
        String str;
        if (this.f4175d != i3) {
            this.f4175d = i3;
            if (i3 == 0) {
                str = "OS_NONE";
            } else if (i3 == 1) {
                str = "OS_TOP";
            } else if (i3 == 2) {
                str = "OS_BOTTOM";
            } else if (i3 == 3) {
                str = "OS_SPRING_BACK";
            } else {
                str = i3 == 4 ? "OS_FLING" : BuildConfig.FLAVOR;
            }
            VLog.d("OverScrollDelegate", "setState->" + str);
        }
    }

    public void b(Canvas canvas) {
        int i3 = this.f4175d;
        if (i3 == 0 || i3 == 1) {
            this.f4178g.c(canvas);
            return;
        }
        if (i3 == 3 || i3 == 4) {
            if (this.f4173b.a()) {
                this.f4176e = this.f4173b.b();
            } else {
                this.f4176e = 0.0f;
                k(0);
            }
        }
        int iSave = canvas.save();
        if (this.f4182k != null && PullToRefreshScrollView.getmFlag() != -1) {
            this.f4182k.a(Math.round(this.f4176e * 1.0f), this.f4175d);
        }
        this.f4181j.c(this.f4176e, canvas, this.f4174c);
        this.f4178g.c(canvas);
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        float f3 = this.f4176e;
        if (f3 > 0.0f) {
            this.f4181j.b(f3, canvas, this.f4174c);
        } else if (f3 < 0.0f) {
            this.f4181j.a(f3, canvas, this.f4174c);
        }
        canvas.restoreToCount(iSave2);
    }

    public boolean e(MotionEvent motionEvent) {
        if (this.f4179h) {
            return f(motionEvent);
        }
        return false;
    }

    public boolean g(MotionEvent motionEvent) {
        if (this.f4179h) {
            return h(motionEvent);
        }
        return false;
    }

    public boolean i(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z2) {
        boolean zB = this.f4178g.b(i3, i4, i5, i6, i7, i8, 0, 0, z2);
        if (!this.f4180i) {
            return zB;
        }
        if (zB) {
            if (!z2 && this.f4175d != 4) {
                VLog.d("OverScrollDelegate", "deltaY->" + i4);
                d(-((int) (((float) i4) / 0.0166666f)));
            }
        } else if (this.f4175d == 4) {
            VLog.d("OverScrollDelegate", "warning, overScroll=flase BUT mState=OS_FLING");
        }
        return zB;
    }

    public void j(InterfaceC0049d interfaceC0049d) {
        this.f4182k = interfaceC0049d;
    }
}
