package com.huawei.appgallery.marketinstallerservice.api;

/* JADX INFO: loaded from: classes3.dex */
public interface InstallCallback {
    void onFailed(FailResultParam failResultParam);

    void onSuccess(MarketInfo marketInfo);
}
