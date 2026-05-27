package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class fsj implements IRequest {

    @SerializedName("actionIdList")
    private List<String> b;

    @SerializedName("sex")
    private int e;

    private fsj(a aVar) {
        this.b = aVar.d;
        this.e = aVar.f13132a;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.q();
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f13132a;
        private List<String> d;

        public a b(List<String> list) {
            this.d = list;
            return this;
        }

        public a c(int i) {
            this.f13132a = i;
            return this;
        }

        public fsj a() {
            return new fsj(this);
        }
    }
}
