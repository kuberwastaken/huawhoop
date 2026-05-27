package defpackage;

/* JADX INFO: loaded from: classes9.dex */
public class kcq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14597a;
    private String b;
    private int c;
    private String d;
    private String e;
    private int f;
    private String g;

    public kcq(String str, int i, String str2) {
        this(str, i, str2, null, null);
    }

    public kcq(String str, int i, String str2, String str3) {
        this(str, i, str2, str3, null);
    }

    public kcq(String str, int i, String str2, String str3, String str4) {
        this.e = str;
        this.f = i;
        this.d = str2;
        this.b = str3;
        this.f14597a = str4;
    }

    public kcq b(int i) {
        this.f = i;
        return this;
    }

    public void b(String str) {
        this.f14597a = str;
    }

    public void c(String str) {
        this.g = str;
    }

    public void e(int i) {
        this.c = i;
    }

    public void d(String str) {
        this.d = str;
    }

    public String c() {
        return this.e;
    }

    public int h() {
        return this.f;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.b;
    }

    public String a() {
        return this.f14597a;
    }

    public String i() {
        return this.g;
    }

    public int b() {
        return this.c;
    }
}
