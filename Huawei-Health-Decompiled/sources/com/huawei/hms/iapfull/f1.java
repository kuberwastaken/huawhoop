package com.huawei.hms.iapfull;

import android.app.Activity;
import android.widget.Toast;

/* JADX INFO: loaded from: classes5.dex */
class f1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f4894a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;

    @Override // java.lang.Runnable
    public void run() {
        Activity activity = this.f4894a;
        Toast.makeText(activity, activity.getResources().getString(this.b), this.c).show();
    }

    f1(Activity activity, int i, int i2) {
        this.f4894a = activity;
        this.b = i;
        this.c = i2;
    }
}
