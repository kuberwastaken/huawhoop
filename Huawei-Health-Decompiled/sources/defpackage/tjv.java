package defpackage;

import com.huawei.health.R;
import com.huawei.hihealth.dictionary.utils.DicDataTypeUtil;
import com.huawei.ui.main.R$string;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class tjv {
    public static final HashMap<String, Integer> d = new HashMap<String, Integer>() { // from class: tjv.4
        {
            put("SLEEP_DURATION", 0);
            put("BED_TIME", 1);
            put("SLEEP_LATENCY", 2);
            put("SLEEP_EFFICIENCY", 3);
            put("DEEP_RATIO", 4);
            put("SHALLOW_RATIO", 5);
            put("REM_RATIO", 6);
            put("DEEP_CONT", 7);
            put("AWAKE_NUMS", 8);
            put("STABLE_SLEEP_RATIO_ALERT", 9);
            put("BREATH_QUALITY", 10);
            put("GO_BED_TIME", 11);
            put("FALL_ASLEEP_TIME", 12);
            put("WAKE_UP_TIME", 13);
            put("RISING_TIME", 14);
            put("GO_BED_REGULARITY", 15);
            put("OFF_BED_REGULARITY", 16);
            put("SLEEP_HEART_RATE", 17);
            put("SLEEP_BLOOD_OX", 18);
            put("SLEEP_BREATH_RATIO", 19);
            put("TRUSLEEP_FIVE_HEART_RATE", 20);
            put("TRUSLEEP_FIVE_HRV", 21);
            put("TRUSLEEP_FIVE_SpO2", 22);
            put("TRUSLEEP_FIVE_BREATH_RATE", 23);
            put("NOON_SLEEP", 24);
            put("TOTAL_SLEEP", 25);
            put("WAKE_UP_FEELING", 26);
        }
    };
    public static final HashMap<Integer, Integer> c = new HashMap<Integer, Integer>() { // from class: tjv.3
        {
            put(0, -1);
            put(1, tjv.d.get("REM_RATIO"));
            put(2, tjv.d.get("AWAKE_NUMS"));
            put(3, tjv.d.get("REM_RATIO"));
            put(4, tjv.d.get("DEEP_RATIO"));
            put(5, tjv.d.get("SLEEP_DURATION"));
            put(6, -1);
            put(7, tjv.d.get("DEEP_CONT"));
            put(8, tjv.d.get("SLEEP_DURATION"));
            put(9, -1);
            put(10, tjv.d.get("SLEEP_EFFICIENCY"));
            put(11, tjv.d.get("SLEEP_LATENCY"));
            put(12, tjv.d.get("REM_RATIO"));
            put(13, tjv.d.get("REM_RATIO"));
            put(14, tjv.d.get("DEEP_RATIO"));
            put(15, tjv.d.get("STABLE_SLEEP_RATIO_ALERT"));
        }
    };
    public static final int[] e = {22101, 22102, 22103, 22104, 22105, 22107, 22106};
    public static final int[] b = {22001, 22002, 22003};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f18016a = {DicDataTypeUtil.DataType.SLEEP_DETAILS.value(), DicDataTypeUtil.DataType.ENVIRONMENT_NOISE_TYPE.value()};
    public static final Map<String, Integer> g = new HashMap<String, Integer>() { // from class: tjv.5
        {
            put("TRUSLEEP_FIVE_HEART_RATE", Integer.valueOf(R$string.IDS_trusleep_five_avg_heart_rate_title));
            put("TRUSLEEP_FIVE_BREATH_RATE", Integer.valueOf(R$string.IDS_trusleep_five_avg_breath_rate_title));
            put("TRUSLEEP_FIVE_HRV", Integer.valueOf(R$string.IDS_trusleep_five_avg_hrv_title));
            put("TRUSLEEP_FIVE_SpO2", Integer.valueOf(R$string.IDS_trusleep_five_avg_spo2_title));
        }
    };
    public static final Map<String, Integer> f = new HashMap<String, Integer>() { // from class: tjv.2
        {
            put("TRUSLEEP_FIVE_HEART_RATE", Integer.valueOf(R$string.IDS_heart_rate_switch_description));
            put("TRUSLEEP_FIVE_BREATH_RATE", -1);
            put("TRUSLEEP_FIVE_HRV", -1);
            put("TRUSLEEP_FIVE_SpO2", Integer.valueOf(R$string.IDS_spo2_switch_description));
        }
    };
    public static final Map<String, Integer> j = new HashMap<String, Integer>() { // from class: tjv.1
        {
            put("TRUSLEEP_FIVE_HEART_RATE", Integer.valueOf(R.plurals._2130903434_res_0x7f03018a));
            put("TRUSLEEP_FIVE_BREATH_RATE", Integer.valueOf(R.plurals._2130903442_res_0x7f030192));
            put("TRUSLEEP_FIVE_HRV", Integer.valueOf(R.plurals._2130903435_res_0x7f03018b));
            put("TRUSLEEP_FIVE_SpO2", Integer.valueOf(R$string.IDS_base_line_percent));
        }
    };
    public static final Map<String, Integer[]> i = new HashMap<String, Integer[]>() { // from class: tjv.8
        {
            put("TRUSLEEP_FIVE_HEART_RATE", new Integer[]{40, 120});
            put("TRUSLEEP_FIVE_BREATH_RATE", new Integer[]{1, 80});
            put("TRUSLEEP_FIVE_HRV", new Integer[]{1, 200});
            put("TRUSLEEP_FIVE_SpO2", new Integer[]{90, 100});
        }
    };
    public static final Map<String, Integer> h = new HashMap<String, Integer>() { // from class: tjv.9
        {
            put("TRUSLEEP_FIVE_HEART_RATE", Integer.valueOf(R.plurals._2130903433_res_0x7f030189));
            put("TRUSLEEP_FIVE_BREATH_RATE", Integer.valueOf(R.plurals._2130903441_res_0x7f030191));
            put("TRUSLEEP_FIVE_HRV", Integer.valueOf(R.plurals._2130903432_res_0x7f030188));
            put("TRUSLEEP_FIVE_SpO2", -1);
        }
    };
}
