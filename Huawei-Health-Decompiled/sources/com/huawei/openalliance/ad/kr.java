package com.huawei.openalliance.ad;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public abstract class kr<P> implements ku<P> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f7406a;

    protected abstract String a(P p);

    @Override // com.huawei.openalliance.ad.ku
    public String a(P p, kq kqVar) {
        if (kqVar != null) {
            kqVar.a(p);
        }
        return a(p);
    }

    public kr(Context context) {
        this.f7406a = context;
    }
}
