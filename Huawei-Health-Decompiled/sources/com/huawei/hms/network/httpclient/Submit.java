package com.huawei.hms.network.httpclient;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Submit<T> implements Cloneable {

    public static abstract class Factory {
        public abstract Submit<ResponseBody> newSubmit(Request request);
    }

    public abstract void cancel();

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract Submit<T> mo905clone();

    public abstract void enqueue(Callback<T> callback);

    public abstract Response<T> execute() throws IOException;

    public abstract RequestFinishedInfo getRequestFinishedInfo();

    public abstract boolean isCanceled();

    public abstract boolean isExecuted();

    public abstract Request request() throws IOException;
}
