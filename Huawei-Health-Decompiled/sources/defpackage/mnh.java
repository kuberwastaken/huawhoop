package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class mnh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15732a;
    private long b;
    private long d;
    private String e;

    public mnh(String str, long j, long j2, long j3) {
        this.e = str;
        this.b = j2;
        this.f15732a = j;
        this.d = j3;
    }

    public mnh(String str) {
        this.b = 0L;
        this.f15732a = 0L;
        this.d = 0L;
        this.e = str;
    }

    public void d(long j) {
        this.f15732a += j;
        this.d += j;
    }

    public void b(long j) {
        this.b += j;
        this.d += j;
    }

    public long d() {
        return this.b;
    }

    public void c(long j) {
        this.b = j;
    }

    public long b() {
        return this.f15732a;
    }

    public void a(long j) {
        this.f15732a = j;
    }

    public long c() {
        return this.d;
    }

    public void e(long j) {
        this.d = j;
    }

    public String a() {
        return this.e;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("date: ");
        stringBuffer.append(this.e);
        stringBuffer.append(" received: ");
        stringBuffer.append(this.b);
        stringBuffer.append(" requested: ");
        stringBuffer.append(this.f15732a);
        stringBuffer.append(" total: ");
        stringBuffer.append(this.d);
        return stringBuffer.toString();
    }
}
