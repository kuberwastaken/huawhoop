package com.huawei.hms.kit.awareness.capture;

import com.huawei.hms.kit.awareness.b.HHI;
import com.huawei.hms.kit.awareness.status.HeadsetStatus;

/* JADX INFO: loaded from: classes10.dex */
public class HeadsetStatusResponse extends HHI<HeadsetStatus> {
    public HeadsetStatus getHeadsetStatus() {
        return getStatus();
    }

    @Override // com.huawei.hms.kit.awareness.b.HHI
    public String getErrorMsg() {
        return "getHeadsetStatus failed: ";
    }

    public HeadsetStatusResponse(HeadsetStatus headsetStatus) {
        super(headsetStatus);
    }
}
