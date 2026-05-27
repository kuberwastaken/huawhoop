package com.huawei.openalliance.ad.download.app;

import com.huawei.openalliance.ad.hq;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f7046a;
    private final CountDownLatch b = new CountDownLatch(1);
    private final String c;
    private boolean d;
    private int e;

    public interface a {
        void a(int i);

        void a(n nVar);

        void b(n nVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7046a == null) {
            return;
        }
        hq.a("RestoreTask", "task:%s startup", this.c);
        if (this.d) {
            hq.a("RestoreTask", "task:%s is canceled", this.c);
            return;
        }
        try {
            try {
                this.f7046a.a(this);
                this.f7046a.b(this);
                d();
            } finally {
                this.f7046a.a(this.e);
            }
        } catch (Throwable unused) {
            hq.c("RestoreTask", "try restore has exception");
        }
    }

    public void c() {
        this.d = false;
    }

    public void b() {
        this.d = true;
    }

    public void a(int i) {
        hq.a("RestoreTask", "stub result code:%s", Integer.valueOf(i));
        if (i == -1 || i == 0) {
            this.e = i;
            this.b.countDown();
        }
    }

    public String a() {
        return this.c;
    }

    private void d() {
        try {
            boolean zAwait = this.b.await(5L, TimeUnit.SECONDS);
            hq.b("RestoreTask", "wait restore success:%s", Boolean.valueOf(zAwait));
            if (zAwait) {
                return;
            }
            this.e = -1;
        } catch (Throwable unused) {
            hq.c("RestoreTask", "wait result failed");
        }
    }

    public n(String str, a aVar) {
        this.c = "restore_" + str;
        this.f7046a = aVar;
    }
}
