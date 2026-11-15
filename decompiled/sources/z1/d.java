package z1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.vivo.calculator.BBKCalculatorApplication;
import com.vivo.calculator.HistoryLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import vivo.util.VLog;

/* JADX INFO: compiled from: History.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static d f6642e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f6643f = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C0103d f6644a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HistoryLayout f6646c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<Map<String, String>> f6645b = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6647d = 0;

    /* JADX INFO: compiled from: History.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f6648b;

        a(Map map) {
            this.f6648b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.t((String) this.f6648b.get("history"), (String) this.f6648b.get("result"), (String) this.f6648b.get("degrad"), (String) this.f6648b.get("datetime"));
                d.d(d.this);
                if (d.this.f6647d > d.f6643f) {
                    d.this.p();
                    d.e(d.this);
                }
            } catch (Exception e3) {
                VLog.e("BBKCalculator/History", "putMapToHistoryData e" + e3);
            }
        }
    }

    /* JADX INFO: compiled from: History.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.o();
            d.this.f6647d = 0;
        }
    }

    /* JADX INFO: compiled from: History.java */
    class c implements Runnable {

        /* JADX INFO: compiled from: History.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f6646c.U();
                VLog.d("BBKCalculator/History", "initHistoryData end");
            }
        }

        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f6647d = 0;
            d.this.m();
            d.this.v();
            if (d.this.f6647d > d.f6643f) {
                while (d.this.f6647d <= d.f6643f) {
                    d.this.f6645b.remove(0);
                    d.this.p();
                    d.e(d.this);
                }
            }
            d.this.f6646c.post(new a());
        }
    }

    /* JADX INFO: renamed from: z1.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: History.java */
    public class C0103d extends SQLiteOpenHelper {
        public C0103d(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i3) {
            super(context, str, cursorFactory, i3);
        }

        private void a(SQLiteDatabase sQLiteDatabase, String str, int i3) {
            VLog.v("BBKCalculator/History", "bootstrap DB from version " + i3);
            try {
                sQLiteDatabase.execSQL(str);
            } catch (Exception e3) {
                VLog.e("BBKCalculator/History", e3.getMessage());
            }
        }

        private void b(SQLiteDatabase sQLiteDatabase, int i3) {
            VLog.v("BBKCalculator/History", "dropTable DB from version " + i3);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS history_table;");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table history_table(history text, result text,degrad text )");
            onUpgrade(sQLiteDatabase, 1, 2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
            VLog.v("BBKCalculator/History", "onDowngrade DB from version " + i3 + " to " + i4);
            if (i4 == 1) {
                b(sQLiteDatabase, i4);
                a(sQLiteDatabase, "create table history_table(history text, result text,degrad text )", i4);
            } else if (i4 == 2) {
                b(sQLiteDatabase, i4);
                a(sQLiteDatabase, "create table history_table(history text, result text,degrad text,datetime text)", i4);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
            while (i3 < i4) {
                if (i3 == 1) {
                    sQLiteDatabase.execSQL("ALTER TABLE history_table ADD COLUMN datetime VARCHAR");
                }
                i3++;
            }
        }
    }

    private d(Context context) {
        this.f6644a = new C0103d(context, "history.db3", null, 2);
    }

    static /* synthetic */ int d(d dVar) {
        int i3 = dVar.f6647d;
        dVar.f6647d = i3 + 1;
        return i3;
    }

    static /* synthetic */ int e(d dVar) {
        int i3 = dVar.f6647d;
        dVar.f6647d = i3 - 1;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f6645b.isEmpty()) {
            return;
        }
        this.f6645b.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        SQLiteDatabase writableDatabase = this.f6644a.getWritableDatabase();
        writableDatabase.execSQL("delete from history_table");
        writableDatabase.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        SQLiteDatabase writableDatabase = this.f6644a.getWritableDatabase();
        writableDatabase.execSQL("delete from history_table where rowid = (select min(rowid) from history_table)");
        writableDatabase.close();
    }

    public static d r(Context context) {
        if (f6642e == null) {
            f6642e = new d(context.getApplicationContext());
        }
        return f6642e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, String str2, String str3, String str4) {
        VLog.d("BBKCalculator/History", "insert Data " + str + "=" + str2 + "(" + str3 + ")datetime:" + str4);
        SQLiteDatabase writableDatabase = this.f6644a.getWritableDatabase();
        writableDatabase.execSQL("insert into history_table values( ? ,?,?,?)", new String[]{str, str2, str3, str4});
        writableDatabase.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        String str;
        try {
            SQLiteDatabase readableDatabase = this.f6644a.getReadableDatabase();
            Cursor cursorRawQuery = null;
            try {
                try {
                    cursorRawQuery = readableDatabase.rawQuery("select * from history_table ORDER BY datetime ASC ", null);
                    if (cursorRawQuery != null && cursorRawQuery.getCount() != 0) {
                        while (cursorRawQuery.moveToNext()) {
                            HashMap map = new HashMap();
                            map.put("history", cursorRawQuery.getString(0));
                            map.put("result", cursorRawQuery.getString(1));
                            map.put("degrad", cursorRawQuery.getString(2));
                            map.put("datetime", cursorRawQuery.getString(3));
                            this.f6645b.add(map);
                            this.f6647d++;
                            VLog.d("BBKCalculator/History", "query Data " + cursorRawQuery.getString(0) + "=" + cursorRawQuery.getString(1) + " mHistoryDataCountInDB=" + this.f6647d);
                        }
                    }
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Exception e3) {
                            str = "queryHistoryData,exception2:" + e3;
                            VLog.e("BBKCalculator/History", str);
                        }
                    }
                } catch (Throwable th) {
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Exception e4) {
                            VLog.e("BBKCalculator/History", "queryHistoryData,exception2:" + e4);
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                VLog.e("BBKCalculator/History", "queryHistoryData,exception1:" + e5);
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception e6) {
                        str = "queryHistoryData,exception2:" + e6;
                        VLog.e("BBKCalculator/History", str);
                    }
                }
            }
            readableDatabase.close();
        } catch (Exception e7) {
            VLog.e("BBKCalculator/History", "queryHistoryData,exception3:" + e7);
        }
    }

    public void n() {
        m();
        BBKCalculatorApplication.a().c().execute(new b());
    }

    public ArrayList<Map<String, String>> q() {
        return this.f6645b;
    }

    public void s() {
        VLog.d("BBKCalculator/History", "initHistoryData start");
        BBKCalculatorApplication.a().c().execute(new c());
    }

    public void u(Map<String, String> map) {
        if (map == null) {
            return;
        }
        this.f6645b.add(map);
        if (this.f6645b.size() > f6643f) {
            this.f6645b.remove(0);
        }
        BBKCalculatorApplication.a().c().execute(new a(map));
    }

    public void w(HistoryLayout historyLayout) {
        this.f6646c = historyLayout;
    }
}
