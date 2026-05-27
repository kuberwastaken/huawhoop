package com.huawei.hwbtsdk.btdatatype.callback;

import com.huawei.hwbtsdk.btdatatype.datatype.BluetoothDeviceNode;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface BluetoothDialogCallback {
    void onScanFinished();

    void onSetList(List<BluetoothDeviceNode> list, boolean z, int i);

    void onSetNameFilter(List<String> list);
}
