package com.huawei.btsportdevice.callback;

import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public interface CallbackBetweenClientAndController {
    void notifyDataChange(int i, Bundle bundle);

    void notifyStateChanged(String str);

    void onDisconnect();

    void onStopByUser();

    void setBreakBySelf(boolean z);
}
