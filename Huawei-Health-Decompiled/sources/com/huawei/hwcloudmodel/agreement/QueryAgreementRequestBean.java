package com.huawei.hwcloudmodel.agreement;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class QueryAgreementRequestBean {

    @SerializedName("agrInfo")
    private List<QueryAgreementRequestInfo> agreementInfo;

    @SerializedName("clientVersion")
    private String mClientVersion = AgrConstant.getClientVersionByHuaweiHealth();

    @SerializedName("usbm")
    private int mUsbm;

    public QueryAgreementRequestBean(List<QueryAgreementRequestInfo> list) {
        this.agreementInfo = list;
    }

    public void setUsbm(int i) {
        this.mUsbm = i;
    }

    public List<QueryAgreementRequestInfo> getAgreementInfo() {
        return this.agreementInfo;
    }

    public void setAgreementInfo(List<QueryAgreementRequestInfo> list) {
        this.agreementInfo = list;
    }
}
