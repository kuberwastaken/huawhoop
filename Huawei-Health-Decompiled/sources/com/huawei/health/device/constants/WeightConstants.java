package com.huawei.health.device.constants;

/* JADX INFO: loaded from: classes4.dex */
public class WeightConstants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double[] f2268a = {50.0d, 100.0d};

    public enum FragmentType {
        DEVICE_BIND_WAITING,
        DEVICE_BIND_WAITING_UNIVERSAL,
        WIFI_PRODUCT_INTRODUCTION,
        HAGRID_DEVICE_MANAGER,
        HAGRID_DEVICE_BIND_GUID,
        HONOUR_DEVICE
    }

    public static double[] a() {
        return (double[]) f2268a.clone();
    }
}
