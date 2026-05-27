package com.huawei.hms.framework.network.grs.g.j;

import android.os.SystemClock;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Future<com.huawei.hms.framework.network.grs.g.d> f4733a;
    private final long b = SystemClock.elapsedRealtime();

    public boolean b() {
        return SystemClock.elapsedRealtime() - this.b <= 300000;
    }

    public Future<com.huawei.hms.framework.network.grs.g.d> a() {
        return this.f4733a;
    }

    public b(Future<com.huawei.hms.framework.network.grs.g.d> future) {
        this.f4733a = future;
    }
}
