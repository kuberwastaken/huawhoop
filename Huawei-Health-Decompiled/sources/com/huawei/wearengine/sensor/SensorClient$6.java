package com.huawei.wearengine.sensor;

import com.huawei.wearengine.sensor.AsyncStopCallback;
import defpackage.wto;

/* JADX INFO: loaded from: classes11.dex */
public class SensorClient$6 extends AsyncStopCallback.Stub {
    final /* synthetic */ wto this$0;
    final /* synthetic */ SensorStopCallback val$sensorStopCallback;

    SensorClient$6(wto wtoVar, SensorStopCallback sensorStopCallback) {
        this.this$0 = wtoVar;
        this.val$sensorStopCallback = sensorStopCallback;
    }

    @Override // com.huawei.wearengine.sensor.AsyncStopCallback
    public void onStopResult(int i) {
        SensorStopCallback sensorStopCallback = this.val$sensorStopCallback;
        if (sensorStopCallback != null) {
            sensorStopCallback.onStopResult(i);
        }
    }
}
