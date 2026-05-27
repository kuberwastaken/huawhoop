package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;
import com.huawei.pluginachievement.manager.db.IAchieveDBMgr;

/* JADX INFO: loaded from: classes4.dex */
public class fsu implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("planSource")
    private Integer f13147a;

    @SerializedName("planCategory")
    private Integer b;

    @SerializedName(IAchieveDBMgr.PARAM_PAGE_SIZE)
    private Integer c;

    @SerializedName("pageStart")
    private Integer e;

    private fsu(a aVar) {
        this.e = aVar.f13148a;
        this.c = aVar.d;
        this.f13147a = aVar.b;
        this.b = aVar.e;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.z();
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f13148a;
        private Integer b;
        private Integer d;
        private Integer e;

        public a a(Integer num) {
            this.f13148a = num;
            return this;
        }

        public a d(Integer num) {
            this.d = num;
            return this;
        }

        public a b(Integer num) {
            this.b = num;
            return this;
        }

        public a c(Integer num) {
            this.e = num;
            return this;
        }

        public fsu d() {
            return new fsu(this);
        }
    }
}
