package ohos.ace.adapter.capability.storage;

import android.content.Context;
import android.content.SharedPreferences;
import ohos.ace.adapter.ALog;

/* JADX INFO: loaded from: classes11.dex */
public class PersistentStorageAosp extends PersistentStorageBase {
    private static final String LOG_TAG = "PersistentStorageAosp";
    private static final String SHARE_PREFERENCE_NAME = "storage_data";
    private Context context;
    private String databasePath;
    SharedPreferences mSharePreferences;

    @Override // ohos.ace.adapter.capability.storage.PersistentStorageBase
    public void initializeStorage(String str) {
    }

    public PersistentStorageAosp(Context context) {
        this.context = context;
        if (context == null) {
            ALog.w(LOG_TAG, "PersistentStorageAosp context null");
        }
        this.mSharePreferences = context.getSharedPreferences(SHARE_PREFERENCE_NAME, 0);
        ALog.i(LOG_TAG, "PersistentStorageAosp constructor");
        nativeInit();
    }

    @Override // ohos.ace.adapter.capability.storage.PersistentStorageBase
    public void set(String str, String str2) {
        SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences == null) {
            ALog.w(LOG_TAG, "set method sharePreference instantiate is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            ALog.w(LOG_TAG, "editor null");
            return;
        }
        editorEdit.putString(str, str2);
        if (editorEdit.commit()) {
            return;
        }
        ALog.i(LOG_TAG, "fail to commit persistent data after set");
    }

    @Override // ohos.ace.adapter.capability.storage.PersistentStorageBase
    public String get(String str) {
        ALog.i(LOG_TAG, "PersistentStorageAosp get");
        SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences == null) {
            ALog.w(LOG_TAG, "sharePreference null");
            return "";
        }
        return sharedPreferences.getString(str, "");
    }

    @Override // ohos.ace.adapter.capability.storage.PersistentStorageBase
    public void clear() {
        SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences == null) {
            ALog.w(LOG_TAG, "clear method sharePreference instantiate is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            ALog.w(LOG_TAG, "editor null");
            return;
        }
        editorEdit.clear();
        if (editorEdit.commit()) {
            return;
        }
        ALog.i(LOG_TAG, "fail to commit persistent data after clear");
    }

    @Override // ohos.ace.adapter.capability.storage.PersistentStorageBase
    public void delete(String str) {
        SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences == null) {
            ALog.w(LOG_TAG, "delete method sharePreference instantiate is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (editorEdit == null) {
            ALog.w(LOG_TAG, "editor null");
            return;
        }
        editorEdit.remove(str);
        if (editorEdit.commit()) {
            return;
        }
        ALog.i(LOG_TAG, "fail to commit persistent data after remove key");
    }
}
