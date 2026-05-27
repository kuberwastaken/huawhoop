package com.huawei.hihealthservice.sync.syncdata.dictionary.statistics;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class HealthStatisticsDownloadByVersionRsp extends CloudCommonReponse {

    @SerializedName("currentVersion")
    private long currentVersion;

    @SerializedName("statisticTotal")
    private Map<String, List<HealthStatistics>> data = new HashMap();

    public Map<String, List<HealthStatistics>> getData() {
        return this.data;
    }

    public long getCurrentVersion() {
        return this.currentVersion;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "HealthStatisticsDownloadByVersionRsp{mAllData=" + getData() + ", ver=" + this.currentVersion + '}';
    }
}
