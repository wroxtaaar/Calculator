package com.vos.widget;

import android.content.Context;
import android.icu.text.DateFormatSymbols;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewStructure;
import android.view.autofill.AutofillValue;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: VTimePicker.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f4442c = a.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f4443b;

    /* JADX INFO: renamed from: com.vos.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VTimePicker.java */
    public interface InterfaceC0052a {
    }

    /* JADX INFO: compiled from: VTimePicker.java */
    interface b {
        int a();

        View b();

        AutofillValue c();

        int d();

        void e(Parcelable parcelable);

        void f(int i3);

        void g(InterfaceC0052a interfaceC0052a);

        View h();

        void i(int i3);

        boolean isEnabled();

        View j();

        void k(boolean z2);

        void l(AutofillValue autofillValue);

        Parcelable m(Parcelable parcelable);

        View n();

        int o();

        void setEnabled(boolean z2);
    }

    static String[] a(Context context) {
        return new DateFormatSymbols(context.getResources().getConfiguration().locale).getAmPmStrings();
    }

    @Override // android.view.View
    public void autofill(AutofillValue autofillValue) {
        if (isEnabled()) {
            this.f4443b.l(autofillValue);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i3) {
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i3);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public View getAmView() {
        return this.f4443b.b();
    }

    @Override // android.view.View
    public int getAutofillType() {
        return isEnabled() ? 4 : 0;
    }

    @Override // android.view.View
    public AutofillValue getAutofillValue() {
        if (isEnabled()) {
            return this.f4443b.c();
        }
        return null;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.f4443b.d();
    }

    @Deprecated
    public Integer getCurrentHour() {
        return Integer.valueOf(getHour());
    }

    @Deprecated
    public Integer getCurrentMinute() {
        return Integer.valueOf(getMinute());
    }

    public int getHour() {
        return this.f4443b.o();
    }

    public View getHourView() {
        return this.f4443b.n();
    }

    public int getMinute() {
        return this.f4443b.a();
    }

    public View getMinuteView() {
        return this.f4443b.h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public View getPmView() {
        return this.f4443b.j();
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.f4443b.isEnabled();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View.BaseSavedState baseSavedState = (View.BaseSavedState) parcelable;
        super.onRestoreInstanceState(baseSavedState.getSuperState());
        this.f4443b.e(baseSavedState);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return this.f4443b.m(super.onSaveInstanceState());
    }

    @Deprecated
    public void setCurrentHour(Integer num) {
        setHour(num.intValue());
    }

    @Deprecated
    public void setCurrentMinute(Integer num) {
        setMinute(num.intValue());
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        this.f4443b.setEnabled(z2);
    }

    public void setHour(int i3) {
        this.f4443b.f(x2.b.a(i3, 0, 23));
    }

    public void setIs24HourView(Boolean bool) {
        if (bool == null) {
            return;
        }
        this.f4443b.k(bool.booleanValue());
    }

    public void setMinute(int i3) {
        this.f4443b.i(x2.b.a(i3, 0, 59));
    }

    public void setOnTimeChangedListener(InterfaceC0052a interfaceC0052a) {
        this.f4443b.g(interfaceC0052a);
    }
}
