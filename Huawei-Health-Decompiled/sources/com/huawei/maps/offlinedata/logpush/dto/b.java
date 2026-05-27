package com.huawei.maps.offlinedata.logpush.dto;

/* JADX INFO: loaded from: classes6.dex */
public class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6677a;
    private String b;
    private Throwable c;

    public String a() {
        return this.f6677a;
    }

    public String b() {
        return this.b;
    }

    public Throwable c() {
        return this.c;
    }

    public String toString() {
        return "ErrorTraceLogDTO{ scenario='" + this.f6677a + "', message='" + this.b + "'}";
    }

    private b(a aVar) {
        this.f6677a = aVar.f6678a;
        this.b = aVar.b;
        this.c = aVar.c;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f6678a;
        private String b;
        private Throwable c;

        public a a(String str) {
            this.f6678a = str;
            return this;
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }
}
