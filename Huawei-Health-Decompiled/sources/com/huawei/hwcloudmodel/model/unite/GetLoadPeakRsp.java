package com.huawei.hwcloudmodel.model.unite;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class GetLoadPeakRsp extends CloudCommonReponse {

    @SerializedName("data")
    private Map<String, List<LoadPeakDataContainer>> data;

    public Map<String, List<LoadPeakDataContainer>> getData() {
        return this.data;
    }

    public void setData(Map<String, List<LoadPeakDataContainer>> map) {
        this.data = map;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "GetLoadPeakRsp{data=" + this.data + '}';
    }
}
