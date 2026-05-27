package defpackage;

import com.huawei.health.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class ojm {
    private static final HashMap<String, Integer> d;

    static {
        HashMap<String, Integer> map = new HashMap<>();
        d = map;
        map.put("h5_calorieConsumed", Integer.valueOf(R.mipmap._2131821683_res_0x7f110473));
        Integer numValueOf = Integer.valueOf(R.mipmap._2131820671_res_0x7f11007f);
        map.put("h5_sportTime", numValueOf);
        map.put("h5_totalScore", Integer.valueOf(R.mipmap._2131821685_res_0x7f110475));
        map.put("h5_totalPutt", Integer.valueOf(R.mipmap._2131821684_res_0x7f110474));
        map.put("h5_fairwayHitRate", Integer.valueOf(R.mipmap._2131821675_res_0x7f11046b));
        map.put("h5_gir", Integer.valueOf(R.mipmap._2131821676_res_0x7f11046c));
        map.put("h5_avgPutt", Integer.valueOf(R.mipmap._2131821667_res_0x7f110463));
        map.put("h5_avgHandicap", Integer.valueOf(R.mipmap._2131821677_res_0x7f11046d));
        map.put("h5_maxDepth", Integer.valueOf(R.mipmap._2131821680_res_0x7f110470));
        Integer numValueOf2 = Integer.valueOf(R.mipmap._2131821679_res_0x7f11046f);
        map.put("h5_diveSportTime", numValueOf2);
        map.put("h5_underwaterTime", Integer.valueOf(R.mipmap._2131821686_res_0x7f110476));
        map.put("h5_waterType", Integer.valueOf(R.mipmap._2131821687_res_0x7f110477));
        map.put("h5_diveNumber", Integer.valueOf(R.mipmap._2131821674_res_0x7f11046a));
        map.put("h5_minWaterTemperature", Integer.valueOf(R.mipmap._2131821682_res_0x7f110472));
        map.put("h5_maxSingleTime", numValueOf);
        map.put("h5_breakTime", numValueOf);
        map.put("h5_closedBreathTime", Integer.valueOf(R.mipmap._2131821673_res_0x7f110469));
        map.put("h5_avgHeartRate", Integer.valueOf(R.mipmap._2131820575_res_0x7f11001f));
        map.put("h5_heartRateRange", Integer.valueOf(R.mipmap._2131821678_res_0x7f11046e));
        map.put("h5_diaphragm", numValueOf2);
        map.put("h5_breathTime", Integer.valueOf(R.mipmap._2131821668_res_0x7f110464));
        map.put("h5_maxWaterTemperature", Integer.valueOf(R.mipmap._2131821681_res_0x7f110471));
        map.put("h5_avgDepth", Integer.valueOf(R.mipmap._2131821666_res_0x7f110462));
        map.put("h5_avgSwingTempo", Integer.valueOf(R.mipmap._2131820759_res_0x7f1100d7));
        map.put("h5_avgBackSwingTime", Integer.valueOf(R.mipmap._2131820756_res_0x7f1100d4));
        map.put("h5_avgDownSwingTime", Integer.valueOf(R.mipmap._2131820757_res_0x7f1100d5));
        map.put("h5_maxSwingSpeed", Integer.valueOf(R.mipmap._2131820758_res_0x7f1100d6));
        map.put("h5_swingSpeed", Integer.valueOf(R.mipmap._2131820755_res_0x7f1100d3));
    }

    public static Integer a(String str) {
        HashMap<String, Integer> map = d;
        if (!map.containsKey(str)) {
            return 0;
        }
        return map.get(str);
    }
}
