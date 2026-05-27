package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class ozr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("domain")
    private String f16577a;

    @SerializedName("text")
    private String b;

    @SerializedName("tag")
    private int c;

    @SerializedName("featureName")
    private String e;

    public String a() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public String c() {
        return this.f16577a;
    }

    public String e() {
        return this.e;
    }

    public String toString() {
        return "IndexCardTextInfo{text='" + this.b + "', tag=" + this.c + ", domain='" + this.f16577a + "', featureName='" + this.e + "'}";
    }
}
