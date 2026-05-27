package com.huawei.thirdpartservice.runtasticapi;

import com.huawei.thirdpartservice.OauthStatusCallback;

/* JADX INFO: loaded from: classes7.dex */
public interface RuntasticProviderApi {
    public static final String ACTION_RUNTASTIC_SYNC_DATA = "com.huawei.feature.dataopen.runtastic.sync";

    void isOauth(OauthStatusCallback oauthStatusCallback);

    boolean isSupportType(int i);
}
