package c2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import vivo.util.VLog;

/* JADX INFO: compiled from: CountryDataBaseHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f2497b;

    public a(Context context) {
        super(context, "CountryBase.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        VLog.d("BBKCalculator/CountryDataBaseHelper", "createTablecreate table CurrencyBase(_id integer primary key autoincrement, id,curr,code,currency_name,exchange,currency_name_py)");
        try {
            sQLiteDatabase.execSQL("create table CurrencyBase(_id integer primary key autoincrement, id,curr,code,currency_name,exchange,currency_name_py)");
        } catch (Exception e3) {
            VLog.e("BBKCalculator/CountryDataBaseHelper", "onUpgrade createTable  err," + e3.getMessage());
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        VLog.d("BBKCalculator/CountryDataBaseHelper", "dropTable TABLE_NAME == CurrencyBase");
        VLog.d("BBKCalculator/CountryDataBaseHelper", "dropTable db == " + sQLiteDatabase);
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS CurrencyBase");
        } catch (Exception e3) {
            VLog.e("BBKCalculator/CountryDataBaseHelper", "dropTable  err," + e3.getMessage());
        }
    }

    public static synchronized a c(Context context) {
        if (f2497b == null) {
            VLog.d("BBKCalculator/CountryDataBaseHelper", "getInstance: ");
            f2497b = new a(context);
        }
        return f2497b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        VLog.d("BBKCalculator/CountryDataBaseHelper", "onCreate: create table CurrencyBase(_id integer primary key autoincrement, id,curr,code,currency_name,exchange,currency_name_py)");
        try {
            sQLiteDatabase.execSQL("create table CurrencyBase(_id integer primary key autoincrement, id,curr,code,currency_name,exchange,currency_name_py)");
        } catch (Exception e3) {
            VLog.e("BBKCalculator/CountryDataBaseHelper", "create Table  err," + e3.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
    }
}
