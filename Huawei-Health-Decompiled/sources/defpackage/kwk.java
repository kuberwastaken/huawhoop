package defpackage;

/* JADX INFO: loaded from: classes5.dex */
public class kwk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14959a;
    private long b;
    private int c;
    private int d;
    private int e;
    private int g;
    private int h;
    private int j;

    public kwk() {
        this.b = 0L;
        this.d = 60;
        this.h = -1;
        this.g = 0;
        this.c = -1;
        this.f14959a = 0;
        this.j = 0;
        this.e = 0;
    }

    public kwk(int i, int i2) {
        this.b = 0L;
        this.d = 60;
        this.h = i;
        this.g = i2;
        this.c = -1;
        this.f14959a = 0;
        this.j = 0;
        this.e = 0;
    }

    public long c() {
        return this.b;
    }

    public int a() {
        return this.d;
    }

    public int e() {
        return this.h;
    }

    public int d() {
        return this.g;
    }

    public int b() {
        return this.j;
    }

    public void e(long j) {
        this.b = j;
    }

    public void c(int i) {
        this.j = i;
    }

    public void d(int i) {
        this.e = i;
    }

    public String toString() {
        String str;
        String str2 = "Sample{startTime=" + this.b + ", duration=" + this.d + ", type=" + this.h;
        int i = this.h;
        if (i == 6 || i == 7) {
            str = str2 + ", value=xx";
        } else {
            str = str2 + ", value=" + this.g;
        }
        return str + ", intensive=" + this.e + '}';
    }
}
