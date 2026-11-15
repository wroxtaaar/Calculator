package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* JADX INFO: compiled from: AppCompatRatingBar.java */
/* JADX INFO: loaded from: classes.dex */
public class t extends RatingBar {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r f773b;

    public t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.ratingBarStyle);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        Bitmap bitmapB = this.f773b.b();
        if (bitmapB != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapB.getWidth() * getNumStars(), i3, 0), getMeasuredHeight());
        }
    }

    public t(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        r0.a(this, getContext());
        r rVar = new r(this);
        this.f773b = rVar;
        rVar.c(attributeSet, i3);
    }
}
