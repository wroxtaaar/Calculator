package p0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* JADX INFO: compiled from: ChangeBounds.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends m {
    private static final String[] O = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> P = new b(PointF.class, "boundsOrigin");
    private static final Property<k, PointF> Q = new C0079c(PointF.class, "topLeft");
    private static final Property<k, PointF> R = new d(PointF.class, "bottomRight");
    private static final Property<View, PointF> S = new e(PointF.class, "bottomRight");
    private static final Property<View, PointF> T = new f(PointF.class, "topLeft");
    private static final Property<View, PointF> U = new g(PointF.class, "position");
    private static p0.k V = new p0.k();
    private int[] L = new int[2];
    private boolean M = false;
    private boolean N = false;

    /* JADX INFO: compiled from: ChangeBounds.java */
    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f5597c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f5598d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f5599e;

        a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f3) {
            this.f5596b = viewGroup;
            this.f5597c = bitmapDrawable;
            this.f5598d = view;
            this.f5599e = f3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c0.b(this.f5596b).d(this.f5597c);
            c0.g(this.f5598d, this.f5599e);
        }
    }

    /* JADX INFO: compiled from: ChangeBounds.java */
    static class b extends Property<Drawable, PointF> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Rect f5601a;

        b(Class cls, String str) {
            super(cls, str);
            this.f5601a = new Rect();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f5601a);
            Rect rect = this.f5601a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f5601a);
            this.f5601a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f5601a);
        }
    }

    /* JADX INFO: renamed from: p0.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ChangeBounds.java */
    static class C0079c extends Property<k, PointF> {
        C0079c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    /* JADX INFO: compiled from: ChangeBounds.java */
    static class d extends Property<k, PointF> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* JADX INFO: compiled from: ChangeBounds.java */
    static class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            c0.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* JADX INFO: compiled from: ChangeBounds.java */
    static class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            c0.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* JADX INFO: compiled from: ChangeBounds.java */
    static class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            c0.f(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    /* JADX INFO: compiled from: ChangeBounds.java */
    class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f5602b;
        private k mViewBounds;

        h(k kVar) {
            this.f5602b = kVar;
            this.mViewBounds = kVar;
        }
    }

    /* JADX INFO: compiled from: ChangeBounds.java */
    class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f5604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f5605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Rect f5606d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f5607e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f5608f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f5609g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f5610h;

        i(View view, Rect rect, int i3, int i4, int i5, int i6) {
            this.f5605c = view;
            this.f5606d = rect;
            this.f5607e = i3;
            this.f5608f = i4;
            this.f5609g = i5;
            this.f5610h = i6;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f5604b = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f5604b) {
                return;
            }
            e0.t.s0(this.f5605c, this.f5606d);
            c0.f(this.f5605c, this.f5607e, this.f5608f, this.f5609g, this.f5610h);
        }
    }

    /* JADX INFO: compiled from: ChangeBounds.java */
    class j extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f5612b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5613c;

        j(ViewGroup viewGroup) {
            this.f5613c = viewGroup;
        }

        @Override // p0.n, p0.m.f
        public void a(m mVar) {
            x.c(this.f5613c, true);
        }

        @Override // p0.m.f
        public void b(m mVar) {
            if (!this.f5612b) {
                x.c(this.f5613c, false);
            }
            mVar.P(this);
        }

        @Override // p0.n, p0.m.f
        public void c(m mVar) {
            x.c(this.f5613c, false);
        }

        @Override // p0.n, p0.m.f
        public void e(m mVar) {
            x.c(this.f5613c, false);
            this.f5612b = true;
        }
    }

    /* JADX INFO: compiled from: ChangeBounds.java */
    private static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f5617c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f5618d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f5619e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f5620f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f5621g;

        k(View view) {
            this.f5619e = view;
        }

        private void b() {
            c0.f(this.f5619e, this.f5615a, this.f5616b, this.f5617c, this.f5618d);
            this.f5620f = 0;
            this.f5621g = 0;
        }

        void a(PointF pointF) {
            this.f5617c = Math.round(pointF.x);
            this.f5618d = Math.round(pointF.y);
            int i3 = this.f5621g + 1;
            this.f5621g = i3;
            if (this.f5620f == i3) {
                b();
            }
        }

        void c(PointF pointF) {
            this.f5615a = Math.round(pointF.x);
            this.f5616b = Math.round(pointF.y);
            int i3 = this.f5620f + 1;
            this.f5620f = i3;
            if (i3 == this.f5621g) {
                b();
            }
        }
    }

    private void c0(s sVar) {
        View view = sVar.f5726b;
        if (!e0.t.S(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        sVar.f5725a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        sVar.f5725a.put("android:changeBounds:parent", sVar.f5726b.getParent());
        if (this.N) {
            sVar.f5726b.getLocationInWindow(this.L);
            sVar.f5725a.put("android:changeBounds:windowX", Integer.valueOf(this.L[0]));
            sVar.f5725a.put("android:changeBounds:windowY", Integer.valueOf(this.L[1]));
        }
        if (this.M) {
            sVar.f5725a.put("android:changeBounds:clip", e0.t.u(view));
        }
    }

    private boolean d0(View view, View view2) {
        if (!this.N) {
            return true;
        }
        s sVarT = t(view, true);
        if (sVarT == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == sVarT.f5726b) {
            return true;
        }
        return false;
    }

    @Override // p0.m
    public String[] D() {
        return O;
    }

    @Override // p0.m
    public void g(s sVar) {
        c0(sVar);
    }

    @Override // p0.m
    public void j(s sVar) {
        c0(sVar);
    }

    @Override // p0.m
    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        int i3;
        View view;
        ObjectAnimator objectAnimatorA;
        int i4;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator animatorC;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map<String, Object> map = sVar.f5725a;
        Map<String, Object> map2 = sVar2.f5725a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.f5726b;
        if (!d0(viewGroup2, viewGroup3)) {
            int iIntValue = ((Integer) sVar.f5725a.get("android:changeBounds:windowX")).intValue();
            int iIntValue2 = ((Integer) sVar.f5725a.get("android:changeBounds:windowY")).intValue();
            int iIntValue3 = ((Integer) sVar2.f5725a.get("android:changeBounds:windowX")).intValue();
            int iIntValue4 = ((Integer) sVar2.f5725a.get("android:changeBounds:windowY")).intValue();
            if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.L);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(bitmapCreateBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            float fC = c0.c(view2);
            c0.g(view2, 0.0f);
            c0.b(viewGroup).b(bitmapDrawable);
            p0.g gVarV = v();
            int[] iArr = this.L;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, p0.i.a(P, gVarV.a(iIntValue - iArr[0], iIntValue2 - iArr[1], iIntValue3 - iArr[0], iIntValue4 - iArr[1])));
            objectAnimatorOfPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, fC));
            return objectAnimatorOfPropertyValuesHolder;
        }
        Rect rect2 = (Rect) sVar.f5725a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) sVar2.f5725a.get("android:changeBounds:bounds");
        int i5 = rect2.left;
        int i6 = rect3.left;
        int i7 = rect2.top;
        int i8 = rect3.top;
        int i9 = rect2.right;
        int i10 = rect3.right;
        int i11 = rect2.bottom;
        int i12 = rect3.bottom;
        int i13 = i9 - i5;
        int i14 = i11 - i7;
        int i15 = i10 - i6;
        int i16 = i12 - i8;
        Rect rect4 = (Rect) sVar.f5725a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) sVar2.f5725a.get("android:changeBounds:clip");
        if ((i13 == 0 || i14 == 0) && (i15 == 0 || i16 == 0)) {
            i3 = 0;
        } else {
            i3 = (i5 == i6 && i7 == i8) ? 0 : 1;
            if (i9 != i10 || i11 != i12) {
                i3++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i3++;
        }
        if (i3 <= 0) {
            return null;
        }
        if (this.M) {
            c0.f(view, i5, i7, Math.max(i13, i15) + i5, Math.max(i14, i16) + i7);
            if (i5 == i6 && i7 == i8) {
                objectAnimatorA = null;
            } else {
                view = view2;
                objectAnimatorA = p0.f.a(view, U, v().a(i5, i7, i6, i8));
            }
            if (rect4 == null) {
                i4 = 0;
                rect = new Rect(0, 0, i13, i14);
            } else {
                i4 = 0;
                rect = rect4;
            }
            Rect rect6 = rect5 == null ? new Rect(i4, i4, i15, i16) : rect5;
            if (rect.equals(rect6)) {
                objectAnimator = null;
            } else {
                e0.t.s0(view, rect);
                p0.k kVar = V;
                Object[] objArr = new Object[2];
                objArr[i4] = rect;
                objArr[1] = rect6;
                ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", kVar, objArr);
                objectAnimatorOfObject.addListener(new i(view, rect5, i6, i8, i10, i12));
                objectAnimator = objectAnimatorOfObject;
            }
            animatorC = r.c(objectAnimatorA, objectAnimator);
        } else {
            c0.f(view, i5, i7, i9, i11);
            if (i3 != 2) {
                animatorC = (i5 == i6 && i7 == i8) ? p0.f.a(view, S, v().a(i9, i11, i10, i12)) : p0.f.a(view, T, v().a(i5, i7, i6, i8));
            } else if (i13 == i15 && i14 == i16) {
                animatorC = p0.f.a(view, U, v().a(i5, i7, i6, i8));
            } else {
                k kVar2 = new k(view);
                ObjectAnimator objectAnimatorA2 = p0.f.a(kVar2, Q, v().a(i5, i7, i6, i8));
                ObjectAnimator objectAnimatorA3 = p0.f.a(kVar2, R, v().a(i9, i11, i10, i12));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                animatorSet.addListener(new h(kVar2));
                animatorC = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            x.c(viewGroup4, true);
            a(new j(viewGroup4));
        }
        return animatorC;
    }
}
