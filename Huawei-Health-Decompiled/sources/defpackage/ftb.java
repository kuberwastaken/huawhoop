package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class ftb implements IRequest {

    @SerializedName("type")
    private int e;

    private ftb(a aVar) {
        this.e = aVar.e;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.d();
    }

    public static final class a {
        private int e;

        public a e(int i) {
            this.e = i;
            return this;
        }

        public ftb d() {
            return new ftb(this);
        }
    }
}
