package com.huawei.maps.offlinedata.service.device.tlvtools;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f6731a;

    public static int a() {
        int i;
        synchronized (b.class) {
            int i2 = f6731a + 1;
            f6731a = i2;
            i = i2 % 10000;
            f6731a = i;
        }
        return i;
    }
}
