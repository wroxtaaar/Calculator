package com.vivo.calculator.helper;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import c2.a;

/* JADX INFO: loaded from: classes.dex */
public class CountryProvide extends ContentProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Uri f4144c = Uri.parse("content://com.vivo.calculator.CountryProvide/CurrencyBase");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final UriMatcher f4145d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f4146b;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f4145d = uriMatcher;
        uriMatcher.addURI("com.vivo.calculator.CountryProvide", "CurrencyBase", 0);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.f4146b.getWritableDatabase();
        if (f4145d.match(uri) == 0) {
            return writableDatabase.delete("CurrencyBase", str, strArr);
        }
        throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = this.f4146b.getWritableDatabase();
        if (f4145d.match(uri) == 0) {
            return ContentUris.withAppendedId(f4144c, writableDatabase.insert("CurrencyBase", null, contentValues));
        }
        throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f4146b = a.c(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteDatabase readableDatabase = this.f4146b.getReadableDatabase();
        if (f4145d.match(uri) == 0) {
            return readableDatabase.query("CurrencyBase", strArr, str, strArr2, null, null, str2);
        }
        throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.f4146b.getWritableDatabase();
        if (f4145d.match(uri) == 0) {
            int iUpdate = writableDatabase.update("CurrencyBase", contentValues, str, strArr);
            getContext().getContentResolver().notifyChange(uri, null);
            getContext().getContentResolver().notifyChange(uri, null);
            return iUpdate;
        }
        throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());
    }
}
