package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fsg implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("type")
    private Integer f13130a;

    @SerializedName("logId")
    private Integer c;

    private fsg(b bVar) {
        this.c = bVar.d;
        this.f13130a = bVar.e;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.l();
    }

    public static final class b {
        private Integer d;
        private Integer e;

        public b c(Integer num) {
            this.d = num;
            return this;
        }

        public b e(Integer num) {
            this.e = num;
            return this;
        }

        public fsg b() {
            return new fsg(this);
        }
    }
}
