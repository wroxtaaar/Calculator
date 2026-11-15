package x;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: compiled from: WrappedDrawableState.java */
/* JADX INFO: loaded from: classes.dex */
final class f extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f6423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Drawable.ConstantState f6424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ColorStateList f6425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    PorterDuff.Mode f6426d;

    f(f fVar) {
        this.f6425c = null;
        this.f6426d = d.f6415h;
        if (fVar != null) {
            this.f6423a = fVar.f6423a;
            this.f6424b = fVar.f6424b;
            this.f6425c = fVar.f6425c;
            this.f6426d = fVar.f6426d;
        }
    }

    boolean a() {
        return this.f6424b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i3 = this.f6423a;
        Drawable.ConstantState constantState = this.f6424b;
        return (constantState != null ? constantState.getChangingConfigurations() : 0) | i3;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new e(this, resources) : new d(this, resources);
    }
}
