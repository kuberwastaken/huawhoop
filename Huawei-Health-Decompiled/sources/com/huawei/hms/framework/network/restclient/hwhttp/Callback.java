package com.huawei.hms.framework.network.restclient.hwhttp;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface Callback {
    void onFailure(Submit submit, Throwable th);

    void onResponse(Submit submit, Response response) throws IOException;
}
