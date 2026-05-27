package com.huawei.ui.thirdpartservice.interactors.callback;

import defpackage.vmb;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface SupportDeviceResultCallback {
    void obtainBindDeviceList(List<vmb> list);

    default void obtainSupportDeviceList(List<vmb> list) {
    }

    void onError(int i, String str);
}
