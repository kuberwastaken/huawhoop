package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class loc {
    private int f;
    private int i;
    private long b = 0;
    private int c = 60;
    private int e = -1;
    private int d = 0;
    private int h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15346a = 0;

    public loc(int i, int i2) {
        this.f = i;
        this.i = i2;
    }

    public long c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public int a() {
        return this.f;
    }

    public int b() {
        return this.i;
    }

    public int e() {
        return this.h;
    }

    public void d(long j) {
        this.b = j;
    }

    public void b(int i) {
        this.h = i;
    }

    public void a(int i) {
        this.f15346a = i;
    }

    public String toString() {
        String str;
        String str2 = "Sample{startTime=" + this.b + ", duration=" + this.c + ", type=" + this.f;
        int i = this.f;
        if (i == 6 || i == 7) {
            str = str2 + ", value=xx";
        } else {
            str = str2 + ", value=" + this.i;
        }
        return str + ", intensive=" + this.f15346a + '}';
    }
}
