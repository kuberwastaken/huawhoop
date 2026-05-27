package com.huawei.hms.kit.awareness.capture;

import com.huawei.hms.kit.awareness.b.HHI;
import com.huawei.hms.kit.awareness.status.BeaconStatus;

/* JADX INFO: loaded from: classes10.dex */
public class BeaconStatusResponse extends HHI<BeaconStatus> {
    @Override // com.huawei.hms.kit.awareness.b.HHI
    public String getErrorMsg() {
        return "getBeaconStatus failed: ";
    }

    public BeaconStatus getBeaconStatus() {
        return getStatus();
    }

    public BeaconStatusResponse(BeaconStatus beaconStatus) {
        super(beaconStatus);
    }
}
