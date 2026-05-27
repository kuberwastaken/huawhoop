package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class GetSportDataByTimeRsp extends CloudCommonReponse {
    private Map<String, List<SportDetail>> data;
    private List<SportDetail> detailInfos;

    public Map<String, List<SportDetail>> getData() {
        return this.data;
    }

    public void setData(Map<String, List<SportDetail>> map) {
        this.data = map;
    }

    public List<SportDetail> getDetailInfos() {
        return this.detailInfos;
    }

    public void setDetailInfos(List<SportDetail> list) {
        this.detailInfos = list;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        StringBuffer stringBufferAppend = new StringBuffer("GetSportDataByTimeRsp{data=").append(this.data);
        stringBufferAppend.append(", detailInfos=").append(this.detailInfos).append('}');
        return stringBufferAppend.toString();
    }
}
