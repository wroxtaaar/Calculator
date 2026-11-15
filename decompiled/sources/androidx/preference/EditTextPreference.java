package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    private String T;

    public EditTextPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
    }

    public String F0() {
        return this.T;
    }

    public void G0(String str) {
        boolean zU0 = u0();
        this.T = str;
        c0(str);
        boolean zU1 = u0();
        if (zU1 != zU0) {
            I(zU1);
        }
    }

    @Override // androidx.preference.Preference
    protected Object R(TypedArray typedArray, int i3) {
        return typedArray.getString(i3);
    }

    @Override // androidx.preference.Preference
    protected void U(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(a.class)) {
            super.U(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.U(aVar.getSuperState());
        G0(aVar.f1592b);
    }

    @Override // androidx.preference.Preference
    protected Parcelable V() {
        Parcelable parcelableV = super.V();
        if (E()) {
            return parcelableV;
        }
        a aVar = new a(parcelableV);
        aVar.f1592b = F0();
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected void W(Object obj) {
        G0(u((String) obj));
    }

    @Override // androidx.preference.Preference
    public boolean u0() {
        return TextUtils.isEmpty(this.T) || super.u0();
    }

    private static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0011a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f1592b;

        /* JADX INFO: renamed from: androidx.preference.EditTextPreference$a$a, reason: collision with other inner class name */
        static class C0011a implements Parcelable.Creator<a> {
            C0011a() {
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
            this.f1592b = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f1592b);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, v.g.a(context, n0.f.editTextPreferenceStyle, R.attr.editTextPreferenceStyle));
    }
}
