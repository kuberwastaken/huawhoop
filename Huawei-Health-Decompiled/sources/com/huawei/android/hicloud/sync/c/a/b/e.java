package com.huawei.android.hicloud.sync.c.a.b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import defpackage.auf;
import defpackage.avi;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public abstract class e<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f1866a = auf.fV_();

    protected abstract V a(Cursor cursor);

    public void a(String str, String[] strArr) throws Exception {
        if (strArr != null) {
            this.f1866a.execSQL(str, strArr);
        } else {
            this.f1866a.execSQL(str);
        }
    }

    public ArrayList<V> b(String str, String[] strArr) {
        Exception e;
        ArrayList<V> arrayList = new ArrayList<>();
        if (str == null) {
            return arrayList;
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = this.f1866a.rawQuery(str, strArr);
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    ArrayList<V> arrayList2 = new ArrayList<>();
                    do {
                        try {
                            arrayList2.add(a(cursorRawQuery));
                        } catch (Exception e2) {
                            e = e2;
                            arrayList = arrayList2;
                            avi.c("SyncOperator", "queryResult4Vo exception: " + e.getClass().getName());
                            return arrayList;
                        }
                    } while (cursorRawQuery.moveToNext());
                    arrayList = arrayList2;
                }
            } finally {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        if (cursorRawQuery != null) {
        }
        return arrayList;
    }

    public Cursor c(String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase = this.f1866a;
        if (sQLiteDatabase == null || str == null) {
            avi.d("SyncOperator", "rawQuery database or sql is null.");
            return null;
        }
        try {
            return sQLiteDatabase.rawQuery(str, strArr);
        } catch (Exception e) {
            avi.c("SyncOperator", "rawQuery exception: " + e.getClass().getName());
            return null;
        }
    }

    public int a(String str, ArrayList<String[]> arrayList) {
        int i;
        if (str == null) {
            return -2;
        }
        try {
            if (arrayList == null) {
                return -2;
            }
            try {
                this.f1866a.beginTransaction();
                SQLiteStatement sQLiteStatementCompileStatement = this.f1866a.compileStatement(str);
                for (String[] strArr : arrayList) {
                    sQLiteStatementCompileStatement.clearBindings();
                    sQLiteStatementCompileStatement.bindAllArgsAsStrings(strArr);
                    sQLiteStatementCompileStatement.execute();
                }
                this.f1866a.setTransactionSuccessful();
                i = 0;
            } catch (Exception e) {
                avi.c("SyncOperator", "execSQL4Batch exception: " + e.getClass().getName());
                i = -1;
            }
            return i;
        } finally {
            this.f1866a.endTransaction();
        }
    }
}
