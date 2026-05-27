package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class mam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15571a;
    private int b;
    private int c;
    private String d;
    private String e;
    private int f;
    private long g;
    private String h;
    private int i;
    private String j;
    private int l;

    public mam() {
        this.l = -1;
        this.b = 0;
    }

    public mam(String str, int i) {
        this.b = 0;
        this.j = str;
        this.l = i;
    }

    public mam(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, long j) {
        this.f = i;
        this.d = str;
        this.f15571a = i2;
        this.i = i4;
        this.j = str2;
        this.l = i3;
        this.h = str3;
        this.b = i5;
        this.g = j;
    }

    public String d() {
        return this.j;
    }

    public int i() {
        return this.l;
    }

    public int c() {
        return this.c;
    }

    public void d(int i) {
        this.c = i;
    }

    public int e() {
        return this.i;
    }

    public void e(int i) {
        this.i = i;
    }

    public String b() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public String a() {
        return this.h;
    }

    public void b(String str) {
        this.h = str;
    }

    public long h() {
        return this.g;
    }

    public void c(long j) {
        this.g = j;
    }

    public String toString() {
        return "smsType(1-inbox 2-sent 3-draft56 4-outbox 5-failed 6-queued) is: " + this.i + ",sub_id is: " + this.l + ",isRead(0-unRead,1-read) is: " + this.b + ",receivedTime is: " + this.g + ",creator is: " + this.d + ",error_code is: " + this.f15571a + ",sender mobile last 3 number is: " + lzp.a(this.j);
    }
}
