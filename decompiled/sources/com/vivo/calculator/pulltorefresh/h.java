package com.vivo.calculator.pulltorefresh;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: ViewCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: compiled from: ViewCompat.java */
    @TargetApi(16)
    static class a {
        public static void a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            a.a(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }
}
