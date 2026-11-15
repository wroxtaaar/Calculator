package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import e0.t;
import t0.h;

/* JADX INFO: loaded from: classes.dex */
class TimePickerView extends ConstraintLayout {
    private final ClockHandView A;
    private final ClockFaceView B;
    private final MaterialButtonToggleGroup C;
    private final View.OnClickListener D;
    private f E;
    private g F;
    private e G;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Chip f3411y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Chip f3412z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TimePickerView.this.F != null) {
                TimePickerView.this.F.a(((Integer) view.getTag(t0.f.selection_type)).intValue());
            }
        }
    }

    class b implements MaterialButtonToggleGroup.d {
        b() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.d
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i3, boolean z2) {
            int i4 = i3 == t0.f.material_clock_period_pm_button ? 1 : 0;
            if (TimePickerView.this.E == null || !z2) {
                return;
            }
            TimePickerView.this.E.a(i4);
        }
    }

    class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            e eVar = TimePickerView.this.G;
            if (eVar == null) {
                return false;
            }
            eVar.a();
            return true;
        }
    }

    class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ GestureDetector f3416b;

        d(GestureDetector gestureDetector) {
            this.f3416b = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f3416b.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    interface e {
        void a();
    }

    interface f {
        void a(int i3);
    }

    interface g {
        void a(int i3);
    }

    public TimePickerView(Context context) {
        this(context, null);
    }

    private void w() {
        Chip chip = this.f3411y;
        int i3 = t0.f.selection_type;
        chip.setTag(i3, 12);
        this.f3412z.setTag(i3, 10);
        this.f3411y.setOnClickListener(this.D);
        this.f3412z.setOnClickListener(this.D);
        this.f3411y.setAccessibilityClassName("android.view.View");
        this.f3412z.setAccessibilityClassName("android.view.View");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void x() {
        d dVar = new d(new GestureDetector(getContext(), new c()));
        this.f3411y.setOnTouchListener(dVar);
        this.f3412z.setOnTouchListener(dVar);
    }

    private void y() {
        if (this.C.getVisibility() == 0) {
            androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
            dVar.g(this);
            dVar.e(t0.f.material_clock_display, t.B(this) == 0 ? 2 : 1);
            dVar.c(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        y();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        if (view == this && i3 == 0) {
            y();
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = new a();
        LayoutInflater.from(context).inflate(h.material_timepicker, this);
        this.B = (ClockFaceView) findViewById(t0.f.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(t0.f.material_clock_period_toggle);
        this.C = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new b());
        this.f3411y = (Chip) findViewById(t0.f.material_minute_tv);
        this.f3412z = (Chip) findViewById(t0.f.material_hour_tv);
        this.A = (ClockHandView) findViewById(t0.f.material_clock_hand);
        x();
        w();
    }
}
