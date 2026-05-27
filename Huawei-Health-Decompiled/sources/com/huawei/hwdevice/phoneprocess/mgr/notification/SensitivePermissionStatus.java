package com.huawei.hwdevice.phoneprocess.mgr.notification;

import com.huawei.openalliance.ad.constant.VastAttribute;

/* JADX INFO: loaded from: classes6.dex */
public enum SensitivePermissionStatus {
    RESTART("restart"),
    COMPLETE("complete"),
    ERROR(VastAttribute.ERROR);

    private final String value;

    SensitivePermissionStatus(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
