package com.huawei.watchface.mvp.model.datatype;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class VipPackageIAP4Resp {
    private List<VipPackageIAP4Bean> productInfoList;

    @SerializedName("resultcode")
    private String resultVipPackageCode;

    @SerializedName("resultinfo")
    private String resultVipPackageInfo;

    public List<VipPackageIAP4Bean> getProductInfoList() {
        return this.productInfoList;
    }

    public String getResultVipPackageInfo() {
        return this.resultVipPackageInfo;
    }

    public void setResultVipPackageInfo(String str) {
        this.resultVipPackageInfo = str;
    }

    public void setProductInfoList(List<VipPackageIAP4Bean> list) {
        this.productInfoList = list;
    }

    public String getResultVipPackageCode() {
        return this.resultVipPackageCode;
    }

    public void setResultVipPackageCode(String str) {
        this.resultVipPackageCode = str;
    }
}
