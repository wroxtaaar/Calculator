package com.vivo.calculator.entry;

/* JADX INFO: loaded from: classes.dex */
public class InsertEntry {
    private String data;
    private boolean explicit;
    private int id;

    public InsertEntry(String str, int i3, boolean z2) {
        this.data = str;
        this.id = i3;
        this.explicit = z2;
    }

    public int getId() {
        return this.id;
    }

    public boolean isExplicit() {
        return this.explicit;
    }
}
