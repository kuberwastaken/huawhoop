package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class sih {
    protected String d(String str, int i) {
        return str + "&from=" + i;
    }

    public static class a {
        private String b;
        private String c;
        private String d;
        private String e;

        public String e() {
            return this.b;
        }

        public void b(String str) {
            this.b = str;
        }

        public String a() {
            return this.d;
        }

        public void a(String str) {
            this.d = str;
        }

        public String c() {
            return this.e;
        }

        public void d(String str) {
            this.e = str;
        }

        public String b() {
            return this.c;
        }

        public void c(String str) {
            this.c = str;
        }

        public String toString() {
            return "title: " + this.b + " content: " + this.d + " watchDeeplink: " + this.c + " phoneDeeplink: " + this.c;
        }
    }
}
