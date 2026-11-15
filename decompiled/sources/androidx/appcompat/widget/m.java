package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: compiled from: AppCompatImageButton.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends ImageButton implements e0.s, androidx.core.widget.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n f687c;

    public m(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f686b;
        if (eVar != null) {
            eVar.b();
        }
        n nVar = this.f687c;
        if (nVar != null) {
            nVar.b();
        }
    }

    @Override // e0.s
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f686b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // e0.s
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f686b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.l
    public ColorStateList getSupportImageTintList() {
        n nVar = this.f687c;
        if (nVar != null) {
            return nVar.c();
        }
        return null;
    }

    @Override // androidx.core.widget.l
    public PorterDuff.Mode getSupportImageTintMode() {
        n nVar = this.f687c;
        if (nVar != null) {
            return nVar.d();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f687c.e() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f686b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        e eVar = this.f686b;
        if (eVar != null) {
            eVar.g(i3);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        n nVar = this.f687c;
        if (nVar != null) {
            nVar.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        n nVar = this.f687c;
        if (nVar != null) {
            nVar.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        this.f687c.g(i3);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        n nVar = this.f687c;
        if (nVar != null) {
            nVar.b();
        }
    }

    @Override // e0.s
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f686b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // e0.s
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f686b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintList(ColorStateList colorStateList) {
        n nVar = this.f687c;
        if (nVar != null) {
            nVar.h(colorStateList);
        }
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        n nVar = this.f687c;
        if (nVar != null) {
            nVar.i(mode);
        }
    }

    public m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.imageButtonStyle);
    }

    public m(Context context, AttributeSet attributeSet, int i3) {
        super(t0.b(context), attributeSet, i3);
        r0.a(this, getContext());
        e eVar = new e(this);
        this.f686b = eVar;
        eVar.e(attributeSet, i3);
        n nVar = new n(this);
        this.f687c = nVar;
        nVar.f(attributeSet, i3);
    }
}
