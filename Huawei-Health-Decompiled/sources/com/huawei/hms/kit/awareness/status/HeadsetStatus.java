package com.huawei.hms.kit.awareness.status;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes10.dex */
public interface HeadsetStatus {
    public static final int CONNECTED = 1;
    public static final int DISCONNECTED = 0;
    public static final int UNKNOWN = -1;

    /* JADX INFO: loaded from: classes2.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface HeadsetStatusDef {
    }

    int getStatus();
}
