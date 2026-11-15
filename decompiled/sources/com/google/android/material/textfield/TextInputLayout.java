package com.google.android.material.textfield;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.w0;
import androidx.appcompat.widget.z;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.m;
import com.vivo.seckeysdk.BuildConfig;
import com.vivo.seckeysdk.SecurityKeyCipher;
import e0.t;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p0.o;

/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    private static final int J0 = t0.j.Widget_Design_TextInputLayout;
    private ColorStateList A;
    private int A0;
    private CharSequence B;
    private int B0;
    private final TextView C;
    private boolean C0;
    private boolean D;
    final com.google.android.material.internal.b D0;
    private CharSequence E;
    private boolean E0;
    private boolean F;
    private boolean F0;
    private k1.g G;
    private ValueAnimator G0;
    private k1.g H;
    private boolean H0;
    private k1.g I;
    private boolean I0;
    private k1.k J;
    private boolean K;
    private final int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private final Rect T;
    private final Rect U;
    private final RectF V;
    private Typeface W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private Drawable f3220a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FrameLayout f3221b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private int f3222b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f3223c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private final LinkedHashSet<f> f3224c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f3225d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f3226d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FrameLayout f3227e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final SparseArray<com.google.android.material.textfield.e> f3228e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    EditText f3229f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private final CheckableImageButton f3230f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CharSequence f3231g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final LinkedHashSet<g> f3232g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3233h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private ColorStateList f3234h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3235i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private PorterDuff.Mode f3236i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f3237j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private Drawable f3238j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f3239k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private int f3240k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.google.android.material.textfield.g f3241l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private Drawable f3242l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f3243m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private View.OnLongClickListener f3244m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f3245n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private View.OnLongClickListener f3246n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f3247o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private final CheckableImageButton f3248o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f3249p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private ColorStateList f3250p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f3251q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private PorterDuff.Mode f3252q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f3253r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private ColorStateList f3254r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CharSequence f3255s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private ColorStateList f3256s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f3257t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f3258t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f3259u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private int f3260u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ColorStateList f3261v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private int f3262v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f3263w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private ColorStateList f3264w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private p0.d f3265x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private int f3266x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private p0.d f3267y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private int f3268y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ColorStateList f3269z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private int f3270z0;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.w0(!textInputLayout.I0);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f3243m) {
                textInputLayout2.m0(editable.length());
            }
            if (TextInputLayout.this.f3257t) {
                TextInputLayout.this.A0(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f3230f0.performClick();
            TextInputLayout.this.f3230f0.jumpDrawablesToCurrentState();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f3229f.requestLayout();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.D0.d0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends e0.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TextInputLayout f3275d;

        public e(TextInputLayout textInputLayout) {
            this.f3275d = textInputLayout;
        }

        @Override // e0.a
        public void g(View view, f0.d dVar) {
            View viewS;
            super.g(view, dVar);
            EditText editText = this.f3275d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f3275d.getHint();
            CharSequence error = this.f3275d.getError();
            CharSequence placeholderText = this.f3275d.getPlaceholderText();
            int counterMaxLength = this.f3275d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f3275d.getCounterOverflowDescription();
            boolean z2 = !TextUtils.isEmpty(text);
            boolean z3 = !TextUtils.isEmpty(hint);
            boolean z4 = !this.f3275d.N();
            boolean z5 = !TextUtils.isEmpty(error);
            boolean z6 = z5 || !TextUtils.isEmpty(counterOverflowDescription);
            String string = z3 ? hint.toString() : BuildConfig.FLAVOR;
            this.f3275d.f3223c.v(dVar);
            if (z2) {
                dVar.t0(text);
            } else if (!TextUtils.isEmpty(string)) {
                dVar.t0(string);
                if (z4 && placeholderText != null) {
                    dVar.t0(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                dVar.t0(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    dVar.h0(string);
                } else {
                    if (z2) {
                        string = ((Object) text) + ", " + string;
                    }
                    dVar.t0(string);
                }
                dVar.q0(!z2);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            dVar.j0(counterMaxLength);
            if (z6) {
                if (!z5) {
                    error = counterOverflowDescription;
                }
                dVar.d0(error);
            }
            if (Build.VERSION.SDK_INT < 17 || (viewS = this.f3275d.f3241l.s()) == null) {
                return;
            }
            dVar.i0(viewS);
        }
    }

    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    public interface g {
        void a(TextInputLayout textInputLayout, int i3);
    }

    static class h extends i0.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        CharSequence f3276d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f3277e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        CharSequence f3278f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        CharSequence f3279g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        CharSequence f3280h;

        class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i3) {
                return new h[i3];
            }
        }

        h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f3276d) + " hint=" + ((Object) this.f3278f) + " helperText=" + ((Object) this.f3279g) + " placeholderText=" + ((Object) this.f3280h) + "}";
        }

        @Override // i0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            TextUtils.writeToParcel(this.f3276d, parcel, i3);
            parcel.writeInt(this.f3277e ? 1 : 0);
            TextUtils.writeToParcel(this.f3278f, parcel, i3);
            TextUtils.writeToParcel(this.f3279g, parcel, i3);
            TextUtils.writeToParcel(this.f3280h, parcel, i3);
        }

        h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3276d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f3277e = parcel.readInt() == 1;
            this.f3278f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f3279g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f3280h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    private boolean A() {
        return this.D && !TextUtils.isEmpty(this.E) && (this.G instanceof com.google.android.material.textfield.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(int i3) {
        if (i3 != 0 || this.C0) {
            J();
        } else {
            h0();
        }
    }

    private void B() {
        Iterator<f> it = this.f3224c0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void B0(boolean z2, boolean z3) {
        int defaultColor = this.f3264w0.getDefaultColor();
        int colorForState = this.f3264w0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f3264w0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z2) {
            this.R = colorForState2;
        } else if (z3) {
            this.R = colorForState;
        } else {
            this.R = defaultColor;
        }
    }

    private void C(int i3) {
        Iterator<g> it = this.f3232g0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i3);
        }
    }

    private void C0() {
        if (this.f3229f == null) {
            return;
        }
        t.y0(this.C, getContext().getResources().getDimensionPixelSize(t0.d.material_input_text_to_prefix_suffix_padding), this.f3229f.getPaddingTop(), (K() || L()) ? 0 : t.F(this.f3229f), this.f3229f.getPaddingBottom());
    }

    private void D(Canvas canvas) {
        k1.g gVar;
        if (this.I == null || (gVar = this.H) == null) {
            return;
        }
        gVar.draw(canvas);
        if (this.f3229f.isFocused()) {
            Rect bounds = this.I.getBounds();
            Rect bounds2 = this.H.getBounds();
            float fX = this.D0.x();
            int iCenterX = bounds2.centerX();
            bounds.left = u0.a.c(iCenterX, bounds2.left, fX);
            bounds.right = u0.a.c(iCenterX, bounds2.right, fX);
            this.I.draw(canvas);
        }
    }

    private void D0() {
        int visibility = this.C.getVisibility();
        int i3 = (this.B == null || N()) ? 8 : 0;
        if (visibility != i3) {
            getEndIconDelegate().c(i3 == 0);
        }
        t0();
        this.C.setVisibility(i3);
        q0();
    }

    private void E(Canvas canvas) {
        if (this.D) {
            this.D0.l(canvas);
        }
    }

    private void F(boolean z2) {
        ValueAnimator valueAnimator = this.G0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.G0.cancel();
        }
        if (z2 && this.F0) {
            k(0.0f);
        } else {
            this.D0.d0(0.0f);
        }
        if (A() && ((com.google.android.material.textfield.c) this.G).j0()) {
            x();
        }
        this.C0 = true;
        J();
        this.f3223c.i(true);
        D0();
    }

    private int G(int i3, boolean z2) {
        int compoundPaddingLeft = i3 + this.f3229f.getCompoundPaddingLeft();
        return (getPrefixText() == null || z2) ? compoundPaddingLeft : (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
    }

    private int H(int i3, boolean z2) {
        int compoundPaddingRight = i3 - this.f3229f.getCompoundPaddingRight();
        return (getPrefixText() == null || !z2) ? compoundPaddingRight : compoundPaddingRight + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
    }

    private boolean I() {
        return this.f3226d0 != 0;
    }

    private void J() {
        TextView textView = this.f3259u;
        if (textView == null || !this.f3257t) {
            return;
        }
        textView.setText((CharSequence) null);
        o.a(this.f3221b, this.f3267y);
        this.f3259u.setVisibility(4);
    }

    private boolean L() {
        return this.f3248o0.getVisibility() == 0;
    }

    private boolean P() {
        return this.M == 1 && (Build.VERSION.SDK_INT < 16 || this.f3229f.getMinLines() <= 1);
    }

    private void Q() {
        o();
        Z();
        E0();
        j0();
        j();
        if (this.M != 0) {
            v0();
        }
    }

    private void R() {
        if (A()) {
            RectF rectF = this.V;
            this.D0.o(rectF, this.f3229f.getWidth(), this.f3229f.getGravity());
            n(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.O);
            ((com.google.android.material.textfield.c) this.G).m0(rectF);
        }
    }

    private void S() {
        if (!A() || this.C0) {
            return;
        }
        x();
        R();
    }

    private static void T(ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
                T((ViewGroup) childAt, z2);
            }
        }
    }

    private void X() {
        TextView textView = this.f3259u;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void Z() {
        if (g0()) {
            t.p0(this.f3229f, this.G);
        }
    }

    private static void a0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zN = t.N(checkableImageButton);
        boolean z2 = onLongClickListener != null;
        boolean z3 = zN || z2;
        checkableImageButton.setFocusable(z3);
        checkableImageButton.setClickable(zN);
        checkableImageButton.setPressable(zN);
        checkableImageButton.setLongClickable(z2);
        t.v0(checkableImageButton, z3 ? 1 : 2);
    }

    private static void b0(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        a0(checkableImageButton, onLongClickListener);
    }

    private static void c0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        a0(checkableImageButton, onLongClickListener);
    }

    private boolean e0() {
        return (this.f3248o0.getVisibility() == 0 || ((I() && K()) || this.B != null)) && this.f3225d.getMeasuredWidth() > 0;
    }

    private boolean f0() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f3223c.getMeasuredWidth() > 0;
    }

    private boolean g0() {
        EditText editText = this.f3229f;
        return (editText == null || this.G == null || editText.getBackground() != null || this.M == 0) ? false : true;
    }

    private com.google.android.material.textfield.e getEndIconDelegate() {
        com.google.android.material.textfield.e eVar = this.f3228e0.get(this.f3226d0);
        return eVar != null ? eVar : this.f3228e0.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.f3248o0.getVisibility() == 0) {
            return this.f3248o0;
        }
        if (I() && K()) {
            return this.f3230f0;
        }
        return null;
    }

    private void h0() {
        if (this.f3259u == null || !this.f3257t || TextUtils.isEmpty(this.f3255s)) {
            return;
        }
        this.f3259u.setText(this.f3255s);
        o.a(this.f3221b, this.f3265x);
        this.f3259u.setVisibility(0);
        this.f3259u.bringToFront();
        if (Build.VERSION.SDK_INT >= 16) {
            announceForAccessibility(this.f3255s);
        }
    }

    private void i() {
        TextView textView = this.f3259u;
        if (textView != null) {
            this.f3221b.addView(textView);
            this.f3259u.setVisibility(0);
        }
    }

    private void i0(boolean z2) {
        if (!z2 || getEndIconDrawable() == null) {
            com.google.android.material.textfield.f.a(this, this.f3230f0, this.f3234h0, this.f3236i0);
            return;
        }
        Drawable drawableMutate = x.a.r(getEndIconDrawable()).mutate();
        x.a.n(drawableMutate, this.f3241l.p());
        this.f3230f0.setImageDrawable(drawableMutate);
    }

    private void j() {
        if (this.f3229f == null || this.M != 1) {
            return;
        }
        if (h1.c.h(getContext())) {
            EditText editText = this.f3229f;
            t.y0(editText, t.G(editText), getResources().getDimensionPixelSize(t0.d.material_filled_edittext_font_2_0_padding_top), t.F(this.f3229f), getResources().getDimensionPixelSize(t0.d.material_filled_edittext_font_2_0_padding_bottom));
        } else if (h1.c.g(getContext())) {
            EditText editText2 = this.f3229f;
            t.y0(editText2, t.G(editText2), getResources().getDimensionPixelSize(t0.d.material_filled_edittext_font_1_3_padding_top), t.F(this.f3229f), getResources().getDimensionPixelSize(t0.d.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    private void j0() {
        if (this.M == 1) {
            if (h1.c.h(getContext())) {
                this.N = getResources().getDimensionPixelSize(t0.d.material_font_2_0_box_collapsed_padding_top);
            } else if (h1.c.g(getContext())) {
                this.N = getResources().getDimensionPixelSize(t0.d.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    private void k0(Rect rect) {
        k1.g gVar = this.H;
        if (gVar != null) {
            int i3 = rect.bottom;
            gVar.setBounds(rect.left, i3 - this.P, rect.right, i3);
        }
        k1.g gVar2 = this.I;
        if (gVar2 != null) {
            int i4 = rect.bottom;
            gVar2.setBounds(rect.left, i4 - this.Q, rect.right, i4);
        }
    }

    private void l() {
        k1.g gVar = this.G;
        if (gVar == null) {
            return;
        }
        k1.k kVarD = gVar.D();
        k1.k kVar = this.J;
        if (kVarD != kVar) {
            this.G.setShapeAppearanceModel(kVar);
            p0();
        }
        if (v()) {
            this.G.c0(this.O, this.R);
        }
        int iP = p();
        this.S = iP;
        this.G.X(ColorStateList.valueOf(iP));
        if (this.f3226d0 == 3) {
            this.f3229f.getBackground().invalidateSelf();
        }
        m();
        invalidate();
    }

    private void l0() {
        if (this.f3249p != null) {
            EditText editText = this.f3229f;
            m0(editText == null ? 0 : editText.getText().length());
        }
    }

    private void m() {
        if (this.H == null || this.I == null) {
            return;
        }
        if (w()) {
            this.H.X(this.f3229f.isFocused() ? ColorStateList.valueOf(this.f3258t0) : ColorStateList.valueOf(this.R));
            this.I.X(ColorStateList.valueOf(this.R));
        }
        invalidate();
    }

    private void n(RectF rectF) {
        float f3 = rectF.left;
        int i3 = this.L;
        rectF.left = f3 - i3;
        rectF.right += i3;
    }

    private static void n0(Context context, TextView textView, int i3, int i4, boolean z2) {
        textView.setContentDescription(context.getString(z2 ? t0.i.character_counter_overflowed_content_description : t0.i.character_counter_content_description, Integer.valueOf(i3), Integer.valueOf(i4)));
    }

    private void o() {
        int i3 = this.M;
        if (i3 == 0) {
            this.G = null;
            this.H = null;
            this.I = null;
            return;
        }
        if (i3 == 1) {
            this.G = new k1.g(this.J);
            this.H = new k1.g();
            this.I = new k1.g();
        } else {
            if (i3 != 2) {
                throw new IllegalArgumentException(this.M + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.D || (this.G instanceof com.google.android.material.textfield.c)) {
                this.G = new k1.g(this.J);
            } else {
                this.G = new com.google.android.material.textfield.c(this.J);
            }
            this.H = null;
            this.I = null;
        }
    }

    private void o0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f3249p;
        if (textView != null) {
            d0(textView, this.f3247o ? this.f3251q : this.f3253r);
            if (!this.f3247o && (colorStateList2 = this.f3269z) != null) {
                this.f3249p.setTextColor(colorStateList2);
            }
            if (!this.f3247o || (colorStateList = this.A) == null) {
                return;
            }
            this.f3249p.setTextColor(colorStateList);
        }
    }

    private int p() {
        return this.M == 1 ? z0.c.g(z0.c.e(this, t0.b.colorSurface, 0), this.S) : this.S;
    }

    private void p0() {
        if (this.f3226d0 == 3 && this.M == 2) {
            ((com.google.android.material.textfield.d) this.f3228e0.get(3)).O((AutoCompleteTextView) this.f3229f);
        }
    }

    private Rect q(Rect rect) {
        if (this.f3229f == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.U;
        boolean zE = com.google.android.material.internal.o.e(this);
        rect2.bottom = rect.bottom;
        int i3 = this.M;
        if (i3 == 1) {
            rect2.left = G(rect.left, zE);
            rect2.top = rect.top + this.N;
            rect2.right = H(rect.right, zE);
            return rect2;
        }
        if (i3 != 2) {
            rect2.left = G(rect.left, zE);
            rect2.top = getPaddingTop();
            rect2.right = H(rect.right, zE);
            return rect2;
        }
        rect2.left = rect.left + this.f3229f.getPaddingLeft();
        rect2.top = rect.top - u();
        rect2.right = rect.right - this.f3229f.getPaddingRight();
        return rect2;
    }

    private int r(Rect rect, Rect rect2, float f3) {
        return P() ? (int) (rect2.top + f3) : rect.bottom - this.f3229f.getCompoundPaddingBottom();
    }

    private int s(Rect rect, float f3) {
        return P() ? (int) (rect.centerY() - (f3 / 2.0f)) : rect.top + this.f3229f.getCompoundPaddingTop();
    }

    private boolean s0() {
        int iMax;
        if (this.f3229f == null || this.f3229f.getMeasuredHeight() >= (iMax = Math.max(this.f3225d.getMeasuredHeight(), this.f3223c.getMeasuredHeight()))) {
            return false;
        }
        this.f3229f.setMinimumHeight(iMax);
        return true;
    }

    private void setEditText(EditText editText) {
        if (this.f3229f != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.f3226d0 != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f3229f = editText;
        int i3 = this.f3233h;
        if (i3 != -1) {
            setMinEms(i3);
        } else {
            setMinWidth(this.f3237j);
        }
        int i4 = this.f3235i;
        if (i4 != -1) {
            setMaxEms(i4);
        } else {
            setMaxWidth(this.f3239k);
        }
        Q();
        setTextInputAccessibilityDelegate(new e(this));
        this.D0.j0(this.f3229f.getTypeface());
        this.D0.b0(this.f3229f.getTextSize());
        if (Build.VERSION.SDK_INT >= 21) {
            this.D0.X(this.f3229f.getLetterSpacing());
        }
        int gravity = this.f3229f.getGravity();
        this.D0.S((gravity & (-113)) | 48);
        this.D0.a0(gravity);
        this.f3229f.addTextChangedListener(new a());
        if (this.f3254r0 == null) {
            this.f3254r0 = this.f3229f.getHintTextColors();
        }
        if (this.D) {
            if (TextUtils.isEmpty(this.E)) {
                CharSequence hint = this.f3229f.getHint();
                this.f3231g = hint;
                setHint(hint);
                this.f3229f.setHint((CharSequence) null);
            }
            this.F = true;
        }
        if (this.f3249p != null) {
            m0(this.f3229f.getText().length());
        }
        r0();
        this.f3241l.f();
        this.f3223c.bringToFront();
        this.f3225d.bringToFront();
        this.f3227e.bringToFront();
        this.f3248o0.bringToFront();
        B();
        C0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        x0(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.E)) {
            return;
        }
        this.E = charSequence;
        this.D0.h0(charSequence);
        if (this.C0) {
            return;
        }
        R();
    }

    private void setPlaceholderTextEnabled(boolean z2) {
        if (this.f3257t == z2) {
            return;
        }
        if (z2) {
            i();
        } else {
            X();
            this.f3259u = null;
        }
        this.f3257t = z2;
    }

    private Rect t(Rect rect) {
        if (this.f3229f == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.U;
        float fW = this.D0.w();
        rect2.left = rect.left + this.f3229f.getCompoundPaddingLeft();
        rect2.top = s(rect, fW);
        rect2.right = rect.right - this.f3229f.getCompoundPaddingRight();
        rect2.bottom = r(rect, rect2, fW);
        return rect2;
    }

    private void t0() {
        this.f3227e.setVisibility((this.f3230f0.getVisibility() != 0 || L()) ? 8 : 0);
        this.f3225d.setVisibility(K() || L() || ((this.B == null || N()) ? '\b' : (char) 0) == 0 ? 0 : 8);
    }

    private int u() {
        float fQ;
        if (!this.D) {
            return 0;
        }
        int i3 = this.M;
        if (i3 == 0) {
            fQ = this.D0.q();
        } else {
            if (i3 != 2) {
                return 0;
            }
            fQ = this.D0.q() / 2.0f;
        }
        return (int) fQ;
    }

    private void u0() {
        this.f3248o0.setVisibility(getErrorIconDrawable() != null && this.f3241l.z() && this.f3241l.l() ? 0 : 8);
        t0();
        C0();
        if (I()) {
            return;
        }
        q0();
    }

    private boolean v() {
        return this.M == 2 && w();
    }

    private void v0() {
        if (this.M != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3221b.getLayoutParams();
            int iU = u();
            if (iU != layoutParams.topMargin) {
                layoutParams.topMargin = iU;
                this.f3221b.requestLayout();
            }
        }
    }

    private boolean w() {
        return this.O > -1 && this.R != 0;
    }

    private void x() {
        if (A()) {
            ((com.google.android.material.textfield.c) this.G).k0();
        }
    }

    private void x0(boolean z2, boolean z3) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f3229f;
        boolean z4 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f3229f;
        boolean z5 = editText2 != null && editText2.hasFocus();
        boolean zL = this.f3241l.l();
        ColorStateList colorStateList2 = this.f3254r0;
        if (colorStateList2 != null) {
            this.D0.R(colorStateList2);
            this.D0.Z(this.f3254r0);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.f3254r0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.B0) : this.B0;
            this.D0.R(ColorStateList.valueOf(colorForState));
            this.D0.Z(ColorStateList.valueOf(colorForState));
        } else if (zL) {
            this.D0.R(this.f3241l.q());
        } else if (this.f3247o && (textView = this.f3249p) != null) {
            this.D0.R(textView.getTextColors());
        } else if (z5 && (colorStateList = this.f3256s0) != null) {
            this.D0.R(colorStateList);
        }
        if (z4 || !this.E0 || (isEnabled() && z5)) {
            if (z3 || this.C0) {
                y(z2);
                return;
            }
            return;
        }
        if (z3 || !this.C0) {
            F(z2);
        }
    }

    private void y(boolean z2) {
        ValueAnimator valueAnimator = this.G0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.G0.cancel();
        }
        if (z2 && this.F0) {
            k(1.0f);
        } else {
            this.D0.d0(1.0f);
        }
        this.C0 = false;
        if (A()) {
            R();
        }
        z0();
        this.f3223c.i(false);
        D0();
    }

    private void y0() {
        EditText editText;
        if (this.f3259u == null || (editText = this.f3229f) == null) {
            return;
        }
        this.f3259u.setGravity(editText.getGravity());
        this.f3259u.setPadding(this.f3229f.getCompoundPaddingLeft(), this.f3229f.getCompoundPaddingTop(), this.f3229f.getCompoundPaddingRight(), this.f3229f.getCompoundPaddingBottom());
    }

    private p0.d z() {
        p0.d dVar = new p0.d();
        dVar.U(87L);
        dVar.W(u0.a.f6257a);
        return dVar;
    }

    private void z0() {
        EditText editText = this.f3229f;
        A0(editText == null ? 0 : editText.getText().length());
    }

    void E0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.G == null || this.M == 0) {
            return;
        }
        boolean z2 = false;
        boolean z3 = isFocused() || ((editText2 = this.f3229f) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f3229f) != null && editText.isHovered())) {
            z2 = true;
        }
        if (!isEnabled()) {
            this.R = this.B0;
        } else if (this.f3241l.l()) {
            if (this.f3264w0 != null) {
                B0(z3, z2);
            } else {
                this.R = this.f3241l.p();
            }
        } else if (!this.f3247o || (textView = this.f3249p) == null) {
            if (z3) {
                this.R = this.f3262v0;
            } else if (z2) {
                this.R = this.f3260u0;
            } else {
                this.R = this.f3258t0;
            }
        } else if (this.f3264w0 != null) {
            B0(z3, z2);
        } else {
            this.R = textView.getCurrentTextColor();
        }
        u0();
        V();
        W();
        U();
        if (getEndIconDelegate().d()) {
            i0(this.f3241l.l());
        }
        if (this.M == 2) {
            int i3 = this.O;
            if (z3 && isEnabled()) {
                this.O = this.Q;
            } else {
                this.O = this.P;
            }
            if (this.O != i3) {
                S();
            }
        }
        if (this.M == 1) {
            if (!isEnabled()) {
                this.S = this.f3268y0;
            } else if (z2 && !z3) {
                this.S = this.A0;
            } else if (z3) {
                this.S = this.f3270z0;
            } else {
                this.S = this.f3266x0;
            }
        }
        l();
    }

    public boolean K() {
        return this.f3227e.getVisibility() == 0 && this.f3230f0.getVisibility() == 0;
    }

    public boolean M() {
        return this.f3241l.A();
    }

    final boolean N() {
        return this.C0;
    }

    public boolean O() {
        return this.F;
    }

    public void U() {
        com.google.android.material.textfield.f.c(this, this.f3230f0, this.f3234h0);
    }

    public void V() {
        com.google.android.material.textfield.f.c(this, this.f3248o0, this.f3250p0);
    }

    public void W() {
        this.f3223c.j();
    }

    public void Y(float f3, float f4, float f5, float f6) {
        boolean zE = com.google.android.material.internal.o.e(this);
        this.K = zE;
        float f7 = zE ? f4 : f3;
        if (!zE) {
            f3 = f4;
        }
        float f8 = zE ? f6 : f5;
        if (!zE) {
            f5 = f6;
        }
        k1.g gVar = this.G;
        if (gVar != null && gVar.G() == f7 && this.G.H() == f3 && this.G.s() == f8 && this.G.t() == f5) {
            return;
        }
        this.J = this.J.v().A(f7).E(f3).s(f8).w(f5).m();
        l();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i3, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f3221b.addView(view, layoutParams2);
        this.f3221b.setLayoutParams(layoutParams);
        v0();
        setEditText((EditText) view);
    }

    void d0(TextView textView, int i3) {
        boolean z2 = true;
        try {
            androidx.core.widget.i.n(textView, i3);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z2 = false;
            }
        } catch (Exception unused) {
        }
        if (z2) {
            androidx.core.widget.i.n(textView, t0.j.TextAppearance_AppCompat_Caption);
            textView.setTextColor(u.a.b(getContext(), t0.c.design_error));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i3) {
        EditText editText = this.f3229f;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i3);
            return;
        }
        if (this.f3231g != null) {
            boolean z2 = this.F;
            this.F = false;
            CharSequence hint = editText.getHint();
            this.f3229f.setHint(this.f3231g);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i3);
                return;
            } finally {
                this.f3229f.setHint(hint);
                this.F = z2;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i3);
        onProvideAutofillVirtualStructure(viewStructure, i3);
        viewStructure.setChildCount(this.f3221b.getChildCount());
        for (int i4 = 0; i4 < this.f3221b.getChildCount(); i4++) {
            View childAt = this.f3221b.getChildAt(i4);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i4);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i3);
            if (childAt == this.f3229f) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.I0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.I0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        E(canvas);
        D(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.H0) {
            return;
        }
        this.H0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.b bVar = this.D0;
        boolean zG0 = bVar != null ? bVar.g0(drawableState) | false : false;
        if (this.f3229f != null) {
            w0(t.S(this) && isEnabled());
        }
        r0();
        E0();
        if (zG0) {
            invalidate();
        }
        this.H0 = false;
    }

    public void g(f fVar) {
        this.f3224c0.add(fVar);
        if (this.f3229f != null) {
            fVar.a(this);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f3229f;
        return editText != null ? editText.getBaseline() + getPaddingTop() + u() : super.getBaseline();
    }

    k1.g getBoxBackground() {
        int i3 = this.M;
        if (i3 == 1 || i3 == 2) {
            return this.G;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.S;
    }

    public int getBoxBackgroundMode() {
        return this.M;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.N;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return com.google.android.material.internal.o.e(this) ? this.J.j().a(this.V) : this.J.l().a(this.V);
    }

    public float getBoxCornerRadiusBottomStart() {
        return com.google.android.material.internal.o.e(this) ? this.J.l().a(this.V) : this.J.j().a(this.V);
    }

    public float getBoxCornerRadiusTopEnd() {
        return com.google.android.material.internal.o.e(this) ? this.J.r().a(this.V) : this.J.t().a(this.V);
    }

    public float getBoxCornerRadiusTopStart() {
        return com.google.android.material.internal.o.e(this) ? this.J.t().a(this.V) : this.J.r().a(this.V);
    }

    public int getBoxStrokeColor() {
        return this.f3262v0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f3264w0;
    }

    public int getBoxStrokeWidth() {
        return this.P;
    }

    public int getBoxStrokeWidthFocused() {
        return this.Q;
    }

    public int getCounterMaxLength() {
        return this.f3245n;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f3243m && this.f3247o && (textView = this.f3249p) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f3269z;
    }

    public ColorStateList getCounterTextColor() {
        return this.f3269z;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f3254r0;
    }

    public EditText getEditText() {
        return this.f3229f;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f3230f0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f3230f0.getDrawable();
    }

    public int getEndIconMode() {
        return this.f3226d0;
    }

    CheckableImageButton getEndIconView() {
        return this.f3230f0;
    }

    public CharSequence getError() {
        if (this.f3241l.z()) {
            return this.f3241l.o();
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.f3241l.n();
    }

    public int getErrorCurrentTextColors() {
        return this.f3241l.p();
    }

    public Drawable getErrorIconDrawable() {
        return this.f3248o0.getDrawable();
    }

    final int getErrorTextCurrentColor() {
        return this.f3241l.p();
    }

    public CharSequence getHelperText() {
        if (this.f3241l.A()) {
            return this.f3241l.r();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f3241l.t();
    }

    public CharSequence getHint() {
        if (this.D) {
            return this.E;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.D0.q();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.D0.t();
    }

    public ColorStateList getHintTextColor() {
        return this.f3256s0;
    }

    public int getMaxEms() {
        return this.f3235i;
    }

    public int getMaxWidth() {
        return this.f3239k;
    }

    public int getMinEms() {
        return this.f3233h;
    }

    public int getMinWidth() {
        return this.f3237j;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f3230f0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f3230f0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f3257t) {
            return this.f3255s;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f3263w;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f3261v;
    }

    public CharSequence getPrefixText() {
        return this.f3223c.a();
    }

    public ColorStateList getPrefixTextColor() {
        return this.f3223c.b();
    }

    public TextView getPrefixTextView() {
        return this.f3223c.c();
    }

    public CharSequence getStartIconContentDescription() {
        return this.f3223c.d();
    }

    public Drawable getStartIconDrawable() {
        return this.f3223c.e();
    }

    public CharSequence getSuffixText() {
        return this.B;
    }

    public ColorStateList getSuffixTextColor() {
        return this.C.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.C;
    }

    public Typeface getTypeface() {
        return this.W;
    }

    public void h(g gVar) {
        this.f3232g0.add(gVar);
    }

    void k(float f3) {
        if (this.D0.x() == f3) {
            return;
        }
        if (this.G0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.G0 = valueAnimator;
            valueAnimator.setInterpolator(u0.a.f6258b);
            this.G0.setDuration(167L);
            this.G0.addUpdateListener(new d());
        }
        this.G0.setFloatValues(this.D0.x(), f3);
        this.G0.start();
    }

    void m0(int i3) {
        boolean z2 = this.f3247o;
        int i4 = this.f3245n;
        if (i4 == -1) {
            this.f3249p.setText(String.valueOf(i3));
            this.f3249p.setContentDescription(null);
            this.f3247o = false;
        } else {
            this.f3247o = i3 > i4;
            n0(getContext(), this.f3249p, i3, this.f3245n, this.f3247o);
            if (z2 != this.f3247o) {
                o0();
            }
            this.f3249p.setText(c0.a.c().j(getContext().getString(t0.i.character_counter_pattern, Integer.valueOf(i3), Integer.valueOf(this.f3245n))));
        }
        if (this.f3229f == null || z2 == this.f3247o) {
            return;
        }
        w0(false);
        E0();
        r0();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.D0.H(configuration);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        EditText editText = this.f3229f;
        if (editText != null) {
            Rect rect = this.T;
            com.google.android.material.internal.c.a(this, editText, rect);
            k0(rect);
            if (this.D) {
                this.D0.b0(this.f3229f.getTextSize());
                int gravity = this.f3229f.getGravity();
                this.D0.S((gravity & (-113)) | 48);
                this.D0.a0(gravity);
                this.D0.O(q(rect));
                this.D0.W(t(rect));
                this.D0.K();
                if (!A() || this.C0) {
                    return;
                }
                R();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        boolean zS0 = s0();
        boolean zQ0 = q0();
        if (zS0 || zQ0) {
            this.f3229f.post(new c());
        }
        y0();
        C0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.j());
        setError(hVar.f3276d);
        if (hVar.f3277e) {
            this.f3230f0.post(new b());
        }
        setHint(hVar.f3278f);
        setHelperText(hVar.f3279g);
        setPlaceholderText(hVar.f3280h);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        boolean z2 = false;
        boolean z3 = i3 == 1;
        boolean z4 = this.K;
        if (z3 != z4) {
            if (z3 && !z4) {
                z2 = true;
            }
            float fA = this.J.r().a(this.V);
            float fA2 = this.J.t().a(this.V);
            float fA3 = this.J.j().a(this.V);
            float fA4 = this.J.l().a(this.V);
            float f3 = z2 ? fA : fA2;
            if (z2) {
                fA = fA2;
            }
            float f4 = z2 ? fA3 : fA4;
            if (z2) {
                fA3 = fA4;
            }
            Y(f3, fA, f4, fA3);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (this.f3241l.l()) {
            hVar.f3276d = getError();
        }
        hVar.f3277e = I() && this.f3230f0.isChecked();
        hVar.f3278f = getHint();
        hVar.f3279g = getHelperText();
        hVar.f3280h = getPlaceholderText();
        return hVar;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0062  */
    boolean q0() {
        boolean z2;
        if (this.f3229f == null) {
            return false;
        }
        boolean z3 = true;
        if (f0()) {
            int measuredWidth = this.f3223c.getMeasuredWidth() - this.f3229f.getPaddingLeft();
            if (this.f3220a0 == null || this.f3222b0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f3220a0 = colorDrawable;
                this.f3222b0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] drawableArrA = androidx.core.widget.i.a(this.f3229f);
            Drawable drawable = drawableArrA[0];
            Drawable drawable2 = this.f3220a0;
            if (drawable != drawable2) {
                androidx.core.widget.i.i(this.f3229f, drawable2, drawableArrA[1], drawableArrA[2], drawableArrA[3]);
                z2 = true;
            } else {
                z2 = false;
            }
        } else if (this.f3220a0 != null) {
            Drawable[] drawableArrA2 = androidx.core.widget.i.a(this.f3229f);
            androidx.core.widget.i.i(this.f3229f, null, drawableArrA2[1], drawableArrA2[2], drawableArrA2[3]);
            this.f3220a0 = null;
            z2 = true;
        } else {
            z2 = false;
        }
        if (e0()) {
            int measuredWidth2 = this.C.getMeasuredWidth() - this.f3229f.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + e0.g.b((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] drawableArrA3 = androidx.core.widget.i.a(this.f3229f);
            Drawable drawable3 = this.f3238j0;
            if (drawable3 == null || this.f3240k0 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f3238j0 = colorDrawable2;
                    this.f3240k0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = drawableArrA3[2];
                Drawable drawable5 = this.f3238j0;
                if (drawable4 != drawable5) {
                    this.f3242l0 = drawableArrA3[2];
                    androidx.core.widget.i.i(this.f3229f, drawableArrA3[0], drawableArrA3[1], drawable5, drawableArrA3[3]);
                } else {
                    z3 = z2;
                }
            } else {
                this.f3240k0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                androidx.core.widget.i.i(this.f3229f, drawableArrA3[0], drawableArrA3[1], this.f3238j0, drawableArrA3[3]);
            }
        } else {
            if (this.f3238j0 == null) {
                return z2;
            }
            Drawable[] drawableArrA4 = androidx.core.widget.i.a(this.f3229f);
            if (drawableArrA4[2] == this.f3238j0) {
                androidx.core.widget.i.i(this.f3229f, drawableArrA4[0], drawableArrA4[1], this.f3242l0, drawableArrA4[3]);
            } else {
                z3 = z2;
            }
            this.f3238j0 = null;
        }
        return z3;
    }

    void r0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f3229f;
        if (editText == null || this.M != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (e0.a(background)) {
            background = background.mutate();
        }
        if (this.f3241l.l()) {
            background.setColorFilter(androidx.appcompat.widget.j.e(this.f3241l.p(), PorterDuff.Mode.SRC_IN));
        } else if (this.f3247o && (textView = this.f3249p) != null) {
            background.setColorFilter(androidx.appcompat.widget.j.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            x.a.c(background);
            this.f3229f.refreshDrawableState();
        }
    }

    public void setBoxBackgroundColor(int i3) {
        if (this.S != i3) {
            this.S = i3;
            this.f3266x0 = i3;
            this.f3270z0 = i3;
            this.A0 = i3;
            l();
        }
    }

    public void setBoxBackgroundColorResource(int i3) {
        setBoxBackgroundColor(u.a.b(getContext(), i3));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f3266x0 = defaultColor;
        this.S = defaultColor;
        this.f3268y0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f3270z0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.A0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        l();
    }

    public void setBoxBackgroundMode(int i3) {
        if (i3 == this.M) {
            return;
        }
        this.M = i3;
        if (this.f3229f != null) {
            Q();
        }
    }

    public void setBoxCollapsedPaddingTop(int i3) {
        this.N = i3;
    }

    public void setBoxStrokeColor(int i3) {
        if (this.f3262v0 != i3) {
            this.f3262v0 = i3;
            E0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f3258t0 = colorStateList.getDefaultColor();
            this.B0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f3260u0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f3262v0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f3262v0 != colorStateList.getDefaultColor()) {
            this.f3262v0 = colorStateList.getDefaultColor();
        }
        E0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f3264w0 != colorStateList) {
            this.f3264w0 = colorStateList;
            E0();
        }
    }

    public void setBoxStrokeWidth(int i3) {
        this.P = i3;
        E0();
    }

    public void setBoxStrokeWidthFocused(int i3) {
        this.Q = i3;
        E0();
    }

    public void setBoxStrokeWidthFocusedResource(int i3) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i3));
    }

    public void setBoxStrokeWidthResource(int i3) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i3));
    }

    public void setCounterEnabled(boolean z2) {
        if (this.f3243m != z2) {
            if (z2) {
                z zVar = new z(getContext());
                this.f3249p = zVar;
                zVar.setId(t0.f.textinput_counter);
                Typeface typeface = this.W;
                if (typeface != null) {
                    this.f3249p.setTypeface(typeface);
                }
                this.f3249p.setMaxLines(1);
                this.f3241l.e(this.f3249p, 2);
                e0.g.d((ViewGroup.MarginLayoutParams) this.f3249p.getLayoutParams(), getResources().getDimensionPixelOffset(t0.d.mtrl_textinput_counter_margin_start));
                o0();
                l0();
            } else {
                this.f3241l.B(this.f3249p, 2);
                this.f3249p = null;
            }
            this.f3243m = z2;
        }
    }

    public void setCounterMaxLength(int i3) {
        if (this.f3245n != i3) {
            if (i3 > 0) {
                this.f3245n = i3;
            } else {
                this.f3245n = -1;
            }
            if (this.f3243m) {
                l0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i3) {
        if (this.f3251q != i3) {
            this.f3251q = i3;
            o0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            o0();
        }
    }

    public void setCounterTextAppearance(int i3) {
        if (this.f3253r != i3) {
            this.f3253r = i3;
            o0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f3269z != colorStateList) {
            this.f3269z = colorStateList;
            o0();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f3254r0 = colorStateList;
        this.f3256s0 = colorStateList;
        if (this.f3229f != null) {
            w0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        T(this, z2);
        super.setEnabled(z2);
    }

    public void setEndIconActivated(boolean z2) {
        this.f3230f0.setActivated(z2);
    }

    public void setEndIconCheckable(boolean z2) {
        this.f3230f0.setCheckable(z2);
    }

    public void setEndIconContentDescription(int i3) {
        setEndIconContentDescription(i3 != 0 ? getResources().getText(i3) : null);
    }

    public void setEndIconDrawable(int i3) {
        setEndIconDrawable(i3 != 0 ? c.a.d(getContext(), i3) : null);
    }

    public void setEndIconMode(int i3) {
        int i4 = this.f3226d0;
        if (i4 == i3) {
            return;
        }
        this.f3226d0 = i3;
        C(i4);
        setEndIconVisible(i3 != 0);
        if (getEndIconDelegate().b(this.M)) {
            getEndIconDelegate().a();
            com.google.android.material.textfield.f.a(this, this.f3230f0, this.f3234h0, this.f3236i0);
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.M + " is not supported by the end icon mode " + i3);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        b0(this.f3230f0, onClickListener, this.f3244m0);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f3244m0 = onLongClickListener;
        c0(this.f3230f0, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.f3234h0 != colorStateList) {
            this.f3234h0 = colorStateList;
            com.google.android.material.textfield.f.a(this, this.f3230f0, colorStateList, this.f3236i0);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.f3236i0 != mode) {
            this.f3236i0 = mode;
            com.google.android.material.textfield.f.a(this, this.f3230f0, this.f3234h0, mode);
        }
    }

    public void setEndIconVisible(boolean z2) {
        if (K() != z2) {
            this.f3230f0.setVisibility(z2 ? 0 : 8);
            t0();
            C0();
            q0();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.f3241l.z()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f3241l.v();
        } else {
            this.f3241l.O(charSequence);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f3241l.D(charSequence);
    }

    public void setErrorEnabled(boolean z2) {
        this.f3241l.E(z2);
    }

    public void setErrorIconDrawable(int i3) {
        setErrorIconDrawable(i3 != 0 ? c.a.d(getContext(), i3) : null);
        V();
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        b0(this.f3248o0, onClickListener, this.f3246n0);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f3246n0 = onLongClickListener;
        c0(this.f3248o0, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        if (this.f3250p0 != colorStateList) {
            this.f3250p0 = colorStateList;
            com.google.android.material.textfield.f.a(this, this.f3248o0, colorStateList, this.f3252q0);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        if (this.f3252q0 != mode) {
            this.f3252q0 = mode;
            com.google.android.material.textfield.f.a(this, this.f3248o0, this.f3250p0, mode);
        }
    }

    public void setErrorTextAppearance(int i3) {
        this.f3241l.F(i3);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f3241l.G(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z2) {
        if (this.E0 != z2) {
            this.E0 = z2;
            w0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (M()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!M()) {
                setHelperTextEnabled(true);
            }
            this.f3241l.P(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f3241l.J(colorStateList);
    }

    public void setHelperTextEnabled(boolean z2) {
        this.f3241l.I(z2);
    }

    public void setHelperTextTextAppearance(int i3) {
        this.f3241l.H(i3);
    }

    public void setHint(CharSequence charSequence) {
        if (this.D) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(SecurityKeyCipher.SECURITY_DATA_SIZE_MAX);
        }
    }

    public void setHintAnimationEnabled(boolean z2) {
        this.F0 = z2;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.D) {
            this.D = z2;
            if (z2) {
                CharSequence hint = this.f3229f.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.E)) {
                        setHint(hint);
                    }
                    this.f3229f.setHint((CharSequence) null);
                }
                this.F = true;
            } else {
                this.F = false;
                if (!TextUtils.isEmpty(this.E) && TextUtils.isEmpty(this.f3229f.getHint())) {
                    this.f3229f.setHint(this.E);
                }
                setHintInternal(null);
            }
            if (this.f3229f != null) {
                v0();
            }
        }
    }

    public void setHintTextAppearance(int i3) {
        this.D0.P(i3);
        this.f3256s0 = this.D0.p();
        if (this.f3229f != null) {
            w0(false);
            v0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f3256s0 != colorStateList) {
            if (this.f3254r0 == null) {
                this.D0.R(colorStateList);
            }
            this.f3256s0 = colorStateList;
            if (this.f3229f != null) {
                w0(false);
            }
        }
    }

    public void setMaxEms(int i3) {
        this.f3235i = i3;
        EditText editText = this.f3229f;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMaxEms(i3);
    }

    public void setMaxWidth(int i3) {
        this.f3239k = i3;
        EditText editText = this.f3229f;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMaxWidth(i3);
    }

    public void setMaxWidthResource(int i3) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i3));
    }

    public void setMinEms(int i3) {
        this.f3233h = i3;
        EditText editText = this.f3229f;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMinEms(i3);
    }

    public void setMinWidth(int i3) {
        this.f3237j = i3;
        EditText editText = this.f3229f;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMinWidth(i3);
    }

    public void setMinWidthResource(int i3) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i3));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i3) {
        setPasswordVisibilityToggleContentDescription(i3 != 0 ? getResources().getText(i3) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i3) {
        setPasswordVisibilityToggleDrawable(i3 != 0 ? c.a.d(getContext(), i3) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z2) {
        if (z2 && this.f3226d0 != 1) {
            setEndIconMode(1);
        } else {
            if (z2) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f3234h0 = colorStateList;
        com.google.android.material.textfield.f.a(this, this.f3230f0, colorStateList, this.f3236i0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f3236i0 = mode;
        com.google.android.material.textfield.f.a(this, this.f3230f0, this.f3234h0, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f3259u == null) {
            z zVar = new z(getContext());
            this.f3259u = zVar;
            zVar.setId(t0.f.textinput_placeholder);
            t.v0(this.f3259u, 2);
            p0.d dVarZ = z();
            this.f3265x = dVarZ;
            dVarZ.Z(67L);
            this.f3267y = z();
            setPlaceholderTextAppearance(this.f3263w);
            setPlaceholderTextColor(this.f3261v);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f3257t) {
                setPlaceholderTextEnabled(true);
            }
            this.f3255s = charSequence;
        }
        z0();
    }

    public void setPlaceholderTextAppearance(int i3) {
        this.f3263w = i3;
        TextView textView = this.f3259u;
        if (textView != null) {
            androidx.core.widget.i.n(textView, i3);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f3261v != colorStateList) {
            this.f3261v = colorStateList;
            TextView textView = this.f3259u;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f3223c.k(charSequence);
    }

    public void setPrefixTextAppearance(int i3) {
        this.f3223c.l(i3);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f3223c.m(colorStateList);
    }

    public void setStartIconCheckable(boolean z2) {
        this.f3223c.n(z2);
    }

    public void setStartIconContentDescription(int i3) {
        setStartIconContentDescription(i3 != 0 ? getResources().getText(i3) : null);
    }

    public void setStartIconDrawable(int i3) {
        setStartIconDrawable(i3 != 0 ? c.a.d(getContext(), i3) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        this.f3223c.q(onClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f3223c.r(onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        this.f3223c.s(colorStateList);
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        this.f3223c.t(mode);
    }

    public void setStartIconVisible(boolean z2) {
        this.f3223c.u(z2);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.B = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.C.setText(charSequence);
        D0();
    }

    public void setSuffixTextAppearance(int i3) {
        androidx.core.widget.i.n(this.C, i3);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.C.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f3229f;
        if (editText != null) {
            t.m0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.W) {
            this.W = typeface;
            this.D0.j0(typeface);
            this.f3241l.L(typeface);
            TextView textView = this.f3249p;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    void w0(boolean z2) {
        x0(z2, false);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t0.b.textInputStyle);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f3230f0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f3230f0.setImageDrawable(drawable);
        if (drawable != null) {
            com.google.android.material.textfield.f.a(this, this.f3230f0, this.f3234h0, this.f3236i0);
            U();
        }
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.f3223c.o(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f3223c.p(drawable);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v109 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50, types: [boolean, int] */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i3) {
        int i4;
        ?? r3;
        int i5 = J0;
        super(m1.a.c(context, attributeSet, i3, i5), attributeSet, i3);
        this.f3233h = -1;
        this.f3235i = -1;
        this.f3237j = -1;
        this.f3239k = -1;
        this.f3241l = new com.google.android.material.textfield.g(this);
        this.T = new Rect();
        this.U = new Rect();
        this.V = new RectF();
        this.f3224c0 = new LinkedHashSet<>();
        this.f3226d0 = 0;
        SparseArray<com.google.android.material.textfield.e> sparseArray = new SparseArray<>();
        this.f3228e0 = sparseArray;
        this.f3232g0 = new LinkedHashSet<>();
        com.google.android.material.internal.b bVar = new com.google.android.material.internal.b(this);
        this.D0 = bVar;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f3221b = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f3227e = frameLayout2;
        LinearLayout linearLayout = new LinearLayout(context2);
        this.f3225d = linearLayout;
        z zVar = new z(context2);
        this.C = zVar;
        linearLayout.setVisibility(8);
        frameLayout2.setVisibility(8);
        zVar.setVisibility(8);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context2);
        int i6 = t0.h.design_text_input_end_icon;
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflaterFrom.inflate(i6, (ViewGroup) linearLayout, false);
        this.f3248o0 = checkableImageButton;
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) layoutInflaterFrom.inflate(i6, (ViewGroup) frameLayout2, false);
        this.f3230f0 = checkableImageButton2;
        frameLayout.setAddStatesFromChildren(true);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator timeInterpolator = u0.a.f6257a;
        bVar.i0(timeInterpolator);
        bVar.f0(timeInterpolator);
        bVar.S(8388659);
        int[] iArr = t0.k.TextInputLayout;
        int i7 = t0.k.TextInputLayout_counterTextAppearance;
        int i8 = t0.k.TextInputLayout_counterOverflowTextAppearance;
        int i9 = t0.k.TextInputLayout_errorTextAppearance;
        int i10 = t0.k.TextInputLayout_helperTextTextAppearance;
        int i11 = t0.k.TextInputLayout_hintTextAppearance;
        w0 w0VarI = m.i(context2, attributeSet, iArr, i3, i5, i7, i8, i9, i10, i11);
        k kVar = new k(this, w0VarI);
        this.f3223c = kVar;
        this.D = w0VarI.a(t0.k.TextInputLayout_hintEnabled, true);
        setHint(w0VarI.p(t0.k.TextInputLayout_android_hint));
        this.F0 = w0VarI.a(t0.k.TextInputLayout_hintAnimationEnabled, true);
        this.E0 = w0VarI.a(t0.k.TextInputLayout_expandedHintEnabled, true);
        int i12 = t0.k.TextInputLayout_android_minEms;
        if (w0VarI.s(i12)) {
            i4 = -1;
            setMinEms(w0VarI.k(i12, -1));
        } else {
            i4 = -1;
            int i13 = t0.k.TextInputLayout_android_minWidth;
            if (w0VarI.s(i13)) {
                setMinWidth(w0VarI.f(i13, -1));
            }
        }
        int i14 = t0.k.TextInputLayout_android_maxEms;
        if (w0VarI.s(i14)) {
            setMaxEms(w0VarI.k(i14, i4));
        } else {
            int i15 = t0.k.TextInputLayout_android_maxWidth;
            if (w0VarI.s(i15)) {
                setMaxWidth(w0VarI.f(i15, i4));
            }
        }
        this.J = k1.k.e(context2, attributeSet, i3, i5).m();
        this.L = context2.getResources().getDimensionPixelOffset(t0.d.mtrl_textinput_box_label_cutout_padding);
        this.N = w0VarI.e(t0.k.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.P = w0VarI.f(t0.k.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(t0.d.mtrl_textinput_box_stroke_width_default));
        this.Q = w0VarI.f(t0.k.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(t0.d.mtrl_textinput_box_stroke_width_focused));
        this.O = this.P;
        float fD = w0VarI.d(t0.k.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float fD2 = w0VarI.d(t0.k.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float fD3 = w0VarI.d(t0.k.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float fD4 = w0VarI.d(t0.k.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        k1.k.b bVarV = this.J.v();
        if (fD >= 0.0f) {
            bVarV.A(fD);
        }
        if (fD2 >= 0.0f) {
            bVarV.E(fD2);
        }
        if (fD3 >= 0.0f) {
            bVarV.w(fD3);
        }
        if (fD4 >= 0.0f) {
            bVarV.s(fD4);
        }
        this.J = bVarV.m();
        ColorStateList colorStateListB = h1.c.b(context2, w0VarI, t0.k.TextInputLayout_boxBackgroundColor);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.f3266x0 = defaultColor;
            this.S = defaultColor;
            if (colorStateListB.isStateful()) {
                this.f3268y0 = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.f3270z0 = colorStateListB.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.A0 = colorStateListB.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.f3270z0 = this.f3266x0;
                ColorStateList colorStateListC = c.a.c(context2, t0.c.mtrl_filled_background_color);
                this.f3268y0 = colorStateListC.getColorForState(new int[]{-16842910}, -1);
                this.A0 = colorStateListC.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.S = 0;
            this.f3266x0 = 0;
            this.f3268y0 = 0;
            this.f3270z0 = 0;
            this.A0 = 0;
        }
        int i16 = t0.k.TextInputLayout_android_textColorHint;
        if (w0VarI.s(i16)) {
            ColorStateList colorStateListC2 = w0VarI.c(i16);
            this.f3256s0 = colorStateListC2;
            this.f3254r0 = colorStateListC2;
        }
        int i17 = t0.k.TextInputLayout_boxStrokeColor;
        ColorStateList colorStateListB2 = h1.c.b(context2, w0VarI, i17);
        this.f3262v0 = w0VarI.b(i17, 0);
        this.f3258t0 = u.a.b(context2, t0.c.mtrl_textinput_default_box_stroke_color);
        this.B0 = u.a.b(context2, t0.c.mtrl_textinput_disabled_color);
        this.f3260u0 = u.a.b(context2, t0.c.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListB2 != null) {
            setBoxStrokeColorStateList(colorStateListB2);
        }
        int i18 = t0.k.TextInputLayout_boxStrokeErrorColor;
        if (w0VarI.s(i18)) {
            setBoxStrokeErrorColor(h1.c.b(context2, w0VarI, i18));
        }
        if (w0VarI.n(i11, -1) != -1) {
            r3 = 0;
            setHintTextAppearance(w0VarI.n(i11, 0));
        } else {
            r3 = 0;
        }
        int iN = w0VarI.n(i9, r3);
        CharSequence charSequenceP = w0VarI.p(t0.k.TextInputLayout_errorContentDescription);
        boolean zA = w0VarI.a(t0.k.TextInputLayout_errorEnabled, r3);
        checkableImageButton.setId(t0.f.text_input_error_icon);
        if (h1.c.g(context2)) {
            e0.g.d((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), r3);
        }
        int i19 = t0.k.TextInputLayout_errorIconTint;
        if (w0VarI.s(i19)) {
            this.f3250p0 = h1.c.b(context2, w0VarI, i19);
        }
        int i20 = t0.k.TextInputLayout_errorIconTintMode;
        if (w0VarI.s(i20)) {
            this.f3252q0 = com.google.android.material.internal.o.f(w0VarI.k(i20, -1), null);
        }
        int i21 = t0.k.TextInputLayout_errorIconDrawable;
        if (w0VarI.s(i21)) {
            setErrorIconDrawable(w0VarI.g(i21));
        }
        checkableImageButton.setContentDescription(getResources().getText(t0.i.error_icon_content_description));
        t.v0(checkableImageButton, 2);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int iN2 = w0VarI.n(i10, 0);
        boolean zA2 = w0VarI.a(t0.k.TextInputLayout_helperTextEnabled, false);
        CharSequence charSequenceP2 = w0VarI.p(t0.k.TextInputLayout_helperText);
        int iN3 = w0VarI.n(t0.k.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence charSequenceP3 = w0VarI.p(t0.k.TextInputLayout_placeholderText);
        int iN4 = w0VarI.n(t0.k.TextInputLayout_suffixTextAppearance, 0);
        CharSequence charSequenceP4 = w0VarI.p(t0.k.TextInputLayout_suffixText);
        boolean zA3 = w0VarI.a(t0.k.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(w0VarI.k(t0.k.TextInputLayout_counterMaxLength, -1));
        this.f3253r = w0VarI.n(i7, 0);
        this.f3251q = w0VarI.n(i8, 0);
        setBoxBackgroundMode(w0VarI.k(t0.k.TextInputLayout_boxBackgroundMode, 0));
        if (h1.c.g(context2)) {
            e0.g.d((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams(), 0);
        }
        int iN5 = w0VarI.n(t0.k.TextInputLayout_endIconDrawable, 0);
        sparseArray.append(-1, new com.google.android.material.textfield.b(this, iN5));
        sparseArray.append(0, new i(this));
        sparseArray.append(1, new j(this, iN5 == 0 ? w0VarI.n(t0.k.TextInputLayout_passwordToggleDrawable, 0) : iN5));
        sparseArray.append(2, new com.google.android.material.textfield.a(this, iN5));
        sparseArray.append(3, new com.google.android.material.textfield.d(this, iN5));
        int i22 = t0.k.TextInputLayout_passwordToggleEnabled;
        if (!w0VarI.s(i22)) {
            int i23 = t0.k.TextInputLayout_endIconTint;
            if (w0VarI.s(i23)) {
                this.f3234h0 = h1.c.b(context2, w0VarI, i23);
            }
            int i24 = t0.k.TextInputLayout_endIconTintMode;
            if (w0VarI.s(i24)) {
                this.f3236i0 = com.google.android.material.internal.o.f(w0VarI.k(i24, -1), null);
            }
        }
        int i25 = t0.k.TextInputLayout_endIconMode;
        if (w0VarI.s(i25)) {
            setEndIconMode(w0VarI.k(i25, 0));
            int i26 = t0.k.TextInputLayout_endIconContentDescription;
            if (w0VarI.s(i26)) {
                setEndIconContentDescription(w0VarI.p(i26));
            }
            setEndIconCheckable(w0VarI.a(t0.k.TextInputLayout_endIconCheckable, true));
        } else if (w0VarI.s(i22)) {
            int i27 = t0.k.TextInputLayout_passwordToggleTint;
            if (w0VarI.s(i27)) {
                this.f3234h0 = h1.c.b(context2, w0VarI, i27);
            }
            int i28 = t0.k.TextInputLayout_passwordToggleTintMode;
            if (w0VarI.s(i28)) {
                this.f3236i0 = com.google.android.material.internal.o.f(w0VarI.k(i28, -1), null);
            }
            setEndIconMode(w0VarI.a(i22, false) ? 1 : 0);
            setEndIconContentDescription(w0VarI.p(t0.k.TextInputLayout_passwordToggleContentDescription));
        }
        zVar.setId(t0.f.textinput_suffix_text);
        zVar.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        t.o0(zVar, 1);
        setErrorContentDescription(charSequenceP);
        setCounterOverflowTextAppearance(this.f3251q);
        setHelperTextTextAppearance(iN2);
        setErrorTextAppearance(iN);
        setCounterTextAppearance(this.f3253r);
        setPlaceholderText(charSequenceP3);
        setPlaceholderTextAppearance(iN3);
        setSuffixTextAppearance(iN4);
        int i29 = t0.k.TextInputLayout_errorTextColor;
        if (w0VarI.s(i29)) {
            setErrorTextColor(w0VarI.c(i29));
        }
        int i30 = t0.k.TextInputLayout_helperTextTextColor;
        if (w0VarI.s(i30)) {
            setHelperTextColor(w0VarI.c(i30));
        }
        int i31 = t0.k.TextInputLayout_hintTextColor;
        if (w0VarI.s(i31)) {
            setHintTextColor(w0VarI.c(i31));
        }
        int i32 = t0.k.TextInputLayout_counterTextColor;
        if (w0VarI.s(i32)) {
            setCounterTextColor(w0VarI.c(i32));
        }
        int i33 = t0.k.TextInputLayout_counterOverflowTextColor;
        if (w0VarI.s(i33)) {
            setCounterOverflowTextColor(w0VarI.c(i33));
        }
        int i34 = t0.k.TextInputLayout_placeholderTextColor;
        if (w0VarI.s(i34)) {
            setPlaceholderTextColor(w0VarI.c(i34));
        }
        int i35 = t0.k.TextInputLayout_suffixTextColor;
        if (w0VarI.s(i35)) {
            setSuffixTextColor(w0VarI.c(i35));
        }
        setEnabled(w0VarI.a(t0.k.TextInputLayout_android_enabled, true));
        w0VarI.w();
        t.v0(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            t.w0(this, 1);
        }
        frameLayout2.addView(checkableImageButton2);
        linearLayout.addView(zVar);
        linearLayout.addView(checkableImageButton);
        linearLayout.addView(frameLayout2);
        frameLayout.addView(kVar);
        frameLayout.addView(linearLayout);
        addView(frameLayout);
        setHelperTextEnabled(zA2);
        setErrorEnabled(zA);
        setCounterEnabled(zA3);
        setHelperText(charSequenceP2);
        setSuffixText(charSequenceP4);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f3248o0.setImageDrawable(drawable);
        u0();
        com.google.android.material.textfield.f.a(this, this.f3248o0, this.f3250p0, this.f3252q0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f3230f0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f3230f0.setImageDrawable(drawable);
    }

    public void setHint(int i3) {
        setHint(i3 != 0 ? getResources().getText(i3) : null);
    }
}
