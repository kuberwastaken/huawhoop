package defpackage;

/* JADX INFO: loaded from: classes10.dex */
public class aud {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f324a;
    private String b;
    private String c;
    private long d;
    private int e = -1;
    private String f = "";
    private int j;

    public void b(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.b = str;
    }

    public String toString() {
        return "{syncType:" + this.b + ",prepareTraceId:" + this.c + ",scene:" + this.e + ",startTime:" + this.d + ",endTime:" + this.f324a + ",errCode:" + this.f + ",times:" + this.j + "}";
    }

    public void a(long j) {
        this.d = j;
    }

    public void e(long j) {
        this.f324a = j;
    }

    public void c(String str) {
        this.f = str;
    }

    public void c(int i) {
        this.j = i;
    }

    public void e(int i) {
        this.e = i;
    }
}
