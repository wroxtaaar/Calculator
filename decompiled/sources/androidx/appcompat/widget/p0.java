package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

/* JADX INFO: compiled from: ScrollingTabContainerView.java */
/* JADX INFO: loaded from: classes.dex */
public class p0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Interpolator f716k = new DecelerateInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Runnable f717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    i0 f719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Spinner f720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f723h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f724i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f725j;

    /* JADX INFO: compiled from: ScrollingTabContainerView.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f726b;

        a(View view) {
            this.f726b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            p0.this.smoothScrollTo(this.f726b.getLeft() - ((p0.this.getWidth() - this.f726b.getWidth()) / 2), 0);
            p0.this.f717b = null;
        }
    }

    /* JADX INFO: compiled from: ScrollingTabContainerView.java */
    private class b extends BaseAdapter {
        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return p0.this.f719d.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return ((d) p0.this.f719d.getChildAt(i3)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            if (view == null) {
                return p0.this.c((b.a.c) getItem(i3), true);
            }
            ((d) view).a((b.a.c) getItem(i3));
            return view;
        }
    }

    /* JADX INFO: compiled from: ScrollingTabContainerView.java */
    private class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = p0.this.f719d.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = p0.this.f719d.getChildAt(i3);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: compiled from: ScrollingTabContainerView.java */
    private class d extends LinearLayout {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private b.a.c f731c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private TextView f732d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ImageView f733e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f734f;

        /* JADX WARN: Illegal instructions before constructor call */
        public d(Context context, b.a.c cVar, boolean z2) {
            int i3 = a.a.actionBarTabStyle;
            super(context, null, i3);
            int[] iArr = {R.attr.background};
            this.f730b = iArr;
            this.f731c = cVar;
            w0 w0VarV = w0.v(context, null, iArr, i3, 0);
            if (w0VarV.s(0)) {
                setBackgroundDrawable(w0VarV.g(0));
            }
            w0VarV.w();
            if (z2) {
                setGravity(8388627);
            }
            c();
        }

        public void a(b.a.c cVar) {
            this.f731c = cVar;
            c();
        }

        public b.a.c b() {
            return this.f731c;
        }

        public void c() {
            b.a.c cVar = this.f731c;
            View viewB = cVar.b();
            if (viewB != null) {
                ViewParent parent = viewB.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewB);
                    }
                    addView(viewB);
                }
                this.f734f = viewB;
                TextView textView = this.f732d;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f733e;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f733e.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f734f;
            if (view != null) {
                removeView(view);
                this.f734f = null;
            }
            Drawable drawableC = cVar.c();
            CharSequence charSequenceD = cVar.d();
            if (drawableC != null) {
                if (this.f733e == null) {
                    o oVar = new o(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    oVar.setLayoutParams(layoutParams);
                    addView(oVar, 0);
                    this.f733e = oVar;
                }
                this.f733e.setImageDrawable(drawableC);
                this.f733e.setVisibility(0);
            } else {
                ImageView imageView2 = this.f733e;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f733e.setImageDrawable(null);
                }
            }
            boolean z2 = !TextUtils.isEmpty(charSequenceD);
            if (z2) {
                if (this.f732d == null) {
                    z zVar = new z(getContext(), null, a.a.actionBarTabTextStyle);
                    zVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    zVar.setLayoutParams(layoutParams2);
                    addView(zVar);
                    this.f732d = zVar;
                }
                this.f732d.setText(charSequenceD);
                this.f732d.setVisibility(0);
            } else {
                TextView textView2 = this.f732d;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f732d.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f733e;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            y0.a(this, z2 ? null : cVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i3, int i4) {
            super.onMeasure(i3, i4);
            if (p0.this.f722g > 0) {
                int measuredWidth = getMeasuredWidth();
                int i5 = p0.this.f722g;
                if (measuredWidth > i5) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), i4);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z2) {
            boolean z3 = isSelected() != z2;
            super.setSelected(z2);
            if (z3 && z2) {
                sendAccessibilityEvent(4);
            }
        }
    }

    private Spinner b() {
        w wVar = new w(getContext(), null, a.a.actionDropDownStyle);
        wVar.setLayoutParams(new i0.a(-2, -1));
        wVar.setOnItemSelectedListener(this);
        return wVar;
    }

    private boolean d() {
        Spinner spinner = this.f720e;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (d()) {
            return;
        }
        if (this.f720e == null) {
            this.f720e = b();
        }
        removeView(this.f719d);
        addView(this.f720e, new ViewGroup.LayoutParams(-2, -1));
        if (this.f720e.getAdapter() == null) {
            this.f720e.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.f717b;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f717b = null;
        }
        this.f720e.setSelection(this.f725j);
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f720e);
        addView(this.f719d, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f720e.getSelectedItemPosition());
        return false;
    }

    public void a(int i3) {
        View childAt = this.f719d.getChildAt(i3);
        Runnable runnable = this.f717b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f717b = aVar;
        post(aVar);
    }

    d c(b.a.c cVar, boolean z2) {
        d dVar = new d(getContext(), cVar, z2);
        if (z2) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f724i));
        } else {
            dVar.setFocusable(true);
            if (this.f718c == null) {
                this.f718c = new c();
            }
            dVar.setOnClickListener(this.f718c);
        }
        return dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f717b;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        g.a aVarB = g.a.b(getContext());
        setContentHeight(aVarB.f());
        this.f723h = aVarB.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f717b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
        ((d) view).b().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f719d.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f722g = -1;
        } else {
            if (childCount > 2) {
                this.f722g = (int) (View.MeasureSpec.getSize(i3) * 0.4f);
            } else {
                this.f722g = View.MeasureSpec.getSize(i3) / 2;
            }
            this.f722g = Math.min(this.f722g, this.f723h);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f724i, 1073741824);
        if (!z2 && this.f721f) {
            this.f719d.measure(0, iMakeMeasureSpec);
            if (this.f719d.getMeasuredWidth() > View.MeasureSpec.getSize(i3)) {
                e();
            } else {
                f();
            }
        } else {
            f();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i3, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z2 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f725j);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z2) {
        this.f721f = z2;
    }

    public void setContentHeight(int i3) {
        this.f724i = i3;
        requestLayout();
    }

    public void setTabSelected(int i3) {
        this.f725j = i3;
        int childCount = this.f719d.getChildCount();
        int i4 = 0;
        while (i4 < childCount) {
            View childAt = this.f719d.getChildAt(i4);
            boolean z2 = i4 == i3;
            childAt.setSelected(z2);
            if (z2) {
                a(i3);
            }
            i4++;
        }
        Spinner spinner = this.f720e;
        if (spinner == null || i3 < 0) {
            return;
        }
        spinner.setSelection(i3);
    }
}
