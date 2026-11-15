package com.vivo.calculator.pulltorefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ScrollView;
import vivo.util.VLog;

/* JADX INFO: compiled from: InternalScrollViewSDK9.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(9)
public class b extends ScrollView implements d.c, d.InterfaceC0049d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PullToRefreshScrollView f4161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f4162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f4164e;

    /* JADX INFO: compiled from: InternalScrollViewSDK9.java */
    interface a {
        void a(int i3, int i4);
    }

    public b(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    private void d(Context context) {
        d dVar = new d(this);
        this.f4162c = dVar;
        dVar.j(this);
    }

    @Override // com.vivo.calculator.pulltorefresh.d.InterfaceC0049d
    public void a(int i3, int i4) {
        a aVar = this.f4164e;
        if (aVar != null) {
            aVar.a(i3, i4);
        }
    }

    @Override // com.vivo.calculator.pulltorefresh.d.c
    public boolean b(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z2) {
        return super.overScrollBy(i3, i4, i5, i6, i7, i8, i9, i10, z2);
    }

    @Override // com.vivo.calculator.pulltorefresh.d.c
    public void c(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void draw(Canvas canvas) {
        this.f4162c.b(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public d getOverScrollDelegate() {
        return this.f4162c;
    }

    @Override // com.vivo.calculator.pulltorefresh.d.c
    public View getOverScrollableView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f4162c.e(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i3, int i4, boolean z2, boolean z3) {
        super.onOverScrolled(i3, i4, z2, z3);
        if (this.f4161b.getScrollViewListener() != null) {
            this.f4161b.getScrollViewListener().h(i4, this.f4163d);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f4162c.g(motionEvent)) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e3) {
            VLog.e("InternalScrollViewSDK9", "onTouchEvent exception:" + e3.getMessage());
            return false;
        }
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z2) {
        this.f4163d = i8;
        return this.f4162c.i(i3, i4, i5, i6, i7, i8, i9, i10, z2);
    }

    public void setScrollOverDYListener(a aVar) {
        this.f4164e = aVar;
    }

    public b(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f4163d = -1;
    }

    public b(Context context, AttributeSet attributeSet, PullToRefreshScrollView pullToRefreshScrollView) {
        this(context, attributeSet, g.b("scrollViewStyle"));
        this.f4161b = pullToRefreshScrollView;
        d(context);
    }
}
