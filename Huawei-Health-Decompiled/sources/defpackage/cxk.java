package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class cxk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12072a;
    private boolean b;
    private boolean c;
    private String d;
    private int e;
    private int h;
    private long i;

    public boolean e() {
        return this.f12072a;
    }

    public void b(boolean z) {
        this.f12072a = z;
    }

    public String b() {
        return this.d;
    }

    public void a(String str) {
        this.d = str;
    }

    public long j() {
        return this.i;
    }

    public void c(long j) {
        this.i = j;
    }

    public boolean a() {
        return this.c;
    }

    public void e(boolean z) {
        this.c = z;
    }

    public int i() {
        return this.h;
    }

    public void b(int i) {
        this.h = i;
    }

    public boolean d() {
        return this.b;
    }

    public void d(boolean z) {
        this.b = z;
    }

    public int c() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("BPInputPageParam{imi=");
        stringBuffer.append(this.f12072a);
        stringBuffer.append(",bsf=").append(this.d);
        stringBuffer.append(",mt=").append(this.i);
        stringBuffer.append(",ifr=").append(this.c);
        stringBuffer.append(",rc=").append(this.h);
        stringBuffer.append(",isbp=").append(this.b);
        stringBuffer.append(",c=").append(this.e);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
