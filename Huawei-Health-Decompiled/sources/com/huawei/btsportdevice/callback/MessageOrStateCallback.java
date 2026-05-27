package com.huawei.btsportdevice.callback;

import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public interface MessageOrStateCallback {
    void onNewMessage(int i, Bundle bundle);

    void onStateChange(String str);
}
