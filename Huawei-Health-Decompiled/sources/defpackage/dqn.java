package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class dqn implements Serializable {
    private static final long serialVersionUID = -6977434421058883312L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12366a;
    private String b;
    private String c;
    private int d;
    private String e;
    private String f;
    private String g;
    private String h = "unknown";
    private String j;

    public dqn() {
    }

    public dqn(String str, String str2, int i) {
        this.f = str;
        this.b = str2;
        this.d = i;
    }

    public String g() {
        return (String) dne.b(this.j);
    }

    public void d(String str) {
        this.j = (String) dne.b(str);
    }

    public String h() {
        return (String) dne.b(this.f);
    }

    public void f(String str) {
        this.f = (String) dne.b(str);
    }

    public String j() {
        return (String) dne.b(this.g);
    }

    public void h(String str) {
        this.g = (String) dne.b(str);
    }

    public String d() {
        return (String) dne.b(this.b);
    }

    public void a(String str) {
        this.b = (String) dne.b(str);
    }

    public String e() {
        return (String) dne.b(this.c);
    }

    public void e(String str) {
        this.c = (String) dne.b(str);
    }

    public String a() {
        return (String) dne.b(this.f12366a);
    }

    public void b(String str) {
        this.f12366a = (String) dne.b(str);
    }

    public String b() {
        return (String) dne.b(this.e);
    }

    public void c(String str) {
        this.e = (String) dne.b(str);
    }

    public String i() {
        return (String) dne.b(this.h);
    }

    public void j(String str) {
        this.h = (String) dne.b(str);
    }

    public int c() {
        return ((Integer) dne.b(Integer.valueOf(this.d))).intValue();
    }

    public void b(int i) {
        this.d = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dqn)) {
            return false;
        }
        dqn dqnVar = (dqn) obj;
        return (d(dqnVar) || c(dqnVar) || a(dqnVar) || e(dqnVar) || b(dqnVar)) ? false : true;
    }

    private boolean d(dqn dqnVar) {
        return h() == null ? dqnVar.h() != null : !h().equals(dqnVar.h());
    }

    private boolean c(dqn dqnVar) {
        return j() == null ? dqnVar.j() != null : !j().equals(dqnVar.j());
    }

    private boolean a(dqn dqnVar) {
        return e() == null ? dqnVar.e() != null : !e().equals(dqnVar.e());
    }

    private boolean e(dqn dqnVar) {
        return d() == null ? dqnVar.d() != null : !d().equals(dqnVar.d());
    }

    private boolean b(dqn dqnVar) {
        return i() == null ? dqnVar.i() != null : !i().equals(dqnVar.i());
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AddDeviceInfo{ssid ='");
        stringBuffer.append(dna.b(this.f)).append("', productId ='");
        stringBuffer.append(dna.b(this.g)).append("', deviceSn ='");
        stringBuffer.append(dna.b(this.b)).append("', deviceId ='");
        stringBuffer.append(dna.b(this.c)).append("', mac ='");
        stringBuffer.append(dna.b(this.f12366a)).append("', baseUrl ='");
        stringBuffer.append(this.e).append("', sourceType ='");
        stringBuffer.append(this.h).append("', encryptMode =");
        stringBuffer.append(this.d);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public int hashCode() {
        int iHashCode = h() != null ? h().hashCode() : 0;
        int iHashCode2 = j() != null ? j().hashCode() : 0;
        int iHashCode3 = e() != null ? e().hashCode() : 0;
        return (((((((iHashCode * 31) + iHashCode2) * 31) + iHashCode3) * 31) + (d() != null ? d().hashCode() : 0)) * 31) + (i() != null ? i().hashCode() : 0);
    }
}
