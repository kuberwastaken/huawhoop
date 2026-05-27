package com.huawei.hihealth.device.open;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public interface MeasureController {
    void cleanup();

    void ending();

    boolean prepare(HealthDevice healthDevice, IHealthDeviceCallback iHealthDeviceCallback, Bundle bundle);

    boolean start();
}
