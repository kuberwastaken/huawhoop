package com.huawei.openalliance.ad;

/* JADX INFO: loaded from: classes6.dex */
public class ox {
    public static boolean a() {
        try {
            Class.forName("com.huawei.hms.pps.HwPPS");
            Class.forName("com.huawei.hmf.tasks.Task");
            return true;
        } catch (Throwable unused) {
            hq.c("HMSConnectProcessor", "check hms sdk available error");
            return false;
        }
    }
}
