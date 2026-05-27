package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class mzh {
    private int b;
    private String c;

    mzh() {
    }

    public int b() {
        return this.b;
    }

    public String e() {
        return this.c;
    }

    public void d(int i) {
        this.b = i;
    }

    public void c(String str) {
        this.c = str;
    }

    public String toString() {
        return "HttpResponse{code=" + this.b + ", response='" + this.c + "'}";
    }
}
