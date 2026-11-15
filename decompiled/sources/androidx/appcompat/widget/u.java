package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: compiled from: AppCompatSeekBar.java */
/* JADX INFO: loaded from: classes.dex */
public class u extends SeekBar {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v f778b;

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.seekBarStyle);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f778b.h();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f778b.i();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f778b.g(canvas);
    }

    public u(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        r0.a(this, getContext());
        v vVar = new v(this);
        this.f778b = vVar;
        vVar.c(attributeSet, i3);
    }
}
