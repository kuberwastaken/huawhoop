package defpackage;

/* JADX INFO: loaded from: classes11.dex */
public class nds {
    private String c;
    private String d;
    private String e;
    private String i;
    private long b = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f16014a = -1;

    public String f() {
        return this.i;
    }

    public String a() {
        return this.d;
    }

    public void e(String str) {
        this.i = str;
    }

    public long e() {
        return this.f16014a;
    }

    public void b(String str) {
        this.d = str;
    }

    public long c() {
        return this.b;
    }

    public void d(String str) {
        this.e = str;
    }

    public void e(long j) {
        this.f16014a = j;
    }

    public String d() {
        return this.e;
    }

    public void c(String str) {
        this.c = str;
    }

    public void b(nds ndsVar) {
        if (ndsVar == null) {
            return;
        }
        if (ndsVar.c() != -1) {
            c(ndsVar.c());
        }
        if (ndsVar.e() != -1) {
            e(ndsVar.e());
        }
        c(ndsVar.b());
        d(ndsVar.d());
        b(ndsVar.a());
        e(ndsVar.f());
    }

    public void c(long j) {
        this.b = j;
    }

    public String b() {
        return this.c;
    }
}
