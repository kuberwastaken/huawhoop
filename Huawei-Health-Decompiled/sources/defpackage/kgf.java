package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class kgf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("relatedDataStartTime")
    private long f14662a;

    @SerializedName("relatedDataType")
    private int b;

    @SerializedName("relatedDataDeviceUuid")
    private String c;

    @SerializedName("relatedDataEndTime")
    private long d;

    @SerializedName("relatedPackageName")
    private String e;

    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("st=");
        sb.append(this.f14662a);
        sb.append(", et=");
        sb.append(this.d);
        sb.append(",type=");
        sb.append(this.b);
        sb.append(", duc=");
        sb.append(this.c);
        sb.append(", pn=");
        sb.append(this.e);
        return sb.toString();
    }

    public long e() {
        return this.f14662a;
    }

    public void b(long j) {
        this.f14662a = j;
    }

    public long c() {
        return this.d;
    }

    public void c(long j) {
        this.d = j;
    }

    public int d() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }

    public String b() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    public String a() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }
}
