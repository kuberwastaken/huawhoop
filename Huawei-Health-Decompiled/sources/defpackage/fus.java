package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fus implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("reportData")
    private String f13204a;

    @SerializedName("planId")
    private String d;

    private fus(e eVar) {
        this.d = eVar.b;
        this.f13204a = eVar.e;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.ce();
    }

    public static final class e {
        private String b;
        private String e;

        public e e(String str) {
            this.b = str;
            return this;
        }

        public e c(String str) {
            this.e = str;
            return this;
        }

        public fus d() {
            return new fus(this);
        }
    }
}
