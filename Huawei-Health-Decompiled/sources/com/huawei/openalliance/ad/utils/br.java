package com.huawei.openalliance.ad.utils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class br {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ao f7929a;

    public static void a(String str) {
        f7929a.a(str);
    }

    public static void a(Runnable runnable, String str, long j) {
        f7929a.a(runnable, str, j);
    }

    public static void a(Runnable runnable, long j) {
        f7929a.a(runnable, null, j);
    }

    public static void a(Runnable runnable) {
        f7929a.a(runnable);
    }

    static {
        ao aoVar = new ao("pps-msg-queue");
        f7929a = aoVar;
        aoVar.a();
    }
}
