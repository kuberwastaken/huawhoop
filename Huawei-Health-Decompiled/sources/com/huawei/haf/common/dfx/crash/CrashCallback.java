package com.huawei.haf.common.dfx.crash;

/* JADX INFO: loaded from: classes.dex */
public interface CrashCallback {
    void handleCrash(Thread thread, Throwable th);

    boolean isAllowRethrow();

    boolean isAllowSelfKill();
}
