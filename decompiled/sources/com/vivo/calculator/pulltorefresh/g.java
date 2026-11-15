package com.vivo.calculator.pulltorefresh;

/* JADX INFO: compiled from: ReflectionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static int a(String str, String str2) {
        try {
            Class<?> cls = Class.forName(str);
            return cls.getField(str2).getInt(cls.newInstance());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int b(String str) {
        return a("com.android.internal.R$styleable", str);
    }
}
