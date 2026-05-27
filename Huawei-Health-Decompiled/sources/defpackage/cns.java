package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class cns {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("name")
    private String f709a;

    @SerializedName("extendData")
    private String b;

    @SerializedName("recordName")
    private String c;

    @SerializedName("examinationInstitution")
    private String d;

    @SerializedName("examinationReport")
    private String e;

    @SerializedName("remarks")
    private String i;

    public void d(String str) {
        this.c = str;
    }

    public String a() {
        return this.c;
    }

    public String e() {
        return this.f709a;
    }

    public void c(String str) {
        this.f709a = str;
    }

    public void j(String str) {
        this.i = str;
    }

    public String g() {
        return this.i;
    }

    public String d() {
        return this.d;
    }

    public void a(String str) {
        this.d = str;
    }

    public String c() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public String b() {
        return this.b;
    }

    public void e(String str) {
        this.b = str;
    }
}
