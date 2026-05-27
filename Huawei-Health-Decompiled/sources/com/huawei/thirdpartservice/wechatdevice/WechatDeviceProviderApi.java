package com.huawei.thirdpartservice.wechatdevice;

import android.content.Context;
import com.huawei.health.devicemgr.business.entity.DeviceInfo;

/* JADX INFO: loaded from: classes7.dex */
public interface WechatDeviceProviderApi {

    public interface CheckResultListener<T> {
        void onError(int i, String str);

        void onResult(T t);
    }

    void bindWechat(Context context, DeviceInfo deviceInfo);

    void checkSupportWechatDevice(DeviceInfo deviceInfo, CheckResultListener<Boolean> checkResultListener);

    void destroy();

    void isBindMaxCount(CheckResultListener<Boolean> checkResultListener);

    void isBindWechat(DeviceInfo deviceInfo, CheckResultListener<Boolean> checkResultListener);

    void jumpToWechatDeviceActivity(Context context);
}
