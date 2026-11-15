package androidx.constraintlayout.widget;

import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import p.k;

/* JADX INFO: compiled from: VirtualLayout.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class j extends b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1081j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1082k;

    @Override // androidx.constraintlayout.widget.b
    protected void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == i.ConstraintLayout_Layout_android_visibility) {
                    this.f1081j = true;
                } else if (index == i.ConstraintLayout_Layout_android_elevation) {
                    this.f1082k = true;
                }
            }
        }
    }

    public void n(k kVar, int i3, int i4) {
    }

    @Override // androidx.constraintlayout.widget.b, android.view.View
    public void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.f1081j || this.f1082k) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i3 = 0; i3 < this.f969c; i3++) {
                View viewH = constraintLayout.h(this.f968b[i3]);
                if (viewH != null) {
                    if (this.f1081j) {
                        viewH.setVisibility(visibility);
                    }
                    if (this.f1082k && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        viewH.setTranslationZ(viewH.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        c();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        c();
    }
}
