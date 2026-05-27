package com.huawei.hianalytics.core;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.DBUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3982a;
    public SQLiteDatabase b;
    public final ContentValues c = new ContentValues();
    public SQLiteStatement d;

    public abstract T a(Cursor cursor);

    public abstract void a(ContentValues contentValues, T t);

    public void c() {
        if (a()) {
            return;
        }
        DBUtil.deleteAll(this.b, this.f3982a);
        HiLog.i("AbstractDao", "deleteAll: " + this.f3982a);
    }

    public final long b(List<T> list, boolean z) {
        long jInsertWithOnConflict;
        long j = -1;
        try {
            synchronized (this) {
                jInsertWithOnConflict = -1;
                for (int i = 0; i < list.size(); i++) {
                    try {
                        a(this.c, list.get(i));
                        jInsertWithOnConflict = z ? this.b.insertWithOnConflict(this.f3982a, null, this.c, 5) : this.b.insert(this.f3982a, null, this.c);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Exception e) {
                            e = e;
                            j = jInsertWithOnConflict;
                            HiLog.e("AbstractDao", "insertOrReplace() error: " + e.getMessage());
                            return j;
                        }
                    }
                }
            }
            return jInsertWithOnConflict;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public long b() {
        if (this.d == null) {
            this.d = this.b.compileStatement("SELECT COUNT(*) FROM \"" + this.f3982a + '\"');
        }
        return this.d.simpleQueryForLong();
    }

    public int b(String str, String[] strArr) {
        int iA = -1;
        if (a()) {
            return -1;
        }
        if (this.b.isDbLockedByCurrentThread()) {
            return a(str, strArr);
        }
        this.b.beginTransaction();
        try {
            try {
                iA = a(str, strArr);
                this.b.setTransactionSuccessful();
            } catch (Exception e) {
                HiLog.e("AbstractDao", e.getMessage());
            }
            return iA;
        } finally {
            this.b.endTransaction();
        }
    }

    public boolean a() {
        return this.b == null;
    }

    public List<T> a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.b.query(this.f3982a, strArr, str, strArr2, null, null, str4, str5);
                while (cursorQuery.moveToNext()) {
                    arrayList.add(a(cursorQuery));
                }
            } catch (Exception e) {
                HiLog.e("AbstractDao", e.getMessage());
                if (cursorQuery != null) {
                }
                return arrayList;
            }
            cursorQuery.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public long a(List<T> list, boolean z) {
        long jB = -1;
        if (a()) {
            return -1L;
        }
        if (this.b.isDbLockedByCurrentThread()) {
            return b(list, z);
        }
        this.b.beginTransaction();
        try {
            try {
                jB = b(list, z);
                this.b.setTransactionSuccessful();
            } catch (Exception e) {
                HiLog.e("AbstractDao", e.getMessage());
            }
            return jB;
        } finally {
            this.b.endTransaction();
        }
    }

    public final int a(String str, String[] strArr) {
        int iDelete = -1;
        try {
            synchronized (this) {
                iDelete = this.b.delete(this.f3982a, str, strArr);
            }
        } catch (Exception e) {
            HiLog.e("AbstractDao", "deleteSynchronized() error: " + e.getMessage());
        }
        return iDelete;
    }

    public a(SQLiteDatabase sQLiteDatabase, String str) {
        this.b = sQLiteDatabase;
        this.f3982a = str;
    }
}
