package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes10.dex */
public class fss implements IRequest {

    @SerializedName("categoryCode")
    private String d;

    private fss(c cVar) {
        this.d = cVar.b;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.ch();
    }

    public static final class c {
        private String b;

        public c a(String str) {
            this.b = str;
            return this;
        }

        public fss c() {
            return new fss(this);
        }
    }
}
