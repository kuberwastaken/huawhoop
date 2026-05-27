package com.huawei.agconnect.credential.internal;

import com.huawei.agconnect.https.annotation.Result;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
public class ClientAuthResponse {

    @Result(Constants.PARAM_ACCESS_TOKEN)
    private String accessToken;

    @Result(Constants.PARAM_EXPIRES_IN)
    private long expiresIn;

    @Result("ret")
    private ConnectRet ret;

    public ConnectRet getRet() {
        return this.ret;
    }

    public long getExpiresIn() {
        return this.expiresIn;
    }

    public String getAccessToken() {
        return this.accessToken;
    }
}
