package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class sro {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f17801a;
    private String b;
    private String c;
    private String d;
    private String e;

    public long e() {
        return this.f17801a;
    }

    public void e(long j) {
        this.f17801a = j;
    }

    public String a() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public void a(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.b;
    }

    public void e(String str) {
        this.b = str;
    }

    public String toString() {
        return "Data{mContent='" + this.c + "', mId='" + this.d + "', mUrl='" + this.b + "', mSize='" + this.f17801a + "', mFileName='" + this.e + "'}";
    }
}
