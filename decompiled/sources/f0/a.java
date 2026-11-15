package f0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: compiled from: AccessibilityClickableSpanCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f4635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f4636d;

    public a(int i3, d dVar, int i4) {
        this.f4634b = i3;
        this.f4635c = dVar;
        this.f4636d = i4;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f4634b);
        this.f4635c.O(this.f4636d, bundle);
    }
}
