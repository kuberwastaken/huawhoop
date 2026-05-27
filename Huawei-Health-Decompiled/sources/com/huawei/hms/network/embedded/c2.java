package com.huawei.hms.network.embedded;

import org.chromium.net.CronetEngine;

/* JADX INFO: loaded from: classes10.dex */
public class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CronetEngine f5387a;
    public boolean b = false;

    public void setEnableConnectionMigrated(boolean z) {
        this.b = z;
    }

    public void setCronetEngine(CronetEngine cronetEngine) {
        this.f5387a = cronetEngine;
    }

    public boolean isEnableConnectionMigrated() {
        return this.b;
    }

    public CronetEngine getCronetEngine() {
        return this.f5387a;
    }
}
