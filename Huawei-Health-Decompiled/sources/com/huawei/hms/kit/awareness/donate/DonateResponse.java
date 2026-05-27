package com.huawei.hms.kit.awareness.donate;

import com.huawei.hms.kit.awareness.b.HHI;
import com.huawei.hms.kit.awareness.status.DonateStatus;

/* JADX INFO: loaded from: classes5.dex */
public class DonateResponse extends HHI<DonateStatus> {
    @Override // com.huawei.hms.kit.awareness.b.HHI
    public String getErrorMsg() {
        return "data donate failed!";
    }

    public DonateStatus getDonateStatus() {
        return getStatus();
    }

    public DonateResponse(DonateStatus donateStatus) {
        super(donateStatus);
    }
}
