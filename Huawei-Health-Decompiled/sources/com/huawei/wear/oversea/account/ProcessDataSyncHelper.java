package com.huawei.wear.oversea.account;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import defpackage.vwc;
import defpackage.vyj;

/* JADX INFO: loaded from: classes8.dex */
public class ProcessDataSyncHelper {
    private static final Object d = new Object();
    private static volatile ProcessDataSyncHelper e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11730a = false;
    private Handler b = vyj.d().fwx_();

    public ProcessDataSyncHelper(Context context) {
        vwc.e("ProcessDataSyncHelper", "isSync " + this.f11730a + ",isMainProcess ,isSwipeCardProcess ", false);
    }

    public static ProcessDataSyncHelper b(Context context) {
        if (e == null) {
            synchronized (d) {
                if (e == null) {
                    e = new ProcessDataSyncHelper(context.getApplicationContext());
                }
            }
        }
        return e;
    }

    public void e(Context context, final String str, final String str2, final Object obj) {
        if (!this.f11730a || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        this.b.post(new Runnable() { // from class: com.huawei.wear.oversea.account.ProcessDataSyncHelper.2
            @Override // java.lang.Runnable
            public void run() {
                if (applicationContext == null) {
                    vwc.e("ProcessDataSyncHelper", "drop put operation for context is null", false);
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("sp_sync_operate_type", (Integer) 0);
                    ProcessDataSyncHelper.this.fwt_(applicationContext, contentValues, str);
                    contentValues.put("sp_sync_key", str2);
                    ProcessDataSyncHelper.this.fws_(contentValues, "sp_sync_value", obj);
                } catch (IllegalArgumentException | SecurityException unused) {
                    vwc.e("ProcessDataSyncHelper", "put failed", false);
                }
            }
        });
    }

    public void d(Context context, final String str, final String str2) {
        if (!this.f11730a || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        this.b.post(new Runnable() { // from class: com.huawei.wear.oversea.account.ProcessDataSyncHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (applicationContext == null) {
                    vwc.e("ProcessDataSyncHelper", "drop remove operation for context is null", false);
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("sp_sync_operate_type", (Integer) 1);
                    ProcessDataSyncHelper.this.fwt_(applicationContext, contentValues, str);
                    contentValues.put("sp_sync_key", str2);
                } catch (IllegalArgumentException | SecurityException unused) {
                    vwc.e("ProcessDataSyncHelper", "remove failed", false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fwt_(Context context, ContentValues contentValues, String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 10) {
            return;
        }
        contentValues.put("sp_sync_sp_name", str.substring(10, str.length()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fws_(ContentValues contentValues, String str, Object obj) {
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
            return;
        }
        if (obj instanceof Integer) {
            contentValues.put(str, (Integer) obj);
            return;
        }
        if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
            return;
        }
        if (obj instanceof Boolean) {
            contentValues.put(str, (Boolean) obj);
        } else if (obj instanceof Float) {
            contentValues.put(str, (Float) obj);
        } else {
            vwc.e("ProcessDataSyncHelper", "unsupported type", false);
        }
    }
}
