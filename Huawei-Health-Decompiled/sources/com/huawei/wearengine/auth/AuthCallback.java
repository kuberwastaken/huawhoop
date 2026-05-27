package com.huawei.wearengine.auth;

/* JADX INFO: loaded from: classes11.dex */
public interface AuthCallback {
    void onCancel();

    void onOk(Permission[] permissionArr);
}
