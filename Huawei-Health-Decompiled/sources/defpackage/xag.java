package defpackage;

import com.huawei.wisesecurity.kfs.ha.message.BaseReportMsgBuilder;

/* JADX INFO: loaded from: classes8.dex */
public class xag extends BaseReportMsgBuilder {
    @Override // com.huawei.wisesecurity.kfs.ha.message.ReportMsgBuilder
    public String getEventId() {
        return "crypto";
    }

    public xag a() {
        this.linkedHashMap.put("flavor", "product");
        return this;
    }
}
