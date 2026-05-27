package com.huawei.hms.kit.awareness.status;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes10.dex */
public interface BluetoothStatus {
    public static final int CONNECTED = 1;
    public static final int DEVICE_CAR = 0;
    public static final int DISCONNECTED = 0;
    public static final int UNKNOWN = -1;

    /* JADX INFO: loaded from: classes2.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BluetoothStatusDef {
    }

    /* JADX INFO: loaded from: classes2.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BluetoothTypesDef {
    }

    int getStatus();
}
