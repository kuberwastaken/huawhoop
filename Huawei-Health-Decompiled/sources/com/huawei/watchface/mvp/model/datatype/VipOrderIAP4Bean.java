package com.huawei.watchface.mvp.model.datatype;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class VipOrderIAP4Bean {
    private PayIap4Info payInfo;

    @SerializedName("resultcode")
    private String resultCode;

    @SerializedName("resultinfo")
    private String resultInfo;

    public String getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(String str) {
        this.resultInfo = str;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String str) {
        this.resultCode = str;
    }

    public PayIap4Info getPayInfo() {
        return this.payInfo;
    }

    public void setPayInfo(PayIap4Info payIap4Info) {
        this.payInfo = payIap4Info;
    }
}
