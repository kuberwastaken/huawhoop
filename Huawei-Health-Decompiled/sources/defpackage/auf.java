package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.huawei.android.hicloud.sync.c.a.a;

/* JADX INFO: loaded from: classes10.dex */
public final class auf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f326a;
    private static volatile a c;
    private static volatile SQLiteDatabase d;

    public static void c(Context context) {
        synchronized (auf.class) {
            avi.b("SyncDBManager", "initDataBase start!");
            f326a = context.createDeviceProtectedStorageContext();
            if (c == null) {
                avi.b("SyncDBManager", "init db helper");
                c = new a(f326a);
            }
        }
    }

    public static SQLiteDatabase fV_() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (auf.class) {
            if (d == null) {
                try {
                    if (c == null) {
                        c(f326a);
                    }
                    d = c.getWritableDatabase();
                } catch (SQLiteException unused) {
                    avi.c("SyncDBManager", "getDB() SQLiteException");
                }
                sQLiteDatabase = d;
            } else {
                sQLiteDatabase = d;
            }
        }
        return sQLiteDatabase;
    }

    public static void e(Context context) {
        f326a = context;
    }

    public static Context e() {
        return f326a;
    }
}
