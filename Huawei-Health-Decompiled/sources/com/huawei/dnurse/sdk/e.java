package com.huawei.dnurse.sdk;

/* JADX INFO: loaded from: classes3.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DnurseDeviceTest f2001a;

    @Override // java.lang.Runnable
    public void run() {
        DnurseDeviceTest dnurseDeviceTest;
        int i;
        switch (this.f2001a.f) {
            case 1:
                if (!this.f2001a.H.f1994a) {
                    dnurseDeviceTest = this.f2001a;
                    i = 14;
                } else if (this.f2001a.G.b()) {
                    dnurseDeviceTest = this.f2001a;
                    i = 15;
                }
                dnurseDeviceTest.b(i);
            case 2:
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                dnurseDeviceTest = this.f2001a;
                i = 17;
                dnurseDeviceTest.b(i);
            default:
                return;
        }
        dnurseDeviceTest = this.f2001a;
        i = 16;
        dnurseDeviceTest.b(i);
    }

    e(DnurseDeviceTest dnurseDeviceTest) {
        this.f2001a = dnurseDeviceTest;
    }
}
