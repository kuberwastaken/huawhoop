package ohos.ace.adapter.capability.web;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import ohos.ace.adapter.ALog;
import ohos.ace.adapter.capability.web.WebDataBaseColumns;

/* JADX INFO: loaded from: classes8.dex */
public class WebDataBaseHelper extends SQLiteOpenHelper {
    private static final String LOG_TAG = "WebDataBaseHelper";
    private static final String SQL_CREATE_CREDENTIAL_TABLE = "CREATE TABLE credential (_id INTEGER PRIMARY KEY,username TEXT NOT NULL,password TEXT NOT NULL,http_auth_id INTEGER NOT NULL,UNIQUE(username, password, http_auth_id),FOREIGN KEY (http_auth_id) REFERENCES http_auth (_id) ON DELETE CASCADE);";
    private static final String SQL_CREATE_GEOLOCATION_TABLE = "CREATE TEMPORARY  TABLE IF NOT EXISTS geolocation (_id INTEGER PRIMARY KEY,origin TEXT,result INTEGER,UNIQUE(origin) ON CONFLICT REPLACE);";
    private static final String SQL_CREATE_HTTPAUTH_TABLE = "CREATE TABLE http_auth (_id INTEGER PRIMARY KEY,host TEXT NOT NULL,realm TEXT,UNIQUE(host, realm));";
    private static final String SQL_DELETE_CREDENTIAL_TABLE = "DROP TABLE IF EXISTS credential";
    private static final String SQL_DELETE_GEOLOCATION_TABLE = "DROP TABLE IF EXISTS geolocation";
    private static final String SQL_DELETE_HTTP_AUTH_TABLE = "DROP TABLE IF EXISTS http_auth";
    private static final String SQL_SELECT_TABLE_FROM_TABLENAME = "SELECT name FROM sqlite_master  WHERE type='table' AND name=? ";

    public WebDataBaseHelper(Context context) {
        super(context, "AceWebDatabase.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SQL_CREATE_HTTPAUTH_TABLE);
        sQLiteDatabase.execSQL(SQL_CREATE_CREDENTIAL_TABLE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(SQL_DELETE_HTTP_AUTH_TABLE);
        sQLiteDatabase.execSQL(SQL_DELETE_CREDENTIAL_TABLE);
        sQLiteDatabase.execSQL(SQL_DELETE_GEOLOCATION_TABLE);
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    public void clearAllTables(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SQL_DELETE_HTTP_AUTH_TABLE);
        sQLiteDatabase.execSQL(SQL_DELETE_CREDENTIAL_TABLE);
        sQLiteDatabase.execSQL(SQL_DELETE_GEOLOCATION_TABLE);
        onCreate(sQLiteDatabase);
    }

    public void isTableExists(SQLiteDatabase sQLiteDatabase, String str) {
        if (WebDataBaseColumns.EntryColumns.TABLE_NAME_GEOLOCATION.equals(str)) {
            Cursor cursorRawQuery = null;
            try {
                try {
                    cursorRawQuery = sQLiteDatabase.rawQuery(SQL_SELECT_TABLE_FROM_TABLENAME, new String[]{str});
                    if (!cursorRawQuery.moveToFirst()) {
                        sQLiteDatabase.execSQL(SQL_CREATE_GEOLOCATION_TABLE);
                    }
                    if (cursorRawQuery == null) {
                        return;
                    }
                } catch (Exception e) {
                    ALog.i(LOG_TAG, "Error occurred during table existence check: " + e.getMessage());
                    if (cursorRawQuery == null) {
                        return;
                    }
                }
                cursorRawQuery.close();
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
        }
    }
}
