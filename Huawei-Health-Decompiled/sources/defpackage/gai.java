package defpackage;

import com.amap.api.services.district.DistrictSearchQuery;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.up.request.HttpRequestBase;
import com.tencent.open.SocialConstants;
import com.tencent.open.SocialOperation;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class gai {

    @SerializedName("resultCode")
    private int b;

    @SerializedName("GetOtherUserInfoRsp")
    private a c;

    @SerializedName("CException")
    private e e;

    /* JADX INFO: loaded from: classes10.dex */
    public static class b {

        @SerializedName(SocialConstants.PARAM_APP_DESC)
        private String b;

        @SerializedName("siteID")
        private int c;

        @SerializedName("type")
        private int d;
    }

    /* JADX INFO: loaded from: classes10.dex */
    public static class d {

        @SerializedName(DistrictSearchQuery.KEYWORDS_PROVINCE)
        private String b;

        @SerializedName(DistrictSearchQuery.KEYWORDS_CITY)
        private String c;

        @SerializedName("nationalCode")
        private String d;
    }

    public void e(int i) {
        this.b = i;
    }

    public int e() {
        return this.b;
    }

    public a c() {
        return this.c;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("otherUserInfoList")
        private List<c> f13363a;

        @SerializedName("reault")
        private int b;

        @SerializedName("version")
        private String c;

        @SerializedName("otherUserInfo")
        private c e;

        public c a() {
            return this.e;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("ageGroupFlag")
        private int f13364a;

        @SerializedName("frdState")
        private int b;

        @SerializedName("frdOrigin")
        private b c;

        @SerializedName(CommonConstant.KEY_GENDER)
        private int d;

        @SerializedName("ext")
        private String e;

        @SerializedName("imageURLDownload")
        private String f;

        @SerializedName("nickName")
        private String g;

        @SerializedName("loginID")
        private String h;

        @SerializedName("imageURL")
        private String i;

        @SerializedName("needVerify")
        private int j;

        @SerializedName("phoneDigest")
        private String k;

        @SerializedName("region")
        private d l;

        @SerializedName("rCY")
        private String m;

        @SerializedName(SocialOperation.GAME_SIGNATURE)
        private String n;

        @SerializedName("privacySetFlags")
        private String o;

        @SerializedName("siteID")
        private int p;

        @SerializedName("userAccount")
        private String q;

        @SerializedName(HwPayConstant.KEY_USER_ID)
        private String r;

        @SerializedName("userType")
        private int s;

        public String a() {
            return this.q;
        }

        public String d() {
            return this.i;
        }

        public String c() {
            return this.g;
        }
    }

    /* JADX INFO: loaded from: classes10.dex */
    static class e {

        @SerializedName(HttpRequestBase.TAG_ERROR_DESC)
        private String c;

        @SerializedName("errorCode")
        private int e;

        e() {
        }
    }
}
