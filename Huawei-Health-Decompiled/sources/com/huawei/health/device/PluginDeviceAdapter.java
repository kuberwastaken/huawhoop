package com.huawei.health.device;

import android.content.Context;
import com.huawei.btsportdevice.callback.DataLifecycle;
import com.huawei.pluginbase.PluginBaseAdapter;

/* JADX INFO: loaded from: classes4.dex */
public interface PluginDeviceAdapter extends PluginBaseAdapter {
    void checkAutoTrackStatus();

    void deviceToSportStrack(Context context);

    void registerStatusFromService(DataLifecycle dataLifecycle);

    void unregisterStatusFromService();
}
