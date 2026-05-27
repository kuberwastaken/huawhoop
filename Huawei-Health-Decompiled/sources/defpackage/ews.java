package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class ews {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12811a;
    private int b;
    private int c;
    private long d;

    public ews(long j, int i, int i2, String str) {
        this.f12811a = str;
        this.d = j;
        this.c = i;
        this.b = i2;
    }

    public String d() {
        return this.f12811a;
    }

    public long c() {
        return this.d;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }

    public String toString() {
        return "mHuid = " + this.f12811a + " mTimestamp = " + this.d + " mType = " + this.c;
    }
}
