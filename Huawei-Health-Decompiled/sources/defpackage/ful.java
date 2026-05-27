package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class ful implements IRequest {

    @SerializedName("type")
    private Integer e;

    private ful(a aVar) {
        this.e = aVar.b;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bv();
    }

    public static final class a {
        private Integer b;

        public a b(Integer num) {
            this.b = num;
            return this;
        }

        public ful e() {
            return new ful(this);
        }
    }
}
