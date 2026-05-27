package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class tya {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("sn")
    private String f18214a;

    @SerializedName("devType")
    private String b;

    @SerializedName("udid")
    private String d;

    @SerializedName("deviceName")
    private String e;

    public String e() {
        return this.b;
    }

    public String c() {
        return this.d;
    }

    public String toString() {
        return "DevInfo{devType=" + this.b + ", deviceName=" + this.e + ", udid=" + this.d + ", sn=" + this.f18214a + '}';
    }
}
