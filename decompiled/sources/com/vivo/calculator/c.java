package com.vivo.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import vivo.util.VLog;

/* JADX INFO: compiled from: ExpressionDB.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f3988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SQLiteDatabase f3989c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f3993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AbstractWindowedCursor f3994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3995i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3996j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f3998l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f3987a = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f3990d = -10000000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f3991e = 10000000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Object f3997k = new Object();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f3999m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Object f4000n = new Object();

    /* JADX INFO: compiled from: ExpressionDB.java */
    private class b extends AsyncTask<d, Void, SQLiteDatabase> {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SQLiteDatabase doInBackground(d... dVarArr) {
            try {
                SQLiteDatabase writableDatabase = dVarArr[0].getWritableDatabase();
                synchronized (c.this.f3997k) {
                    c.this.f3989c = writableDatabase;
                    VLog.d("BBKCalculator/ExpressionDB", "AsyncInitializer int sql ");
                    Cursor cursorRawQuery = writableDatabase.rawQuery("SELECT MIN(_id) FROM expressions", null);
                    try {
                        if (cursorRawQuery.moveToFirst()) {
                            c.this.f3992f = Math.min(cursorRawQuery.getLong(0), -10L);
                        } else {
                            c.this.f3992f = -10L;
                        }
                        cursorRawQuery.close();
                        Cursor cursorRawQuery2 = writableDatabase.rawQuery("SELECT MAX(_id) FROM expressions", null);
                        try {
                            if (cursorRawQuery2.moveToFirst()) {
                                c.this.f3993g = Math.max(cursorRawQuery2.getLong(0), 0L);
                            } else {
                                c.this.f3993g = 0L;
                            }
                            cursorRawQuery2.close();
                            if (c.this.f3993g > 2147483647L) {
                                throw new AssertionError("Expression index absurdly large");
                            }
                            c cVar = c.this;
                            cVar.f3995i = (int) cVar.f3993g;
                            if (c.this.f3993g != 0 || c.this.f3992f != -10) {
                                c.this.f3994h = (AbstractWindowedCursor) writableDatabase.rawQuery("SELECT * FROM expressions WHERE _id <= ? AND _id >= ? ORDER BY _id DESC ", new String[]{Long.toString(c.this.f3995i), Long.toString(c.this.f3992f)});
                                if (!c.this.f3994h.moveToFirst()) {
                                    c.this.B();
                                    return null;
                                }
                            }
                            c.this.f3996j = true;
                            c.this.f3997k.notifyAll();
                            return writableDatabase;
                        } catch (Throwable th) {
                            if (cursorRawQuery2 != null) {
                                try {
                                    cursorRawQuery2.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        if (cursorRawQuery != null) {
                            try {
                                cursorRawQuery.close();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                        }
                        throw th3;
                    }
                }
            } catch (SQLiteException e3) {
                VLog.e("BBKCalculator/ExpressionDB", "Database initialization failed.\n", e3);
                synchronized (c.this.f3997k) {
                    c.this.B();
                    c.this.f3997k.notifyAll();
                    return null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase == null) {
                c.this.r();
            }
        }
    }

    /* JADX INFO: renamed from: com.vivo.calculator.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExpressionDB.java */
    private class AsyncTaskC0048c extends AsyncTask<ContentValues, Void, Long> {
        private AsyncTaskC0048c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long doInBackground(ContentValues... contentValuesArr) {
            long jLongValue = contentValuesArr[0].getAsLong("_id").longValue();
            long jInsert = c.this.f3989c.insert("expressions", null, contentValuesArr[0]);
            c.this.G();
            if (jInsert == -1) {
                return Long.valueOf(jLongValue);
            }
            if (jInsert == jLongValue) {
                return 0L;
            }
            throw new AssertionError("Expected row id " + jLongValue + ", got " + jInsert);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Long l3) {
            if (l3.longValue() != 0) {
                synchronized (c.this.f3997k) {
                    if (l3.longValue() > 0) {
                        c.this.f3991e = l3.longValue() - 1;
                    } else {
                        c.this.f3990d = l3.longValue() + 1;
                    }
                }
                c.this.r();
            }
        }
    }

    /* JADX INFO: compiled from: ExpressionDB.java */
    private class d extends SQLiteOpenHelper {
        public d(Context context) {
            super(context, "Expressions.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE expressions (_id INTEGER PRIMARY KEY,expression BLOB,flags INTEGER,history_flags INTEGER,timeStamp INTEGER)");
            sQLiteDatabase.execSQL("CREATE INDEX timestamp_index ON expressions(timeStamp)");
            sQLiteDatabase.execSQL("CREATE TABLE expressions_save (_id INTEGER PRIMARY KEY,expression BLOB,flags INTEGER,history_flags INTEGER,timeStamp INTEGER)");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
            onUpgrade(sQLiteDatabase, i3, i4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
            sQLiteDatabase.execSQL("DROP INDEX IF EXISTS timestamp_index");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS expressions");
            onCreate(sQLiteDatabase);
        }
    }

    /* JADX INFO: compiled from: ExpressionDB.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f4004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f4006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f4007d;

        private boolean b(int i3) {
            return (i3 & 2) != 0;
        }

        private static int c(Boolean bool, Boolean bool2) {
            return (bool.booleanValue() ? 2 : 0) | (bool2.booleanValue() ? 1 : 0);
        }

        private boolean e(int i3) {
            return (i3 & 1) != 0;
        }

        public boolean a() {
            return b(this.f4005b);
        }

        public boolean d() {
            return e(this.f4005b);
        }

        public ContentValues f() {
            ContentValues contentValues = new ContentValues();
            contentValues.put("expression", this.f4004a);
            contentValues.put("flags", Integer.valueOf(this.f4005b));
            contentValues.put("history_flags", Integer.valueOf(this.f4007d));
            if (this.f4006c == 0) {
                this.f4006c = System.currentTimeMillis();
            }
            contentValues.put("timeStamp", Long.valueOf(this.f4006c));
            return contentValues;
        }

        private e(byte[] bArr, int i3, int i4, long j3) {
            this.f4004a = bArr;
            this.f4005b = i3;
            this.f4006c = j3;
            this.f4007d = i4;
        }

        public e(byte[] bArr, boolean z2, boolean z3, int i3, long j3) {
            this(bArr, c(Boolean.valueOf(z2), Boolean.valueOf(z3)), i3, j3);
        }
    }

    public c(Context context) {
        this.f3988b = new d(context);
        new b().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, this.f3988b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        VLog.e("BBKCalculator/ExpressionDB", "Database access failed");
        r();
        synchronized (this.f3997k) {
            this.f3990d = 1L;
            this.f3991e = -1L;
        }
    }

    private void E() {
        synchronized (this.f3997k) {
            boolean z2 = false;
            while (!this.f3996j && !z()) {
                try {
                    this.f3997k.wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        synchronized (this.f4000n) {
            int i3 = this.f3999m - 1;
            this.f3999m = i3;
            if (i3 == 0) {
                this.f4000n.notifyAll();
            }
        }
    }

    private void H() {
        synchronized (this.f4000n) {
            this.f3999m++;
        }
    }

    private e u(long j3, int i3) {
        Cursor cursorRawQuery = this.f3989c.rawQuery("SELECT * FROM expressions WHERE _id = ?", new String[]{Long.toString(j3)});
        try {
            if (cursorRawQuery.moveToFirst()) {
                e eVar = new e(cursorRawQuery.getBlob(1), cursorRawQuery.getInt(2), cursorRawQuery.getInt(3), cursorRawQuery.getLong(4));
                cursorRawQuery.close();
                return eVar;
            }
            B();
            e eVarA = A(i3);
            cursorRawQuery.close();
            return eVarA;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private e v(int i3, int i4) {
        synchronized (this.f3997k) {
            AbstractWindowedCursor abstractWindowedCursor = this.f3994h;
            if (abstractWindowedCursor == null) {
                return null;
            }
            if (abstractWindowedCursor.moveToPosition(i3)) {
                return new e(this.f3994h.getBlob(1), this.f3994h.getInt(2), this.f3994h.getInt(3), this.f3994h.getLong(4));
            }
            VLog.d("BBKCalculator/ExpressionDB", "Failed to move cursor to position " + i3);
            B();
            return A(i4);
        }
    }

    private boolean x(long j3) {
        return true;
    }

    private boolean z() {
        return false;
    }

    e A(int i3) {
        if (i3 == 0) {
            com.vivo.calculator.a aVar = new com.vivo.calculator.a();
            aVar.e(R.id.lparen);
            aVar.e(R.id.rparen);
            return new e(aVar.i1(), false, false, 0, 0L);
        }
        if (1 == i3) {
            com.vivo.calculator.a aVar2 = new com.vivo.calculator.a(true);
            aVar2.e(R.id.lparen);
            aVar2.e(R.id.rparen);
            return new e(aVar2.i1(), false, false, 0, 0L);
        }
        com.vivo.calculator.a aVar3 = new com.vivo.calculator.a(false, false);
        aVar3.e(R.id.lparen);
        aVar3.e(R.id.rparen);
        return new e(aVar3.i1(), false, false, 0, 0L);
    }

    public long C(boolean z2, e eVar) {
        long j3;
        E();
        synchronized (this.f3997k) {
            try {
                if (z2) {
                    j3 = this.f3992f - 1;
                    this.f3992f = j3;
                } else {
                    j3 = this.f3993g + 1;
                    this.f3993g = j3;
                }
                if (!x(j3)) {
                    return j3;
                }
                H();
                ContentValues contentValuesF = eVar.f();
                contentValuesF.put("_id", Long.valueOf(j3));
                new AsyncTaskC0048c().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, contentValuesF);
                return j3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean D(e eVar, int i3) {
        ContentValues contentValuesF = eVar.f();
        String[] strArr = {Integer.toString(i3)};
        SQLiteDatabase sQLiteDatabase = this.f3989c;
        if (sQLiteDatabase != null) {
            return sQLiteDatabase.update("expressions_save", contentValuesF, "history_flags=?", strArr) > 0;
        }
        return false;
    }

    public void F() {
        synchronized (this.f4000n) {
            boolean z2 = false;
            while (this.f3999m != 0) {
                try {
                    this.f4000n.wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public long q(boolean z2, e eVar) {
        long j3;
        E();
        synchronized (this.f3997k) {
            try {
                if (z2) {
                    j3 = this.f3992f - 1;
                    this.f3992f = j3;
                } else {
                    j3 = this.f3993g + 1;
                    this.f3993g = j3;
                }
                if (!x(j3)) {
                    return j3;
                }
                H();
                ContentValues contentValuesF = eVar.f();
                contentValuesF.put("_id", Long.valueOf(j3));
                new AsyncTaskC0048c().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, contentValuesF);
                return j3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void r() {
        if (this.f3998l) {
            return;
        }
        VLog.e("BBKCalculator/ExpressionDB", "Calculator restarting due to database error");
        this.f3998l = true;
    }

    public long s() {
        long j3;
        E();
        synchronized (this.f3997k) {
            j3 = this.f3993g;
        }
        return j3;
    }

    public e t(long j3, int i3) {
        int startPosition;
        VLog.d("BBKCalculator/ExpressionDB", "getRow: index = HistoryFragment = " + j3);
        E();
        if (!x(j3)) {
            r();
            return A(i3);
        }
        int i4 = this.f3995i - ((int) j3);
        if (j3 < 0) {
            i4 = (int) (((long) i4) - 11);
        }
        if (i4 < 0) {
            VLog.e("BBKCalculator/ExpressionDB", "Database access out of range, index = " + j3 + " rel. pos. = " + i4);
        }
        if (j3 < 0) {
            if (this.f3994h == null) {
                return null;
            }
            synchronized (this.f3997k) {
                CursorWindow window = this.f3994h.getWindow();
                startPosition = window.getStartPosition() + window.getNumRows();
            }
            if (i4 >= startPosition) {
                return u(j3, i3);
            }
        }
        return v(i4, i3);
    }

    public e w(String str) {
        String[] strArr = {str};
        SQLiteDatabase sQLiteDatabase = this.f3989c;
        if (sQLiteDatabase == null) {
            return null;
        }
        Cursor cursorQuery = sQLiteDatabase.query("expressions_save", null, "history_flags=?", strArr, null, null, null);
        if (cursorQuery.moveToFirst()) {
            return new e(cursorQuery.getBlob(1), cursorQuery.getInt(2), cursorQuery.getInt(3), cursorQuery.getLong(4));
        }
        return null;
    }

    public void y(e eVar) {
        ContentValues contentValuesF = eVar.f();
        SQLiteDatabase sQLiteDatabase = this.f3989c;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.insert("expressions_save", null, contentValuesF);
        }
    }
}
