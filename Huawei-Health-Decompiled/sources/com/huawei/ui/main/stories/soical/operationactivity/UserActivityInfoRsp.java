package com.huawei.ui.main.stories.soical.operationactivity;

import com.google.gson.annotations.SerializedName;
import defpackage.uxl;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class UserActivityInfoRsp {

    @SerializedName("resultCode")
    private String resultCode;

    @SerializedName("resultDesc")
    private String resultDesc;

    @SerializedName("userActivityInfo")
    private uxl userActivityInfo;

    @SerializedName("userActivityInfoList")
    private List<uxl> userActivityInfoList;

    public String getResultCode() {
        return this.resultCode;
    }

    public List<uxl> getUserActivityInfoList() {
        return this.userActivityInfoList;
    }

    public String toString() {
        return "UserActivityInfoRsp{resultCode='" + this.resultCode + "', resultDesc='" + this.resultDesc + "', userActivityInfo=" + this.userActivityInfo + ", userActivityInfoList=" + this.userActivityInfoList + '}';
    }
}
