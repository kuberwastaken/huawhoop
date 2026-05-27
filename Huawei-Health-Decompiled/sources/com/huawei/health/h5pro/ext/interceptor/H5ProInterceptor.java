package com.huawei.health.h5pro.ext.interceptor;

/* JADX INFO: loaded from: classes.dex */
public interface H5ProInterceptor<P, R> {

    /* JADX INFO: loaded from: classes4.dex */
    public interface InterceptCallback<R> {
        void onIntercepted(R r);

        void onNotIntercepted();
    }

    void intercept(P p, InterceptCallback<R> interceptCallback);
}
