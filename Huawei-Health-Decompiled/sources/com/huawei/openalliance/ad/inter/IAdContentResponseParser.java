package com.huawei.openalliance.ad.inter;

/* JADX INFO: loaded from: classes6.dex */
public interface IAdContentResponseParser {
    void processAdResponse(String str);

    void processAdResponse(String str, AdParseConfig adParseConfig);

    void processAdResponse(String str, boolean z);

    void startCache(int i);

    void stopCache();
}
