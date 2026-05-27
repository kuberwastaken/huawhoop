package com.huawei.health.basesport.wearengine;

import defpackage.cxe;

/* JADX INFO: loaded from: classes3.dex */
public interface DataReceiver {
    default boolean isMatch(int i) {
        return true;
    }

    void onDataReceived(cxe cxeVar, int i, byte[] bArr);
}
