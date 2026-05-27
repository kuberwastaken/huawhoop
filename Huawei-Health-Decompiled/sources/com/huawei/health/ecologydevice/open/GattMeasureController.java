package com.huawei.health.ecologydevice.open;

import android.bluetooth.BluetoothGattCallback;
import android.os.Bundle;
import com.huawei.health.device.callback.IHealthDeviceCallback;
import com.huawei.health.device.model.HealthDevice;
import com.huawei.health.device.open.BleMeasureController;
import defpackage.dun;
import defpackage.duq;

/* JADX INFO: loaded from: classes4.dex */
public abstract class GattMeasureController extends BleMeasureController {
    public dun mDevice;

    protected abstract BluetoothGattCallback getGattCallbackImpl();

    @Override // com.huawei.health.device.open.MeasureController
    public boolean prepare(HealthDevice healthDevice, IHealthDeviceCallback iHealthDeviceCallback, Bundle bundle) {
        if (!(healthDevice instanceof dun) || iHealthDeviceCallback == null) {
            return false;
        }
        dun dunVar = (dun) healthDevice;
        this.mDevice = dunVar;
        dunVar.Td_(getGattCallbackImpl());
        return true;
    }

    @Override // com.huawei.health.device.open.MeasureController
    public void ending() throws InterruptedException {
        dun dunVar = this.mDevice;
        if (dunVar != null) {
            dunVar.disconnect();
            this.mDevice.Td_(null);
            duq.c().e(this.mDevice.getAddress());
        }
    }
}
