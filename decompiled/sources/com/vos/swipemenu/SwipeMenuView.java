package com.vos.swipemenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import u2.d;

/* JADX INFO: loaded from: classes.dex */
public class SwipeMenuView extends LinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f4360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RecyclerView.d0 f4361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private u2.b f4363e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View.OnClickListener f4364f;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SwipeMenuView.this.f4363e == null || SwipeMenuView.this.f4360b == null || !SwipeMenuView.this.f4360b.a()) {
                return;
            }
            SwipeMenuView.this.f4363e.a(SwipeMenuView.this.f4360b, SwipeMenuView.this.f4361c.j(), view.getId(), SwipeMenuView.this.f4362d);
        }
    }

    public SwipeMenuView(Context context) {
        this(context, null);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public SwipeMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    public SwipeMenuView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f4364f = new a();
    }
}
