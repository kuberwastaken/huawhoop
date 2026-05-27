package ohos.ace.adapter.capability.web;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import ohos.ace.adapter.capability.web.WebDataBaseColumns;

/* JADX INFO: loaded from: classes8.dex */
public class WebDataBaseGeolocationPermissionsDao {
    private static final String LOG_TAG = "WebDataBaseGeolocationPermissionsDao";
    String[] columns = {"_id", "origin", "result"};
    private WebDataBaseHelper dataBaseHelper;

    public WebDataBaseGeolocationPermissionsDao(WebDataBaseHelper webDataBaseHelper) {
        this.dataBaseHelper = webDataBaseHelper;
    }

    public long insertPermissionByOrigin(WebDataBaseGeolocationPermissions webDataBaseGeolocationPermissions) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("origin", webDataBaseGeolocationPermissions.getOrigin());
        contentValues.put("result", webDataBaseGeolocationPermissions.getResult());
        WebDataBaseHelper webDataBaseHelper = this.dataBaseHelper;
        webDataBaseHelper.isTableExists(webDataBaseHelper.getReadableDatabase(), WebDataBaseColumns.EntryColumns.TABLE_NAME_GEOLOCATION);
        return this.dataBaseHelper.getWritableDatabase().insert(WebDataBaseColumns.EntryColumns.TABLE_NAME_GEOLOCATION, null, contentValues);
    }

    public int clearPermissionByOrigin(String str) {
        WebDataBaseHelper webDataBaseHelper = this.dataBaseHelper;
        webDataBaseHelper.isTableExists(webDataBaseHelper.getReadableDatabase(), WebDataBaseColumns.EntryColumns.TABLE_NAME_GEOLOCATION);
        return this.dataBaseHelper.getWritableDatabase().delete(WebDataBaseColumns.EntryColumns.TABLE_NAME_GEOLOCATION, "origin = ?", new String[]{str});
    }

    public int clearAllPermission() {
        WebDataBaseHelper webDataBaseHelper = this.dataBaseHelper;
        webDataBaseHelper.isTableExists(webDataBaseHelper.getReadableDatabase(), WebDataBaseColumns.EntryColumns.TABLE_NAME_GEOLOCATION);
        return this.dataBaseHelper.getWritableDatabase().delete(WebDataBaseColumns.EntryColumns.TABLE_NAME_GEOLOCATION, null, null);
    }

    public WebDataBaseGeolocationPermissions getPermissionResultByOrigin(String str) {
        String[] strArr = {str};
        WebDataBaseHelper webDataBaseHelper = this.dataBaseHelper;
        webDataBaseHelper.isTableExists(webDataBaseHelper.getReadableDatabase(), WebDataBaseColumns.EntryColumns.TABLE_NAME_GEOLOCATION);
        Cursor cursorQuery = this.dataBaseHelper.getReadableDatabase().query(WebDataBaseColumns.EntryColumns.TABLE_NAME_GEOLOCATION, this.columns, "origin = ?", strArr, null, null, null);
        try {
            if (cursorQuery.moveToFirst()) {
                long j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
                return new WebDataBaseGeolocationPermissions(Long.valueOf(j), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("origin")), Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("result"))));
            }
            cursorQuery.close();
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    public List<WebDataBaseGeolocationPermissions> getOriginsByPermission() {
        WebDataBaseHelper webDataBaseHelper = this.dataBaseHelper;
        webDataBaseHelper.isTableExists(webDataBaseHelper.getReadableDatabase(), WebDataBaseColumns.EntryColumns.TABLE_NAME_GEOLOCATION);
        Cursor cursorQuery = this.dataBaseHelper.getReadableDatabase().query(WebDataBaseColumns.EntryColumns.TABLE_NAME_GEOLOCATION, this.columns, null, null, null, null, null);
        try {
            if (!cursorQuery.moveToFirst()) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            do {
                long j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
                arrayList.add(new WebDataBaseGeolocationPermissions(Long.valueOf(j), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("origin")), Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("result")))));
            } while (cursorQuery.moveToNext());
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }
}
