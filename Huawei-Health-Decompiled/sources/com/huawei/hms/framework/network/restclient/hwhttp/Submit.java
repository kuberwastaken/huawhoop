package com.huawei.hms.framework.network.restclient.hwhttp;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface Submit extends Cloneable {

    /* JADX INFO: loaded from: classes.dex */
    @Deprecated
    public interface Factory {
        Submit newSubmit(Request request);
    }

    void cancel();

    Submit clone();

    void enqueue(Callback callback);

    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request() throws IOException;
}
