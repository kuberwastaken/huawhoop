package com.huawei.hms.network.inner.api;

import com.huawei.hms.network.httpclient.Interceptor;

/* JADX INFO: loaded from: classes10.dex */
public abstract class InterceptorNetworkService extends NetworkService {
    public abstract Interceptor getInterceptor();

    public abstract boolean isNetworkInterceptor();
}
