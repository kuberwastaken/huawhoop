package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class lqn {
    private String b;
    private int c;
    private String d;

    public lqn(int i, String str, String str2) {
        this.c = i;
        this.d = str;
        this.b = str2;
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public String toString() {
        return "SimpleContactBean{rawContactId=" + this.c + ", rawContactUid='" + this.d + "', rawContactFeature='" + this.b + "'}";
    }
}
