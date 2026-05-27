package com.huawei.pluginsleepdetection;

import android.content.Context;
import com.huawei.health.h5pro.jsbridge.base.JsModuleBase;
import com.huawei.hwbasemgr.IBaseResponseCallback;

/* JADX INFO: loaded from: classes7.dex */
public interface PluginSleepDetectionApi {
    void disconnect();

    Class<? extends JsModuleBase> getJsModule();

    int getSleepTime();

    boolean isEnableRecord();

    boolean isOpenNotification();

    void sleepRecordStatus(IBaseResponseCallback iBaseResponseCallback);

    void stopSleepRecord(Context context);

    void syncSleepAlarmInfo();
}
