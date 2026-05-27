package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.tencent.open.SocialOperation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class tyf extends CloudCommonReponse {

    @SerializedName("FindUserV2Rsp")
    private e b = new e();

    public static class c {

        @SerializedName("nationalCode")
        private String c;
    }

    public e a() {
        return this.b;
    }

    public static class e {

        @SerializedName("findUserInfo")
        private List<a> b = new ArrayList();

        public List<a> a() {
            return this.b;
        }
    }

    public static class a {

        @SerializedName("needVerify")
        private int c;

        @SerializedName(CommonConstant.KEY_GENDER)
        private int e;

        @SerializedName("siteID")
        private int f;

        @SerializedName("region")
        private c h;

        @SerializedName(HwPayConstant.KEY_USER_ID)
        private long j;

        @SerializedName("userType")
        private int k;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("imageURL")
        private String f18216a = "";

        @SerializedName("imageURLDownload")
        private String b = "";

        @SerializedName("nickName")
        private String d = "";

        @SerializedName(SocialOperation.GAME_SIGNATURE)
        private String i = "";

        @SerializedName("phoneDigest")
        private String g = "";

        public long d() {
            return this.j;
        }

        public String e() {
            return this.f18216a;
        }
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        StringBuilder sb = new StringBuilder("FindUserV2Response{FindUserV2Rsp=");
        if (a() != null) {
            sb.append(" findUserInfo=");
            if (a().a().size() != 0) {
                sb.append(", userID='");
                sb.append(a().a().get(0).d());
                sb.append(", imageURL='");
                sb.append(a().a().get(0).e());
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
