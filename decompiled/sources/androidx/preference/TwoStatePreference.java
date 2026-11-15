package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {
    private CharSequence N;
    private CharSequence O;
    protected boolean P;
    private boolean Q;
    private boolean R;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
    }

    public void A0(boolean z2) {
        boolean z3 = this.P != z2;
        if (z3 || !this.Q) {
            this.P = z2;
            this.Q = true;
            a0(z2);
            if (z3) {
                I(u0());
                H();
            }
        }
    }

    public void B0(boolean z2) {
        this.R = z2;
    }

    public void C0(CharSequence charSequence) {
        this.O = charSequence;
        if (z0()) {
            return;
        }
        H();
    }

    public void D0(CharSequence charSequence) {
        this.N = charSequence;
        if (z0()) {
            H();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0030  */
    /* JADX WARN: Code duplicated, block: B:19:0x003a  */
    /* JADX WARN: Code duplicated, block: B:23:0x0043  */
    /* JADX WARN: Code duplicated, block: B:26:0x004a  */
    /* JADX WARN: Code duplicated, block: B:28:? A[RETURN, SYNTHETIC] */
    protected void E0(View view) {
        int i3;
        CharSequence charSequenceZ;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            boolean z2 = true;
            if (!this.P || TextUtils.isEmpty(this.N)) {
                if (!this.P && !TextUtils.isEmpty(this.O)) {
                    textView.setText(this.O);
                }
                if (z2) {
                    charSequenceZ = z();
                    if (!TextUtils.isEmpty(charSequenceZ)) {
                        textView.setText(charSequenceZ);
                        z2 = false;
                    }
                }
                i3 = z2 ? 8 : 0;
                if (i3 != textView.getVisibility()) {
                    textView.setVisibility(i3);
                }
            }
            textView.setText(this.N);
            z2 = false;
            if (z2) {
                charSequenceZ = z();
                if (!TextUtils.isEmpty(charSequenceZ)) {
                    textView.setText(charSequenceZ);
                    z2 = false;
                }
            }
            if (z2) {
            }
            if (i3 != textView.getVisibility()) {
                textView.setVisibility(i3);
            }
        }
    }

    protected void F0(g gVar) {
        E0(gVar.M(R.id.summary));
    }

    @Override // androidx.preference.Preference
    protected void O() {
        super.O();
        boolean z2 = !z0();
        if (b(Boolean.valueOf(z2))) {
            A0(z2);
        }
    }

    @Override // androidx.preference.Preference
    protected Object R(TypedArray typedArray, int i3) {
        return Boolean.valueOf(typedArray.getBoolean(i3, false));
    }

    @Override // androidx.preference.Preference
    protected void U(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(a.class)) {
            super.U(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.U(aVar.getSuperState());
        A0(aVar.f1630b);
    }

    @Override // androidx.preference.Preference
    protected Parcelable V() {
        Parcelable parcelableV = super.V();
        if (E()) {
            return parcelableV;
        }
        a aVar = new a(parcelableV);
        aVar.f1630b = z0();
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected void W(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        A0(s(((Boolean) obj).booleanValue()));
    }

    @Override // androidx.preference.Preference
    public boolean u0() {
        boolean z2;
        if (this.R) {
            z2 = this.P;
        } else {
            z2 = !this.P;
        }
        return z2 || super.u0();
    }

    public boolean z0() {
        return this.P;
    }

    static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0014a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f1630b;

        /* JADX INFO: renamed from: androidx.preference.TwoStatePreference$a$a, reason: collision with other inner class name */
        static class C0014a implements Parcelable.Creator<a> {
            C0014a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i3) {
                return new a[i3];
            }
        }

        public a(Parcel parcel) {
            super(parcel);
            this.f1630b = parcel.readInt() == 1;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f1630b ? 1 : 0);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoStatePreference(Context context) {
        this(context, null);
    }
}
