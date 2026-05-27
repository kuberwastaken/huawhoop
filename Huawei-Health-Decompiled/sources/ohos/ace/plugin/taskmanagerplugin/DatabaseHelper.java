package ohos.ace.plugin.taskmanagerplugin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes2.dex */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "task.db";
    private static final int DATABASE_VERSION = 1;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE Task (tid INTEGER PRIMARY KEY AUTOINCREMENT, saveas TEXT, url TEXT, data TEXT, title TEXT, description TEXT, action1 INTEGER, mode INTEGER, mimeType TEXT, progress TEXT, ctime INTEGER, mtime INTEGER, faults INTEGER, reason TEXT, taskStates TEXT, downloadId TEXT, token TEXT, roaming INTEGER, metered INTEGER, network INTEGER, headers TEXT, version INTEGER, index1 INTEGER, begins INTEGER, ends INTEGER, priority INTEGER, overwrite INTEGER, retry INTEGER, redirect INTEGER, gauge INTEGER, precise INTEGER, background INTEGER, method TEXT, forms TEXT, files TEXT, bodyFds TEXT, bodyFileNames TEXT, tries INTEGER, code INTEGER, withSystem INTEGER, extras TEXT)");
    }
}
