package com.huawei.hms.ads.dynamicloader;

import android.os.Bundle;

/* JADX INFO: loaded from: classes5.dex */
public final class j extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Bundle f4496a;

    private Bundle a() {
        return this.f4496a;
    }

    public j(String str, Bundle bundle) {
        super(str);
        this.f4496a = bundle;
    }

    public j(String str) {
        super(str);
    }
}
