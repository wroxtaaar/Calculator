package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* JADX INFO: compiled from: AppCompatToggleButton.java */
/* JADX INFO: loaded from: classes.dex */
public class b0 extends ToggleButton {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y f540b;

    public b0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    public b0(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        r0.a(this, getContext());
        y yVar = new y(this);
        this.f540b = yVar;
        yVar.m(attributeSet, i3);
    }
}
