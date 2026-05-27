package com.huawei.health.h5pro.jsbridge.system.network;

/* JADX INFO: loaded from: classes.dex */
public interface SseRequestInterceptor {

    /* JADX INFO: loaded from: classes10.dex */
    public interface SSECallback {
        void complete(String str, int i);

        void fail(String str, int i);

        void success(String str);
    }

    void destroySseRequest(long j, String str);

    void startSseRequest(long j, String str, SSECallback sSECallback);
}
