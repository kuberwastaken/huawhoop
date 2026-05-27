package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes10.dex */
public class fth implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("cond")
    private String f13159a;

    private fth(a aVar) {
        this.f13159a = aVar.c;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.an();
    }

    public static final class a {
        private String c;

        public a c(String str) {
            this.c = str;
            return this;
        }

        public fth d() {
            return new fth(this);
        }
    }
}
