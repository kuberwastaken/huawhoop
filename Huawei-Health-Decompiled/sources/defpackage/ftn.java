package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class ftn implements IRequest {

    @SerializedName("operateType")
    private Integer b;

    @SerializedName("id")
    private Integer e;

    private ftn(a aVar) {
        this.e = aVar.b;
        this.b = aVar.e;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.ay();
    }

    public static final class a {
        private Integer b;
        private Integer e;

        public a d(Integer num) {
            this.b = num;
            return this;
        }

        public a b(Integer num) {
            this.e = num;
            return this;
        }

        public ftn e() {
            return new ftn(this);
        }
    }
}
