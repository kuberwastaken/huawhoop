package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class vwl extends vxc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f18816a = true;
    private String b;
    private String c;
    private int d;
    private String e;
    private String i;

    public String b() {
        return this.b;
    }

    public void d(String str) {
        this.b = str;
    }

    public String c() {
        return this.e;
    }

    public void a(String str) {
        this.e = str;
    }

    public String d() {
        return this.c;
    }

    public void e(String str) {
        this.c = str;
    }

    public String j() {
        return this.i;
    }

    public void c(String str) {
        this.i = str;
    }

    @Override // defpackage.vxe
    public boolean a() {
        return this.f18816a;
    }

    @Override // defpackage.vxe
    public void e(boolean z) {
        this.f18816a = z;
    }

    @Override // defpackage.vxe
    public int e() {
        return this.d;
    }

    @Override // defpackage.vxe
    public void b(int i) {
        this.d = i;
    }
}
