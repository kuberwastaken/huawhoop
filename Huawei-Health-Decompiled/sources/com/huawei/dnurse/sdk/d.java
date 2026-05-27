package com.huawei.dnurse.sdk;

/* JADX INFO: loaded from: classes3.dex */
class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DnurseDeviceTest f2000a;

    @Override // java.lang.Runnable
    public void run() {
        this.f2000a.H.c();
        DnurseDeviceTest dnurseDeviceTest = this.f2000a;
        dnurseDeviceTest.a(dnurseDeviceTest.n);
    }

    d(DnurseDeviceTest dnurseDeviceTest) {
        this.f2000a = dnurseDeviceTest;
    }
}
