package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import e0.t;
import java.util.Iterator;
import java.util.List;
import t0.j;
import t0.k;
import u0.h;

/* JADX INFO: loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    private static final int G = j.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    static final Property<View, Float> H = new b(Float.class, "width");
    static final Property<View, Float> I = new c(Float.class, "height");
    static final Property<View, Float> J = new d(Float.class, "paddingStart");
    static final Property<View, Float> K = new e(Float.class, "paddingEnd");
    private int A;
    private final CoordinatorLayout.c<ExtendedFloatingActionButton> B;
    private boolean C;
    private boolean D;
    private boolean E;
    protected ColorStateList F;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f2945t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.c f2946u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.c f2947v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.c f2948w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.c f2949x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f2950y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f2951z;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.floatingactionbutton.c f2958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f2959d;

        a(com.google.android.material.floatingactionbutton.c cVar, f fVar) {
            this.f2958c = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2957b = true;
            this.f2958c.d();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2958c.c();
            if (this.f2957b) {
                return;
            }
            this.f2958c.f(this.f2959d);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f2958c.onAnimationStart(animator);
            this.f2957b = false;
        }
    }

    class b extends Property<View, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f3) {
            view.getLayoutParams().width = f3.intValue();
            view.requestLayout();
        }
    }

    class c extends Property<View, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f3) {
            view.getLayoutParams().height = f3.intValue();
            view.requestLayout();
        }
    }

    class d extends Property<View, Float> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(t.G(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f3) {
            t.y0(view, f3.intValue(), view.getPaddingTop(), t.F(view), view.getPaddingBottom());
        }
    }

    class e extends Property<View, Float> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(t.F(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f3) {
            t.y0(view, t.G(view), view.getPaddingTop(), f3.intValue(), view.getPaddingBottom());
        }
    }

    public static abstract class f {
    }

    private boolean o() {
        if (getVisibility() != 0) {
            return this.f2945t == 2;
        }
        return this.f2945t != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(com.google.android.material.floatingactionbutton.c cVar, f fVar) {
        if (cVar.g()) {
            return;
        }
        if (!r()) {
            cVar.i();
            cVar.f(fVar);
            return;
        }
        measure(0, 0);
        AnimatorSet animatorSetB = cVar.b();
        animatorSetB.addListener(new a(cVar, fVar));
        Iterator<Animator.AnimatorListener> it = cVar.e().iterator();
        while (it.hasNext()) {
            animatorSetB.addListener(it.next());
        }
        animatorSetB.start();
    }

    private void q() {
        this.F = getTextColors();
    }

    private boolean r() {
        return (t.S(this) || (!o() && this.E)) && !isInEditMode();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<ExtendedFloatingActionButton> getBehavior() {
        return this.B;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    int getCollapsedSize() {
        int i3 = this.f2950y;
        return i3 < 0 ? (Math.min(t.G(this), t.F(this)) * 2) + getIconSize() : i3;
    }

    public h getExtendMotionSpec() {
        return this.f2947v.a();
    }

    public h getHideMotionSpec() {
        return this.f2949x.a();
    }

    public h getShowMotionSpec() {
        return this.f2948w.a();
    }

    public h getShrinkMotionSpec() {
        return this.f2946u.a();
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.C && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.C = false;
            this.f2946u.i();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z2) {
        this.E = z2;
    }

    public void setExtendMotionSpec(h hVar) {
        this.f2947v.h(hVar);
    }

    public void setExtendMotionSpecResource(int i3) {
        setExtendMotionSpec(h.c(getContext(), i3));
    }

    public void setExtended(boolean z2) {
        if (this.C == z2) {
            return;
        }
        com.google.android.material.floatingactionbutton.c cVar = z2 ? this.f2947v : this.f2946u;
        if (cVar.g()) {
            return;
        }
        cVar.i();
    }

    public void setHideMotionSpec(h hVar) {
        this.f2949x.h(hVar);
    }

    public void setHideMotionSpecResource(int i3) {
        setHideMotionSpec(h.c(getContext(), i3));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i3, int i4, int i5, int i6) {
        super.setPadding(i3, i4, i5, i6);
        if (!this.C || this.D) {
            return;
        }
        this.f2951z = t.G(this);
        this.A = t.F(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i3, int i4, int i5, int i6) {
        super.setPaddingRelative(i3, i4, i5, i6);
        if (!this.C || this.D) {
            return;
        }
        this.f2951z = i3;
        this.A = i5;
    }

    public void setShowMotionSpec(h hVar) {
        this.f2948w.h(hVar);
    }

    public void setShowMotionSpecResource(int i3) {
        setShowMotionSpec(h.c(getContext(), i3));
    }

    public void setShrinkMotionSpec(h hVar) {
        this.f2946u.h(hVar);
    }

    public void setShrinkMotionSpecResource(int i3) {
        setShrinkMotionSpec(h.c(getContext(), i3));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i3) {
        super.setTextColor(i3);
        q();
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Rect f2952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private f f2953b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private f f2954c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2955d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f2956e;

        public ExtendedFloatingActionButtonBehavior() {
            this.f2955d = false;
            this.f2956e = true;
        }

        private static boolean G(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean J(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f2955d || this.f2956e) && ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams()).e() == view.getId();
        }

        private boolean L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f2952a == null) {
                this.f2952a = new Rect();
            }
            Rect rect = this.f2952a;
            com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        private boolean M(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        protected void E(ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z2 = this.f2956e;
            extendedFloatingActionButton.p(z2 ? extendedFloatingActionButton.f2947v : extendedFloatingActionButton.f2948w, z2 ? this.f2954c : this.f2953b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!G(view)) {
                return false;
            }
            M(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i3) {
            List<View> listR = coordinatorLayout.r(extendedFloatingActionButton);
            int size = listR.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = listR.get(i4);
                if (!(view instanceof AppBarLayout)) {
                    if (G(view) && M(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.I(extendedFloatingActionButton, i3);
            return true;
        }

        protected void K(ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z2 = this.f2956e;
            extendedFloatingActionButton.p(z2 ? extendedFloatingActionButton.f2946u : extendedFloatingActionButton.f2949x, z2 ? this.f2954c : this.f2953b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f fVar) {
            if (fVar.f1117h == 0) {
                fVar.f1117h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ExtendedFloatingActionButton_Behavior_Layout);
            this.f2955d = typedArrayObtainStyledAttributes.getBoolean(k.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f2956e = typedArrayObtainStyledAttributes.getBoolean(k.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        q();
    }
}
