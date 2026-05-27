package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fuo implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("propType")
    private String f13198a;

    @SerializedName("planType")
    private int c;

    @SerializedName("propValue")
    private String d;

    @SerializedName("planId")
    private String e;

    private fuo(a aVar) {
        this.e = aVar.e;
        this.c = aVar.c;
        this.f13198a = aVar.f13199a;
        this.d = aVar.b;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bx();
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13199a;
        private String b;
        private int c;
        private String e;

        public a d(String str) {
            this.e = str;
            return this;
        }

        public a c(int i) {
            this.c = i;
            return this;
        }

        public a b(String str) {
            this.f13199a = str;
            return this;
        }

        public a c(String str) {
            this.b = str;
            return this;
        }

        public fuo c() {
            return new fuo(this);
        }
    }
}
