package com.huawei.hwcloudmodel.agreement;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SignAgreementRequestBean {

    @SerializedName("clientVersion")
    private String mClientVersion = AgrConstant.getClientVersionByHuaweiHealth();

    @SerializedName("usbm")
    private int mUsbm;
    private List<SignAgreementRequestInfo> signInfo;

    public SignAgreementRequestBean(List<SignAgreementRequestInfo> list) {
        this.signInfo = list;
    }

    public void setUsbm(int i) {
        this.mUsbm = i;
    }

    public List<SignAgreementRequestInfo> getSignInfo() {
        return this.signInfo;
    }

    public void setSignInfo(List<SignAgreementRequestInfo> list) {
        this.signInfo = list;
    }
}
