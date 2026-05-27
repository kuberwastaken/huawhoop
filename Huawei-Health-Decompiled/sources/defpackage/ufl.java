package defpackage;

/* JADX INFO: loaded from: classes9.dex */
public final class ufl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18287a;
    private String b;
    private String c;
    private boolean d;
    private boolean e;
    private int h;
    private int i;

    public ufl(int i, String str, boolean z, boolean z2, int i2) {
        this.h = i;
        this.c = str;
        this.d = z;
        this.e = z2;
        this.i = i2;
    }

    public ufl(int i, String str, String str2, boolean z, int i2) {
        this.h = i;
        this.b = str;
        this.f18287a = str2;
        this.d = z;
        this.i = i2;
    }

    public String b() {
        return this.c;
    }

    public int j() {
        return this.i;
    }

    public boolean g() {
        return this.e;
    }

    public boolean h() {
        return this.d;
    }

    public void c(boolean z) {
        this.d = z;
    }

    public boolean c() {
        return this.d;
    }

    public int a() {
        return this.h;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.f18287a;
    }

    public String toString() {
        return "ThirdPartAccountAuthBean{itemViewType=" + this.h + ", itemTitleShow=" + this.e + ", operationType=" + this.i + "', isOpen=" + this.d + '}';
    }
}
