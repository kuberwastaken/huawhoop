package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class kgd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("serviceData")
    private String f14660a;

    @SerializedName("endTime")
    private long b;

    @SerializedName("metadata")
    private String c;

    @SerializedName("startTime")
    private long d;

    @SerializedName("dataSource")
    private String e;

    @SerializedName("version")
    private long f;

    @SerializedName("type")
    private int h;

    @SerializedName("timeZone")
    private String i;

    public long a() {
        return this.d;
    }

    public void a(long j) {
        this.d = j;
    }

    public long e() {
        return this.b;
    }

    public void c(long j) {
        this.b = j;
    }

    public int f() {
        return this.h;
    }

    public void b(int i) {
        this.h = i;
    }

    public String d() {
        return this.e;
    }

    public void d(String str) {
        this.e = str;
    }

    public String c() {
        return this.f14660a;
    }

    public void a(String str) {
        this.f14660a = str;
    }

    public String b() {
        return this.i;
    }

    public void b(String str) {
        this.i = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("st=" + this.d);
        sb.append(",et=" + this.b);
        sb.append(",type=" + this.h);
        sb.append(",ds=" + this.e);
        sb.append(",sd=" + this.f14660a);
        sb.append(",tz=" + this.i);
        sb.append(",ver=" + this.f);
        sb.append(",metadata=" + this.c);
        return sb.toString();
    }
}
