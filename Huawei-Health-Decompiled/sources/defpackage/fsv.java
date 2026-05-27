package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes9.dex */
public class fsv implements IRequest {

    @SerializedName("version")
    private String c;

    @SerializedName("actionId")
    private String e;

    private fsv(b bVar) {
        this.e = bVar.b;
        this.c = bVar.f13149a;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.ab();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13149a;
        private String b;

        public b b(String str) {
            this.b = str;
            return this;
        }

        public b c(String str) {
            this.f13149a = str;
            return this;
        }

        public fsv b() {
            return new fsv(this);
        }
    }
}
