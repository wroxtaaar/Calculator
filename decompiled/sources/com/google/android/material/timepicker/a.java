package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;
import com.vivo.seckeysdk.BuildConfig;

/* JADX INFO: compiled from: MaxInputValidator.java */
/* JADX INFO: loaded from: classes.dex */
class a implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3418a;

    public a(int i3) {
        this.f3418a = i3;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i3, int i4, Spanned spanned, int i5, int i6) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i5, i6, charSequence.subSequence(i3, i4).toString());
            if (Integer.parseInt(sb.toString()) <= this.f3418a) {
                return null;
            }
            return BuildConfig.FLAVOR;
        } catch (NumberFormatException unused) {
            return BuildConfig.FLAVOR;
        }
    }
}
