package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fug implements IRequest {

    @SerializedName("type")
    private Integer e;

    private fug(e eVar) {
        this.e = eVar.b;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bo();
    }

    public static final class e {
        private Integer b;

        public e d(Integer num) {
            this.b = num;
            return this;
        }

        public fug c() {
            return new fug(this);
        }
    }
}
