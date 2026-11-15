package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e0.t;
import java.util.HashMap;
import java.util.Map;
import t0.a;
import u0.h;
import u0.j;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<View, Integer> f3460i;

    public FabTransformationSheetBehavior() {
    }

    private void g0(View view, boolean z2) {
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z2) {
                this.f3460i = new HashMap(childCount);
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                boolean z3 = (childAt.getLayoutParams() instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) childAt.getLayoutParams()).f() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z3) {
                    if (z2) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f3460i.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        t.v0(childAt, 4);
                    } else {
                        Map<View, Integer> map = this.f3460i;
                        if (map != null && map.containsKey(childAt)) {
                            t.v0(childAt, this.f3460i.get(childAt).intValue());
                        }
                    }
                }
            }
            if (z2) {
                return;
            }
            this.f3460i = null;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    protected boolean H(View view, View view2, boolean z2, boolean z3) {
        g0(view2, z2);
        return super.H(view, view2, z2, z3);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    protected FabTransformationBehavior.e e0(Context context, boolean z2) {
        int i3 = z2 ? a.mtrl_fab_transformation_sheet_expand_spec : a.mtrl_fab_transformation_sheet_collapse_spec;
        FabTransformationBehavior.e eVar = new FabTransformationBehavior.e();
        eVar.f3453a = h.c(context, i3);
        eVar.f3454b = new j(17, 0.0f, 0.0f);
        return eVar;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
