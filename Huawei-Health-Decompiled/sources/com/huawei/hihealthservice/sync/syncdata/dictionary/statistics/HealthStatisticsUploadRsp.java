package com.huawei.hihealthservice.sync.syncdata.dictionary.statistics;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;

/* JADX INFO: loaded from: classes9.dex */
public class HealthStatisticsUploadRsp extends CloudCommonReponse {

    @SerializedName("version")
    private long version;

    public long getVersion() {
        return this.version;
    }
}
