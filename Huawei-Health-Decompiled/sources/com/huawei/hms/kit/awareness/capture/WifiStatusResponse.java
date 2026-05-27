package com.huawei.hms.kit.awareness.capture;

import com.huawei.hms.kit.awareness.b.HHI;
import com.huawei.hms.kit.awareness.status.WifiStatus;

/* JADX INFO: loaded from: classes10.dex */
public class WifiStatusResponse extends HHI<WifiStatus> {
    public WifiStatus getWifiStatus() {
        return getStatus();
    }

    @Override // com.huawei.hms.kit.awareness.b.HHI
    public String getErrorMsg() {
        return "getWifiStatus failed: ";
    }

    public WifiStatusResponse(WifiStatus wifiStatus) {
        super(wifiStatus);
    }
}
