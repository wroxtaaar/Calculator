package com.vivo.calculator.pulltorefresh;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes.dex */
public class PullToRefreshScrollView extends f<ScrollView> {
    private static int D = -1;

    public PullToRefreshScrollView(Context context) {
        super(context);
    }

    public static int getmFlag() {
        return D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.calculator.pulltorefresh.f
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public ScrollView i(Context context, AttributeSet attributeSet) {
        return Build.VERSION.SDK_INT >= 9 ? new b(context, attributeSet, this) : new ScrollView(context, attributeSet);
    }

    @Override // com.vivo.calculator.pulltorefresh.f
    public final f.k getPullToRefreshScrollDirection() {
        return f.k.VERTICAL;
    }

    @Override // com.vivo.calculator.pulltorefresh.f
    protected boolean n() {
        View childAt = getmRefreshableViewWrapper().getChildAt(0);
        return childAt != null && getmRefreshableViewWrapper().getScrollY() >= childAt.getHeight() - getHeight();
    }

    @Override // com.vivo.calculator.pulltorefresh.f
    protected boolean o() {
        return getmRefreshableViewWrapper().getScrollY() == 0;
    }

    public PullToRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private PullToRefreshScrollView(Context context, f.e eVar) {
        super(context, eVar);
    }

    private PullToRefreshScrollView(Context context, f.e eVar, f.d dVar) {
        super(context, eVar, dVar);
    }
}
