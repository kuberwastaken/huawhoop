package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class ddh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12185a;
    private int b;
    private int c;
    private int d;
    private String e;
    private String f;
    private byte[] j;

    public ddh(int i, int i2, int i3, int i4) {
        this.c = i;
        this.f12185a = i2;
        this.d = i3;
        this.b = i4;
    }

    public ddh() {
        this(0, 0, 0, 0);
    }

    public int c() {
        return this.c;
    }

    public int e() {
        return this.f12185a;
    }

    public void b(int i) {
        this.f12185a = i;
    }

    public void b(String str) {
        this.e = str;
    }

    public String d() {
        return this.e;
    }

    public String b() {
        return this.f;
    }

    public void c(String str) {
        this.f = str;
    }

    public byte[] a() {
        return this.j;
    }

    public void c(byte[] bArr) {
        this.j = bArr;
    }
}
