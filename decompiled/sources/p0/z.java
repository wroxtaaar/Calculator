package p0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: ViewOverlayApi14.java */
/* JADX INFO: loaded from: classes.dex */
class z implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a f5739a;

    /* JADX INFO: compiled from: ViewOverlayApi14.java */
    static class a extends ViewGroup {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static Method f5740g;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ViewGroup f5741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        View f5742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ArrayList<Drawable> f5743d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        z f5744e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f5745f;

        static {
            try {
                Class cls = Integer.TYPE;
                f5740g = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, z zVar) {
            super(context);
            this.f5743d = null;
            this.f5741b = viewGroup;
            this.f5742c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f5744e = zVar;
        }

        private void c() {
            if (this.f5745f) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void d() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f5743d;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f5745f = true;
                    this.f5741b.removeView(this);
                }
            }
        }

        private void e(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f5741b.getLocationOnScreen(iArr2);
            this.f5742c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void a(Drawable drawable) {
            c();
            if (this.f5743d == null) {
                this.f5743d = new ArrayList<>();
            }
            if (this.f5743d.contains(drawable)) {
                return;
            }
            this.f5743d.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b(View view) {
            c();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f5741b && viewGroup.getParent() != null && e0.t.R(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f5741b.getLocationOnScreen(iArr2);
                    e0.t.X(view, iArr[0] - iArr2[0]);
                    e0.t.Y(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f5741b.getLocationOnScreen(iArr);
            this.f5742c.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, this.f5742c.getWidth(), this.f5742c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f5743d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f5743d.get(i3).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public void f(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f5743d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                d();
            }
        }

        public void g(View view) {
            super.removeView(view);
            d();
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f5741b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (!(this.f5741b instanceof ViewGroup)) {
                invalidate(rect);
                return null;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = new int[2];
            e(iArr2);
            rect.offset(iArr2[0], iArr2[1]);
            return super.invalidateChildInParent(iArr, rect);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f5743d) != null && arrayList.contains(drawable));
        }
    }

    z(Context context, ViewGroup viewGroup, View view) {
        this.f5739a = new a(context, viewGroup, view, this);
    }

    static z e(View view) {
        ViewGroup viewGroupF = f(view);
        if (viewGroupF == null) {
            return null;
        }
        int childCount = viewGroupF.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroupF.getChildAt(i3);
            if (childAt instanceof a) {
                return ((a) childAt).f5744e;
            }
        }
        return new u(viewGroupF.getContext(), viewGroupF, view);
    }

    static ViewGroup f(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    @Override // p0.b0
    public void b(Drawable drawable) {
        this.f5739a.a(drawable);
    }

    @Override // p0.b0
    public void d(Drawable drawable) {
        this.f5739a.f(drawable);
    }
}
