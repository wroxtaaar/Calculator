package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import n0.h;
import n0.l;

/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    int N;
    int O;
    private int P;
    private int Q;
    boolean R;
    SeekBar S;
    private TextView T;
    boolean U;
    private boolean V;
    private SeekBar.OnSeekBarChangeListener W;
    private View.OnKeyListener X;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z2) {
            if (z2) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.R) {
                    return;
                }
                seekBarPreference.D0(seekBar);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.R = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.R = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.O != seekBarPreference.N) {
                seekBarPreference.D0(seekBar);
            }
        }
    }

    class b implements View.OnKeyListener {
        b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.U && (i3 == 21 || i3 == 22)) || i3 == 23 || i3 == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.S;
            if (seekBar != null) {
                return seekBar.onKeyDown(i3, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.W = new a();
        this.X = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.SeekBarPreference, i3, i4);
        this.O = typedArrayObtainStyledAttributes.getInt(l.SeekBarPreference_min, 0);
        z0(typedArrayObtainStyledAttributes.getInt(l.SeekBarPreference_android_max, 100));
        A0(typedArrayObtainStyledAttributes.getInt(l.SeekBarPreference_seekBarIncrement, 0));
        this.U = typedArrayObtainStyledAttributes.getBoolean(l.SeekBarPreference_adjustable, true);
        this.V = typedArrayObtainStyledAttributes.getBoolean(l.SeekBarPreference_showSeekBarValue, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void C0(int i3, boolean z2) {
        int i4 = this.O;
        if (i3 < i4) {
            i3 = i4;
        }
        int i5 = this.P;
        if (i3 > i5) {
            i3 = i5;
        }
        if (i3 != this.N) {
            this.N = i3;
            TextView textView = this.T;
            if (textView != null) {
                textView.setText(String.valueOf(i3));
            }
            b0(i3);
            if (z2) {
                H();
            }
        }
    }

    public final void A0(int i3) {
        if (i3 != this.Q) {
            this.Q = Math.min(this.P - this.O, Math.abs(i3));
            H();
        }
    }

    public void B0(int i3) {
        C0(i3, true);
    }

    void D0(SeekBar seekBar) {
        int progress = this.O + seekBar.getProgress();
        if (progress != this.N) {
            if (b(Integer.valueOf(progress))) {
                C0(progress, false);
            } else {
                seekBar.setProgress(this.N - this.O);
            }
        }
    }

    @Override // androidx.preference.Preference
    public void N(g gVar) {
        super.N(gVar);
        gVar.f1813a.setOnKeyListener(this.X);
        this.S = (SeekBar) gVar.M(h.seekbar);
        TextView textView = (TextView) gVar.M(h.seekbar_value);
        this.T = textView;
        if (this.V) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.T = null;
        }
        SeekBar seekBar = this.S;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.W);
        this.S.setMax(this.P - this.O);
        int i3 = this.Q;
        if (i3 != 0) {
            this.S.setKeyProgressIncrement(i3);
        } else {
            this.Q = this.S.getKeyProgressIncrement();
        }
        this.S.setProgress(this.N - this.O);
        TextView textView2 = this.T;
        if (textView2 != null) {
            textView2.setText(String.valueOf(this.N));
        }
        this.S.setEnabled(D());
    }

    @Override // androidx.preference.Preference
    protected Object R(TypedArray typedArray, int i3) {
        return Integer.valueOf(typedArray.getInt(i3, 0));
    }

    @Override // androidx.preference.Preference
    protected void U(Parcelable parcelable) {
        if (!parcelable.getClass().equals(c.class)) {
            super.U(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.U(cVar.getSuperState());
        this.N = cVar.f1625b;
        this.O = cVar.f1626c;
        this.P = cVar.f1627d;
        H();
    }

    @Override // androidx.preference.Preference
    protected Parcelable V() {
        Parcelable parcelableV = super.V();
        if (E()) {
            return parcelableV;
        }
        c cVar = new c(parcelableV);
        cVar.f1625b = this.N;
        cVar.f1626c = this.O;
        cVar.f1627d = this.P;
        return cVar;
    }

    @Override // androidx.preference.Preference
    protected void W(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        B0(t(((Integer) obj).intValue()));
    }

    public final void z0(int i3) {
        int i4 = this.O;
        if (i3 < i4) {
            i3 = i4;
        }
        if (i3 != this.P) {
            this.P = i3;
            H();
        }
    }

    private static class c extends Preference.b {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1627d;

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

        public c(Parcel parcel) {
            super(parcel);
            this.f1625b = parcel.readInt();
            this.f1626c = parcel.readInt();
            this.f1627d = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f1625b);
            parcel.writeInt(this.f1626c);
            parcel.writeInt(this.f1627d);
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, n0.f.seekBarPreferenceStyle);
    }
}
