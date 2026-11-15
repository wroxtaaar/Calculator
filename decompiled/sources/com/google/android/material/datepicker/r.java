package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: compiled from: TimeSource.java */
/* JADX INFO: loaded from: classes.dex */
class r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final r f2937c = new r(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Long f2938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeZone f2939b;

    private r(Long l3, TimeZone timeZone) {
        this.f2938a = l3;
        this.f2939b = timeZone;
    }

    static r c() {
        return f2937c;
    }

    Calendar a() {
        return b(this.f2939b);
    }

    Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l3 = this.f2938a;
        if (l3 != null) {
            calendar.setTimeInMillis(l3.longValue());
        }
        return calendar;
    }
}
