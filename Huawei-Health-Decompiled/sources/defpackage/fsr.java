package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fsr implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("type")
    private Integer f13145a;

    @SerializedName("lang")
    private String b;

    private fsr(a aVar) {
        this.f13145a = aVar.d;
        this.b = aVar.c;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.p();
    }

    public static final class a {
        private String c;
        private Integer d;

        public a e(Integer num) {
            this.d = num;
            return this;
        }

        public a d(String str) {
            this.c = str;
            return this;
        }

        public fsr a() {
            return new fsr(this);
        }
    }
}
