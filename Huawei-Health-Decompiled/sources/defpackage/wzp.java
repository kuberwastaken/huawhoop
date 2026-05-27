package defpackage;

import com.huawei.wisesecurity.kfs.ha.message.BaseReportMsgBuilder;
import io.jsonwebtoken.Header;

/* JADX INFO: loaded from: classes8.dex */
public class wzp extends BaseReportMsgBuilder {
    @Override // com.huawei.wisesecurity.kfs.ha.message.ReportMsgBuilder
    public String getEventId() {
        return "applyCredential";
    }

    public wzp e(String str) {
        this.linkedHashMap.put(Header.CONTENT_TYPE, str);
        return this;
    }

    public wzp d(String str) {
        this.linkedHashMap.put("credentialPackageName", str);
        return this;
    }

    public wzp b() {
        this.linkedHashMap.put("flavor", "product");
        return this;
    }
}
