package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.preference.internal.AbstractMultiSelectListPreference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import n0.l;

/* JADX INFO: loaded from: classes.dex */
public class MultiSelectListPreference extends AbstractMultiSelectListPreference {
    private CharSequence[] T;
    private CharSequence[] U;
    private Set<String> V;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.V = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.MultiSelectListPreference, i3, i4);
        this.T = v.g.q(typedArrayObtainStyledAttributes, l.MultiSelectListPreference_entries, l.MultiSelectListPreference_android_entries);
        this.U = v.g.q(typedArrayObtainStyledAttributes, l.MultiSelectListPreference_entryValues, l.MultiSelectListPreference_android_entryValues);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.internal.AbstractMultiSelectListPreference
    public CharSequence[] F0() {
        return this.T;
    }

    @Override // androidx.preference.internal.AbstractMultiSelectListPreference
    public CharSequence[] G0() {
        return this.U;
    }

    @Override // androidx.preference.internal.AbstractMultiSelectListPreference
    public Set<String> H0() {
        return this.V;
    }

    @Override // androidx.preference.internal.AbstractMultiSelectListPreference
    public void I0(Set<String> set) {
        this.V.clear();
        this.V.addAll(set);
        d0(set);
    }

    @Override // androidx.preference.Preference
    protected Object R(TypedArray typedArray, int i3) {
        CharSequence[] textArray = typedArray.getTextArray(i3);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // androidx.preference.Preference
    protected void U(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(a.class)) {
            super.U(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.U(aVar.getSuperState());
        I0(aVar.f1594b);
    }

    @Override // androidx.preference.Preference
    protected Parcelable V() {
        Parcelable parcelableV = super.V();
        if (E()) {
            return parcelableV;
        }
        a aVar = new a(parcelableV);
        aVar.f1594b = H0();
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected void W(Object obj) {
        I0(v((Set) obj));
    }

    private static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0013a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Set<String> f1594b;

        /* JADX INFO: renamed from: androidx.preference.MultiSelectListPreference$a$a, reason: collision with other inner class name */
        static class C0013a implements Parcelable.Creator<a> {
            C0013a() {
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

        a(Parcel parcel) {
            super(parcel);
            int i3 = parcel.readInt();
            this.f1594b = new HashSet();
            String[] strArr = new String[i3];
            parcel.readStringArray(strArr);
            Collections.addAll(this.f1594b, strArr);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f1594b.size());
            Set<String> set = this.f1594b;
            parcel.writeStringArray((String[]) set.toArray(new String[set.size()]));
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, v.g.a(context, n0.f.dialogPreferenceStyle, R.attr.dialogPreferenceStyle));
    }
}
