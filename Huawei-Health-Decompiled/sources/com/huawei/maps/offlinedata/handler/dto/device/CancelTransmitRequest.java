package com.huawei.maps.offlinedata.handler.dto.device;

/* JADX INFO: loaded from: classes11.dex */
public class CancelTransmitRequest {
    private Boolean isContinueTransmit;
    private Long requestId;

    public Long getRequestId() {
        return this.requestId;
    }

    public void setRequestId(Long l) {
        this.requestId = l;
    }

    public Boolean getContinueTransmit() {
        return this.isContinueTransmit;
    }

    public void setContinueTransmit(Boolean bool) {
        this.isContinueTransmit = bool;
    }
}
