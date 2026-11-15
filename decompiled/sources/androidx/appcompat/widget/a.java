package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: AbsActionBarView.java */
/* JADX INFO: loaded from: classes.dex */
abstract class a extends ViewGroup {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final C0002a f507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final Context f508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected ActionMenuView f509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected c f510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected e0.x f512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f514i;

    /* JADX INFO: renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbsActionBarView.java */
    protected class C0002a implements e0.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f515a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f516b;

        protected C0002a() {
        }

        @Override // e0.y
        public void a(View view) {
            if (this.f515a) {
                return;
            }
            a aVar = a.this;
            aVar.f512g = null;
            a.super.setVisibility(this.f516b);
        }

        @Override // e0.y
        public void b(View view) {
            a.super.setVisibility(0);
            this.f515a = false;
        }

        @Override // e0.y
        public void c(View view) {
            this.f515a = true;
        }

        public C0002a d(e0.x xVar, int i3) {
            a.this.f512g = xVar;
            this.f516b = i3;
            return this;
        }
    }

    a(Context context) {
        this(context, null);
    }

    protected static int d(int i3, int i4, boolean z2) {
        return z2 ? i3 - i4 : i3 + i4;
    }

    protected int c(View view, int i3, int i4, int i5) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE), i4);
        return Math.max(0, (i3 - view.getMeasuredWidth()) - i5);
    }

    protected int e(View view, int i3, int i4, int i5, boolean z2) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i6 = i4 + ((i5 - measuredHeight) / 2);
        if (z2) {
            view.layout(i3 - measuredWidth, i6, i3, measuredHeight + i6);
        } else {
            view.layout(i3, i6, i3 + measuredWidth, measuredHeight + i6);
        }
        return z2 ? -measuredWidth : measuredWidth;
    }

    public e0.x f(int i3, long j3) {
        e0.x xVar = this.f512g;
        if (xVar != null) {
            xVar.b();
        }
        if (i3 != 0) {
            e0.x xVarA = e0.t.d(this).a(0.0f);
            xVarA.d(j3);
            xVarA.f(this.f507b.d(xVarA, i3));
            return xVarA;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        e0.x xVarA2 = e0.t.d(this).a(1.0f);
        xVarA2.d(j3);
        xVarA2.f(this.f507b.d(xVarA2, i3));
        return xVarA2;
    }

    public int getAnimatedVisibility() {
        return this.f512g != null ? this.f507b.f516b : getVisibility();
    }

    public int getContentHeight() {
        return this.f511f;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(a.j.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        c cVar = this.f510e;
        if (cVar != null) {
            cVar.F(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f514i = false;
        }
        if (!this.f514i) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f514i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f514i = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f513h = false;
        }
        if (!this.f513h) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f513h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f513h = false;
        }
        return true;
    }

    public void setContentHeight(int i3) {
        this.f511f = i3;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        if (i3 != getVisibility()) {
            e0.x xVar = this.f512g;
            if (xVar != null) {
                xVar.b();
            }
            super.setVisibility(i3);
        }
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f507b = new C0002a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(a.a.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.f508c = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f508c = context;
        }
    }
}
