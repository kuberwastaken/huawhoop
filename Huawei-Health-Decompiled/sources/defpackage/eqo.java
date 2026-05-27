package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class eqo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("appType")
    private String f12739a;

    @SerializedName("appName")
    private String b;

    @SerializedName("configName")
    private String c;

    @SerializedName("configDescription")
    private String d;

    @SerializedName("configData")
    private String e;

    @SerializedName("type")
    private String f;

    @SerializedName("id")
    private String h;

    @SerializedName("version")
    private long j;

    public String a() {
        return this.e;
    }

    public String toString() {
        return "GetUserSampleConfig{mType=" + this.f + ", mId=" + this.h + ", mConfigData=" + this.e + ", mConfigName=" + this.c + ", mConfigDescription=" + this.d + ", mVersion=" + this.j + ", mAppName=" + this.b + ", mAppType=" + this.f12739a + "}";
    }
}
