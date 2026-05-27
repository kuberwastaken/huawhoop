package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.network.inner.api.NetworkService;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.hwid.bean.AckQrLoginReq;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;

/* JADX INFO: loaded from: classes8.dex */
public class tyo extends CloudCommonReponse {

    @SerializedName("LoginSNSRsp")
    private c e = new c();

    public c c() {
        return this.e;
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("digestKey")
        private String f18220a;

        @SerializedName(AckQrLoginReq.KEY_IS_FIRST_LOGIN)
        private String b;

        @SerializedName("grpListVersion")
        private String c;

        @SerializedName(NetworkService.Constants.CONFIG_SERVICE)
        private String d;

        @SerializedName("frdListVersion")
        private int e;

        @SerializedName("sessionValidTime")
        private int h;

        @SerializedName(HwPayConstant.KEY_USER_ID)
        private long j;

        public long b() {
            return this.j;
        }

        public String e() {
            return this.b;
        }

        public int c() {
            return this.h;
        }
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        StringBuilder sb = new StringBuilder("LoginUserSeverResponse{LoginSNSRsp=");
        if (c() != null) {
            sb.append("userId=");
            sb.append(c().b());
            sb.append(", isFirstLogin=");
            sb.append(c().e());
        }
        sb.append('}');
        return sb.toString();
    }
}
