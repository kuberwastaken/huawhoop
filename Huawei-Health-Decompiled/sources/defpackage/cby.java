package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.ad.db.bean.SdkCfgSha256Record;

/* JADX INFO: loaded from: classes10.dex */
public class cby {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("appLogo")
    private String f567a;

    @SerializedName(SdkCfgSha256Record.PKGNAME)
    private String b;

    @SerializedName("uid")
    private String c;

    @SerializedName("status")
    private String d;

    @SerializedName("appName")
    private String e;

    public String e() {
        return this.c;
    }

    public void e(String str) {
        this.c = str;
    }

    public String a() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public void d(String str) {
        this.e = str;
    }

    public void c(String str) {
        this.f567a = str;
    }

    public void a(String str) {
        this.d = str;
    }
}
