package com.huawei.openalliance.ad;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public abstract class sk implements sw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f7792a;
    private fw b;

    @Override // com.huawei.openalliance.ad.sw
    public void c() {
    }

    @Override // com.huawei.openalliance.ad.sw
    public void d() {
    }

    public void a(long j) {
        this.b.a(com.huawei.openalliance.ad.utils.ar.c() - j, a());
    }

    public sk(Context context) {
        this.f7792a = context.getApplicationContext();
        this.b = ey.a(context);
    }
}
