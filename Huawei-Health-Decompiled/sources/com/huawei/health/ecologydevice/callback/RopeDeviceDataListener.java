package com.huawei.health.ecologydevice.callback;

/* JADX INFO: loaded from: classes4.dex */
public interface RopeDeviceDataListener {
    void onNewBatteryState();

    void onNewDeviceInfo();

    void onNewDeviceState();

    void onNewLastRope();

    void onQuaryTrackDetailDataSuccess();

    void onReverseControl();

    void onRopeConfigSetting();

    void onRopeConfigSwitch();

    void onRopeMonthDataSuccess();

    void onRopeSportStatusChange(int i);

    void onSetDefaultValue();

    void onSetRopeMode();
}
