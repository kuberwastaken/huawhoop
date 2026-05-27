package com.huawei.updatesdk.b.a.b;

import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C0295a f11326a;
    private String b;
    private long c;

    public String c() {
        return this.b;
    }

    public long b() {
        return this.c;
    }

    public void a(String str) {
        this.b = str;
    }

    /* JADX INFO: renamed from: com.huawei.updatesdk.b.a.b.a$a, reason: collision with other inner class name */
    public static class C0295a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<String> f11327a;

        public void a(List<String> list) {
            this.f11327a = list;
        }

        public List<String> a() {
            return this.f11327a;
        }
    }

    public void a(C0295a c0295a) {
        this.f11326a = c0295a;
    }

    public void a(long j) {
        this.c = j;
    }

    public C0295a a() {
        return this.f11326a;
    }
}
