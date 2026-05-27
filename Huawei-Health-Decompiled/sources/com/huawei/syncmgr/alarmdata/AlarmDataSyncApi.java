package com.huawei.syncmgr.alarmdata;

import com.huawei.health.devicemgr.business.entity.DeviceInfo;

/* JADX INFO: loaded from: classes7.dex */
public interface AlarmDataSyncApi {
    void startSyncHeartRateAlarm(DeviceInfo deviceInfo);

    void startSyncLowSpo2Alarm(DeviceInfo deviceInfo);
}
