package com.huawei.openalliance.ad.media.listener;

/* JADX INFO: loaded from: classes11.dex */
public interface ILinkedMediaStateListener {
    void onMediaCompletion(int i);

    void onMediaError(int i, int i2, int i3);

    void onMediaPause(int i);

    void onMediaProgress(int i, int i2);

    void onMediaStart(int i);

    void onMediaStop(int i);
}
