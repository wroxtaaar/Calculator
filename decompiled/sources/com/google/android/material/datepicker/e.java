package com.google.android.material.datepicker;

import android.os.Build;
import android.text.format.DateUtils;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: DateStrings.java */
/* JADX INFO: loaded from: classes.dex */
class e {
    static String a(long j3) {
        return b(j3, Locale.getDefault());
    }

    static String b(long j3, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? s.b(locale).format(new Date(j3)) : s.f(locale).format(new Date(j3));
    }

    static String c(long j3) {
        return DateUtils.formatDateTime(null, j3, 8228);
    }

    static String d(long j3) {
        return e(j3, Locale.getDefault());
    }

    static String e(long j3, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? s.m(locale).format(new Date(j3)) : s.f(locale).format(new Date(j3));
    }
}
