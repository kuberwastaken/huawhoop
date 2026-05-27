package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;

/* JADX INFO: loaded from: classes9.dex */
public class AddHealthDataRsp extends CloudCommonReponse {
    private boolean hasMore;
    private ParamValidDetail paramValidDetail;
    private Long timestamp;

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long l) {
        this.timestamp = l;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public ParamValidDetail getParamValidDetail() {
        return this.paramValidDetail;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "AddHealthDataRsp{timestamp=" + this.timestamp + ", hasMore=" + this.hasMore + '}';
    }
}
