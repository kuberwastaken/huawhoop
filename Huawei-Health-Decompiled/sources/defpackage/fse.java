package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class fse implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("idList")
    private List<Integer> f13128a;

    private fse(c cVar) {
        this.f13128a = cVar.c;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.o();
    }

    public static final class c {
        private List<Integer> c;

        public c a(List<Integer> list) {
            this.c = list;
            return this;
        }

        public fse d() {
            return new fse(this);
        }
    }
}
