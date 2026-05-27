package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class kgg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("relatedDatas")
    private List<kgf> f14663a;

    @SerializedName("startTime")
    private long b;

    @SerializedName("extensions")
    private String c;

    @SerializedName("datasource")
    private String d;

    @SerializedName("orderId")
    private String e;

    @SerializedName("status")
    private int f;

    @SerializedName("interpretTime")
    private long g;

    public List<kgf> d() {
        return this.f14663a;
    }

    public void d(List<kgf> list) {
        this.f14663a = list;
    }

    public int c() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public void b(long j) {
        this.g = j;
    }

    public void a(String str) {
        this.c = str;
    }

    public String a() {
        return this.c;
    }

    public void b(String str) {
        this.d = str;
    }

    public void c(long j) {
        this.b = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("ts=" + this.g);
        sb.append(",rds=");
        sb.append(this.f14663a);
        sb.append(",status=" + this.f);
        sb.append(",es=" + this.c);
        sb.append(",orderId" + this.e);
        sb.append(",startTime" + this.b);
        return sb.toString();
    }
}
