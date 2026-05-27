package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class dqb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("code")
    private String f12358a;

    @SerializedName("cloudUrl")
    private String b;

    @SerializedName("psk")
    private String c;

    @SerializedName("devId")
    private String d;

    public void a(String str) {
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    public void d(String str) {
        this.f12358a = str;
    }

    public void c(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.c = str;
    }

    public String toString() {
        return "SoftApRegisterInfo{devId =" + dna.b(this.d) + ", code ='" + dna.b(this.f12358a) + "', cloudUrl ='" + dna.b(this.b) + "', psk ='" + dna.b(this.c) + "'}";
    }
}
