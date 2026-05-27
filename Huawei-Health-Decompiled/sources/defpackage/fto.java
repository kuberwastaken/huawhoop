package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fto implements IRequest {

    @SerializedName("workoutInfoQueryParams")
    private List<gjl> c;

    @SerializedName("showDetail")
    private Boolean d;

    private fto(a aVar) {
        this.c = aVar.e;
        this.d = aVar.d;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.aq();
    }

    public static final class a {
        private Boolean d;
        private List<gjl> e;

        public a a(List<gjl> list) {
            this.e = list;
            return this;
        }

        public a b(Boolean bool) {
            this.d = bool;
            return this;
        }

        public fto b() {
            return new fto(this);
        }
    }
}
