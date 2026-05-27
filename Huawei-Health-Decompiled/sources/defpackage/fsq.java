package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fsq implements IRequest {

    @SerializedName("returnAlgorithmInfos")
    private Boolean b;

    @SerializedName("weekIndex")
    private Integer d;

    @SerializedName("planId")
    private String e;

    private fsq(d dVar) {
        this.e = dVar.b;
        this.d = dVar.e;
        this.b = dVar.c;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.y();
    }

    public static final class d {
        private String b;
        private Boolean c;
        private Integer e;

        public d c(String str) {
            this.b = str;
            return this;
        }

        public d a(Integer num) {
            this.e = num;
            return this;
        }

        public d d(Boolean bool) {
            this.c = bool;
            return this;
        }

        public fsq c() {
            return new fsq(this);
        }
    }
}
