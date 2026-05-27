package com.huawei.health.hwhealthlinkage.linkageinterface;

import android.os.Bundle;

/* JADX INFO: loaded from: classes4.dex */
public interface SportPostureLifecycle {
    void closeReport(int i, int i2);

    void openReport(int i, int i2);

    void sendDataToDevice(Bundle bundle);
}
