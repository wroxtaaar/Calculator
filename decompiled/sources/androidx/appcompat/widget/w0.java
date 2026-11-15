package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: compiled from: TintTypedArray.java */
/* JADX INFO: loaded from: classes.dex */
public class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypedArray f815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TypedValue f816c;

    private w0(Context context, TypedArray typedArray) {
        this.f814a = context;
        this.f815b = typedArray;
    }

    public static w0 t(Context context, int i3, int[] iArr) {
        return new w0(context, context.obtainStyledAttributes(i3, iArr));
    }

    public static w0 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new w0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static w0 v(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i4) {
        return new w0(context, context.obtainStyledAttributes(attributeSet, iArr, i3, i4));
    }

    public boolean a(int i3, boolean z2) {
        return this.f815b.getBoolean(i3, z2);
    }

    public int b(int i3, int i4) {
        return this.f815b.getColor(i3, i4);
    }

    public ColorStateList c(int i3) {
        int resourceId;
        ColorStateList colorStateListC;
        return (!this.f815b.hasValue(i3) || (resourceId = this.f815b.getResourceId(i3, 0)) == 0 || (colorStateListC = c.a.c(this.f814a, resourceId)) == null) ? this.f815b.getColorStateList(i3) : colorStateListC;
    }

    public float d(int i3, float f3) {
        return this.f815b.getDimension(i3, f3);
    }

    public int e(int i3, int i4) {
        return this.f815b.getDimensionPixelOffset(i3, i4);
    }

    public int f(int i3, int i4) {
        return this.f815b.getDimensionPixelSize(i3, i4);
    }

    public Drawable g(int i3) {
        int resourceId;
        return (!this.f815b.hasValue(i3) || (resourceId = this.f815b.getResourceId(i3, 0)) == 0) ? this.f815b.getDrawable(i3) : c.a.d(this.f814a, resourceId);
    }

    public Drawable h(int i3) {
        int resourceId;
        if (!this.f815b.hasValue(i3) || (resourceId = this.f815b.getResourceId(i3, 0)) == 0) {
            return null;
        }
        return j.b().d(this.f814a, resourceId, true);
    }

    public float i(int i3, float f3) {
        return this.f815b.getFloat(i3, f3);
    }

    public Typeface j(int i3, int i4, v.f.a aVar) {
        int resourceId = this.f815b.getResourceId(i3, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f816c == null) {
            this.f816c = new TypedValue();
        }
        return v.f.d(this.f814a, resourceId, this.f816c, i4, aVar);
    }

    public int k(int i3, int i4) {
        return this.f815b.getInt(i3, i4);
    }

    public int l(int i3, int i4) {
        return this.f815b.getInteger(i3, i4);
    }

    public int m(int i3, int i4) {
        return this.f815b.getLayoutDimension(i3, i4);
    }

    public int n(int i3, int i4) {
        return this.f815b.getResourceId(i3, i4);
    }

    public String o(int i3) {
        return this.f815b.getString(i3);
    }

    public CharSequence p(int i3) {
        return this.f815b.getText(i3);
    }

    public CharSequence[] q(int i3) {
        return this.f815b.getTextArray(i3);
    }

    public TypedArray r() {
        return this.f815b;
    }

    public boolean s(int i3) {
        return this.f815b.hasValue(i3);
    }

    public void w() {
        this.f815b.recycle();
    }
}
