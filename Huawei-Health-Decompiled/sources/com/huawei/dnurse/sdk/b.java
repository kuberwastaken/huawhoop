package com.huawei.dnurse.sdk;

/* JADX INFO: loaded from: classes3.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DnurseDeviceTest f1998a;

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1998a.G.a().booleanValue()) {
            this.f1998a.b();
        } else {
            this.f1998a.K.postDelayed(this.f1998a.f1993a, this.f1998a.o);
        }
    }

    b(DnurseDeviceTest dnurseDeviceTest) {
        this.f1998a = dnurseDeviceTest;
    }
}
