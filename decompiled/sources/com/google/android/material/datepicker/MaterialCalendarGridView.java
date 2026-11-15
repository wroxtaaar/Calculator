package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Calendar f2824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f2825c;

    class a extends e0.a {
        a() {
        }

        @Override // e0.a
        public void g(View view, f0.d dVar) {
            super.g(view, dVar);
            dVar.Z(null);
        }
    }

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    private void a(int i3, Rect rect) {
        if (i3 == 33) {
            setSelection(getAdapter().i());
        } else if (i3 == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i3, rect);
        }
    }

    private View c(int i3) {
        return getChildAt(i3 - getFirstVisiblePosition());
    }

    private static int d(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean e(Long l3, Long l4, Long l5, Long l6) {
        return l3 == null || l4 == null || l5 == null || l6 == null || l5.longValue() > l4.longValue() || l6.longValue() < l3.longValue();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m getAdapter() {
        return (m) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        int iA;
        int iD;
        int iA2;
        int iD2;
        int width;
        int i3;
        int right;
        int right2;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        m adapter = getAdapter();
        d<?> dVar = adapter.f2924c;
        c cVar = adapter.f2926e;
        int iMax = Math.max(adapter.b(), getFirstVisiblePosition());
        int iMin = Math.min(adapter.i(), getLastVisiblePosition());
        Long item = adapter.getItem(iMax);
        Long item2 = adapter.getItem(iMin);
        Iterator<d0.e<Long, Long>> it = dVar.d().iterator();
        while (it.hasNext()) {
            d0.e<Long, Long> next = it.next();
            Long l3 = next.f4502a;
            if (l3 == null) {
                materialCalendarGridView = this;
            } else if (next.f4503b != null) {
                long jLongValue = l3.longValue();
                long jLongValue2 = next.f4503b.longValue();
                if (!e(item, item2, Long.valueOf(jLongValue), Long.valueOf(jLongValue2))) {
                    boolean zE = com.google.android.material.internal.o.e(this);
                    if (jLongValue < item.longValue()) {
                        if (adapter.f(iMax)) {
                            right2 = 0;
                        } else {
                            right2 = !zE ? materialCalendarGridView.c(iMax - 1).getRight() : materialCalendarGridView.c(iMax - 1).getLeft();
                        }
                        iD = right2;
                        iA = iMax;
                    } else {
                        materialCalendarGridView.f2824b.setTimeInMillis(jLongValue);
                        iA = adapter.a(materialCalendarGridView.f2824b.get(5));
                        iD = d(materialCalendarGridView.c(iA));
                    }
                    if (jLongValue2 > item2.longValue()) {
                        if (adapter.g(iMin)) {
                            right = getWidth();
                        } else {
                            right = !zE ? materialCalendarGridView.c(iMin).getRight() : materialCalendarGridView.c(iMin).getLeft();
                        }
                        iD2 = right;
                        iA2 = iMin;
                    } else {
                        materialCalendarGridView.f2824b.setTimeInMillis(jLongValue2);
                        iA2 = adapter.a(materialCalendarGridView.f2824b.get(5));
                        iD2 = d(materialCalendarGridView.c(iA2));
                    }
                    int itemId = (int) adapter.getItemId(iA);
                    int i4 = iMax;
                    int i5 = iMin;
                    int itemId2 = (int) adapter.getItemId(iA2);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (numColumns + getNumColumns()) - 1;
                        View viewC = materialCalendarGridView.c(numColumns);
                        int top = viewC.getTop() + cVar.f2845a.c();
                        m mVar = adapter;
                        int bottom = viewC.getBottom() - cVar.f2845a.b();
                        if (zE) {
                            int i6 = iA2 > numColumns2 ? 0 : iD2;
                            width = numColumns > iA ? getWidth() : iD;
                            i3 = i6;
                        } else {
                            i3 = numColumns > iA ? 0 : iD;
                            width = iA2 > numColumns2 ? getWidth() : iD2;
                        }
                        canvas.drawRect(i3, top, width, bottom, cVar.f2852h);
                        itemId++;
                        materialCalendarGridView = this;
                        it = it;
                        adapter = mVar;
                    }
                    materialCalendarGridView = this;
                    iMax = i4;
                    iMin = i5;
                }
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z2, int i3, Rect rect) {
        if (z2) {
            a(i3, rect);
        } else {
            super.onFocusChanged(false, i3, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (!super.onKeyDown(i3, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i3) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i4) {
        if (!this.f2825c) {
            super.onMeasure(i3, i4);
            return;
        }
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i3) {
        if (i3 < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i3);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof m)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), m.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f2824b = s.k();
        if (i.U1(getContext())) {
            setNextFocusLeftId(t0.f.cancel_button);
            setNextFocusRightId(t0.f.confirm_button);
        }
        this.f2825c = i.V1(getContext());
        e0.t.m0(this, new a());
    }
}
