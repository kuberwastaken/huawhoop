package defpackage;

import com.huawei.wisesecurity.ucs.credential.outer.GrsCapability;
import com.huawei.wisesecurity.ucs_credential.o;

/* JADX INFO: loaded from: classes8.dex */
public class wzv implements o {
    public GrsCapability e;

    @Override // com.huawei.wisesecurity.ucs_credential.o
    public String b() {
        return b("HA");
    }

    @Override // com.huawei.wisesecurity.ucs_credential.o
    public String a(String str, String str2) {
        return b("CDN") + "tsms/" + str + "/" + str2;
    }

    public final String b(String str) {
        String strSynGetGrsUrl = this.e.synGetGrsUrl("com.huawei.tsms", str);
        wzg.a("OuterGrsUrlImpl", "synGetGrsUrl : {0}", strSynGetGrsUrl);
        return strSynGetGrsUrl;
    }

    @Override // com.huawei.wisesecurity.ucs_credential.o
    public String a() {
        return b("ROOT") + "/tsms/v2/credentials";
    }

    public wzv(GrsCapability grsCapability) {
        this.e = grsCapability;
    }
}
