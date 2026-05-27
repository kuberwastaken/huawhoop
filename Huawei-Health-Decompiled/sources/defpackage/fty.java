package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fty implements IRequest {

    @SerializedName("planId")
    private String b;

    private fty(c cVar) {
        this.b = cVar.e;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bk();
    }

    public static final class c {
        private String e;

        public c c(String str) {
            this.e = str;
            return this;
        }

        public fty c() {
            return new fty(this);
        }
    }
}
