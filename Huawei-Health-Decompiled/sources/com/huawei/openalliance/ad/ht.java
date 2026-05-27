package com.huawei.openalliance.ad;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class ht extends ho {
    private final hv b;
    private final Executor c = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.huawei.openalliance.ad.utils.o("PPS-FileLog"));

    @Override // com.huawei.openalliance.ad.hv
    public void a(final hx hxVar, final int i, final String str) {
        this.c.execute(new Runnable() { // from class: com.huawei.openalliance.ad.ht.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ht.this.b.a(hxVar, i, str);
                } catch (Throwable th) {
                    Log.w("HiAdLog", "log err: " + th.getClass().getSimpleName());
                }
            }
        });
        if (this.f7165a != null) {
            this.f7165a.a(hxVar, i, str);
        }
    }

    @Override // com.huawei.openalliance.ad.hv
    public hv a(final String str, final String str2) {
        this.c.execute(new Runnable() { // from class: com.huawei.openalliance.ad.ht.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ht.this.b.a(str, str2);
                } catch (Throwable th) {
                    Log.w("HiAdLog", "init err: " + th.getClass().getSimpleName());
                }
            }
        });
        if (this.f7165a != null) {
            this.f7165a.a(str, str2);
        }
        return this;
    }

    public ht(hv hvVar) {
        this.b = hvVar;
    }
}
