package com.huawei.hwcloudmodel.model.unite;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class GetLacticStatisticsRsp extends CloudCommonReponse {

    @SerializedName("statisticTotal")
    private Map<Integer, List<LacticStatistics>> statisticTotal;

    public Map<Integer, List<LacticStatistics>> getStatisticTotal() {
        return this.statisticTotal;
    }

    public void setStatisticTotal(Map<Integer, List<LacticStatistics>> map) {
        this.statisticTotal = map;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "GetLacticStatisticsRsp{statisticTotal=" + this.statisticTotal.toString() + '}';
    }
}
