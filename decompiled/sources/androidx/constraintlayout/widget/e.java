package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* JADX INFO: compiled from: Constraints.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends ViewGroup {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    d f1066b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public d getConstraintSet() {
        if (this.f1066b == null) {
            this.f1066b = new d();
        }
        this.f1066b.h(this);
        return this.f1066b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.b(layoutParams);
    }

    /* JADX INFO: compiled from: Constraints.java */
    public static class a extends ConstraintLayout.b {
        public float A0;
        public float B0;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public float f1067p0;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public boolean f1068q0;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public float f1069r0;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public float f1070s0;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public float f1071t0;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public float f1072u0;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public float f1073v0;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public float f1074w0;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public float f1075x0;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public float f1076y0;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        public float f1077z0;

        public a(int i3, int i4) {
            super(i3, i4);
            this.f1067p0 = 1.0f;
            this.f1068q0 = false;
            this.f1069r0 = 0.0f;
            this.f1070s0 = 0.0f;
            this.f1071t0 = 0.0f;
            this.f1072u0 = 0.0f;
            this.f1073v0 = 1.0f;
            this.f1074w0 = 1.0f;
            this.f1075x0 = 0.0f;
            this.f1076y0 = 0.0f;
            this.f1077z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1067p0 = 1.0f;
            this.f1068q0 = false;
            this.f1069r0 = 0.0f;
            this.f1070s0 = 0.0f;
            this.f1071t0 = 0.0f;
            this.f1072u0 = 0.0f;
            this.f1073v0 = 1.0f;
            this.f1074w0 = 1.0f;
            this.f1075x0 = 0.0f;
            this.f1076y0 = 0.0f;
            this.f1077z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.ConstraintSet);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == i.ConstraintSet_android_alpha) {
                    this.f1067p0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1067p0);
                } else if (index == i.ConstraintSet_android_elevation) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.f1069r0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1069r0);
                        this.f1068q0 = true;
                    }
                } else if (index == i.ConstraintSet_android_rotationX) {
                    this.f1071t0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1071t0);
                } else if (index == i.ConstraintSet_android_rotationY) {
                    this.f1072u0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1072u0);
                } else if (index == i.ConstraintSet_android_rotation) {
                    this.f1070s0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1070s0);
                } else if (index == i.ConstraintSet_android_scaleX) {
                    this.f1073v0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1073v0);
                } else if (index == i.ConstraintSet_android_scaleY) {
                    this.f1074w0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1074w0);
                } else if (index == i.ConstraintSet_android_transformPivotX) {
                    this.f1075x0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1075x0);
                } else if (index == i.ConstraintSet_android_transformPivotY) {
                    this.f1076y0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1076y0);
                } else if (index == i.ConstraintSet_android_translationX) {
                    this.f1077z0 = typedArrayObtainStyledAttributes.getFloat(index, this.f1077z0);
                } else if (index == i.ConstraintSet_android_translationY) {
                    this.A0 = typedArrayObtainStyledAttributes.getFloat(index, this.A0);
                } else if (index == i.ConstraintSet_android_translationZ && Build.VERSION.SDK_INT >= 21) {
                    this.B0 = typedArrayObtainStyledAttributes.getFloat(index, this.B0);
                }
            }
        }
    }
}
