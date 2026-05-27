package com.huawei.dnurse.sdk;

/* JADX INFO: loaded from: classes3.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DnurseDeviceTest f1999a;

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1999a.f != 0) {
            if (!this.f1999a.G.a().booleanValue()) {
                this.f1999a.K.postDelayed(this.f1999a.b, this.f1999a.q);
                return;
            }
            this.f1999a.b(0);
            if (this.f1999a.B) {
                this.f1999a.wakeupDevice();
            }
        }
    }

    c(DnurseDeviceTest dnurseDeviceTest) {
        this.f1999a = dnurseDeviceTest;
    }
}
