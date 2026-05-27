package com.braintreepayments.api;

import com.huawei.openalliance.ad.constant.VastAttribute;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/braintreepayments/api/ClientTokenCallback;", "", "onFailure", "", VastAttribute.ERROR, "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "clientToken", "", "BraintreeCore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ClientTokenCallback {
    void onFailure(Exception error);

    void onSuccess(String clientToken);
}
