package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class omb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("ftpValue")
    private double f16448a;

    @SerializedName("pwrLevelTag")
    private String b;

    @SerializedName("recordTime")
    private int c;

    @SerializedName("pwr")
    private double d;

    @SerializedName("pwrLevelDesc")
    private String e;

    public double a() {
        return this.f16448a;
    }

    public int d() {
        return this.c;
    }

    public double b() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String c() {
        return this.b;
    }

    public String toString() {
        return "FtpRecord{mFtpValue=" + this.f16448a + ", mRecordTime=" + this.c + ", mPwr=" + this.d + ", mPwrLevelDesc='" + this.e + "', mPwrLevelTag='" + this.b + "'}";
    }
}
