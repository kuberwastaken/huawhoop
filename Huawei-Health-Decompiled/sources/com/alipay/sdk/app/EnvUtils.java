package com.alipay.sdk.app;

/* JADX INFO: loaded from: classes9.dex */
public class EnvUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static EnvEnum f774a = EnvEnum.ONLINE;

    public enum EnvEnum {
        ONLINE,
        PRE_SANDBOX,
        SANDBOX
    }

    public static boolean a() {
        return f774a == EnvEnum.SANDBOX;
    }

    public static boolean c() {
        return d() || a();
    }

    public static boolean d() {
        return f774a == EnvEnum.PRE_SANDBOX;
    }
}
