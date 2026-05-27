package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class dtn {
    private int b;
    private String c;
    private String d;

    public dtn(String str, int i, String str2) {
        this.d = str;
        this.b = i;
        this.c = str2;
    }

    public dtn() {
    }

    public String a() {
        return (String) kqt.e(this.d);
    }

    public int c() {
        return ((Integer) kqt.e(Integer.valueOf(this.b))).intValue();
    }

    public String b() {
        return (String) kqt.e(this.c);
    }
}
