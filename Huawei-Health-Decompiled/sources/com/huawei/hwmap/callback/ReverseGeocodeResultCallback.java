package com.huawei.hwmap.callback;

import com.huawei.hwmap.model.ReverseGeocodeResponse;

/* JADX INFO: loaded from: classes6.dex */
public interface ReverseGeocodeResultCallback {
    void onFailure(Throwable th);

    void onSuccess(ReverseGeocodeResponse reverseGeocodeResponse);
}
