package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class gma {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13528a;
    private String b;
    private String d;
    private String e;

    private gma() {
    }

    public String a() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String d() {
        return this.d;
    }

    public void a(String str) {
        this.d = str;
    }

    public String j() {
        return this.f13528a;
    }

    public void d(String str) {
        this.f13528a = str;
    }

    public String e() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public void b() {
        this.b = "";
        this.e = "";
        this.d = "";
        this.f13528a = "";
    }

    static class e {
        private static final gma c = new gma();
    }

    public static final gma c() {
        return e.c;
    }
}
