package defpackage;

/* JADX INFO: loaded from: classes5.dex */
public class kkn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14726a;
    private final String b;
    private final String c;
    private final String d;
    private final int e;
    private final String g;

    private kkn(d dVar) {
        this.e = dVar.b;
        this.f14726a = dVar.f14727a;
        this.g = dVar.h;
        this.d = dVar.e;
        this.c = dVar.c;
        this.b = dVar.d;
    }

    public int c() {
        return this.e;
    }

    public String b() {
        return this.f14726a;
    }

    public String g() {
        return this.g;
    }

    public String e() {
        return this.d;
    }

    public String a() {
        return this.c;
    }

    public String d() {
        return this.b;
    }

    public String toString() {
        return "PushOpenAppBiInfo{biType=" + this.e + ", name='" + this.f14726a + "', url='" + this.g + "', pushId='" + this.d + "', serviceId='" + this.c + "', content='" + this.b + "'}";
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f14727a;
        private int b;
        private String c;
        private String d;
        private String e;
        private String h;

        public d a(int i) {
            this.b = i;
            return this;
        }

        public d a(String str) {
            this.f14727a = str;
            return this;
        }

        public d e(String str) {
            this.h = str;
            return this;
        }

        public d c(String str) {
            this.e = str;
            return this;
        }

        public d b(String str) {
            this.c = str;
            return this;
        }

        public d d(String str) {
            this.d = str;
            return this;
        }

        public kkn c() {
            return new kkn(this);
        }
    }
}
