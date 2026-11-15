package b;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: ActionBar.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: compiled from: ActionBar.java */
    public interface b {
        void a(boolean z2);
    }

    /* JADX INFO: compiled from: ActionBar.java */
    @Deprecated
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z2);

    public abstract int j();

    public abstract Context k();

    public boolean l() {
        return false;
    }

    public abstract void m(Configuration configuration);

    void n() {
    }

    public abstract boolean o(int i3, KeyEvent keyEvent);

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(boolean z2);

    public abstract void s(boolean z2);

    public abstract void t(boolean z2);

    public abstract void u(boolean z2);

    public abstract void v(CharSequence charSequence);

    public abstract void w(CharSequence charSequence);

    public abstract g.b x(g.b.a aVar);

    /* JADX INFO: renamed from: b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionBar.java */
    public static class C0024a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2229a;

        public C0024a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2229a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ActionBarLayout);
            this.f2229a = typedArrayObtainStyledAttributes.getInt(a.j.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0024a(int i3, int i4) {
            super(i3, i4);
            this.f2229a = 0;
            this.f2229a = 8388627;
        }

        public C0024a(C0024a c0024a) {
            super((ViewGroup.MarginLayoutParams) c0024a);
            this.f2229a = 0;
            this.f2229a = c0024a.f2229a;
        }

        public C0024a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2229a = 0;
        }
    }
}
