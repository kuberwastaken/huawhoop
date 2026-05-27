package com.huawei.health.device.api;

import android.content.ContentValues;

/* JADX INFO: loaded from: classes4.dex */
public interface DeviceDataBaseHelperApi {
    long insert(ContentValues contentValues);

    long update(ContentValues contentValues, String str, String[] strArr);
}
