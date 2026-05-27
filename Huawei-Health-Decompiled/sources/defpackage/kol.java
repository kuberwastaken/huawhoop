package defpackage;

import com.huawei.pluginhealthzone.interactors.HealthZonePushReceiver;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class kol {
    private static HashMap<String, Integer> e = new HashMap<>(0);

    public static Map<String, Integer> d() {
        if (e.isEmpty()) {
            e.put("1", 0);
            e.put(HealthZonePushReceiver.CYCLE_BLOOD_OXYGEN_NOTIFY, 0);
            e.put("2", 1);
            e.put("3", 1);
            e.put("4", 1);
            e.put("6", 1);
            e.put("7", 1);
            e.put(HealthZonePushReceiver.BODY_TEMPERATURE_HIGH_NOTIFY, 1);
            e.put(HealthZonePushReceiver.BODY_TEMPERATURE_LOW_NOTIFY, 1);
            e.put(HealthZonePushReceiver.DATA_POST_COMMENTS_NOTIFY, 1);
            e.put(HealthZonePushReceiver.COMMENT_FAILED_NOTIFY, 1);
            e.put("8", 2);
            e.put("75", 2);
            e.put("12", 3);
            e.put("13", 3);
            e.put("14", 3);
            e.put("18", 3);
            e.put("39", 3);
            e.put(HealthZonePushReceiver.FAMILY_CARE_NOTIFY, 3);
            e.put("15", 4);
            e.put("16", 4);
            e.put("17", 4);
            e.put(HealthZonePushReceiver.SOS_LOCATION_NOTIFY, 4);
            e.put("42", 4);
            e.put("25", 6);
            e.put(HealthZonePushReceiver.SLEEP_TIME_NOTIFY, 6);
            e.put("46", 7);
            e.put("47", 8);
            e.put("19", 13);
            e.put(HealthZonePushReceiver.DEAUTH_EVENT_NOTIFY, 13);
            e.put("21", 13);
            e.put("22", 13);
            e.put("23", 13);
            e.put(HealthZonePushReceiver.ECG_MEASUREMENT_ABNORMAL, 13);
            e.put("44", 13);
            e.put("76", 13);
            e.put("53", 15);
            e.put("11", 18);
            e.put("68", 18);
            e.put("69", 18);
            e.put("73", 18);
            e.put("74", 18);
            e.put("26", 19);
            e.put("24", 32);
            e.put(HealthZonePushReceiver.SLEEP_SCORE_NOTIFY, 33);
            e.put("31", 34);
            e.put(HealthZonePushReceiver.PRESSURE_NOTIFY, 35);
        }
        return e;
    }
}
