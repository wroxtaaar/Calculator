package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import n0.l;

/* JADX INFO: loaded from: classes.dex */
public abstract class DialogPreference extends Preference {
    private CharSequence N;
    private CharSequence O;
    private Drawable P;
    private CharSequence Q;
    private CharSequence R;
    private int S;

    public interface a {
        Preference h(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.DialogPreference, i3, i4);
        String strO = v.g.o(typedArrayObtainStyledAttributes, l.DialogPreference_dialogTitle, l.DialogPreference_android_dialogTitle);
        this.N = strO;
        if (strO == null) {
            this.N = A();
        }
        this.O = v.g.o(typedArrayObtainStyledAttributes, l.DialogPreference_dialogMessage, l.DialogPreference_android_dialogMessage);
        this.P = v.g.c(typedArrayObtainStyledAttributes, l.DialogPreference_dialogIcon, l.DialogPreference_android_dialogIcon);
        this.Q = v.g.o(typedArrayObtainStyledAttributes, l.DialogPreference_positiveButtonText, l.DialogPreference_android_positiveButtonText);
        this.R = v.g.o(typedArrayObtainStyledAttributes, l.DialogPreference_negativeButtonText, l.DialogPreference_android_negativeButtonText);
        this.S = v.g.n(typedArrayObtainStyledAttributes, l.DialogPreference_dialogLayout, l.DialogPreference_android_dialogLayout, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int A0() {
        return this.S;
    }

    public CharSequence B0() {
        return this.O;
    }

    public CharSequence C0() {
        return this.N;
    }

    public CharSequence D0() {
        return this.R;
    }

    public CharSequence E0() {
        return this.Q;
    }

    @Override // androidx.preference.Preference
    protected void O() {
        x().u(this);
    }

    public Drawable z0() {
        return this.P;
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, v.g.a(context, n0.f.dialogPreferenceStyle, R.attr.dialogPreferenceStyle));
    }
}
