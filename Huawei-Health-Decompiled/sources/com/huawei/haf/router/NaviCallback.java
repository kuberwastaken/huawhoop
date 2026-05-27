package com.huawei.haf.router;

/* JADX INFO: loaded from: classes.dex */
public interface NaviCallback {
    void onArrival(Guidepost guidepost);

    default void onFound(Guidepost guidepost) {
    }

    default void onInterrupt(Guidepost guidepost) {
    }

    default void onLost(Guidepost guidepost) {
    }
}
