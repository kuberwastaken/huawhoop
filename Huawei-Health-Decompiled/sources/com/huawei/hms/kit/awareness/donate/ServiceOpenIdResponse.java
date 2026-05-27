package com.huawei.hms.kit.awareness.donate;

import com.huawei.hms.kit.awareness.b.HHI;
import com.huawei.hms.kit.awareness.status.ServiceOpenIdStatus;

/* JADX INFO: loaded from: classes10.dex */
public class ServiceOpenIdResponse extends HHI<ServiceOpenIdStatus> {
    @Override // com.huawei.hms.kit.awareness.b.HHI
    public String getErrorMsg() {
        return null;
    }

    public ServiceOpenIdStatus getSidStatus() {
        return getStatus();
    }

    public ServiceOpenIdResponse(ServiceOpenIdStatus serviceOpenIdStatus) {
        super(serviceOpenIdStatus);
    }
}
