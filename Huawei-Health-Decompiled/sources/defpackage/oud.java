package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class oud {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16557a;
    private String b;
    private String[] c;
    private String[] d;
    private String e;
    private String j;

    public oud(b bVar) {
        this.b = bVar.e;
        this.j = bVar.g;
        this.f16557a = bVar.c;
        this.e = bVar.d;
        this.c = bVar.f16558a;
        this.d = bVar.b;
    }

    public String e() {
        return this.j;
    }

    public String c() {
        return this.f16557a;
    }

    public String a() {
        return this.e;
    }

    public String[] d() {
        return this.c;
    }

    public String[] b() {
        return this.d;
    }

    public String toString() {
        return "mStyleType: " + this.b + " mSupportWidgetClz: " + this.j + " mStyleableClzName" + this.f16557a + " mStyleableField: " + this.e + " mIndexNames: " + this.c + " mAttrNames: " + this.d;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String[] f16558a;
        private String[] b;
        private String c;
        private String d;
        private String e;
        private String g;

        public b a(String str) {
            if ("style".equals(str)) {
                this.e = "style";
            } else if ("textAppearance".equals(str)) {
                this.e = "textAppearance";
            }
            return this;
        }

        public b e(String str) {
            this.g = str;
            return this;
        }

        public b c(String str) {
            this.c = str;
            return this;
        }

        public b d(String str) {
            this.d = str;
            return this;
        }

        public b a(String[] strArr) {
            this.f16558a = strArr;
            return this;
        }

        public b d(String[] strArr) {
            this.b = strArr;
            return this;
        }

        public oud c() {
            return new oud(this);
        }
    }
}
