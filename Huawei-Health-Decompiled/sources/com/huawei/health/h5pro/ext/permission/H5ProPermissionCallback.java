package com.huawei.health.h5pro.ext.permission;

/* JADX INFO: loaded from: classes4.dex */
public interface H5ProPermissionCallback {
    void onDenied(String str);

    void onForeverDenied(String[] strArr);

    void onGranted();
}
