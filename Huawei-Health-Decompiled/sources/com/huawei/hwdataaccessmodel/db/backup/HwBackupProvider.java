package com.huawei.hwdataaccessmodel.db.backup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import health.compact.a.LogUtil;
import health.compact.a.SqlUtil;

/* JADX INFO: loaded from: classes.dex */
public class HwBackupProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (uri == null) {
            LogUtil.b("HwBackupProvider", "query uri is null");
            return null;
        }
        SQLiteDatabase readableDatabase = c().getReadableDatabase();
        String string = uri.toString();
        String strSubstring = string.substring(string.lastIndexOf("/") + 1);
        if (TextUtils.isEmpty(strSubstring)) {
            throw new IllegalArgumentException("This is a unknown Uri" + uri.toString());
        }
        return readableDatabase.query(strSubstring, strArr, SqlUtil.d(str), strArr2, null, null, str2);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (uri == null) {
            LogUtil.b("HwBackupProvider", "insert uri is null");
            return null;
        }
        if (contentValues == null) {
            LogUtil.b("HwBackupProvider", "insert values is null");
            return null;
        }
        SQLiteDatabase writableDatabase = c().getWritableDatabase();
        String string = uri.toString();
        String strSubstring = string.substring(string.lastIndexOf("/") + 1);
        if (TextUtils.isEmpty(strSubstring)) {
            throw new IllegalArgumentException("This is a unknown Uri" + uri.toString());
        }
        Uri uriWithAppendedPath = Uri.withAppendedPath(uri, "/" + writableDatabase.insert(strSubstring, null, contentValues));
        getContext().getContentResolver().notifyChange(uri, null);
        return uriWithAppendedPath;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (uri == null) {
            LogUtil.b("HwBackupProvider", "delete uri is null");
            return 0;
        }
        SQLiteDatabase writableDatabase = c().getWritableDatabase();
        String string = uri.toString();
        String strSubstring = string.substring(string.lastIndexOf("/") + 1);
        if (TextUtils.isEmpty(strSubstring)) {
            throw new IllegalArgumentException("This is a unknown Uri" + uri.toString());
        }
        return writableDatabase.delete(strSubstring, SqlUtil.d(str), strArr);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (uri == null) {
            LogUtil.b("HwBackupProvider", "update uri is null");
            return 0;
        }
        if (contentValues == null) {
            LogUtil.b("HwBackupProvider", "update values is null");
            return 0;
        }
        SQLiteDatabase writableDatabase = c().getWritableDatabase();
        String string = uri.toString();
        String strSubstring = string.substring(string.lastIndexOf("/") + 1);
        if (TextUtils.isEmpty(strSubstring)) {
            throw new IllegalArgumentException("This is a unknown Uri" + uri.toString());
        }
        return writableDatabase.update(strSubstring, contentValues, SqlUtil.d(str), strArr);
    }

    private DbBackupKeyProvider c() {
        return DbBackupKeyProvider.b(getContext());
    }
}
