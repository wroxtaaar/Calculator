package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.vivo.seckeysdk.BuildConfig;
import n0.l;

/* JADX INFO: loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    private CharSequence[] T;
    private CharSequence[] U;
    private String V;
    private String W;
    private boolean X;

    public ListPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ListPreference, i3, i4);
        this.T = v.g.q(typedArrayObtainStyledAttributes, l.ListPreference_entries, l.ListPreference_android_entries);
        this.U = v.g.q(typedArrayObtainStyledAttributes, l.ListPreference_entryValues, l.ListPreference_android_entryValues);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, l.Preference, i3, i4);
        this.W = v.g.o(typedArrayObtainStyledAttributes2, l.Preference_summary, l.Preference_android_summary);
        typedArrayObtainStyledAttributes2.recycle();
    }

    private int K0() {
        return F0(this.V);
    }

    public int F0(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.U) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.U[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] G0() {
        return this.T;
    }

    public CharSequence H0() {
        CharSequence[] charSequenceArr;
        int iK0 = K0();
        if (iK0 < 0 || (charSequenceArr = this.T) == null) {
            return null;
        }
        return charSequenceArr[iK0];
    }

    public CharSequence[] I0() {
        return this.U;
    }

    public String J0() {
        return this.V;
    }

    public void L0(String str) {
        boolean z2 = !TextUtils.equals(this.V, str);
        if (z2 || !this.X) {
            this.V = str;
            this.X = true;
            c0(str);
            if (z2) {
                H();
            }
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
        L0(aVar.f1593b);
    }

    @Override // androidx.preference.Preference
    protected Parcelable V() {
        Parcelable parcelableV = super.V();
        if (E()) {
            return parcelableV;
        }
        a aVar = new a(parcelableV);
        aVar.f1593b = J0();
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected void W(Object obj) {
        L0(u((String) obj));
    }

    @Override // androidx.preference.Preference
    public CharSequence z() {
        CharSequence charSequenceH0 = H0();
        String str = this.W;
        if (str == null) {
            return super.z();
        }
        Object[] objArr = new Object[1];
        if (charSequenceH0 == null) {
            charSequenceH0 = BuildConfig.FLAVOR;
        }
        objArr[0] = charSequenceH0;
        return String.format(str, objArr);
    }

    private static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0012a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f1593b;

        /* JADX INFO: renamed from: androidx.preference.ListPreference$a$a, reason: collision with other inner class name */
        static class C0012a implements Parcelable.Creator<a> {
            C0012a() {
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
            this.f1593b = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f1593b);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, v.g.a(context, n0.f.dialogPreferenceStyle, R.attr.dialogPreferenceStyle));
    }
}
