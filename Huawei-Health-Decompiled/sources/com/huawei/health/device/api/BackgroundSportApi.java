package com.huawei.health.device.api;

import com.huawei.health.IBaseCommonCallback;
import com.huawei.hihealth.StartSportParam;

/* JADX INFO: loaded from: classes4.dex */
public interface BackgroundSportApi {
    void pauseSportEnhance(IBaseCommonCallback iBaseCommonCallback);

    void resumeSportEnhance(IBaseCommonCallback iBaseCommonCallback);

    void sendDeviceControlinstruction(String str, IBaseCommonCallback iBaseCommonCallback);

    void startSportEnhance(StartSportParam startSportParam, IBaseCommonCallback iBaseCommonCallback);

    void stopSportEnhance(IBaseCommonCallback iBaseCommonCallback);
}
