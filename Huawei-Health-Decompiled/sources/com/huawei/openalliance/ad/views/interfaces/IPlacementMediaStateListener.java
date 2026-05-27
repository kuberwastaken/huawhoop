package com.huawei.openalliance.ad.views.interfaces;

/* JADX INFO: loaded from: classes6.dex */
public interface IPlacementMediaStateListener {
    void onErrorWithContentId(int i, int i2, int i3, String str);

    void onMediaCompletion(int i);

    void onMediaError(int i, int i2, int i3);

    void onMediaPause(int i);

    void onMediaProgress(int i, int i2);

    void onMediaStart(int i);

    void onMediaStop(int i);
}
