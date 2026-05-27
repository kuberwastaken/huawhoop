package com.huawei.devicefeature;

import com.huawei.health.devicemgr.business.entity.DeviceInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface DeviceFeatureSupportApi {

    public interface ServiceSupportCallBack {
        void onResult(String str);
    }

    boolean isActivityReminder(DeviceInfo deviceInfo);

    boolean isEnableNMPA(DeviceInfo deviceInfo);

    void isServiceSupport(DeviceInfo deviceInfo, ServiceSupportCallBack serviceSupportCallBack);

    void isSupportAPPMarket(DeviceInfo deviceInfo, FeatureSupportCallback featureSupportCallback);

    boolean isSupportAlarm(DeviceInfo deviceInfo);

    boolean isSupportArrhythmia(DeviceInfo deviceInfo);

    void isSupportBaidouSatellite(DeviceInfo deviceInfo, FeatureSupportCallback featureSupportCallback);

    boolean isSupportBloodOxygen(DeviceInfo deviceInfo);

    boolean isSupportBloodPressure(DeviceInfo deviceInfo);

    boolean isSupportCamera(DeviceInfo deviceInfo);

    boolean isSupportCmccAi(DeviceInfo deviceInfo);

    boolean isSupportContactDataSync(DeviceInfo deviceInfo);

    boolean isSupportContacts(DeviceInfo deviceInfo);

    boolean isSupportEarphoneManager(DeviceInfo deviceInfo);

    boolean isSupportEmotionPressure(DeviceInfo deviceInfo);

    boolean isSupportEsim(DeviceInfo deviceInfo);

    void isSupportExclusiveGuardian(DeviceInfo deviceInfo, FeatureSupportCallback featureSupportCallback);

    boolean isSupportExclusiveGuardianFromLocal(DeviceInfo deviceInfo);

    boolean isSupportFamilyHeart(DeviceInfo deviceInfo);

    boolean isSupportFindDevice(DeviceInfo deviceInfo);

    boolean isSupportGolf(DeviceInfo deviceInfo);

    void isSupportHealthCalendarSync(DeviceInfo deviceInfo, FeatureSupportCallback featureSupportCallback);

    boolean isSupportHealthMonitoring(DeviceInfo deviceInfo);

    boolean isSupportHeart(DeviceInfo deviceInfo);

    boolean isSupportHeartIndex(DeviceInfo deviceInfo);

    boolean isSupportHelp(DeviceInfo deviceInfo);

    boolean isSupportHiResearch(DeviceInfo deviceInfo);

    boolean isSupportHighMonitoring(DeviceInfo deviceInfo);

    boolean isSupportIntelligentHomeLinkage(DeviceInfo deviceInfo);

    boolean isSupportKeepAlive(DeviceInfo deviceInfo);

    boolean isSupportMessageAlert(DeviceInfo deviceInfo);

    boolean isSupportMicroWorkout(DeviceInfo deviceInfo);

    boolean isSupportMusic(DeviceInfo deviceInfo);

    boolean isSupportMyWatchFace(DeviceInfo deviceInfo);

    boolean isSupportNewEsim(DeviceInfo deviceInfo);

    boolean isSupportNotificationLive(DeviceInfo deviceInfo);

    boolean isSupportOfflineMap(DeviceInfo deviceInfo);

    boolean isSupportPhysiological(DeviceInfo deviceInfo);

    boolean isSupportPressure(DeviceInfo deviceInfo);

    boolean isSupportQuickAPPEcg(DeviceInfo deviceInfo);

    boolean isSupportQuickAPPEcgAnalysic(DeviceInfo deviceInfo);

    boolean isSupportQuickReplySms(DeviceInfo deviceInfo);

    boolean isSupportSleep(DeviceInfo deviceInfo);

    boolean isSupportSleepBreathe(DeviceInfo deviceInfo);

    boolean isSupportStudentInfo(DeviceInfo deviceInfo);

    boolean isSupportTemperature(DeviceInfo deviceInfo);

    boolean isSupportVascularElasticity(DeviceInfo deviceInfo);

    void isSupportWallet(DeviceInfo deviceInfo, FeatureSupportCallback featureSupportCallback);

    boolean isSupportWatchFaceMarket(DeviceInfo deviceInfo);

    boolean isSupportWeatherPush(DeviceInfo deviceInfo);

    void isSupportWechatBind(DeviceInfo deviceInfo, FeatureSupportCallback featureSupportCallback);

    boolean isSupportWheelchair(DeviceInfo deviceInfo);
}
