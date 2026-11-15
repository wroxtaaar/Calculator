package i1;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import k1.g;
import k1.k;
import k1.n;

/* JADX INFO: compiled from: RippleDrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends Drawable implements n, x.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f4884b;

    @Override // android.graphics.drawable.Drawable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mutate() {
        this.f4884b = new b(this.f4884b);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f4884b;
        if (bVar.f4886b) {
            bVar.f4885a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f4884b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f4884b.f4885a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f4884b.f4885a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f4884b.f4885a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zB = i1.b.b(iArr);
        b bVar = this.f4884b;
        if (bVar.f4886b == zB) {
            return zOnStateChange;
        }
        bVar.f4886b = zB;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f4884b.f4885a.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4884b.f4885a.setColorFilter(colorFilter);
    }

    @Override // k1.n
    public void setShapeAppearanceModel(k kVar) {
        this.f4884b.f4885a.setShapeAppearanceModel(kVar);
    }

    @Override // android.graphics.drawable.Drawable, x.b
    public void setTint(int i3) {
        this.f4884b.f4885a.setTint(i3);
    }

    @Override // android.graphics.drawable.Drawable, x.b
    public void setTintList(ColorStateList colorStateList) {
        this.f4884b.f4885a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, x.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f4884b.f4885a.setTintMode(mode);
    }

    public a(k kVar) {
        this(new b(new g(kVar)));
    }

    /* JADX INFO: compiled from: RippleDrawableCompat.java */
    static final class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        g f4885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f4886b;

        public b(g gVar) {
            this.f4885a = gVar;
            this.f4886b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(b bVar) {
            this.f4885a = (g) bVar.f4885a.getConstantState().newDrawable();
            this.f4886b = bVar.f4886b;
        }
    }

    private a(b bVar) {
        this.f4884b = bVar;
    }
}
