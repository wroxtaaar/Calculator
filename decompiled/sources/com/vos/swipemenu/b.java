package com.vos.swipemenu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;

/* JADX INFO: compiled from: SwipeLeftHorizontal.java */
/* JADX INFO: loaded from: classes.dex */
class b extends a {
    public b(View view) {
        super(1, view);
    }

    @Override // com.vos.swipemenu.a
    public void a(OverScroller overScroller, int i3, int i4) {
        overScroller.startScroll(-Math.abs(i3), 0, Math.abs(i3), 0, i4);
    }

    @Override // com.vos.swipemenu.a
    public void b(OverScroller overScroller, int i3, int i4) {
        overScroller.startScroll(Math.abs(i3), 0, e().getWidth() - Math.abs(i3), 0, i4);
    }

    @Override // com.vos.swipemenu.a
    public a.C0051a c(int i3, int i4) {
        a.C0051a c0051a = this.f4368c;
        c0051a.f4369a = i3;
        c0051a.f4370b = i4;
        c0051a.f4371c = false;
        if (i3 == 0) {
            c0051a.f4371c = true;
        }
        if (i3 >= 0) {
            c0051a.f4369a = 0;
        }
        return c0051a;
    }

    @Override // com.vos.swipemenu.a
    public boolean g(int i3, float f3) {
        return f3 > ((float) e().getWidth());
    }

    @Override // com.vos.swipemenu.a
    public void h(float f3, float f4, float f5) {
        View view = this.f4367b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            View childAt = viewGroup.getChildAt(0);
            if (childAt != null) {
                childAt.setTranslationX(f3);
            }
            View childAt2 = viewGroup.getChildAt(1);
            if (childAt2 != null) {
                childAt2.setTranslationX(f4);
            }
            View childAt3 = viewGroup.getChildAt(2);
            if (childAt3 != null) {
                childAt3.setTranslationX(f5);
            }
            viewGroup.invalidate();
        }
    }

    @Override // com.vos.swipemenu.a
    public void i() {
        View view = this.f4367b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            View childAt = viewGroup.getChildAt(0);
            if (childAt != null) {
                childAt.setTranslationX(0.0f);
            }
            View childAt2 = viewGroup.getChildAt(1);
            if (childAt2 != null) {
                childAt2.setTranslationX(0.0f);
            }
            View childAt3 = viewGroup.getChildAt(2);
            if (childAt3 != null) {
                childAt3.setTranslationX(0.0f);
            }
            viewGroup.invalidate();
        }
    }

    public boolean j(int i3) {
        int iD = (-e().getWidth()) * d();
        return i3 <= iD && iD != 0;
    }
}
