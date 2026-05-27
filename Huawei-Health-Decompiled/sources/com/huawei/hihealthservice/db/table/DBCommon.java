package com.huawei.hihealthservice.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import androidx.media3.common.C;
import com.huawei.hihealth.util.HiJsonUtil;
import com.huawei.hihealthservice.db.helper.HiHealthDBHelper;
import com.huawei.hwlogsmodel.LogUtil;
import health.compact.a.LogAnonymous;
import health.compact.a.hwlogsmodel.ReleaseLogUtil;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DBCommon {
    private static final int DB_EXCEPTION = -1001;
    public static final int DB_NULL_ERROR = -1000;
    private static final int DURATION_THRESHOLD = 1000;
    private static final int DURATION_THRESHOLD_LONG_TIME = 3000;
    private static final String LOG_TAG = "HiH_DBCommon";
    private final String mDbName;

    protected abstract String[] getColumns();

    protected abstract String getTableName();

    public DBCommon() {
        this.mDbName = null;
    }

    public DBCommon(String str) {
        this.mDbName = str;
    }

    public long insert(ContentValues contentValues) {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            SQLiteDatabase writableDatabase = HiHealthDBHelper.b(this.mDbName).getWritableDatabase();
            if (writableDatabase == null) {
                return -1000L;
            }
            long jInsert = writableDatabase.insert(getTableName(), (String) null, contentValues);
            printDurationLog(jElapsedRealtime, getTableName(), "insert", null);
            return jInsert;
        } catch (SQLiteException e) {
            ReleaseLogUtil.c(LOG_TAG, "insert SQLiteException!", LogAnonymous.b(e));
            return -1001L;
        } catch (Exception e2) {
            ReleaseLogUtil.c(LOG_TAG, "insert Exception!", LogAnonymous.b(e2));
            return -1001L;
        }
    }

    public int delete(String str, String[] strArr) {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            SQLiteDatabase writableDatabase = HiHealthDBHelper.b(this.mDbName).getWritableDatabase();
            if (writableDatabase == null) {
                return -1000;
            }
            int iDelete = writableDatabase.delete(getTableName(), str, strArr);
            printDurationLog(jElapsedRealtime, getTableName(), "delete:" + str, strArr);
            return iDelete;
        } catch (SQLiteException e) {
            ReleaseLogUtil.c(LOG_TAG, "delete SQLiteException!", LogAnonymous.b(e));
            return -1001;
        } catch (Exception e2) {
            ReleaseLogUtil.c(LOG_TAG, "delete Exception!", LogAnonymous.b(e2));
            return -1001;
        }
    }

    public int update(ContentValues contentValues, String str, String[] strArr) {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            SQLiteDatabase writableDatabase = HiHealthDBHelper.b(this.mDbName).getWritableDatabase();
            if (writableDatabase == null) {
                return -1000;
            }
            int iUpdate = writableDatabase.update(getTableName(), contentValues, str, strArr);
            printDurationLog(jElapsedRealtime, getTableName(), "update:" + str, strArr);
            return iUpdate;
        } catch (SQLiteException e) {
            ReleaseLogUtil.c(LOG_TAG, "update SQLiteException!", LogAnonymous.b(e));
            return -1001;
        } catch (Exception e2) {
            ReleaseLogUtil.c(LOG_TAG, "update Exception!", LogAnonymous.b(e2));
            return -1001;
        }
    }

    public Cursor query(String str, String[] strArr, String str2, String str3, String str4) {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                SQLiteDatabase writableDatabase = HiHealthDBHelper.b(this.mDbName).getWritableDatabase();
                if (writableDatabase == null) {
                    return null;
                }
                Cursor cursorQuery = writableDatabase.query(getTableName(), getColumns(), str, strArr, str2, str3, str4);
                printDurationLog(jElapsedRealtime, getTableName(), "query:" + str, strArr);
                return cursorQuery;
            } catch (SQLiteException e) {
                e = e;
                ReleaseLogUtil.c(LOG_TAG, "query SQLiteException!", LogAnonymous.b(e));
                return null;
            } catch (Exception e2) {
                e = e2;
                ReleaseLogUtil.c(LOG_TAG, "query Exception!", LogAnonymous.b(e));
                return null;
            }
        } catch (SQLiteException e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
        }
    }

    public Cursor queryEX(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                SQLiteDatabase writableDatabase = HiHealthDBHelper.b(this.mDbName).getWritableDatabase();
                if (writableDatabase == null) {
                    return null;
                }
                Cursor cursorQuery = writableDatabase.query(getTableName(), strArr, str, strArr2, str2, str3, str4);
                printDurationLog(jElapsedRealtime, getTableName(), "query:" + str, strArr2);
                return cursorQuery;
            } catch (SQLiteException e) {
                e = e;
                ReleaseLogUtil.c(LOG_TAG, "queryEX SQLiteException!", LogAnonymous.b(e));
                return null;
            } catch (Exception e2) {
                e = e2;
                ReleaseLogUtil.c(LOG_TAG, "queryEX Exception!", LogAnonymous.b(e));
                return null;
            }
        } catch (SQLiteException e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            SQLiteDatabase writableDatabase = HiHealthDBHelper.b(this.mDbName).getWritableDatabase();
            if (writableDatabase == null) {
                return null;
            }
            Cursor cursorRawQuery = writableDatabase.rawQuery(str, strArr);
            printDurationLog(jElapsedRealtime, getTableName(), "rawQuery:" + str, strArr);
            return cursorRawQuery;
        } catch (SQLiteException e) {
            ReleaseLogUtil.c(LOG_TAG, "rawQuery SQLiteException!", LogAnonymous.b(e));
            return null;
        } catch (Exception e2) {
            ReleaseLogUtil.c(LOG_TAG, "rawQuery Exception!", LogAnonymous.b(e2));
            return null;
        }
    }

    public void execSQL(String str, Object[] objArr) {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            SQLiteDatabase writableDatabase = HiHealthDBHelper.b(this.mDbName).getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.execSQL(str, objArr);
                printDurationLog(jElapsedRealtime, null, "execSQL:" + str, null);
            }
        } catch (SQLiteException e) {
            ReleaseLogUtil.c(LOG_TAG, "execSQL ClearAllInfo SQLiteException!", LogAnonymous.b(e));
        } catch (Exception e2) {
            ReleaseLogUtil.c(LOG_TAG, "execSQL ClearAllInfo Exception!", LogAnonymous.b(e2));
        }
    }

    private void printDurationLog(long j, String str, String str2, String[] strArr) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (jElapsedRealtime > C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
            LogUtil.b(LOG_TAG, "duration:", Long.valueOf(jElapsedRealtime), "ms, tableName:" + str, ", sql:" + str2);
            LogUtil.e(LOG_TAG, "param:" + HiJsonUtil.d(strArr));
        }
    }
}
