package defpackage;

import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes7.dex */
public class pbu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16613a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String i;

    public pbu(c cVar) {
        if (cVar == null) {
            LogUtil.a("ThemeProductQueryParam", "builder is null");
            return;
        }
        this.e = cVar.b;
        this.b = cVar.d;
        this.c = cVar.c;
        this.d = cVar.e;
        this.i = cVar.f;
        this.f16613a = cVar.f16614a;
    }

    public String e() {
        return this.e;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String j() {
        return this.i;
    }

    public String a() {
        return this.f16613a;
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f16614a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;

        public pbu e() {
            return new pbu(this);
        }

        public c b(String str) {
            this.b = str;
            return this;
        }

        public c e(String str) {
            this.d = str;
            return this;
        }

        public c c(String str) {
            this.c = str;
            return this;
        }

        public c d(String str) {
            this.e = str;
            return this;
        }

        public c j(String str) {
            this.f = str;
            return this;
        }

        public c a(String str) {
            this.f16614a = str;
            return this;
        }
    }
}
