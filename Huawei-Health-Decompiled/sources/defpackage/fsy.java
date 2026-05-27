package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fsy implements IRequest {

    @SerializedName("timbre")
    private String b;

    @SerializedName("version")
    private Long e;

    private fsy(b bVar) {
        this.e = bVar.e;
        this.b = bVar.c;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.af();
    }

    public static final class b {
        private String c;
        private Long e;

        public b a(Long l) {
            this.e = l;
            return this;
        }

        public b b(String str) {
            this.c = str;
            return this;
        }

        public fsy b() {
            return new fsy(this);
        }
    }
}
