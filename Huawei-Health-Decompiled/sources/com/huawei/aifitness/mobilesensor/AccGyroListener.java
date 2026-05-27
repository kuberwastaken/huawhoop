package com.huawei.aifitness.mobilesensor;

import android.hardware.SensorEvent;

/* JADX INFO: loaded from: classes3.dex */
public interface AccGyroListener {
    void getAcc(SensorEvent sensorEvent, int i);

    void getGyro(SensorEvent sensorEvent);
}
