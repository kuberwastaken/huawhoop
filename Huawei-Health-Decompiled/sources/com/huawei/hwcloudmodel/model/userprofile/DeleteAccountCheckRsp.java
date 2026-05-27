package com.huawei.hwcloudmodel.model.userprofile;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class DeleteAccountCheckRsp extends CloudCommonReponse {

    @SerializedName("businessName")
    private String businessName;

    @SerializedName("currentBenefits")
    private List<String> currentBenefits;

    @SerializedName("ifAllow")
    private Integer ifAllow;

    @SerializedName("refusalCause")
    private String refusalCause;

    @SerializedName("refusalDetails")
    private List<RefusalText> refusalDetails;

    public Integer getIfAllow() {
        return this.ifAllow;
    }

    public void setIfAllow(Integer num) {
        this.ifAllow = num;
    }

    public String getBusinessName() {
        return this.businessName;
    }

    public void setBusinessName(String str) {
        this.businessName = str;
    }

    public String getRefusalCause() {
        return this.refusalCause;
    }

    public void setRefusalCause(String str) {
        this.refusalCause = str;
    }

    public List<RefusalText> getRefusalDetails() {
        return this.refusalDetails;
    }

    public void setRefusalDetails(List<RefusalText> list) {
        this.refusalDetails = list;
    }

    public List<String> getCurrentBenefits() {
        return this.currentBenefits;
    }

    public void setCurrentBenefits(List<String> list) {
        this.currentBenefits = list;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "DeleteAccountCheckRsp{ifAllow=" + this.ifAllow + ", businessName=" + this.businessName + ", refusalCause=" + this.refusalCause + ", refusalDetails=" + this.refusalDetails + ", currentBenefits=" + this.currentBenefits + '}';
    }
}
