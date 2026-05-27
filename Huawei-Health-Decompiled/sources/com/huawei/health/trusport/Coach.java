package com.huawei.health.trusport;

/* JADX INFO: loaded from: classes5.dex */
public class Coach {
    public static native int[] runningPerformancePrediction(double d);

    static {
        System.loadLibrary("racepredict");
    }
}
