package com.huawei.maps.offlinedata.logpush.dto;

/* JADX INFO: loaded from: classes6.dex */
public class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6675a;
    private String b;
    private String c;
    private long d;
    private long e;

    public void a(String str) {
        this.f6675a = str;
    }

    public String a() {
        return this.f6675a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public long d() {
        return this.d;
    }

    public long e() {
        return this.e;
    }

    public void a(long j) {
        this.e = j;
    }

    public String toString() {
        return "AccessTraceLogDTO{ requestId='" + this.f6675a + "', apiName='" + this.b + "', errorCode='" + this.c + "', startTime=" + this.d + ", endTime=" + this.e + '}';
    }

    private a(C0182a c0182a) {
        this.f6675a = "";
        this.b = "";
        this.c = "";
        this.f6675a = c0182a.f6676a;
        this.b = c0182a.b;
        this.d = System.currentTimeMillis();
        c(c0182a.c);
    }

    /* JADX INFO: renamed from: com.huawei.maps.offlinedata.logpush.dto.a$a, reason: collision with other inner class name */
    public static final class C0182a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f6676a = "";
        private String b;
        private String c;

        private C0182a() {
        }

        public C0182a a(String str) {
            this.b = str;
            return this;
        }

        public static C0182a a() {
            C0182a c0182a = new C0182a();
            c0182a.c = "sdk";
            return c0182a;
        }

        public static C0182a b() {
            C0182a c0182a = new C0182a();
            c0182a.c = "cloud";
            return c0182a;
        }

        public a c() {
            return new a(this);
        }
    }
}
