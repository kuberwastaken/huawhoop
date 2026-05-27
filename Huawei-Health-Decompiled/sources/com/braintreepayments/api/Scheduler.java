package com.braintreepayments.api;

/* JADX INFO: loaded from: classes9.dex */
public interface Scheduler {
    void runOnBackground(Runnable runnable);

    void runOnMain(Runnable runnable);
}
