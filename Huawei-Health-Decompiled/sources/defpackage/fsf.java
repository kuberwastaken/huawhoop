package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fsf implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("planId")
    private String f13129a;

    @SerializedName("recordId")
    private String d;

    @SerializedName("planType")
    private Integer e;

    private fsf(d dVar) {
        this.e = dVar.b;
        this.f13129a = dVar.d;
        this.d = dVar.e;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.n();
    }

    public static final class d {
        private Integer b;
        private String d;
        private String e;

        public d b(Integer num) {
            this.b = num;
            return this;
        }

        public d d(String str) {
            this.d = str;
            return this;
        }

        public d e(String str) {
            this.e = str;
            return this;
        }

        public fsf c() {
            return new fsf(this);
        }
    }
}
