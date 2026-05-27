package com.huawei.hms.iapfull.network;

import com.huawei.hms.framework.network.restclient.Headers;
import com.huawei.hms.iapfull.network.model.BaseResponse;

/* JADX INFO: loaded from: classes5.dex */
public interface e<T extends BaseResponse> {
    void a(T t, Headers headers);

    void onFailure(Throwable th);
}
