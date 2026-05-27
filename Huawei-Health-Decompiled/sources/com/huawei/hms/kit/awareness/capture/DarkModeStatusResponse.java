package com.huawei.hms.kit.awareness.capture;

import com.huawei.hms.kit.awareness.b.HHI;
import com.huawei.hms.kit.awareness.status.DarkModeStatus;

/* JADX INFO: loaded from: classes10.dex */
public class DarkModeStatusResponse extends HHI<DarkModeStatus> {
    @Override // com.huawei.hms.kit.awareness.b.HHI
    public String getErrorMsg() {
        return "getWifiStatus failed: ";
    }

    public DarkModeStatus getDarkModeStatus() {
        return getStatus();
    }

    public DarkModeStatusResponse(DarkModeStatus darkModeStatus) {
        super(darkModeStatus);
    }
}
