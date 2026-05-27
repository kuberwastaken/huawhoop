package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class mxm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("extend")
    private String f15917a;

    @SerializedName("state")
    private int c;

    @SerializedName("session")
    private String d;

    @SerializedName("code")
    private int e;

    public String b() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public int a() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public String e() {
        return this.f15917a;
    }

    public void b(String str) {
        this.f15917a = str;
    }

    public int d() {
        return this.e;
    }

    public void e(int i) {
        this.e = i;
    }
}
