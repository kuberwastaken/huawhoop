package com.huawei.ui.homehealth.device.featureaction;

import com.huawei.pluginhealthzone.interactors.HealthZonePushReceiver;

/* JADX INFO: loaded from: classes7.dex */
public enum FeatureType {
    WATCH_FACE("1"),
    MUSIC_MENU("2"),
    DEVICE_SCAN("3"),
    DEVICE_GUIDE("4"),
    WALLET("5"),
    APP_MARKET("6"),
    PLAY_MACHINE("7"),
    MUSIC_LIST("8"),
    ALL_DEVICE("9"),
    WEATHER("10"),
    CONTACT("11"),
    CALENDAR("12"),
    QUICK_REPLY("13"),
    SATCOM_CARD("14"),
    FIND_DEVICE("15"),
    MY_WATCH_FACE("16"),
    TODO_LIST("17"),
    NOTIFICATION_SETTING("19"),
    DEVICE_SETTING(HealthZonePushReceiver.DEAUTH_EVENT_NOTIFY),
    ALARM("21"),
    OFFLINE_MAP("22"),
    SLEEP_SELECTOR("23"),
    REMINDER_SETTING("24"),
    CONTINUE_HEART_RATE("25"),
    CYCLE_CALENDAR("26"),
    GOLF(HealthZonePushReceiver.BLOOD_SUGAR_DAWN_NOTIFY),
    CAMERA("28"),
    E_SIM(HealthZonePushReceiver.SLEEP_TIME_NOTIFY),
    WECHAT_DEVICE(HealthZonePushReceiver.SLEEP_SCORE_NOTIFY),
    WATCH_FACE_DETAIL("31"),
    DEVICE_DETAIL(HealthZonePushReceiver.PRESSURE_NOTIFY),
    PRESS_MONITOR(HealthZonePushReceiver.CYCLE_BLOOD_OXYGEN_NOTIFY),
    BLOOD_PRESSURE_SETTING(HealthZonePushReceiver.BODY_TEMPERATURE_HIGH_NOTIFY),
    CYCLE_BLOOD_OXYGEN(HealthZonePushReceiver.BODY_TEMPERATURE_LOW_NOTIFY),
    TEMPERATURE_MONITOR(HealthZonePushReceiver.DATA_POST_COMMENTS_NOTIFY),
    WEIGHT_MEASURE(HealthZonePushReceiver.PROACTIVE_SHARING_NOTIFY),
    KEEP_ALIVE(HealthZonePushReceiver.FAMILY_CARE_NOTIFY),
    CONTACT_MANAGE(HealthZonePushReceiver.SOS_LOCATION_NOTIFY),
    EARPHONE("42"),
    EMOTION_MONITOR("45"),
    HIGHLAND_BLOOD_OXYGEN("46"),
    VASCULAR_ELASTICITY("48"),
    RESEARCH("49"),
    INTELLIGENT_HOME("50"),
    EXCLUSIVE_GUARD("51"),
    SLEEP_BREATHE("52"),
    ARRHYTHMIA("53"),
    FIND_HEADPHONE("54"),
    CMMCC_AI("58"),
    ECG_ANALYSIS("59"),
    ECG("60"),
    BENEFIT("61"),
    MACA_DETAIL("62"),
    SERVICE_SUPPORT("63"),
    FEEDBACK("64"),
    LOG_UPLOAD("65");

    private String mType;

    FeatureType(String str) {
        this.mType = str;
    }

    public String value() {
        return this.mType;
    }

    public static FeatureType getValue(String str) {
        for (FeatureType featureType : values()) {
            if (featureType.value().equals(str)) {
                return featureType;
            }
        }
        return null;
    }
}
