package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class dla implements Serializable {
    private static final long serialVersionUID = 5732217115586382887L;
    private String b;
    private int c;
    private String d;
    private String e;

    public void b(String str) {
        this.b = (String) dne.b(str);
    }

    public String d() {
        return (String) dne.b(this.e);
    }

    public void a(String str) {
        this.e = (String) dne.b(str);
    }

    public String c() {
        return (String) dne.b(this.d);
    }

    public void e(String str) {
        this.d = (String) dne.b(str);
    }

    public int a() {
        return ((Integer) dne.b(Integer.valueOf(this.c))).intValue();
    }

    public void c(int i) {
        this.c = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("WeightResultShowModel [weight=");
        sb.append(this.b);
        sb.append(", bodyFat=");
        sb.append(this.e);
        sb.append(", targetWeight=");
        sb.append(this.d);
        sb.append(", bodyFatColor=");
        sb.append(this.c);
        sb.append("]");
        return sb.toString();
    }
}
