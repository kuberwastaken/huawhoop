package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class ewt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12812a;
    private String b;
    private int c;
    private long d;
    private long e;
    private String f;

    public ewt(long j, long j2, String str, String str2) {
        this.e = j;
        this.d = j2;
        this.b = str;
        this.f = str2;
    }

    public long c() {
        return this.e;
    }

    public long e() {
        return this.d;
    }

    public String g() {
        return this.f;
    }

    public String a() {
        return this.b;
    }

    public String d() {
        return this.f12812a;
    }

    public void d(String str) {
        this.f12812a = str;
    }

    public int b() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public String toString() {
        return "RecordReadOption{startTime=" + this.e + ", endTime=" + this.d + ", type=" + this.f + ", count = " + this.c + ", sortOrder=" + this.f12812a + '}';
    }
}
