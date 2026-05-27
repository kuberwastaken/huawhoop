package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class mnq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("endLocalDate")
    private String f15744a;

    @SerializedName("endTime")
    private long b;

    @SerializedName("startLocalDate")
    private String c;

    @SerializedName("startTime")
    private long d;

    @SerializedName("dataSourceOptions")
    private mno e;

    @SerializedName("subUserOption")
    private c g;

    @SerializedName("timeZone")
    private String i;

    public String g() {
        return this.i;
    }

    public String e() {
        return this.c;
    }

    public String c() {
        return this.f15744a;
    }

    public long a() {
        return this.d;
    }

    public long b() {
        return this.b;
    }

    public mno d() {
        return this.e;
    }

    public String f() {
        c cVar = this.g;
        return cVar == null ? "" : cVar.c();
    }

    public String toString() {
        return "DataRequest{startLocalDate='" + this.c + "', endLocalDate='" + this.f15744a + "', startTime=" + this.d + ", endTime=" + this.b + ", dataSourceOptions=" + this.e + ", subUserOption=" + this.g + '}';
    }

    class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("subUser")
        private String f15745a;

        @SerializedName("subUserOnly")
        private boolean c;

        public String c() {
            return this.f15745a;
        }

        public String toString() {
            return "SubUserOption{subUser='" + this.f15745a + "', subUserOnly=" + this.c + '}';
        }
    }
}
