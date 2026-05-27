package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hiai.awareness.AwarenessConstants;
import com.huawei.hwarkuix.oHBrigdePlugin.health.NativeInvokeHeartRateBridge;
import com.huawei.up.utils.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class jrc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Integer, String> f14398a;
    private static final Map<Integer, String> b;
    private static final Map<Integer, String> c;
    private static final Map<Integer, String> d;
    private static final Map<String, Integer> e;
    private static volatile int g;
    private static final Map<Integer, String> i;
    private static volatile int j;

    static {
        HashMap map = new HashMap();
        map.put("query_step_detail", 1);
        map.put("query_stress_detail", 1);
        map.put("query_heart_rate_detail", 1);
        map.put("delete_sample", 2);
        map.put("save_samples", 3);
        map.put("get_category", 3);
        map.put("query_new_body_thermometer", 3);
        map.put("query_oxygen_detail", 4);
        map.put("save_new_body_thermometer", 4);
        map.put("save_oxygen", 4);
        map.put("save_uric_acid", 4);
        map.put("delete_new_body_thermometer", 4);
        map.put("delete_oxygen", 4);
        map.put("delete_uric_acid", 4);
        map.put("save_osa_set", 5);
        map.put("query_osa_set", 5);
        map.put("query_osa_detail_half_hour", 5);
        map.put("save_heart_rate_detail", 6);
        map.put("save_core_sleep_session", 6);
        map.put("query_core_sleep_session", 6);
        map.put("divide_save_samples", 7);
        map.put("query_data", 7);
        map.put("save_sleep_record_score", 7);
        map.put("query_vascular_health", 8);
        map.put("query_blood_pressure", 8);
        map.put("query_convergence_core_sleep_session", 9);
        map.put("query_convergence_heart_rate_detail", 9);
        map.put("query_convergence_new_body_thermometer", 9);
        map.put("basicSportQuery", 9);
        map.put("register_data_auto_report", 9);
        map.put("unregister_data_auto_report", 9);
        map.put("query_arrhythmia", 10);
        map.put("query_blood_sugar", 10);
        map.put("query_electrocardiogram", 11);
        map.put(Constants.METHOD_GET_USER_INFO, 11);
        map.put("setUserPreference", 12);
        map.put("getUserPreference", 12);
        map.put("subscribe_data", 12);
        map.put("savePhysiologicalCycle", 13);
        map.put("queryPhysiologicalCycle", 13);
        map.put("savePhysiologicalCycleRemark", 13);
        map.put("queryPhysiologicalCycleRemark", 13);
        map.put("saveDrinkWater", 13);
        map.put("queryDrinkWater", 13);
        map.put("savePhysiologicalCycleBusiness", 13);
        map.put("queryPhysiologicalCycleBusiness", 13);
        map.put("queryCntbpPpg", 13);
        map.put("subscribe_goal_achieve", 14);
        map.put("bodyShapeAllAbility", 15);
        map.put("save_sleep_on_off_bed_record", 15);
        map.put("query_sleep_on_off_bed_record", 15);
        map.put("delete_sleep_on_off_bed_record", 15);
        map.put("delete_core_sleep_bed", 15);
        map.put("delete_core_sleep_on", 15);
        map.put("send_device_controlinstruction", 16);
        map.put("mindfulnessAllAbility", 16);
        map.put("pauseSport", 17);
        map.put("resumeSport", 17);
        map.put("syncData", 18);
        map.put("connectSportDevice", 18);
        map.put("queryTrends", 19);
        e = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put(400011975, "save_new_body_thermometer");
        map2.put(2103, "save_oxygen");
        map2.put(2109, "save_uric_acid");
        map2.put(500002, "save_osa_set");
        map2.put(22101, "save_core_sleep_session");
        map2.put(22102, "save_core_sleep_session");
        map2.put(22103, "save_core_sleep_session");
        map2.put(22104, "save_core_sleep_session");
        map2.put(22105, "save_core_sleep_session");
        map2.put(22106, "save_core_sleep_session");
        map2.put(22107, "save_core_sleep_session");
        map2.put(2002, "save_heart_rate_detail");
        map2.put(500005569, "save_sleep_record_score");
        map2.put(400018, "savePhysiologicalCycle");
        map2.put(400018283, "savePhysiologicalCycleRemark");
        map2.put(Integer.valueOf(AwarenessConstants.ERROR_UNKNOWN_CODE), "saveDrinkWater");
        map2.put(400019462, "savePhysiologicalCycleBusiness");
        map2.put(400020, "bodyShapeAllAbility");
        map2.put(500010, "save_sleep_on_off_bed_record");
        map2.put(700011, "mindfulnessAllAbility");
        b = Collections.unmodifiableMap(map2);
        HashMap map3 = new HashMap();
        map3.put(400011975, "delete_new_body_thermometer");
        map3.put(2103, "delete_oxygen");
        map3.put(2109, "delete_uric_acid");
        map3.put(400020, "bodyShapeAllAbility");
        map3.put(500010, "delete_sleep_on_off_bed_record");
        map3.put(22106, "delete_core_sleep_bed");
        map3.put(22107, "delete_core_sleep_on");
        map3.put(700011, "mindfulnessAllAbility");
        d = Collections.unmodifiableMap(map3);
        HashMap map4 = new HashMap();
        map4.put(2, "query_step_detail");
        map4.put(2002, "query_heart_rate_detail");
        map4.put(2034, "query_stress_detail");
        map4.put(400011975, "query_new_body_thermometer");
        map4.put(2103, "query_oxygen_detail");
        map4.put(500002, "query_osa_set");
        map4.put(500002656, "query_osa_detail_half_hour");
        map4.put(22100, "query_core_sleep_session");
        c = Collections.unmodifiableMap(map4);
        HashMap map5 = new HashMap();
        map5.put(700002, "query_vascular_health");
        map5.put(700003, "query_vascular_health");
        map5.put(Integer.valueOf(NativeInvokeHeartRateBridge.DATA_VASCULAR_HEALTH), "query_vascular_health");
        map5.put(500002, "query_vascular_health");
        map5.put(500002656, "query_vascular_health");
        map5.put(10002, "query_blood_pressure");
        map5.put(10001, "query_blood_sugar");
        map5.put(22100, "query_convergence_core_sleep_session");
        map5.put(2002, "query_convergence_heart_rate_detail");
        map5.put(400011975, "query_convergence_new_body_thermometer");
        map5.put(30264, "basicSportQuery");
        map5.put(30283, "basicSportQuery");
        map5.put(30265, "basicSportQuery");
        map5.put(30273, "basicSportQuery");
        map5.put(30274, "basicSportQuery");
        map5.put(30257, "basicSportQuery");
        map5.put(30258, "basicSportQuery");
        map5.put(30259, "basicSportQuery");
        map5.put(30260, "basicSportQuery");
        map5.put(30262, "basicSportQuery");
        map5.put(30266, "basicSportQuery");
        map5.put(30281, "basicSportQuery");
        map5.put(500007, "query_arrhythmia");
        map5.put(Integer.valueOf(NativeInvokeHeartRateBridge.DATA_SEQUENCE_PPG_OF_ARRHYTHMIA), "query_arrhythmia");
        map5.put(Integer.valueOf(NativeInvokeHeartRateBridge.DATA_SEQUENCE_ELECTROCARDIOGRAM), "query_electrocardiogram");
        map5.put(700005, "subscribe_data");
        map5.put(700006, "subscribe_data");
        map5.put(700007, "subscribe_data");
        map5.put(700008, "subscribe_data");
        map5.put(400018, "queryPhysiologicalCycle");
        map5.put(400018283, "queryPhysiologicalCycleRemark");
        map5.put(Integer.valueOf(AwarenessConstants.ERROR_UNKNOWN_CODE), "queryDrinkWater");
        map5.put(400019462, "queryPhysiologicalCycleBusiness");
        map5.put(700010, "queryCntbpPpg");
        map5.put(400020, "bodyShapeAllAbility");
        map5.put(500010, "query_sleep_on_off_bed_record");
        map5.put(700011, "mindfulnessAllAbility");
        f14398a = Collections.unmodifiableMap(map5);
        HashMap map6 = new HashMap();
        map6.put(700005, "subscribe_data");
        map6.put(700006, "subscribe_data");
        map6.put(700007, "subscribe_data");
        map6.put(700008, "subscribe_data");
        i = Collections.unmodifiableMap(map6);
    }

    public static int e(Context context) {
        if (j != 0) {
            return j;
        }
        j = c(context);
        return j;
    }

    public static int b() {
        return g;
    }

    public static void e(int i2) {
        g = i2;
    }

    public static boolean c(String str) {
        Log.i("HiHealthKitVersionUtil", "isServiceSupport apiName:" + str);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Map<String, Integer> map = e;
        int iIntValue = map.get(str) == null ? 0 : map.get(str).intValue();
        if (iIntValue == 0) {
            Log.w("HiHealthKitVersionUtil", "support by default");
            return true;
        }
        Log.i("HiHealthKitVersionUtil", "isServiceSupport apiLevel: " + g + ", minSupportApiLevel:" + iIntValue);
        return g >= iIntValue;
    }

    private static int c(Context context) {
        if (context == null) {
            Log.w("HiHealthKitVersionUtil", "getApiLevelForMetaData context is null");
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            Log.w("HiHealthKitVersionUtil", "getApiLevelForMetaData PackageManager is null");
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                int i2 = applicationInfo.metaData.getInt("com.huawei.hihealthkit.hihealthkitapi.sdk.api_level");
                Log.i("HiHealthKitVersionUtil", "getApiLevelForMetaData apiLevel:" + i2);
                return i2;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("HiHealthKitVersionUtil", "getApiLevelForMetaData PackageManager.NameNotFoundException");
        }
        return 0;
    }

    public static boolean d(int i2) {
        return c(b.get(Integer.valueOf(i2)));
    }

    public static boolean c(int i2) {
        return c(d.get(Integer.valueOf(i2)));
    }

    public static boolean b(int i2) {
        return c(c.get(Integer.valueOf(i2)));
    }

    public static boolean a(int i2) {
        return c(f14398a.get(Integer.valueOf(i2)));
    }
}
