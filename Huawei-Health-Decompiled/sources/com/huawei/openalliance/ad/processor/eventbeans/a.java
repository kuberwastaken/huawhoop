package com.huawei.openalliance.ad.processor.eventbeans;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Long f7711a;
    private Integer b;
    private Integer c;
    private String d;
    private String e;
    private boolean f;
    private Integer g;
    private String h;
    private String i;
    private boolean j;
    private String k;
    private boolean l;

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.processor.eventbeans.a$a, reason: collision with other inner class name */
    public static class C0223a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f7712a;
        private Integer b;
        private Integer c;
        private String h;
        private String i;
        private String k;
        private String d = null;
        private String e = null;
        private boolean f = true;
        private Integer g = null;
        private boolean j = true;
        private boolean l = false;

        public C0223a e(String str) {
            this.k = str;
            return this;
        }

        public C0223a d(String str) {
            this.i = str;
            return this;
        }

        public C0223a c(boolean z) {
            this.l = z;
            return this;
        }

        public C0223a c(String str) {
            this.h = str;
            return this;
        }

        public C0223a c(Integer num) {
            this.g = num;
            return this;
        }

        public C0223a b(boolean z) {
            this.f = z;
            return this;
        }

        public C0223a b(String str) {
            this.e = str;
            return this;
        }

        public C0223a b(Integer num) {
            this.c = num;
            return this;
        }

        public a a() {
            return new a(this);
        }

        public C0223a a(boolean z) {
            this.j = z;
            return this;
        }

        public C0223a a(String str) {
            this.d = str;
            return this;
        }

        public C0223a a(Long l) {
            this.f7712a = l;
            return this;
        }

        public C0223a a(Integer num) {
            this.b = num;
            return this;
        }
    }

    public boolean l() {
        return this.l;
    }

    public String k() {
        return this.i;
    }

    public String j() {
        return this.h;
    }

    public Integer i() {
        return this.g;
    }

    public boolean h() {
        return this.f;
    }

    public String g() {
        return this.e;
    }

    public String f() {
        return this.d;
    }

    public Integer e() {
        return this.c;
    }

    public Integer d() {
        return this.b;
    }

    public Long c() {
        return this.f7711a;
    }

    public boolean b() {
        return this.j;
    }

    public String a() {
        return this.k;
    }

    private a(C0223a c0223a) {
        this.j = true;
        this.l = false;
        this.f7711a = c0223a.f7712a;
        this.b = c0223a.b;
        this.c = c0223a.c;
        this.d = c0223a.d;
        this.e = c0223a.e;
        this.f = c0223a.f;
        this.g = c0223a.g;
        this.h = c0223a.h;
        this.i = c0223a.i;
        this.j = c0223a.j;
        this.k = c0223a.k;
        this.l = c0223a.l;
    }

    private a() {
        this.j = true;
        this.l = false;
    }
}
