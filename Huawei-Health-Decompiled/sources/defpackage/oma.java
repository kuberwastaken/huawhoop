package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class oma {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("max")
    private double f16447a;

    @SerializedName("name")
    private String b;

    @SerializedName("tag")
    private String c;

    @SerializedName("min")
    private double d;

    public double a() {
        return this.d;
    }

    public double b() {
        return this.f16447a;
    }

    public String e() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String toString() {
        return "PwrLevelConfig{mMin=" + this.d + ", mMax=" + this.f16447a + ", mName='" + this.b + "', mTag='" + this.c + "'}";
    }
}
