package com.huawei.openalliance.ad;

/* JADX INFO: loaded from: classes6.dex */
public class ji {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7376a = false;
    private boolean b = false;
    private long c = 0;
    private long d = 0;
    private String e;

    public long e() {
        return this.d;
    }

    public long d() {
        return this.c;
    }

    public void c() {
        if (hq.a()) {
            hq.a(this.e, "onVideoEnd");
        }
        this.b = false;
        this.f7376a = false;
        this.c = 0L;
        this.d = 0L;
    }

    public void b() {
        if (hq.a()) {
            hq.a(this.e, "onBufferStart");
        }
        if (this.f7376a) {
            return;
        }
        this.f7376a = true;
        this.c = System.currentTimeMillis();
    }

    public void a() {
        if (hq.a()) {
            hq.a(this.e, "onPlayStart");
        }
        if (this.b) {
            return;
        }
        this.b = true;
        this.d = System.currentTimeMillis();
    }

    public ji(String str) {
        this.e = "VideoMonitor_" + str;
    }
}
