package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class vnj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18675a;
    private int b;
    private int c;
    private int d;

    public vnj() {
        this(0, 0, 0, 0);
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.f18675a;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }

    public String toString() {
        return "HwColumn{mMargin=" + this.c + ", mGutter=" + this.b + ", mColumnCount=" + this.d + ", mMaxColumnCount=" + this.f18675a + '}';
    }

    vnj(int i, int i2, int i3, int i4) {
        this.c = i;
        this.b = i2;
        this.d = i3;
        this.f18675a = i4;
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.d = i;
    }

    public void d(int i) {
        this.f18675a = i;
    }

    public void e(int i) {
        this.b = i;
    }
}
