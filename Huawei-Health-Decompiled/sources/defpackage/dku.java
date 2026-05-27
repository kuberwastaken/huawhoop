package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class dku {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12281a = -1;
    private int e = 0;
    private String b = null;
    private String i = null;
    private String c = null;
    private boolean d = true;
    private boolean f = false;
    private boolean j = true;

    public boolean d() {
        return this.f;
    }

    public void d(boolean z) {
        this.f = z;
    }

    public int c() {
        return ((Integer) dne.b(Integer.valueOf(this.f12281a))).intValue();
    }

    public void d(int i) {
        this.f12281a = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public int b() {
        return ((Integer) dne.b(Integer.valueOf(this.e))).intValue();
    }

    public void e(int i) {
        this.e = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public String e() {
        return (String) dne.b(this.b);
    }

    public void d(String str) {
        this.b = (String) dne.b(str);
    }

    public String j() {
        return (String) dne.b(this.i);
    }

    public void b(String str) {
        this.i = (String) dne.b(str);
    }

    public String a() {
        return (String) dne.b(this.c);
    }

    public void a(String str) {
        this.c = (String) dne.b(str);
    }

    public boolean f() {
        return ((Boolean) dne.b(Boolean.valueOf(this.d))).booleanValue();
    }

    public void b(boolean z) {
        this.d = ((Boolean) dne.b(Boolean.valueOf(z))).booleanValue();
    }

    public boolean g() {
        return this.j;
    }

    public void e(boolean z) {
        this.j = z;
    }
}
