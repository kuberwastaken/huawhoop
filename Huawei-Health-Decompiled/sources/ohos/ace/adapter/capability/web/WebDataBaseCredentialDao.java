package ohos.ace.adapter.capability.web;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import ohos.ace.adapter.capability.web.WebDataBaseColumns;

/* JADX INFO: loaded from: classes8.dex */
public class WebDataBaseCredentialDao {
    String[] columns = {"_id", WebDataBaseColumns.EntryColumns.COLUMN_NAME_USERNAME, WebDataBaseColumns.EntryColumns.COLUMN_NAME_USERPASS, WebDataBaseColumns.EntryColumns.COLUMN_NAME_HTTP_AUTH_ID};
    WebDataBaseHelper dataBaseHelper;

    public WebDataBaseCredentialDao(WebDataBaseHelper webDataBaseHelper) {
        this.dataBaseHelper = webDataBaseHelper;
    }

    public List<WebDataBaseCredential> getAllByHttpAuthId(Long l) {
        Cursor cursorQuery = this.dataBaseHelper.getReadableDatabase().query(WebDataBaseColumns.EntryColumns.TABLE_NAME_CREDENTIAL, this.columns, "http_auth_id = ?", new String[]{l.toString()}, null, null, null);
        ArrayList arrayList = new ArrayList();
        while (cursorQuery.moveToNext()) {
            long j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
            arrayList.add(new WebDataBaseCredential(Long.valueOf(j), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(WebDataBaseColumns.EntryColumns.COLUMN_NAME_USERNAME)), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(WebDataBaseColumns.EntryColumns.COLUMN_NAME_USERPASS)), l));
        }
        cursorQuery.close();
        return arrayList;
    }

    public WebDataBaseCredential find(String str, String str2, Long l) {
        WebDataBaseCredential webDataBaseCredential;
        Cursor cursorQuery = this.dataBaseHelper.getReadableDatabase().query(WebDataBaseColumns.EntryColumns.TABLE_NAME_CREDENTIAL, this.columns, "username = ? AND password = ? AND http_auth_id = ?", new String[]{str, str2, l.toString()}, null, null, null);
        if (cursorQuery.moveToNext()) {
            long j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
            webDataBaseCredential = new WebDataBaseCredential(Long.valueOf(j), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(WebDataBaseColumns.EntryColumns.COLUMN_NAME_USERNAME)), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(WebDataBaseColumns.EntryColumns.COLUMN_NAME_USERPASS)), l);
        } else {
            webDataBaseCredential = null;
        }
        cursorQuery.close();
        return webDataBaseCredential;
    }

    public long insert(WebDataBaseCredential webDataBaseCredential) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(WebDataBaseColumns.EntryColumns.COLUMN_NAME_USERNAME, webDataBaseCredential.getUsername());
        contentValues.put(WebDataBaseColumns.EntryColumns.COLUMN_NAME_USERPASS, webDataBaseCredential.getPassword());
        contentValues.put(WebDataBaseColumns.EntryColumns.COLUMN_NAME_HTTP_AUTH_ID, webDataBaseCredential.getHttpAuthId());
        return this.dataBaseHelper.getWritableDatabase().insert(WebDataBaseColumns.EntryColumns.TABLE_NAME_CREDENTIAL, null, contentValues);
    }

    public long delete(WebDataBaseCredential webDataBaseCredential) {
        return this.dataBaseHelper.getWritableDatabase().delete(WebDataBaseColumns.EntryColumns.TABLE_NAME_CREDENTIAL, "_id = ?", new String[]{webDataBaseCredential.getId().toString()});
    }

    public long update(WebDataBaseCredential webDataBaseCredential) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(WebDataBaseColumns.EntryColumns.COLUMN_NAME_USERNAME, webDataBaseCredential.getUsername());
        contentValues.put(WebDataBaseColumns.EntryColumns.COLUMN_NAME_USERPASS, webDataBaseCredential.getPassword());
        return this.dataBaseHelper.getWritableDatabase().update(WebDataBaseColumns.EntryColumns.TABLE_NAME_CREDENTIAL, contentValues, "http_auth_id = ?", new String[]{webDataBaseCredential.getHttpAuthId().toString()});
    }

    public boolean exist() {
        Cursor cursorQuery = this.dataBaseHelper.getReadableDatabase().query(WebDataBaseColumns.EntryColumns.TABLE_NAME_CREDENTIAL, this.columns, null, null, null, null, null);
        int count = cursorQuery.getCount();
        cursorQuery.close();
        return count != 0;
    }
}
