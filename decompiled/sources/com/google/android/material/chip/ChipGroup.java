package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.internal.m;
import e0.t;
import java.util.List;
import java.util.Set;
import t0.j;
import t0.k;

/* JADX INFO: loaded from: classes.dex */
public class ChipGroup extends com.google.android.material.internal.e {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f2786l = j.Widget_MaterialComponents_ChipGroup;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2787f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2788g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e f2789h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.google.android.material.internal.a<Chip> f2790i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f2791j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final f f2792k;

    class a implements com.google.android.material.internal.a.b {
        a() {
        }

        @Override // com.google.android.material.internal.a.b
        public void a(Set<Integer> set) {
            if (ChipGroup.this.f2789h != null) {
                e eVar = ChipGroup.this.f2789h;
                ChipGroup chipGroup = ChipGroup.this;
                eVar.a(chipGroup, chipGroup.f2790i.j(ChipGroup.this));
            }
        }
    }

    class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f2794a;

        b(d dVar) {
            this.f2794a = dVar;
        }

        @Override // com.google.android.material.chip.ChipGroup.e
        public void a(ChipGroup chipGroup, List<Integer> list) {
            if (ChipGroup.this.f2790i.l()) {
                this.f2794a.a(chipGroup, ChipGroup.this.getCheckedChipId());
            }
        }
    }

    public static class c extends ViewGroup.MarginLayoutParams {
        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(int i3, int i4) {
            super(i3, i4);
        }
    }

    @Deprecated
    public interface d {
        void a(ChipGroup chipGroup, int i3);
    }

    public interface e {
        void a(ChipGroup chipGroup, List<Integer> list);
    }

    private class f implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ViewGroup.OnHierarchyChangeListener f2796a;

        private f() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(t.k());
                }
                ChipGroup.this.f2790i.e((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f2796a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            ChipGroup chipGroup = ChipGroup.this;
            if (view == chipGroup && (view2 instanceof Chip)) {
                chipGroup.f2790i.n((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f2796a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }

        /* synthetic */ f(ChipGroup chipGroup, a aVar) {
            this();
        }
    }

    public ChipGroup(Context context) {
        this(context, null);
    }

    private int getChipCount() {
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) instanceof Chip) {
                i3++;
            }
        }
        return i3;
    }

    @Override // com.google.android.material.internal.e
    public boolean c() {
        return super.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof c);
    }

    int g(View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) instanceof Chip) {
                if (((Chip) getChildAt(i4)) == view) {
                    return i3;
                }
                i3++;
            }
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        return this.f2790i.k();
    }

    public List<Integer> getCheckedChipIds() {
        return this.f2790i.j(this);
    }

    public int getChipSpacingHorizontal() {
        return this.f2787f;
    }

    public int getChipSpacingVertical() {
        return this.f2788g;
    }

    public boolean h() {
        return this.f2790i.l();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i3 = this.f2791j;
        if (i3 != -1) {
            this.f2790i.f(i3);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        f0.d.x0(accessibilityNodeInfo).Z(f0.d.b.a(getRowCount(), c() ? getChipCount() : -1, false, h() ? 1 : 2));
    }

    public void setChipSpacing(int i3) {
        setChipSpacingHorizontal(i3);
        setChipSpacingVertical(i3);
    }

    public void setChipSpacingHorizontal(int i3) {
        if (this.f2787f != i3) {
            this.f2787f = i3;
            setItemSpacing(i3);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i3) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i3));
    }

    public void setChipSpacingResource(int i3) {
        setChipSpacing(getResources().getDimensionPixelOffset(i3));
    }

    public void setChipSpacingVertical(int i3) {
        if (this.f2788g != i3) {
            this.f2788g = i3;
            setLineSpacing(i3);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i3) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i3));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i3) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(d dVar) {
        if (dVar == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new b(dVar));
        }
    }

    public void setOnCheckedStateChangeListener(e eVar) {
        this.f2789h = eVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f2792k.f2796a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z2) {
        this.f2790i.p(z2);
    }

    @Deprecated
    public void setShowDividerHorizontal(int i3) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i3) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.e
    public void setSingleLine(boolean z2) {
        super.setSingleLine(z2);
    }

    public void setSingleSelection(boolean z2) {
        this.f2790i.q(z2);
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t0.b.chipGroupStyle);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public void setSingleLine(int i3) {
        setSingleLine(getResources().getBoolean(i3));
    }

    public void setSingleSelection(int i3) {
        setSingleSelection(getResources().getBoolean(i3));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ChipGroup(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f2786l;
        super(m1.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        com.google.android.material.internal.a<Chip> aVar = new com.google.android.material.internal.a<>();
        this.f2790i = aVar;
        f fVar = new f(this, null);
        this.f2792k = fVar;
        TypedArray typedArrayH = m.h(getContext(), attributeSet, k.ChipGroup, i3, i4, new int[0]);
        int dimensionPixelOffset = typedArrayH.getDimensionPixelOffset(k.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(typedArrayH.getDimensionPixelOffset(k.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayH.getDimensionPixelOffset(k.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(typedArrayH.getBoolean(k.ChipGroup_singleLine, false));
        setSingleSelection(typedArrayH.getBoolean(k.ChipGroup_singleSelection, false));
        setSelectionRequired(typedArrayH.getBoolean(k.ChipGroup_selectionRequired, false));
        this.f2791j = typedArrayH.getResourceId(k.ChipGroup_checkedChip, -1);
        typedArrayH.recycle();
        aVar.o(new a());
        super.setOnHierarchyChangeListener(fVar);
        t.v0(this, 1);
    }
}
