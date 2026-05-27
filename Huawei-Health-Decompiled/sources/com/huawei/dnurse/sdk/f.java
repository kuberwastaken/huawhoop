package com.huawei.dnurse.sdk;

import java.util.TimerTask;

/* JADX INFO: loaded from: classes3.dex */
class f extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DnurseDeviceTest f2002a;

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f2002a.f == 7) {
            DnurseDeviceTest.k(this.f2002a);
            if (this.f2002a.D <= 0) {
                this.f2002a.L.cancel();
                this.f2002a.a(3000);
            } else {
                this.f2002a.J.onMeasuring(this.f2002a.f, this.f2002a.D);
            }
        }
    }

    f(DnurseDeviceTest dnurseDeviceTest) {
        this.f2002a = dnurseDeviceTest;
    }
}
