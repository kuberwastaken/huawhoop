package com.huawei.appgallery.marketinstallerservice.api;

/* JADX INFO: loaded from: classes3.dex */
public class FailResultParam extends BaseResultParam {
    private MarketInfo d = null;

    public void setMarketInfo(MarketInfo marketInfo) {
        this.d = marketInfo;
    }

    public MarketInfo getMarketInfo() {
        return this.d;
    }
}
