package c2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.vivo.calculator.helper.CountryProvide;
import java.util.ArrayList;
import vivo.util.VLog;

/* JADX INFO: compiled from: DataBaseUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f2498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<c> f2499b;

    public b(Context context) {
        this.f2498a = a.c(context.getApplicationContext());
    }

    public ContentValues a(String str, String str2, String str3, String str4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("curr", str);
        contentValues.put("code", str2);
        contentValues.put("currency_name", str3);
        contentValues.put("currency_name_py", str4);
        return contentValues;
    }

    public ContentValues b(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("curr", str);
        contentValues.put("exchange", str2);
        return contentValues;
    }

    public void c(Context context, Uri uri, ContentValues contentValues) {
        context.getContentResolver().insert(uri, contentValues);
    }

    public synchronized ArrayList<c> d(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        this.f2499b = new ArrayList<>();
        Cursor cursorQuery = context.getContentResolver().query(uri, strArr, str, strArr2, str2);
        if (cursorQuery == null) {
            return null;
        }
        if (!cursorQuery.isClosed()) {
            while (cursorQuery.moveToNext()) {
                c cVar = new c();
                int columnIndex = cursorQuery.getColumnIndex("curr");
                if (columnIndex != -1) {
                    cVar.h(cursorQuery.getString(columnIndex));
                }
                int columnIndex2 = cursorQuery.getColumnIndex("code");
                if (columnIndex2 != -1) {
                    cVar.g(cursorQuery.getString(columnIndex2));
                }
                int columnIndex3 = cursorQuery.getColumnIndex("currency_name");
                if (columnIndex3 != -1) {
                    cVar.i(cursorQuery.getString(columnIndex3));
                }
                int columnIndex4 = cursorQuery.getColumnIndex("exchange");
                if (columnIndex4 != -1) {
                    cVar.k(cursorQuery.getString(columnIndex4));
                }
                int columnIndex5 = cursorQuery.getColumnIndex("currency_name_py");
                if (columnIndex5 != -1) {
                    cVar.j(cursorQuery.getString(columnIndex5));
                }
                String strC = cVar.c();
                String strB = cVar.b();
                String strB2 = cVar.b();
                String strE = cVar.e();
                if (!TextUtils.isEmpty(strC) && !TextUtils.isEmpty(strB) && !TextUtils.isEmpty(strB2) && !"0".equalsIgnoreCase(strE) && !"0.0".equalsIgnoreCase(strE) && !TextUtils.isEmpty(strE)) {
                    this.f2499b.add(cVar);
                }
            }
            try {
                cursorQuery.close();
            } catch (Exception e3) {
                VLog.d("BBKCalculator/DataBaseUtils", "queryData e " + e3);
            }
        }
        return this.f2499b;
    }

    public synchronized Cursor e(String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorQuery = this.f2498a.getReadableDatabase().query("CurrencyBase", strArr, str, strArr2, null, null, str2);
        if (cursorQuery == null) {
            return null;
        }
        return cursorQuery;
    }

    public boolean f(Context context, ContentValues contentValues, String str, String[] strArr) {
        return context.getContentResolver().update(CountryProvide.f4144c, contentValues, str, strArr) > 0;
    }

    public b() {
        VLog.d("BBKCalculator/DataBaseUtils", "DataBaseUtils: ");
    }
}
