package com.vos.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewOverlay;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import x2.c;
import y1.d;

/* JADX INFO: loaded from: classes.dex */
public class VToolBar extends Toolbar {
    private boolean Q;
    private Drawable R;
    private int S;
    private int T;
    private int U;
    private TextView V;

    public VToolBar(Context context) {
        this(context, null);
    }

    private void O(Context context) {
        this.R = getResources().getDrawable(d.vigour_toolbar_divider);
    }

    private TextView getTitleView() {
        TextView textView = this.V;
        return textView != null ? textView : (TextView) c.a(Toolbar.class, "mTitleTextView", this);
    }

    public void P(boolean z2) {
        if (this.Q != z2) {
            this.Q = z2;
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.Q || this.R == null) {
            return;
        }
        this.R.setBounds(0, (int) ((getHeight() - 1) - 0.5f), getWidth(), getHeight());
        this.R.draw(canvas);
    }

    public VToolBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Q = false;
        this.R = null;
        this.S = 18;
        this.T = 30;
        this.U = 44;
        O(context);
        setWillNotDraw(false);
    }
}
