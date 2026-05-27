package defpackage;

import com.huawei.wisesecurity.kfs.ha.message.BaseReportMsgBuilder;
import io.jsonwebtoken.Header;

/* JADX INFO: loaded from: classes8.dex */
public class wzw extends BaseReportMsgBuilder {
    @Override // com.huawei.wisesecurity.kfs.ha.message.ReportMsgBuilder
    public String getEventId() {
        return "credentialFromString";
    }

    public wzw e(String str) {
        this.linkedHashMap.put(Header.CONTENT_TYPE, str);
        return this;
    }

    public wzw d(String str) {
        this.linkedHashMap.put("credentialAppName", str);
        return this;
    }

    public wzw a(int i) {
        this.linkedHashMap.put("akSkVersion", String.valueOf(i));
        return this;
    }

    public wzw b() {
        this.linkedHashMap.put("flavor", "product");
        return this;
    }
}
