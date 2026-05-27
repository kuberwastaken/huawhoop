package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;
import com.huawei.pluginachievement.manager.db.IAchieveDBMgr;

/* JADX INFO: loaded from: classes10.dex */
public class fso implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("infoType")
    private Integer f13141a;

    @SerializedName("operType")
    private Integer c;

    @SerializedName(IAchieveDBMgr.PARAM_PAGE_SIZE)
    private Integer d;

    @SerializedName("pageNo")
    private Integer e;

    private fso(d dVar) {
        this.e = dVar.e;
        this.d = dVar.c;
        this.c = dVar.f13142a;
        this.f13141a = dVar.d;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.w();
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f13142a;
        private Integer c;
        private Integer d;
        private Integer e;

        public d e(Integer num) {
            this.e = num;
            return this;
        }

        public d a(Integer num) {
            this.c = num;
            return this;
        }

        public d d(Integer num) {
            this.f13142a = num;
            return this;
        }

        public d b(Integer num) {
            this.d = num;
            return this;
        }

        public fso a() {
            return new fso(this);
        }
    }
}
