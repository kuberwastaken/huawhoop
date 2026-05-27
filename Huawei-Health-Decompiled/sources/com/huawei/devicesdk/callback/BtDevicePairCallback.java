package com.huawei.devicesdk.callback;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes3.dex */
public interface BtDevicePairCallback {
    void onDevicePairNone(BluetoothDevice bluetoothDevice);

    void onDevicePaired(BluetoothDevice bluetoothDevice);

    void onDevicePairing(BluetoothDevice bluetoothDevice);
}
