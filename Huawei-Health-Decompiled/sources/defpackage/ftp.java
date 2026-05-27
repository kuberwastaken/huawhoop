package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;
import com.huawei.pluginachievement.manager.db.IAchieveDBMgr;

/* JADX INFO: loaded from: classes4.dex */
public class ftp implements IRequest {

    @SerializedName("pageStart")
    private Integer b;

    @SerializedName(IAchieveDBMgr.PARAM_PAGE_SIZE)
    private Integer d;

    private ftp(a aVar) {
        this.b = aVar.e;
        this.d = aVar.b;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.ba();
    }

    public static final class a {
        private Integer b;
        private Integer e;

        public a e(Integer num) {
            this.e = num;
            return this;
        }

        public a a(Integer num) {
            this.b = num;
            return this;
        }

        public ftp e() {
            return new ftp(this);
        }
    }
}
