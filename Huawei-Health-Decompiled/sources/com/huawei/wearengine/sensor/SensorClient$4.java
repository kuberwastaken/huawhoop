package com.huawei.wearengine.sensor;

import com.huawei.wearengine.sensor.AsyncReadCallback;
import defpackage.wto;

/* JADX INFO: loaded from: classes11.dex */
public class SensorClient$4 extends AsyncReadCallback.Stub {
    final /* synthetic */ wto this$0;
    final /* synthetic */ SensorReadCallback val$sensorReadCallback;

    SensorClient$4(wto wtoVar, SensorReadCallback sensorReadCallback) {
        this.this$0 = wtoVar;
        this.val$sensorReadCallback = sensorReadCallback;
    }

    @Override // com.huawei.wearengine.sensor.AsyncReadCallback
    public void onReadResult(int i, DataResult dataResult) {
        SensorReadCallback sensorReadCallback = this.val$sensorReadCallback;
        if (sensorReadCallback != null) {
            sensorReadCallback.onReadResult(i, dataResult);
        }
    }
}
