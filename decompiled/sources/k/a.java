package k;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: CardView.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f5031h = {R.attr.colorBackground};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final f f5032i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f5035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f5036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Rect f5037f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e f5038g;

    static {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            f5032i = new c();
        } else if (i3 >= 17) {
            f5032i = new b();
        } else {
            f5032i = new d();
        }
        f5032i.k();
    }

    public ColorStateList getCardBackgroundColor() {
        return f5032i.j(this.f5038g);
    }

    public float getCardElevation() {
        return f5032i.m(this.f5038g);
    }

    public int getContentPaddingBottom() {
        return this.f5037f.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f5037f.left;
    }

    public int getContentPaddingRight() {
        return this.f5037f.right;
    }

    public int getContentPaddingTop() {
        return this.f5037f.top;
    }

    public float getMaxCardElevation() {
        return f5032i.e(this.f5038g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f5034c;
    }

    public float getRadius() {
        return f5032i.d(this.f5038g);
    }

    public boolean getUseCompatPadding() {
        return this.f5033b;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        f fVar = f5032i;
        if (fVar instanceof c) {
            super.onMeasure(i3, i4);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(fVar.c(this.f5038g)), View.MeasureSpec.getSize(i3)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i4);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i4 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(fVar.i(this.f5038g)), View.MeasureSpec.getSize(i4)), mode2);
        }
        super.onMeasure(i3, i4);
    }

    public void setCardBackgroundColor(int i3) {
        f5032i.g(this.f5038g, ColorStateList.valueOf(i3));
    }

    public void setCardElevation(float f3) {
        f5032i.l(this.f5038g, f3);
    }

    public void setMaxCardElevation(float f3) {
        f5032i.f(this.f5038g, f3);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i3) {
        this.f5036e = i3;
        super.setMinimumHeight(i3);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i3) {
        this.f5035d = i3;
        super.setMinimumWidth(i3);
    }

    @Override // android.view.View
    public void setPadding(int i3, int i4, int i5, int i6) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i3, int i4, int i5, int i6) {
    }

    public void setPreventCornerOverlap(boolean z2) {
        if (z2 != this.f5034c) {
            this.f5034c = z2;
            f5032i.a(this.f5038g);
        }
    }

    public void setRadius(float f3) {
        f5032i.h(this.f5038g, f3);
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.f5033b != z2) {
            this.f5033b = z2;
            f5032i.b(this.f5038g);
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f5032i.g(this.f5038g, colorStateList);
    }
}
