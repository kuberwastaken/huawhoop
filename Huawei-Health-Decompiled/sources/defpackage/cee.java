package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class cee {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f606a;
    private int c;
    private int d;
    private int e;

    public int c() {
        return this.f606a;
    }

    public void e(int i) {
        this.f606a = i;
    }

    public void a(int i) {
        this.c = i;
    }

    public void c(int i) {
        this.d = i;
    }

    public int d() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(0);
        stringBuffer.append("bondStatus: ").append(this.f606a).append(" BondStatusInfo: ").append(this.c).append("VersionInfo: ").append(this.d).append(" ServiceMtu: ").append(this.e);
        return stringBuffer.toString();
    }
}
