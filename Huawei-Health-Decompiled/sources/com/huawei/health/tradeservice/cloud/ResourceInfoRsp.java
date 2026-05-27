package com.huawei.health.tradeservice.cloud;

import com.huawei.trade.datatype.ResourceSummary;

/* JADX INFO: loaded from: classes10.dex */
public class ResourceInfoRsp extends BaseRsp {
    private ResourceSummary resourceSummary;

    public ResourceSummary getResourceSummary() {
        return this.resourceSummary;
    }

    public void setResourceSummary(ResourceSummary resourceSummary) {
        this.resourceSummary = resourceSummary;
    }
}
