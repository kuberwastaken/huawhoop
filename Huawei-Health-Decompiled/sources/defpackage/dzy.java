package defpackage;

import health.compact.a.CommonUtil;

/* JADX INFO: loaded from: classes4.dex */
public class dzy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12501a;
    private String b;
    private String c;
    private String d;
    private boolean e = false;

    public dzy(String str, String str2, String str3, String str4) {
        this.d = str;
        this.c = str2;
        this.b = str3;
        this.f12501a = str4;
    }

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            dzy dzyVar = obj instanceof dzy ? (dzy) obj : null;
            String str = this.d;
            if (str != null && this.c != null && dzyVar != null && str.equals(dzyVar.b()) && this.c.equals(dzyVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return CommonUtil.i(b());
    }

    public String b() {
        return (String) dne.b(this.d);
    }

    public String d() {
        return (String) dne.b(this.f12501a);
    }

    public String c() {
        return (String) dne.b(this.c);
    }

    public String e() {
        return (String) dne.b(this.b);
    }

    public boolean a() {
        return this.e;
    }

    public void d(boolean z) {
        this.e = z;
    }
}
