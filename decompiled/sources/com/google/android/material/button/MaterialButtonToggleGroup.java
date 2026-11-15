package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.google.android.material.internal.m;
import com.google.android.material.internal.o;
import e0.g;
import e0.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import k1.k;
import t0.j;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f2711l = MaterialButtonToggleGroup.class.getSimpleName();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f2712m = j.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<c> f2713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f2714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedHashSet<d> f2715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Comparator<MaterialButton> f2716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer[] f2717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2718g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2719h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f2720i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f2721j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Set<Integer> f2722k;

    class a implements Comparator<MaterialButton> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int iCompareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return iCompareTo2 != 0 ? iCompareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    class b extends e0.a {
        b() {
        }

        @Override // e0.a
        public void g(View view, f0.d dVar) {
            super.g(view, dVar);
            dVar.a0(f0.d.c.f(0, 1, MaterialButtonToggleGroup.this.i(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    private static class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final k1.c f2725e = new k1.a(0.0f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        k1.c f2726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        k1.c f2727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        k1.c f2728c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        k1.c f2729d;

        c(k1.c cVar, k1.c cVar2, k1.c cVar3, k1.c cVar4) {
            this.f2726a = cVar;
            this.f2727b = cVar3;
            this.f2728c = cVar4;
            this.f2729d = cVar2;
        }

        public static c a(c cVar) {
            k1.c cVar2 = f2725e;
            return new c(cVar2, cVar.f2729d, cVar2, cVar.f2728c);
        }

        public static c b(c cVar, View view) {
            return o.e(view) ? c(cVar) : d(cVar);
        }

        public static c c(c cVar) {
            k1.c cVar2 = cVar.f2726a;
            k1.c cVar3 = cVar.f2729d;
            k1.c cVar4 = f2725e;
            return new c(cVar2, cVar3, cVar4, cVar4);
        }

        public static c d(c cVar) {
            k1.c cVar2 = f2725e;
            return new c(cVar2, cVar2, cVar.f2727b, cVar.f2728c);
        }

        public static c e(c cVar, View view) {
            return o.e(view) ? d(cVar) : c(cVar);
        }

        public static c f(c cVar) {
            k1.c cVar2 = cVar.f2726a;
            k1.c cVar3 = f2725e;
            return new c(cVar2, cVar3, cVar.f2727b, cVar3);
        }
    }

    public interface d {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i3, boolean z2);
    }

    private class e implements MaterialButton.b {
        private e() {
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(MaterialButton materialButton, boolean z2) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ e(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(Context context) {
        this(context, null);
    }

    private void c() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i3 = firstVisibleChildIndex + 1; i3 < getChildCount(); i3++) {
            MaterialButton materialButtonH = h(i3);
            int iMin = Math.min(materialButtonH.getStrokeWidth(), h(i3 - 1).getStrokeWidth());
            LinearLayout.LayoutParams layoutParamsD = d(materialButtonH);
            if (getOrientation() == 0) {
                g.c(layoutParamsD, 0);
                g.d(layoutParamsD, -iMin);
                layoutParamsD.topMargin = 0;
            } else {
                layoutParamsD.bottomMargin = 0;
                layoutParamsD.topMargin = -iMin;
                g.d(layoutParamsD, 0);
            }
            materialButtonH.setLayoutParams(layoutParamsD);
        }
        n(firstVisibleChildIndex);
    }

    private LinearLayout.LayoutParams d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void e(int i3, boolean z2) {
        if (i3 == -1) {
            Log.e(f2711l, "Button ID is not valid: " + i3);
            return;
        }
        HashSet hashSet = new HashSet(this.f2722k);
        if (z2 && !hashSet.contains(Integer.valueOf(i3))) {
            if (this.f2719h && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i3));
        } else {
            if (z2 || !hashSet.contains(Integer.valueOf(i3))) {
                return;
            }
            if (!this.f2720i || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i3));
            }
        }
        q(hashSet);
    }

    private void g(int i3, boolean z2) {
        Iterator<d> it = this.f2715d.iterator();
        while (it.hasNext()) {
            it.next().a(this, i3, z2);
        }
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (k(i3)) {
                return i3;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (k(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if ((getChildAt(i4) instanceof MaterialButton) && k(i4)) {
                i3++;
            }
        }
        return i3;
    }

    private MaterialButton h(int i3) {
        return (MaterialButton) getChildAt(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == view) {
                return i3;
            }
            if ((getChildAt(i4) instanceof MaterialButton) && k(i4)) {
                i3++;
            }
        }
        return -1;
    }

    private c j(int i3, int i4, int i5) {
        c cVar = this.f2713b.get(i3);
        if (i4 == i5) {
            return cVar;
        }
        boolean z2 = getOrientation() == 0;
        if (i3 == i4) {
            return z2 ? c.e(cVar, this) : c.f(cVar);
        }
        if (i3 == i5) {
            return z2 ? c.b(cVar, this) : c.a(cVar);
        }
        return null;
    }

    private boolean k(int i3) {
        return getChildAt(i3).getVisibility() != 8;
    }

    private void n(int i3) {
        if (getChildCount() == 0 || i3 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) h(i3).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            g.c(layoutParams, 0);
            g.d(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void o(int i3, boolean z2) {
        View viewFindViewById = findViewById(i3);
        if (viewFindViewById instanceof MaterialButton) {
            this.f2718g = true;
            ((MaterialButton) viewFindViewById).setChecked(z2);
            this.f2718g = false;
        }
    }

    private static void p(k.b bVar, c cVar) {
        if (cVar == null) {
            bVar.o(0.0f);
        } else {
            bVar.B(cVar.f2726a).t(cVar.f2729d).F(cVar.f2727b).x(cVar.f2728c);
        }
    }

    private void q(Set<Integer> set) {
        Set<Integer> set2 = this.f2722k;
        this.f2722k = new HashSet(set);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            int id = h(i3).getId();
            o(id, set.contains(Integer.valueOf(id)));
            if (set2.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                g(id, set.contains(Integer.valueOf(id)));
            }
        }
        invalidate();
    }

    private void r() {
        TreeMap treeMap = new TreeMap(this.f2716e);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            treeMap.put(h(i3), Integer.valueOf(i3));
        }
        this.f2717f = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(t.k());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f2714c);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(f2711l, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i3, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        e(materialButton.getId(), materialButton.isChecked());
        k shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f2713b.add(new c(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        t.m0(materialButton, new b());
    }

    public void b(d dVar) {
        this.f2715d.add(dVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        r();
        super.dispatchDraw(canvas);
    }

    public void f() {
        q(new HashSet());
    }

    public int getCheckedButtonId() {
        if (!this.f2719h || this.f2722k.isEmpty()) {
            return -1;
        }
        return this.f2722k.iterator().next().intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            int id = h(i3).getId();
            if (this.f2722k.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i4) {
        Integer[] numArr = this.f2717f;
        if (numArr != null && i4 < numArr.length) {
            return numArr[i4].intValue();
        }
        Log.w(f2711l, "Child order wasn't updated");
        return i4;
    }

    public boolean l() {
        return this.f2719h;
    }

    void m(MaterialButton materialButton, boolean z2) {
        if (this.f2718g) {
            return;
        }
        e(materialButton.getId(), z2);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i3 = this.f2721j;
        if (i3 != -1) {
            q(Collections.singleton(Integer.valueOf(i3)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        f0.d.x0(accessibilityNodeInfo).Z(f0.d.b.a(1, getVisibleButtonCount(), false, l() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        s();
        c();
        super.onMeasure(i3, i4);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f2713b.remove(iIndexOfChild);
        }
        s();
        c();
    }

    void s() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i3 = 0; i3 < childCount; i3++) {
            MaterialButton materialButtonH = h(i3);
            if (materialButtonH.getVisibility() != 8) {
                k.b bVarV = materialButtonH.getShapeAppearanceModel().v();
                p(bVarV, j(i3, firstVisibleChildIndex, lastVisibleChildIndex));
                materialButtonH.setShapeAppearanceModel(bVarV.m());
            }
        }
    }

    public void setSelectionRequired(boolean z2) {
        this.f2720i = z2;
    }

    public void setSingleSelection(boolean z2) {
        if (this.f2719h != z2) {
            this.f2719h = z2;
            f();
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t0.b.materialButtonToggleGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f2712m;
        super(m1.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f2713b = new ArrayList();
        this.f2714c = new e(this, null);
        this.f2715d = new LinkedHashSet<>();
        this.f2716e = new a();
        this.f2718g = false;
        this.f2722k = new HashSet();
        TypedArray typedArrayH = m.h(getContext(), attributeSet, t0.k.MaterialButtonToggleGroup, i3, i4, new int[0]);
        setSingleSelection(typedArrayH.getBoolean(t0.k.MaterialButtonToggleGroup_singleSelection, false));
        this.f2721j = typedArrayH.getResourceId(t0.k.MaterialButtonToggleGroup_checkedButton, -1);
        this.f2720i = typedArrayH.getBoolean(t0.k.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        typedArrayH.recycle();
        t.v0(this, 1);
    }

    public void setSingleSelection(int i3) {
        setSingleSelection(getResources().getBoolean(i3));
    }
}
