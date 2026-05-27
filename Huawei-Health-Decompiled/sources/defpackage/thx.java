package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class thx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f17993a;
    private int b;
    private boolean c;
    private boolean d;
    private String e;
    private boolean f;
    private boolean g;

    public thx(String str) {
        this.f = true;
        this.e = str;
    }

    public thx(String str, boolean z, int i, boolean z2) {
        this.e = str;
        this.f = z;
        this.b = i;
        this.c = z2;
    }

    public String c() {
        return this.e;
    }

    public boolean i() {
        return this.f;
    }

    public void d(boolean z) {
        this.f = z;
    }

    public int b() {
        return this.b;
    }

    public boolean a() {
        return this.d;
    }

    public void c(boolean z) {
        this.d = z;
        if (z) {
            this.b = 1073741824;
        }
    }

    public boolean e() {
        return this.f17993a;
    }

    public void e(boolean z) {
        this.f17993a = z;
    }

    public boolean d() {
        return this.c;
    }

    public boolean j() {
        return this.g;
    }

    public void a(boolean z) {
        this.g = z;
    }
}
