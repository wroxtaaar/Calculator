package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.CheckableImageButton;
import e0.c0;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: MaterialDatePicker.java */
/* JADX INFO: loaded from: classes.dex */
public final class i<S> extends androidx.fragment.app.c {
    static final Object I0 = "CONFIRM_BUTTON_TAG";
    static final Object J0 = "CANCEL_BUTTON_TAG";
    static final Object K0 = "TOGGLE_BUTTON_TAG";
    private CharSequence A0;
    private int B0;
    private CharSequence C0;
    private TextView D0;
    private CheckableImageButton E0;
    private k1.g F0;
    private Button G0;
    private boolean H0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private final LinkedHashSet<j<? super S>> f2890m0 = new LinkedHashSet<>();

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final LinkedHashSet<View.OnClickListener> f2891n0 = new LinkedHashSet<>();

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnCancelListener> f2892o0 = new LinkedHashSet<>();

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnDismissListener> f2893p0 = new LinkedHashSet<>();

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private int f2894q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private com.google.android.material.datepicker.d<S> f2895r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private p<S> f2896s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private com.google.android.material.datepicker.a f2897t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private h<S> f2898u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private int f2899v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private CharSequence f2900w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private boolean f2901x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private int f2902y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private int f2903z0;

    /* JADX INFO: compiled from: MaterialDatePicker.java */
    class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = i.this.f2890m0.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a(i.this.R1());
            }
            i.this.w1();
        }
    }

    /* JADX INFO: compiled from: MaterialDatePicker.java */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = i.this.f2891n0.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            i.this.w1();
        }
    }

    /* JADX INFO: compiled from: MaterialDatePicker.java */
    class c implements e0.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f2906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2907b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f2908c;

        c(int i3, View view, int i4) {
            this.f2906a = i3;
            this.f2907b = view;
            this.f2908c = i4;
        }

        @Override // e0.p
        public c0 a(View view, c0 c0Var) {
            int i3 = c0Var.f(c0.m.c()).f6322b;
            if (this.f2906a >= 0) {
                this.f2907b.getLayoutParams().height = this.f2906a + i3;
                View view2 = this.f2907b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.f2907b;
            view3.setPadding(view3.getPaddingLeft(), this.f2908c + i3, this.f2907b.getPaddingRight(), this.f2907b.getPaddingBottom());
            return c0Var;
        }
    }

    /* JADX INFO: compiled from: MaterialDatePicker.java */
    class d extends o<S> {
        d() {
        }

        @Override // com.google.android.material.datepicker.o
        public void a(S s3) {
            i.this.Y1();
            i.this.G0.setEnabled(i.this.O1().f());
        }
    }

    /* JADX INFO: compiled from: MaterialDatePicker.java */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.G0.setEnabled(i.this.O1().f());
            i.this.E0.toggle();
            i iVar = i.this;
            iVar.Z1(iVar.E0);
            i.this.X1();
        }
    }

    private static Drawable M1(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, c.a.d(context, t0.e.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], c.a.d(context, t0.e.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private void N1(Window window) {
        if (this.H0) {
            return;
        }
        View viewFindViewById = h1().findViewById(t0.f.fullscreen_header);
        com.google.android.material.internal.d.a(window, true, com.google.android.material.internal.o.c(viewFindViewById), null);
        e0.t.x0(viewFindViewById, new c(viewFindViewById.getLayoutParams().height, viewFindViewById, viewFindViewById.getPaddingTop()));
        this.H0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.material.datepicker.d<S> O1() {
        if (this.f2895r0 == null) {
            this.f2895r0 = (com.google.android.material.datepicker.d) s().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f2895r0;
    }

    private static int Q1(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(t0.d.mtrl_calendar_content_padding);
        int i3 = l.m().f2918e;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(t0.d.mtrl_calendar_day_width) * i3) + ((i3 - 1) * resources.getDimensionPixelOffset(t0.d.mtrl_calendar_month_horizontal_padding));
    }

    private int S1(Context context) {
        int i3 = this.f2894q0;
        return i3 != 0 ? i3 : O1().c(context);
    }

    private void T1(Context context) {
        this.E0.setTag(K0);
        this.E0.setImageDrawable(M1(context));
        this.E0.setChecked(this.f2902y0 != 0);
        e0.t.m0(this.E0, null);
        Z1(this.E0);
        this.E0.setOnClickListener(new e());
    }

    static boolean U1(Context context) {
        return W1(context, R.attr.windowFullscreen);
    }

    static boolean V1(Context context) {
        return W1(context, t0.b.nestedScrollable);
    }

    static boolean W1(Context context, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(h1.b.d(context, t0.b.materialCalendarStyle, h.class.getCanonicalName()), new int[]{i3});
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X1() {
        int iS1 = S1(g1());
        this.f2898u0 = h.M1(O1(), iS1, this.f2897t0);
        this.f2896s0 = this.E0.isChecked() ? k.w1(O1(), iS1, this.f2897t0) : this.f2898u0;
        Y1();
        androidx.fragment.app.s sVarI = t().i();
        sVarI.m(t0.f.mtrl_calendar_frame, this.f2896s0);
        sVarI.h();
        this.f2896s0.u1(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y1() {
        String strP1 = P1();
        this.D0.setContentDescription(String.format(N(t0.i.mtrl_picker_announce_current_selection), strP1));
        this.D0.setText(strP1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1(CheckableImageButton checkableImageButton) {
        this.E0.setContentDescription(this.E0.isChecked() ? checkableImageButton.getContext().getString(t0.i.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(t0.i.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // androidx.fragment.app.c
    public final Dialog A1(Bundle bundle) {
        Dialog dialog = new Dialog(g1(), S1(g1()));
        Context context = dialog.getContext();
        this.f2901x0 = U1(context);
        int iD = h1.b.d(context, t0.b.colorSurface, i.class.getCanonicalName());
        k1.g gVar = new k1.g(context, null, t0.b.materialCalendarStyle, t0.j.Widget_MaterialComponents_MaterialCalendar);
        this.F0 = gVar;
        gVar.N(context);
        this.F0.X(ColorStateList.valueOf(iD));
        this.F0.W(e0.t.w(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public final void D0(Bundle bundle) {
        super.D0(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f2894q0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f2895r0);
        com.google.android.material.datepicker.a.b bVar = new com.google.android.material.datepicker.a.b(this.f2897t0);
        if (this.f2898u0.H1() != null) {
            bVar.b(this.f2898u0.H1().f2920g);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f2899v0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f2900w0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f2903z0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.A0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.B0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.C0);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void E0() {
        super.E0();
        Window window = B1().getWindow();
        if (this.f2901x0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.F0);
            N1(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = H().getDimensionPixelOffset(t0.d.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.F0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new a1.a(B1(), rect));
        }
        X1();
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void F0() {
        this.f2896s0.v1();
        super.F0();
    }

    public String P1() {
        return O1().b(u());
    }

    public final S R1() {
        return O1().a();
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public final void h0(Bundle bundle) {
        super.h0(bundle);
        if (bundle == null) {
            bundle = s();
        }
        this.f2894q0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f2895r0 = (com.google.android.material.datepicker.d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f2897t0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f2899v0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f2900w0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f2902y0 = bundle.getInt("INPUT_MODE_KEY");
        this.f2903z0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.A0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.B0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.C0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View l0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.f2901x0 ? t0.h.mtrl_picker_fullscreen : t0.h.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.f2901x0) {
            viewInflate.findViewById(t0.f.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(Q1(context), -2));
        } else {
            viewInflate.findViewById(t0.f.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(Q1(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(t0.f.mtrl_picker_header_selection_text);
        this.D0 = textView;
        e0.t.o0(textView, 1);
        this.E0 = (CheckableImageButton) viewInflate.findViewById(t0.f.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) viewInflate.findViewById(t0.f.mtrl_picker_title_text);
        CharSequence charSequence = this.f2900w0;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.f2899v0);
        }
        T1(context);
        this.G0 = (Button) viewInflate.findViewById(t0.f.confirm_button);
        if (O1().f()) {
            this.G0.setEnabled(true);
        } else {
            this.G0.setEnabled(false);
        }
        this.G0.setTag(I0);
        CharSequence charSequence2 = this.A0;
        if (charSequence2 != null) {
            this.G0.setText(charSequence2);
        } else {
            int i3 = this.f2903z0;
            if (i3 != 0) {
                this.G0.setText(i3);
            }
        }
        this.G0.setOnClickListener(new a());
        Button button = (Button) viewInflate.findViewById(t0.f.cancel_button);
        button.setTag(J0);
        CharSequence charSequence3 = this.C0;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i4 = this.B0;
            if (i4 != 0) {
                button.setText(i4);
            }
        }
        button.setOnClickListener(new b());
        return viewInflate;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f2892o0.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f2893p0.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) P();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }
}
