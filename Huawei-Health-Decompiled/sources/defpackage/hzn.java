package defpackage;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.google.gson.annotations.SerializedName;
import com.huawei.hihealth.util.HiJsonUtil;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.openalliance.ad.constant.JsbMapKeyNames;

/* JADX INFO: loaded from: classes5.dex */
public class hzn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("nickName")
    private String f14008a;

    @SerializedName(CommonConstant.KEY_GENDER)
    private byte b;

    @SerializedName("birthday")
    private String c;

    @SerializedName("height")
    private int d;

    @SerializedName(CmcdConfiguration.KEY_SESSION_ID)
    private String e;

    @SerializedName("weight")
    private float h;

    @SerializedName(JsbMapKeyNames.H5_USER_ID)
    private String i;

    public hzn(String str, String str2, String str3, byte b) {
        this.i = str;
        this.f14008a = str2;
        this.c = str3;
        this.b = b;
    }

    public String h() {
        return this.i;
    }

    public String e() {
        return this.f14008a;
    }

    public String a() {
        return this.c;
    }

    public byte b() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public void e(int i) {
        this.d = i;
    }

    public float f() {
        return this.h;
    }

    public void e(float f) {
        this.h = f;
    }

    public String c() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public String toString() {
        return HiJsonUtil.d(this);
    }
}
