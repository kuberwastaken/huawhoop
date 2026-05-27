package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class nog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16064a;
    private int b;
    private String c;
    private String d;
    private int e;

    public nog() {
        this("", 0, 0);
    }

    public nog(String str, int i, int i2) {
        this.f16064a = str;
        this.b = i;
        this.e = i2;
    }

    public String a() {
        return this.f16064a;
    }

    public void d(String str) {
        this.f16064a = str;
    }

    public int e() {
        return this.b;
    }

    public void e(int i) {
        this.b = i;
    }

    public String d() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public String b() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public String toString() {
        return "{taskId:" + this.f16064a + ", status:" + this.b + ", productId:" + this.d + ", valueType:" + this.e + ", timeZone:" + this.c + '}';
    }
}
