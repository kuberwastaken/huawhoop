package ohos.ace.adapter.capability.web;

import android.content.ContentValues;
import android.database.Cursor;
import ohos.ace.adapter.capability.web.WebDataBaseColumns;

/* JADX INFO: loaded from: classes8.dex */
public class WebDataBaseHttpAuthDao {
    String[] columns = {"_id", "host", WebDataBaseColumns.EntryColumns.COLUMN_NAME_REALM};
    WebDataBaseHelper dataBaseHelper;

    public WebDataBaseHttpAuthDao(WebDataBaseHelper webDataBaseHelper) {
        this.dataBaseHelper = webDataBaseHelper;
    }

    public long insert(WebDataBaseHttpAuth webDataBaseHttpAuth) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("host", webDataBaseHttpAuth.getHost());
        contentValues.put(WebDataBaseColumns.EntryColumns.COLUMN_NAME_REALM, webDataBaseHttpAuth.getRealm());
        return this.dataBaseHelper.getWritableDatabase().insert(WebDataBaseColumns.EntryColumns.TABLE_NAME_HTTPAUTH, null, contentValues);
    }

    public long delete(WebDataBaseHttpAuth webDataBaseHttpAuth) {
        return this.dataBaseHelper.getWritableDatabase().delete(WebDataBaseColumns.EntryColumns.TABLE_NAME_HTTPAUTH, "_id = ?", new String[]{webDataBaseHttpAuth.getId().toString()});
    }

    public WebDataBaseHttpAuth find(String str, String str2) {
        WebDataBaseHttpAuth webDataBaseHttpAuth;
        Cursor cursorQuery = this.dataBaseHelper.getReadableDatabase().query(WebDataBaseColumns.EntryColumns.TABLE_NAME_HTTPAUTH, this.columns, "host = ? AND realm = ?", new String[]{str, str2}, null, null, null);
        if (cursorQuery.moveToNext()) {
            long j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
            webDataBaseHttpAuth = new WebDataBaseHttpAuth(Long.valueOf(j), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("host")), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(WebDataBaseColumns.EntryColumns.COLUMN_NAME_REALM)));
        } else {
            webDataBaseHttpAuth = null;
        }
        cursorQuery.close();
        return webDataBaseHttpAuth;
    }
}
