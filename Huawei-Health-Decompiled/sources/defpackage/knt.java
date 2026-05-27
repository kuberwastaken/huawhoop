package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class knt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mcp")
    private String f14774a;

    @SerializedName("appAuditInfo")
    private knn b;

    @SerializedName("appId")
    private int c;

    @SerializedName("packageName")
    private String d;

    @SerializedName("appName")
    private String e;

    @SerializedName("prodType")
    private int h;

    public String e() {
        return this.f14774a;
    }

    public String toString() {
        return "AppInfo{appId=" + this.c + ", prodType=" + this.h + ", appName='" + this.e + "', packageName='" + this.d + "', mcp='" + this.f14774a + "', appAuditInfo=" + this.b + '}';
    }
}
