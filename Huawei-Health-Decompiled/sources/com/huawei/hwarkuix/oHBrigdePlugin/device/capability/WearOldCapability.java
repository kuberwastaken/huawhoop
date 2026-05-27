package com.huawei.hwarkuix.oHBrigdePlugin.device.capability;

import com.huawei.health.devicemgr.business.entity.DeviceCapability;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class WearOldCapability {
    private static final Map<String, IGetCapability> getCapabilityHashMap = new HashMap<String, IGetCapability>() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability.1
        {
            put("5.1.9", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda0
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportAutoLightScreen();
                }
            });
            put("5.1.13", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda2
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isFactoryReset();
                }
            });
            put("5.1.18", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda14
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportHeartRate();
                }
            });
            put("5.1.26", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda26
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportLeftRightHandWearMode();
                }
            });
            put("5.1.27", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda38
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportRotateSwitchScreen();
                }
            });
            put("5.1.41", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda39
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportRemoteCamera();
                }
            });
            put("5.1.43", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda40
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportAppId();
                }
            });
            put("5.1.47", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda41
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportSyncWifi();
                }
            });
            put("5.2.1", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda42
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isMessageAlert();
                }
            });
            put("5.2.4", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda43
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportMessageAlertInfo();
                }
            });
            put("5.3.1", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda11
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isContacts();
                }
            });
            put("5.7.3", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda22
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportSportTotal();
                }
            });
            put("5.7.7", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda33
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isActivityReminder();
                }
            });
            put("5.7.14", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda44
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportThreshold();
                }
            });
            put("5.7.19", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda45
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportHeartRateZone();
                }
            });
            put("5.7.22", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda46
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportCoreSleep();
                }
            });
            put("5.7.23", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda47
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportHeartRateEnable();
                }
            });
            put("5.7.24", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda48
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportSendCoreSleepOutState();
                }
            });
            put("5.7.27", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda49
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportQueryDeviceCoreSleepSwitch();
                }
            });
            put("5.7.28", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda1
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportContinueHeartRate();
                }
            });
            put("5.7.29", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda3
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportHeartRateRaiseAlarm();
                }
            });
            put("5.7.30", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda4
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportGetHeartRateRaiseAlarmNumber();
                }
            });
            put("5.7.33", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda5
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.getIsSupportHrrHeartRateCapability();
                }
            });
            put("5.7.34", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda6
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportHeartRateDownAlarm();
                }
            });
            put("5.7.35", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda7
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportRestHeartRateControls();
                }
            });
            put("5.7.36", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda8
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportCycleBloodOxygenSwitch();
                }
            });
            put("5.7.37", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda9
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportBloodOxygenDownRemind();
                }
            });
            put("5.8.1", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda10
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isEventAlarm();
                }
            });
            put("5.8.2", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda12
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSmartAlarm();
                }
            });
            put("5.9.1", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda13
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isOtaUpdate();
                }
            });
            put("5.11.3", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda15
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isBluetoothOffAlert();
                }
            });
            put("5.15.1", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda16
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isWeatherPush();
                }
            });
            put("5.15.8", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda17
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isWeatherSupportFutureInfo();
                }
            });
            put("5.15.11", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda18
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportTide();
                }
            });
            put("5.25.1", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda19
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportHeartRateInfo();
                }
            });
            put("5.26.7", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda20
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportSyncAccount();
                }
            });
            put("5.29.1", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda21
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportEsim();
                }
            });
            put("5.29.10", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda23
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportNewEsim();
                }
            });
            put("5.32.9", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda24
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportPressAutoMonitor();
                }
            });
            put("5.35.11", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda25
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportEcgAuth();
                }
            });
            put("5.37.2", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda27
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportMusicControl();
                }
            });
            put("5.37.4", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda28
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportMusicInfoList();
                }
            });
            put("5.39.1", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda29
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportWatchFace();
                }
            });
            put("5.42.1", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda30
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportMarketFace();
                }
            });
            put("5.42.6", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda31
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportMarketParams();
                }
            });
            put("5.50.1", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda32
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportMenstrual();
                }
            });
            put("5.51.1", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda34
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportSosTransmission();
                }
            });
            put("5.27.1", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda35
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportPay();
                }
            });
            put("5.27.25", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda36
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isSupportWalletOpenCard();
                }
            });
            put("5.27.26", new IGetCapability() { // from class: com.huawei.hwarkuix.oHBrigdePlugin.device.capability.WearOldCapability$1$$ExternalSyntheticLambda37
                @Override // com.huawei.hwarkuix.oHBrigdePlugin.device.capability.IGetCapability
                public final boolean getWearCapability(DeviceCapability deviceCapability) {
                    return deviceCapability.isHideWalletEntrance();
                }
            });
        }
    };

    public static boolean getWearCapability(String str, DeviceCapability deviceCapability) {
        IGetCapability iGetCapability = getCapabilityHashMap.get(str);
        if (iGetCapability != null) {
            return iGetCapability.getWearCapability(deviceCapability);
        }
        return false;
    }
}
