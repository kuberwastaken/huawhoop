package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fum implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("planId")
    private String f13194a;

    @SerializedName("dayNum")
    private Integer b;

    @SerializedName("record")
    private nzy c;

    @SerializedName("planType")
    private Integer d;

    @SerializedName("weekNum")
    private Integer e;

    private fum(a aVar) {
        this.d = aVar.c;
        this.f13194a = aVar.f13195a;
        this.e = aVar.b;
        this.b = aVar.e;
        this.c = aVar.d;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bz();
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13195a;
        private Integer b;
        private Integer c;
        private nzy d;
        private Integer e;

        public a e(Integer num) {
            this.c = num;
            return this;
        }

        public a d(String str) {
            this.f13195a = str;
            return this;
        }

        public a b(Integer num) {
            this.b = num;
            return this;
        }

        public a d(Integer num) {
            this.e = num;
            return this;
        }

        public a c(nzy nzyVar) {
            this.d = nzyVar;
            return this;
        }

        public fum a() {
            return new fum(this);
        }
    }
}
