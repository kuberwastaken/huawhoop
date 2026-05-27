package com.huawei.openalliance.ad;

/* JADX INFO: loaded from: classes6.dex */
public class hb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ha f7143a;
    private static final byte[] b = new byte[0];

    public static void a(String str) {
        synchronized (b) {
            hq.a("LinkedAdConfigurationDataShare", "set soundSwitch for linked");
            ha haVar = f7143a;
            if (haVar == null) {
                return;
            }
            haVar.a(str);
        }
    }

    public static void a(ha haVar) {
        synchronized (b) {
            if (haVar == null) {
                hq.a("LinkedAdConfigurationDataShare", "set linked ad from linked");
                f7143a = null;
            } else {
                f7143a = haVar;
            }
        }
    }

    public static ha a() {
        ha haVar;
        synchronized (b) {
            hq.a("LinkedAdConfigurationDataShare", "get linked ad from linked");
            haVar = f7143a;
        }
        return haVar;
    }
}
