package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;

/* JADX INFO: loaded from: classes9.dex */
public class AddSportDataRsp extends CloudCommonReponse {
    private ParamValidDetail paramValidDetail;
    private Long timestamp;

    public ParamValidDetail getParamValidDetail() {
        return this.paramValidDetail;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AddSportDataRsp{timestamp=");
        stringBuffer.append(this.timestamp);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
