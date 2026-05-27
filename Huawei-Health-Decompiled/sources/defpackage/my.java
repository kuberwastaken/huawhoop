package defpackage;

/* JADX INFO: loaded from: classes9.dex */
public class my {
    public String b;
    public long c = System.currentTimeMillis() + 86400000;
    public int e;

    public String toString() {
        return "ValueData{value='" + this.b + "', code=" + this.e + ", expired=" + this.c + '}';
    }

    public my(String str, int i) {
        this.b = str;
        this.e = i;
    }
}
