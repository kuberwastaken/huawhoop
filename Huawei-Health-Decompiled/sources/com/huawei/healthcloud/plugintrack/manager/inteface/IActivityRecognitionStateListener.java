package com.huawei.healthcloud.plugintrack.manager.inteface;

/* JADX INFO: loaded from: classes5.dex */
public interface IActivityRecognitionStateListener {
    String getCurrentState();

    boolean isCurrentStateIsStill();

    void onStateChange(int i);
}
