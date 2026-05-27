package com.huawei.openalliance.ad;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public abstract class kw<R> implements ld<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7408a;

    protected abstract R a(String str);

    @Override // com.huawei.openalliance.ad.ld
    public R a(int i, InputStream inputStream, long j, kq kqVar) throws IOException {
        String strA = com.huawei.openalliance.ad.utils.dc.a(inputStream);
        this.f7408a = System.currentTimeMillis();
        R rA = a(strA);
        if (kqVar != null) {
            kqVar.a(rA);
        }
        return rA;
    }

    @Override // com.huawei.openalliance.ad.ld
    public long a() {
        return this.f7408a;
    }
}
