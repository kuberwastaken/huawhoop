package defpackage;

/* JADX INFO: loaded from: classes9.dex */
public class jzk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14533a;
    private String b;
    private String c;
    private boolean d;

    public jzk(boolean z, String str) {
        this(z, str, null, null);
    }

    public jzk(boolean z, String str, String str2) {
        this(z, str, null, str2);
    }

    public jzk(boolean z, String str, String str2, String str3) {
        this.d = z;
        this.f14533a = str;
        this.c = str2;
        this.b = str3;
    }

    public boolean b() {
        return this.d;
    }

    public boolean a() {
        return "getCount".equals(this.f14533a);
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.f14533a;
    }

    public String e() {
        return this.b;
    }
}
