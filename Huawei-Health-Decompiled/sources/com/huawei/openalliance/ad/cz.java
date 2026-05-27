package com.huawei.openalliance.ad;

/* JADX INFO: loaded from: classes6.dex */
public abstract class cz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private cz f6929a = null;

    public abstract boolean a();

    protected boolean b() {
        cz czVar = this.f6929a;
        if (czVar != null) {
            return czVar.a();
        }
        return false;
    }

    public void a(cz czVar) {
        this.f6929a = czVar;
    }
}
