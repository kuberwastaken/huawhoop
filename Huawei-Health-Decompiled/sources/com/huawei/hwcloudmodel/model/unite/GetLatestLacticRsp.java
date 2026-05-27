package com.huawei.hwcloudmodel.model.unite;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class GetLatestLacticRsp extends CloudCommonReponse {

    @SerializedName("detailInfos")
    private List<LacticData> detailInfos;

    public List<LacticData> getDetailInfos() {
        return this.detailInfos;
    }

    public void setDetailInfos(List<LacticData> list) {
        this.detailInfos = list;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "GetLatestLacticRsp{detailInfos=" + this.detailInfos + '}';
    }
}
