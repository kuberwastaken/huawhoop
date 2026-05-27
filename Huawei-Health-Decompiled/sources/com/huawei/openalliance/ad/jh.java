package com.huawei.openalliance.ad;

/* JADX INFO: loaded from: classes6.dex */
public class jh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7374a = "PRELOAD_" + hashCode();
    private int b = 0;
    private a c;

    public interface a {
        void a();
    }

    public void b() {
        synchronized (this) {
            int i = this.b - 1;
            this.b = i;
            if (i < 0) {
                this.b = 0;
            }
            hq.a("PreloadWebViewMonitor", "dec count: " + this.b);
            if (this.b <= 0) {
                com.huawei.openalliance.ad.utils.dn.a(new Runnable() { // from class: com.huawei.openalliance.ad.jh.1
                    @Override // java.lang.Runnable
                    public void run() {
                        jh.this.c();
                    }
                }, this.f7374a, 60000L);
            }
        }
    }

    public void a() {
        synchronized (this) {
            this.b++;
            com.huawei.openalliance.ad.utils.dn.a(this.f7374a);
            hq.a("PreloadWebViewMonitor", "inc count: " + this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        hq.a("PreloadWebViewMonitor", "unbindService");
        this.c.a();
    }

    public jh(a aVar) {
        this.c = aVar;
    }
}
