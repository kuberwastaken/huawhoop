package com.huawei.hwcommonmodel.utils;

/* JADX INFO: loaded from: classes.dex */
public enum CommonUtil$SnStatus {
    DEFAULT(-1),
    SUCCESS(0),
    FAIL_PERMISSION_DENIED(1),
    FAIL_SDK_VERSION_GREATER_THAN_28(2);

    int value;

    CommonUtil$SnStatus(int i) {
        this.value = i;
    }
}
