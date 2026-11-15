package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import n0.l;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    private List<Preference> N;
    private boolean O;
    private int P;
    private boolean Q;
    private int R;
    private b S;
    final l.g<String, Long> T;
    private final Handler U;
    private final Runnable V;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                PreferenceGroup.this.T.clear();
            }
        }
    }

    public interface b {
        void a();
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.O = true;
        this.P = 0;
        this.Q = false;
        this.R = Integer.MAX_VALUE;
        this.S = null;
        this.T = new l.g<>();
        this.U = new Handler();
        this.V = new a();
        this.N = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.PreferenceGroup, i3, i4);
        int i5 = l.PreferenceGroup_orderingFromXml;
        this.O = v.g.b(typedArrayObtainStyledAttributes, i5, i5, true);
        int i6 = l.PreferenceGroup_initialExpandedChildrenCount;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            I0(v.g.d(typedArrayObtainStyledAttributes, i6, i6, Integer.MAX_VALUE));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public boolean A0(Preference preference) {
        long jF;
        if (this.N.contains(preference)) {
            return true;
        }
        if (preference.o() != null) {
            PreferenceGroup preferenceGroupR = this;
            while (preferenceGroupR.r() != null) {
                preferenceGroupR = preferenceGroupR.r();
            }
            String strO = preference.o();
            if (preferenceGroupR.B0(strO) != null) {
                Log.e("PreferenceGroup", "Found duplicated key: \"" + strO + "\". This can cause unintended behaviour, please use unique keys for every preference.");
            }
        }
        if (preference.q() == Integer.MAX_VALUE) {
            if (this.O) {
                int i3 = this.P;
                this.P = i3 + 1;
                preference.q0(i3);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).J0(this.O);
            }
        }
        int iBinarySearch = Collections.binarySearch(this.N, preference);
        if (iBinarySearch < 0) {
            iBinarySearch = (iBinarySearch * (-1)) - 1;
        }
        if (!H0(preference)) {
            return false;
        }
        synchronized (this) {
            this.N.add(iBinarySearch, preference);
        }
        f fVarX = x();
        String strO2 = preference.o();
        if (strO2 == null || !this.T.containsKey(strO2)) {
            jF = fVarX.f();
        } else {
            jF = this.T.get(strO2).longValue();
            this.T.remove(strO2);
        }
        preference.M(fVarX, jF);
        preference.a(this);
        if (this.Q) {
            preference.K();
        }
        J();
        return true;
    }

    public Preference B0(CharSequence charSequence) {
        Preference preferenceB0;
        if (TextUtils.equals(o(), charSequence)) {
            return this;
        }
        int iF0 = F0();
        for (int i3 = 0; i3 < iF0; i3++) {
            Preference preferenceE0 = E0(i3);
            String strO = preferenceE0.o();
            if (strO != null && strO.equals(charSequence)) {
                return preferenceE0;
            }
            if ((preferenceE0 instanceof PreferenceGroup) && (preferenceB0 = ((PreferenceGroup) preferenceE0).B0(charSequence)) != null) {
                return preferenceB0;
            }
        }
        return null;
    }

    public int C0() {
        return this.R;
    }

    public b D0() {
        return this.S;
    }

    public Preference E0(int i3) {
        return this.N.get(i3);
    }

    public int F0() {
        return this.N.size();
    }

    protected boolean G0() {
        return true;
    }

    protected boolean H0(Preference preference) {
        preference.T(this, u0());
        return true;
    }

    @Override // androidx.preference.Preference
    public void I(boolean z2) {
        super.I(z2);
        int iF0 = F0();
        for (int i3 = 0; i3 < iF0; i3++) {
            E0(i3).T(this, z2);
        }
    }

    public void I0(int i3) {
        if (i3 != Integer.MAX_VALUE && !C()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.R = i3;
    }

    public void J0(boolean z2) {
        this.O = z2;
    }

    @Override // androidx.preference.Preference
    public void K() {
        super.K();
        this.Q = true;
        int iF0 = F0();
        for (int i3 = 0; i3 < iF0; i3++) {
            E0(i3).K();
        }
    }

    void K0() {
        synchronized (this) {
            Collections.sort(this.N);
        }
    }

    @Override // androidx.preference.Preference
    public void Q() {
        super.Q();
        this.Q = false;
        int iF0 = F0();
        for (int i3 = 0; i3 < iF0; i3++) {
            E0(i3).Q();
        }
    }

    @Override // androidx.preference.Preference
    protected void U(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(c.class)) {
            super.U(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        this.R = cVar.f1622b;
        super.U(cVar.getSuperState());
    }

    @Override // androidx.preference.Preference
    protected Parcelable V() {
        return new c(super.V(), this.R);
    }

    @Override // androidx.preference.Preference
    protected void e(Bundle bundle) {
        super.e(bundle);
        int iF0 = F0();
        for (int i3 = 0; i3 < iF0; i3++) {
            E0(i3).e(bundle);
        }
    }

    @Override // androidx.preference.Preference
    protected void f(Bundle bundle) {
        super.f(bundle);
        int iF0 = F0();
        for (int i3 = 0; i3 < iF0; i3++) {
            E0(i3).f(bundle);
        }
    }

    public void z0(Preference preference) {
        A0(preference);
    }

    static class c extends Preference.b {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1622b;

        static class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i3) {
                return new c[i3];
            }
        }

        c(Parcel parcel) {
            super(parcel);
            this.f1622b = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f1622b);
        }

        c(Parcelable parcelable, int i3) {
            super(parcelable);
            this.f1622b = i3;
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
