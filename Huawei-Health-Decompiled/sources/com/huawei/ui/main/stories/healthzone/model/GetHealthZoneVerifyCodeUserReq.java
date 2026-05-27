package com.huawei.ui.main.stories.healthzone.model;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonRequest;

/* JADX INFO: loaded from: classes8.dex */
public class GetHealthZoneVerifyCodeUserReq extends CloudCommonRequest {

    @SerializedName("verifyCode")
    private String verifyCode;

    public void setVerifyCode(String str) {
        this.verifyCode = str;
    }
}
