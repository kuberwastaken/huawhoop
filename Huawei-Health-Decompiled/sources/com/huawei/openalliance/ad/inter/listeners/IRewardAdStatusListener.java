package com.huawei.openalliance.ad.inter.listeners;

/* JADX INFO: loaded from: classes6.dex */
public interface IRewardAdStatusListener {
    void onAdClicked();

    void onAdClosed();

    void onAdCompleted();

    void onAdError(int i, int i2);

    void onAdShown();

    void onRewarded();
}
