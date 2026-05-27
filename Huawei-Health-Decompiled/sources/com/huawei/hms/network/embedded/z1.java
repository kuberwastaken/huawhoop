package com.huawei.hms.network.embedded;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes10.dex */
public class z1 extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PackageManager f5776a;

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        PackageManager packageManager = this.f5776a;
        if (packageManager != null) {
            return packageManager;
        }
        a2 a2Var = new a2(getBaseContext());
        this.f5776a = a2Var;
        return a2Var;
    }

    public z1(Context context) {
        super(context);
    }
}
