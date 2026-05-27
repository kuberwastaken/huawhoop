package com.huawei.hms.network.embedded;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public final class sb extends ac {
    public ac e;
    public boolean f;
    public long g;
    public long h;

    public void f() {
        this.e.timeout(this.h, TimeUnit.NANOSECONDS);
        if (this.f) {
            this.e.deadlineNanoTime(this.g);
        } else {
            this.e.a();
        }
    }

    public void a(ac acVar) {
        long jC;
        this.e = acVar;
        boolean zD = acVar.d();
        this.f = zD;
        this.g = zD ? acVar.c() : -1L;
        long jE = acVar.e();
        this.h = jE;
        acVar.timeout(ac.a(jE, e()), TimeUnit.NANOSECONDS);
        if (this.f && d()) {
            jC = Math.min(c(), this.g);
        } else if (!d()) {
            return;
        } else {
            jC = c();
        }
        acVar.deadlineNanoTime(jC);
    }
}
