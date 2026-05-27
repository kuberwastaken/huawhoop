package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class ewu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12813a;
    private String b;
    private String c;
    private String d = String.valueOf(System.currentTimeMillis());

    public String e() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String d() {
        return this.b;
    }

    public void e(String str) {
        this.b = str;
    }

    public String b() {
        return this.f12813a;
    }

    public void d(String str) {
        this.f12813a = str;
    }

    public String c() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public String toString() {
        return "UserLabelInfo{mHuid='" + this.c + "', mUriKey='" + this.b + "', mUriValue=" + this.f12813a + ", mTimeStamp='" + this.d + "'}";
    }
}
