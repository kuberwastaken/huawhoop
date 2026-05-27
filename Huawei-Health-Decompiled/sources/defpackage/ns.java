package defpackage;

/* JADX INFO: loaded from: classes9.dex */
public class ns {
    public final String b;
    public final String c;
    public final String e;

    public static class c {
        public static String b = "2";
        public static String c = "1";
        public static String d = "0";
    }

    public ns(String str, String str2, String str3) {
        this.c = str;
        this.b = str2;
        this.e = str3;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String e() {
        return this.e;
    }

    public String toString() {
        return "updateStrategy: " + this.e + " sha256:" + this.c + " sourceUrl:" + this.b;
    }
}
