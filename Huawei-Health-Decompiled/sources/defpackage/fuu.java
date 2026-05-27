package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fuu implements IRequest {

    @SerializedName("planId")
    private String b;

    @SerializedName("exeDate")
    private List<Integer> d;

    @SerializedName("runDate")
    private List<Integer> e;

    private fuu(e eVar) {
        this.b = eVar.c;
        this.e = eVar.b;
        this.d = eVar.d;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.cc();
    }

    public static final class e {
        private List<Integer> b;
        private String c;
        private List<Integer> d;

        public e d(String str) {
            this.c = str;
            return this;
        }

        public e a(List<Integer> list) {
            this.b = list;
            return this;
        }

        public e d(List<Integer> list) {
            this.d = list;
            return this;
        }

        public fuu d() {
            return new fuu(this);
        }
    }
}
