package defpackage;

/* JADX INFO: loaded from: classes11.dex */
public class ouk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16564a;
    private String b;
    private String c;
    private int d;
    private int e;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ouk)) {
            return false;
        }
        ouk oukVar = (ouk) obj;
        return this.b.equals(oukVar.b) && this.c.equals(oukVar.c) && this.f16564a == oukVar.f16564a && this.e == oukVar.e && this.d == oukVar.d;
    }
}
