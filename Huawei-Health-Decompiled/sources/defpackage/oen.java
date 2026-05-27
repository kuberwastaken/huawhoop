package defpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class oen {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f16325a;
    public static final Map<String, String> b;
    public static final Map<String, String> c;
    public static final Map<String, String> d;
    public static final Map<String, String> e;

    static {
        HashMap map = new HashMap();
        map.put("HDK_WEIGHT", "bodyFatScales");
        map.put("HDK_BLOOD_SUGAR", "bloodSugarMonitor");
        map.put("HDK_BLOOD_PRESSURE", "bloodPressureMeter");
        map.put("HDK_HEART_RATE", "heartRateMonitor");
        map.put("HDK_BODY_TEMPERATURE", "temperatureMonitor");
        map.put("HDK_BLOOD_OXYGEN", "bloopOxygenMonitor");
        map.put("HDK_ROPE_SKIPPING", "ropeSkippingMonitor");
        map.put("HDK_TREADMILL", "sportTreadmillMonitor");
        map.put("HDK_EXERCISE_BIKE", "sportExerciseBikeMonitor");
        map.put("HDK_ROWING_MACHINE", "sportRowingMachineMonitor");
        map.put("HDK_ELLIPTICAL_MACHINE", "ellipticalMachineMonitor");
        map.put("HDK_WALKING_MACHINE", "sportWalkingMachineMonitor");
        map.put("HDK_SMART_WATCH", "thirdWatchMonitor");
        map.put("HDK_ECG", "ecgMonitor");
        map.put("HDK_SMART_PILLOW", "smartPillowMonitor");
        map.put("HDK_MASSAGE_GUN", "fasciaGunMonitor");
        map.put("HDK_VENTILATOR", "Ventilator");
        map.put("SMART_HEADPHONES", "smartHeadphones");
        e = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("HDK_WEIGHT", "bodyFat_index_0");
        map2.put("HDK_BLOOD_SUGAR", "bloodSugar_index_0");
        map2.put("HDK_BLOOD_PRESSURE", "bloodPressure_index_0");
        map2.put("HDK_HEART_RATE", "heartRate_index_0");
        map2.put("HDK_BODY_TEMPERATURE", "temperature_index_0");
        map2.put("HDK_BLOOD_OXYGEN", "bloodOxygen_index_0");
        map2.put("HDK_ROPE_SKIPPING", "ropeSkipping_index_0");
        map2.put("HDK_TREADMILL", "treadmill_index_0");
        map2.put("HDK_EXERCISE_BIKE", "exerciseBike_index_0");
        map2.put("HDK_ROWING_MACHINE", "rowingMachine_index_0");
        map2.put("HDK_ELLIPTICAL_MACHINE", "elliptical_index_0");
        map2.put("HDK_WALKING_MACHINE", "walkingMachine_index_0");
        map2.put("HDK_SMART_WATCH", "thirdWatch_index_0");
        map2.put("HDK_ECG", "ecg_index_0");
        map2.put("HDK_SMART_PILLOW", "smartPillow_index_0");
        map2.put("HDK_MASSAGE_GUN", "fasciaGun_index_0");
        map2.put("HDK_VENTILATOR", "ventilator_index_1");
        map2.put("SMART_HEADPHONES", "index");
        c = Collections.unmodifiableMap(map2);
        HashMap map3 = new HashMap();
        map3.put("HDK_WEIGHT", "com.huawei.health_BodyFat_deviceConfigBeta");
        map3.put("HDK_BLOOD_SUGAR", "com.huawei.health_BloodSugar_deviceConfigBeta");
        map3.put("HDK_BLOOD_PRESSURE", "com.huawei.health_BloodPressure_deviceConfigBeta");
        map3.put("HDK_HEART_RATE", "com.huawei.health_HeartRate_deviceConfigBeta");
        map3.put("HDK_BODY_TEMPERATURE", "com.huawei.health_Temperature_deviceConfigBeta");
        map3.put("HDK_BLOOD_OXYGEN", "com.huawei.health_BloodOxygen_deviceConfigBeta");
        map3.put("HDK_ROPE_SKIPPING", "com.huawei.health_Rope_deviceConfigBeta");
        map3.put("HDK_TREADMILL", "com.huawei.health_Treadmill_deviceConfigBeta");
        map3.put("HDK_EXERCISE_BIKE", "com.huawei.health_ExerciseBike_deviceConfigBeta");
        map3.put("HDK_ROWING_MACHINE", "com.huawei.health_RowingMachine_deviceConfigBeta");
        map3.put("HDK_ELLIPTICAL_MACHINE", "com.huawei.health_Elliptical_deviceConfigBeta");
        map3.put("HDK_WALKING_MACHINE", "com.huawei.health_WalkingMachine_deviceConfigBeta");
        map3.put("HDK_SMART_WATCH", "com.huawei.health_ThirdWatch_deviceConfigBeta");
        map3.put("HDK_ECG", "com.huawei.health_Ecg_deviceConfigBeta");
        map3.put("HDK_SMART_PILLOW", "com.huawei.health_SmartPillow_deviceConfigBeta");
        map3.put("HDK_MASSAGE_GUN", "com.huawei.health_FasciaGun_deviceConfigBeta");
        map3.put("HDK_VENTILATOR", "com.huawei.health_Ventilator_deviceConfigBeta");
        map3.put("SMART_HEADPHONES", "com.huawei.health_HwWear_deviceConfigBeta");
        b = Collections.unmodifiableMap(map3);
        HashMap map4 = new HashMap();
        map4.put("HDK_WEIGHT", "com.huawei.health_BodyFat_deviceConfig");
        map4.put("HDK_BLOOD_SUGAR", "com.huawei.health_BloodSugar_deviceConfig");
        map4.put("HDK_BLOOD_PRESSURE", "com.huawei.health_BloodPressure_deviceConfig");
        map4.put("HDK_HEART_RATE", "com.huawei.health_HeartRate_deviceConfig");
        map4.put("HDK_BODY_TEMPERATURE", "com.huawei.health_Temperature_deviceConfig");
        map4.put("HDK_BLOOD_OXYGEN", "com.huawei.health_BloodOxygen_deviceConfig");
        map4.put("HDK_ROPE_SKIPPING", "com.huawei.health_Rope_deviceConfig");
        map4.put("HDK_TREADMILL", "com.huawei.health_Treadmill_deviceConfig");
        map4.put("HDK_EXERCISE_BIKE", "com.huawei.health_ExerciseBike_deviceConfig");
        map4.put("HDK_ROWING_MACHINE", "com.huawei.health_RowingMachine_deviceConfig");
        map4.put("HDK_ELLIPTICAL_MACHINE", "com.huawei.health_Elliptical_deviceConfig");
        map4.put("HDK_WALKING_MACHINE", "com.huawei.health_WalkingMachine_deviceConfig");
        map4.put("HDK_SMART_WATCH", "com.huawei.health_ThirdWatch_deviceConfig");
        map4.put("HDK_ECG", "com.huawei.health_Ecg_deviceConfig");
        map4.put("HDK_SMART_PILLOW", "com.huawei.health_SmartPillow_deviceConfig");
        map4.put("HDK_MASSAGE_GUN", "com.huawei.health_FasciaGun_deviceConfig");
        map4.put("HDK_VENTILATOR", "com.huawei.health_Ventilator_deviceConfig");
        map4.put("SMART_HEADPHONES", "com.huawei.health_HwWear_deviceBeta");
        d = Collections.unmodifiableMap(map4);
        HashMap map5 = new HashMap();
        map5.put("HDK_WEIGHT", "deviceType=bodyFatScales");
        map5.put("HDK_BLOOD_SUGAR", "deviceType=bloodSugarMonitor");
        map5.put("HDK_BLOOD_PRESSURE", "deviceType=bloodPressureMeter");
        map5.put("HDK_HEART_RATE", "deviceType=heartRateMonitor");
        map5.put("HDK_BODY_TEMPERATURE", "deviceType=temperatureMonitor");
        map5.put("HDK_BLOOD_OXYGEN", "deviceType=bloopOxygenMonitor");
        map5.put("HDK_ROPE_SKIPPING", "deviceType=ropeSkippingMonitor");
        map5.put("HDK_TREADMILL", "deviceType=sportTreadmillMonitor");
        map5.put("HDK_EXERCISE_BIKE", "deviceType=sportExerciseBikeMonitor");
        map5.put("HDK_ROWING_MACHINE", "deviceType=sportRowingMachineMonitor");
        map5.put("HDK_ELLIPTICAL_MACHINE", "deviceType=ellipticalMachineMonitor");
        map5.put("HDK_WALKING_MACHINE", "deviceType=sportWalkingMachineMonitor");
        map5.put("HDK_ECG", "deviceType=ecgMonitor");
        map5.put("HDK_SMART_WATCH", "deviceType=thirdWatchMonitor");
        map5.put("HDK_SMART_PILLOW", "deviceType=smartPillowMonitor");
        map5.put("HDK_MASSAGE_GUN", "deviceType=fasciaGunMonitor");
        map5.put("HDK_VENTILATOR", "deviceType=Ventilator");
        map5.put("SMART_HEADPHONES", "deviceType=smartHeadphones");
        f16325a = Collections.unmodifiableMap(map5);
    }

    public static String e(String str) {
        Map<String, String> map = f16325a;
        return map.containsKey(str) ? map.get(str) : "";
    }
}
