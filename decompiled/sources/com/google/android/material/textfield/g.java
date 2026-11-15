package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.z;
import com.vivo.seckeysdk.BuildConfig;
import e0.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: IndicatorViewController.java */
/* JADX INFO: loaded from: classes.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextInputLayout f3336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinearLayout f3337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FrameLayout f3339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Animator f3340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f3341g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3342h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3343i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f3344j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3345k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f3346l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private CharSequence f3347m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f3348n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ColorStateList f3349o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f3350p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f3351q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f3352r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f3353s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ColorStateList f3354t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Typeface f3355u;

    /* JADX INFO: compiled from: IndicatorViewController.java */
    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3356b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TextView f3357c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f3358d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f3359e;

        a(int i3, TextView textView, int i4, TextView textView2) {
            this.f3356b = i3;
            this.f3357c = textView;
            this.f3358d = i4;
            this.f3359e = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g.this.f3342h = this.f3356b;
            g.this.f3340f = null;
            TextView textView = this.f3357c;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f3358d == 1 && g.this.f3346l != null) {
                    g.this.f3346l.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f3359e;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f3359e.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f3359e;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    /* JADX INFO: compiled from: IndicatorViewController.java */
    class b extends View.AccessibilityDelegate {
        b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText editText = g.this.f3336b.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    public g(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f3335a = context;
        this.f3336b = textInputLayout;
        this.f3341g = context.getResources().getDimensionPixelSize(t0.d.design_textinput_caption_translate_y);
    }

    private void C(int i3, int i4) {
        TextView textViewM;
        TextView textViewM2;
        if (i3 == i4) {
            return;
        }
        if (i4 != 0 && (textViewM2 = m(i4)) != null) {
            textViewM2.setVisibility(0);
            textViewM2.setAlpha(1.0f);
        }
        if (i3 != 0 && (textViewM = m(i3)) != null) {
            textViewM.setVisibility(4);
            if (i3 == 1) {
                textViewM.setText((CharSequence) null);
            }
        }
        this.f3342h = i4;
    }

    private void K(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void M(ViewGroup viewGroup, int i3) {
        if (i3 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean N(TextView textView, CharSequence charSequence) {
        return t.S(this.f3336b) && this.f3336b.isEnabled() && !(this.f3343i == this.f3342h && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void Q(int i3, int i4, boolean z2) {
        if (i3 == i4) {
            return;
        }
        if (z2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f3340f = animatorSet;
            ArrayList arrayList = new ArrayList();
            i(arrayList, this.f3351q, this.f3352r, 2, i3, i4);
            i(arrayList, this.f3345k, this.f3346l, 1, i3, i4);
            u0.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i4, m(i3), i3, m(i4)));
            animatorSet.start();
        } else {
            C(i3, i4);
        }
        this.f3336b.r0();
        this.f3336b.w0(z2);
        this.f3336b.E0();
    }

    private boolean g() {
        return (this.f3337c == null || this.f3336b.getEditText() == null) ? false : true;
    }

    private void i(List<Animator> list, boolean z2, TextView textView, int i3, int i4, int i5) {
        if (textView == null || !z2) {
            return;
        }
        if (i3 == i5 || i3 == i4) {
            list.add(j(textView, i5 == i3));
            if (i5 == i3) {
                list.add(k(textView));
            }
        }
    }

    private ObjectAnimator j(TextView textView, boolean z2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z2 ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(167L);
        objectAnimatorOfFloat.setInterpolator(u0.a.f6257a);
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator k(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f3341g, 0.0f);
        objectAnimatorOfFloat.setDuration(217L);
        objectAnimatorOfFloat.setInterpolator(u0.a.f6260d);
        return objectAnimatorOfFloat;
    }

    private TextView m(int i3) {
        if (i3 == 1) {
            return this.f3346l;
        }
        if (i3 != 2) {
            return null;
        }
        return this.f3352r;
    }

    private int u(boolean z2, int i3, int i4) {
        return z2 ? this.f3335a.getResources().getDimensionPixelSize(i3) : i4;
    }

    private boolean x(int i3) {
        return (i3 != 1 || this.f3346l == null || TextUtils.isEmpty(this.f3344j)) ? false : true;
    }

    boolean A() {
        return this.f3351q;
    }

    void B(TextView textView, int i3) {
        FrameLayout frameLayout;
        if (this.f3337c == null) {
            return;
        }
        if (!y(i3) || (frameLayout = this.f3339e) == null) {
            this.f3337c.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i4 = this.f3338d - 1;
        this.f3338d = i4;
        M(this.f3337c, i4);
    }

    void D(CharSequence charSequence) {
        this.f3347m = charSequence;
        TextView textView = this.f3346l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    void E(boolean z2) {
        if (this.f3345k == z2) {
            return;
        }
        h();
        if (z2) {
            z zVar = new z(this.f3335a);
            this.f3346l = zVar;
            zVar.setId(t0.f.textinput_error);
            if (Build.VERSION.SDK_INT >= 17) {
                this.f3346l.setTextAlignment(5);
            }
            Typeface typeface = this.f3355u;
            if (typeface != null) {
                this.f3346l.setTypeface(typeface);
            }
            F(this.f3348n);
            G(this.f3349o);
            D(this.f3347m);
            this.f3346l.setVisibility(4);
            t.o0(this.f3346l, 1);
            e(this.f3346l, 0);
        } else {
            v();
            B(this.f3346l, 0);
            this.f3346l = null;
            this.f3336b.r0();
            this.f3336b.E0();
        }
        this.f3345k = z2;
    }

    void F(int i3) {
        this.f3348n = i3;
        TextView textView = this.f3346l;
        if (textView != null) {
            this.f3336b.d0(textView, i3);
        }
    }

    void G(ColorStateList colorStateList) {
        this.f3349o = colorStateList;
        TextView textView = this.f3346l;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void H(int i3) {
        this.f3353s = i3;
        TextView textView = this.f3352r;
        if (textView != null) {
            androidx.core.widget.i.n(textView, i3);
        }
    }

    void I(boolean z2) {
        if (this.f3351q == z2) {
            return;
        }
        h();
        if (z2) {
            z zVar = new z(this.f3335a);
            this.f3352r = zVar;
            zVar.setId(t0.f.textinput_helper_text);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 17) {
                this.f3352r.setTextAlignment(5);
            }
            Typeface typeface = this.f3355u;
            if (typeface != null) {
                this.f3352r.setTypeface(typeface);
            }
            this.f3352r.setVisibility(4);
            t.o0(this.f3352r, 1);
            H(this.f3353s);
            J(this.f3354t);
            e(this.f3352r, 1);
            if (i3 >= 17) {
                this.f3352r.setAccessibilityDelegate(new b());
            }
        } else {
            w();
            B(this.f3352r, 1);
            this.f3352r = null;
            this.f3336b.r0();
            this.f3336b.E0();
        }
        this.f3351q = z2;
    }

    void J(ColorStateList colorStateList) {
        this.f3354t = colorStateList;
        TextView textView = this.f3352r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void L(Typeface typeface) {
        if (typeface != this.f3355u) {
            this.f3355u = typeface;
            K(this.f3346l, typeface);
            K(this.f3352r, typeface);
        }
    }

    void O(CharSequence charSequence) {
        h();
        this.f3344j = charSequence;
        this.f3346l.setText(charSequence);
        int i3 = this.f3342h;
        if (i3 != 1) {
            this.f3343i = 1;
        }
        Q(i3, this.f3343i, N(this.f3346l, charSequence));
    }

    void P(CharSequence charSequence) {
        h();
        this.f3350p = charSequence;
        this.f3352r.setText(charSequence);
        int i3 = this.f3342h;
        if (i3 != 2) {
            this.f3343i = 2;
        }
        Q(i3, this.f3343i, N(this.f3352r, charSequence));
    }

    void e(TextView textView, int i3) {
        if (this.f3337c == null && this.f3339e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f3335a);
            this.f3337c = linearLayout;
            linearLayout.setOrientation(0);
            this.f3336b.addView(this.f3337c, -1, -2);
            this.f3339e = new FrameLayout(this.f3335a);
            this.f3337c.addView(this.f3339e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f3336b.getEditText() != null) {
                f();
            }
        }
        if (y(i3)) {
            this.f3339e.setVisibility(0);
            this.f3339e.addView(textView);
        } else {
            this.f3337c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f3337c.setVisibility(0);
        this.f3338d++;
    }

    void f() {
        if (g()) {
            EditText editText = this.f3336b.getEditText();
            boolean zG = h1.c.g(this.f3335a);
            LinearLayout linearLayout = this.f3337c;
            int i3 = t0.d.material_helper_text_font_1_3_padding_horizontal;
            t.y0(linearLayout, u(zG, i3, t.G(editText)), u(zG, t0.d.material_helper_text_font_1_3_padding_top, this.f3335a.getResources().getDimensionPixelSize(t0.d.material_helper_text_default_padding_top)), u(zG, i3, t.F(editText)), 0);
        }
    }

    void h() {
        Animator animator = this.f3340f;
        if (animator != null) {
            animator.cancel();
        }
    }

    boolean l() {
        return x(this.f3343i);
    }

    CharSequence n() {
        return this.f3347m;
    }

    CharSequence o() {
        return this.f3344j;
    }

    int p() {
        TextView textView = this.f3346l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    ColorStateList q() {
        TextView textView = this.f3346l;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    CharSequence r() {
        return this.f3350p;
    }

    View s() {
        return this.f3352r;
    }

    int t() {
        TextView textView = this.f3352r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    void v() {
        this.f3344j = null;
        h();
        if (this.f3342h == 1) {
            if (!this.f3351q || TextUtils.isEmpty(this.f3350p)) {
                this.f3343i = 0;
            } else {
                this.f3343i = 2;
            }
        }
        Q(this.f3342h, this.f3343i, N(this.f3346l, BuildConfig.FLAVOR));
    }

    void w() {
        h();
        int i3 = this.f3342h;
        if (i3 == 2) {
            this.f3343i = 0;
        }
        Q(i3, this.f3343i, N(this.f3352r, BuildConfig.FLAVOR));
    }

    boolean y(int i3) {
        return i3 == 0 || i3 == 1;
    }

    boolean z() {
        return this.f3345k;
    }
}
