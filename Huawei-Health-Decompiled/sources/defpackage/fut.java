package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;
import com.huawei.pluginfitnessadvice.plandata.UserInfoBean;

/* JADX INFO: loaded from: classes4.dex */
public class fut implements IRequest {

    @SerializedName("weekIndex")
    private Integer b;

    @SerializedName("userInfo")
    private UserInfoBean d;

    @SerializedName("returnAlgorithmInfos")
    private Boolean e;

    private fut(a aVar) {
        this.d = aVar.f13205a;
        this.b = aVar.e;
        this.e = aVar.b;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.cf();
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private UserInfoBean f13205a;
        private Boolean b;
        private Integer e;

        public a d(UserInfoBean userInfoBean) {
            this.f13205a = userInfoBean;
            return this;
        }

        public a b(Integer num) {
            this.e = num;
            return this;
        }

        public a b(Boolean bool) {
            this.b = bool;
            return this;
        }

        public fut d() {
            return new fut(this);
        }
    }
}
