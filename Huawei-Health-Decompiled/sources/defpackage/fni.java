package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;

/* JADX INFO: loaded from: classes10.dex */
public class fni {

    @SerializedName("needVerify")
    private int c;

    @SerializedName(HwPayConstant.KEY_USER_ID)
    private long d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("imageURL")
    private String f13039a = "";

    @SerializedName("imageURLDownload")
    private String e = "";

    @SerializedName("nickName")
    private String b = "";

    public String toString() {
        return "UserInfo{mUserId=" + this.d + ", mNeedVerify=" + this.c + ", mImageUrl='" + this.f13039a + "', mImageUrlDownload='" + this.e + "', mNickname='" + this.b + "'}";
    }
}
