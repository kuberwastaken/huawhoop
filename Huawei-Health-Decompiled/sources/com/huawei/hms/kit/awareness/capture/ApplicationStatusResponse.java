package com.huawei.hms.kit.awareness.capture;

import com.huawei.hms.kit.awareness.b.HHI;
import com.huawei.hms.kit.awareness.status.ApplicationStatus;

/* JADX INFO: loaded from: classes10.dex */
public class ApplicationStatusResponse extends HHI<ApplicationStatus> {
    @Override // com.huawei.hms.kit.awareness.b.HHI
    public String getErrorMsg() {
        return "getApplicationStatus failed";
    }

    public ApplicationStatus getApplicationStatus() {
        return getStatus();
    }

    public ApplicationStatusResponse(ApplicationStatus applicationStatus) {
        super(applicationStatus);
    }
}
