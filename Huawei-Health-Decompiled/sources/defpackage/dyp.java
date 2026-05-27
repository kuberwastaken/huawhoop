package defpackage;

import android.bluetooth.BluetoothGattCallback;
import com.huawei.health.ecologydevice.open.GattMeasureController;

/* JADX INFO: loaded from: classes4.dex */
public class dyp extends GattMeasureController {
    @Override // com.huawei.health.device.open.MeasureController
    public void cleanup() {
    }

    @Override // com.huawei.health.ecologydevice.open.GattMeasureController
    public BluetoothGattCallback getGattCallbackImpl() {
        return null;
    }

    @Override // com.huawei.health.device.open.MeasureController
    public boolean start() {
        return false;
    }
}
