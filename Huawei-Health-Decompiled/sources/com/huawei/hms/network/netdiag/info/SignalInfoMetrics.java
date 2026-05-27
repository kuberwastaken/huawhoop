package com.huawei.hms.network.netdiag.info;

/* JADX INFO: loaded from: classes10.dex */
public interface SignalInfoMetrics {
    int getLteCqi();

    int getLteRsrp();

    int getLteRsrq();

    int getLteRssi();

    int getLteRssnr();

    int getMobileSignalStrength();

    long getSignalTimeStamp();

    int getWifiSignalStrength();
}
