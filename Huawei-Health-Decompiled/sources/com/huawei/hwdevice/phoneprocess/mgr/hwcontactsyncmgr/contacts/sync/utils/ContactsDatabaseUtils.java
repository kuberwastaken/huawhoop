package com.huawei.hwdevice.phoneprocess.mgr.hwcontactsyncmgr.contacts.sync.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwlogsmodel.LogUtil;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class ContactsDatabaseUtils {

    public interface ResultCallback<R> {
        void onResult(R r);
    }

    public static void b(d dVar, ResultCallback<Cursor> resultCallback) {
        if (dVar == null || resultCallback == null) {
            LogUtil.j("ContactsDatabaseUtils", "query: input parameter is null.");
            return;
        }
        ContentResolver contentResolver = BaseApplication.getContext().getContentResolver();
        if (contentResolver == null) {
            LogUtil.j("ContactsDatabaseUtils", "query: resolver is null.");
            return;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(dVar.f6552a, dVar.c, dVar.d, dVar.e, dVar.b);
                resultCallback.onResult(cursorQuery);
                if (cursorQuery == null) {
                    return;
                }
            } catch (CursorIndexOutOfBoundsException | SQLiteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException unused) {
                LogUtil.a("ContactsDatabaseUtils", "getContactIdList: occurred Exception.");
                if (cursorQuery == null) {
                    return;
                }
            }
            cursorQuery.close();
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public static void bSF_(Cursor cursor, int i, ResultCallback<String> resultCallback) {
        if (bSD_(cursor)) {
            LogUtil.j("ContactsDatabaseUtils", "parseDataList: cursor is null or cannot move.");
            return;
        }
        if (resultCallback == null) {
            LogUtil.j("ContactsDatabaseUtils", "parseDataList: out data list is null.");
        } else if (!bSE_(cursor, i)) {
            LogUtil.j("ContactsDatabaseUtils", "parseDataList: columnIndex is invalid.");
        } else {
            do {
                resultCallback.onResult(cursor.getString(i));
            } while (cursor.moveToNext());
        }
    }

    public static void bSG_(Cursor cursor, int i, ResultCallback<String> resultCallback) {
        if (bSD_(cursor)) {
            LogUtil.j("ContactsDatabaseUtils", "parseDataList: cursor is null or cannot move.");
            return;
        }
        if (resultCallback == null) {
            LogUtil.j("ContactsDatabaseUtils", "parseDataList: out data list is null.");
            return;
        }
        if (!bSE_(cursor, i)) {
            LogUtil.j("ContactsDatabaseUtils", "parseDataList: columnIndex is invalid.");
            return;
        }
        String str = "-1";
        do {
            String string = cursor.getString(i);
            String string2 = cursor.getString(1);
            if (!string2.equals(str)) {
                resultCallback.onResult(string);
                str = string2;
            } else {
                LogUtil.b("ContactsDatabaseUtils", "preContactId is : ", str, " currentContactId is : ", string2);
            }
        } while (cursor.moveToNext());
    }

    public static boolean bSD_(Cursor cursor) {
        return cursor == null || !cursor.moveToFirst();
    }

    private static boolean bSE_(Cursor cursor, int i) {
        if (cursor != null) {
            return i >= 0 && i < cursor.getColumnCount();
        }
        LogUtil.j("ContactsDatabaseUtils", "isValidIndex: cursor is null.");
        return false;
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Uri f6552a;
        private String b;
        private String[] c;
        private String d;
        private String[] e;

        public d bSI_(Uri uri) {
            this.f6552a = uri;
            return this;
        }

        public d a(String[] strArr) {
            if (strArr != null) {
                this.c = (String[]) Arrays.copyOf(strArr, strArr.length);
            }
            return this;
        }

        public d b(String str) {
            this.d = str;
            return this;
        }

        public d e(String[] strArr) {
            if (strArr != null) {
                this.e = (String[]) Arrays.copyOf(strArr, strArr.length);
            }
            return this;
        }

        public d c(String str) {
            this.b = str;
            return this;
        }
    }
}
