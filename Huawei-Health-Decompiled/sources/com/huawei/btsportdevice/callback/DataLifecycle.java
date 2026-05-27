package com.huawei.btsportdevice.callback;

/* JADX INFO: loaded from: classes3.dex */
public interface DataLifecycle {
    void init();

    void onDestroy();

    void onPause();

    void onResume();

    void onStart();
}
