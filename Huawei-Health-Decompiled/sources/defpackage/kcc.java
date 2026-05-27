package defpackage;

import com.huawei.hihealthservice.old.model.OldToNewMotionPath;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public class kcc {
    private static HashMap<Integer, int[]> sportTypeMap = new HashMap<>();
    private static HashMap<Integer, String[]> sportTypeQueryKeys = new HashMap<>();

    static {
        sportTypeMap.put(258, new int[]{2, 4, 5, 3});
        sportTypeMap.put(283, new int[]{4, 5, 3});
        HashMap<Integer, int[]> map = sportTypeMap;
        Integer numValueOf = Integer.valueOf(OldToNewMotionPath.SPORT_TYPE_CROSS_TRAINER);
        map.put(numValueOf, new int[]{4, 5, 3});
        HashMap<Integer, int[]> map2 = sportTypeMap;
        Integer numValueOf2 = Integer.valueOf(OldToNewMotionPath.SPORT_TYPE_INDOOR_BIKE);
        map2.put(numValueOf2, new int[]{4, 5, 3});
        HashMap<Integer, int[]> map3 = sportTypeMap;
        Integer numValueOf3 = Integer.valueOf(OldToNewMotionPath.SPORT_TYPE_ROW_MACHINE);
        map3.put(numValueOf3, new int[]{4, 5, 3});
        sportTypeQueryKeys.put(258, new String[]{"total_distance", "total_duration", "total_time", "total_calorie"});
        sportTypeQueryKeys.put(283, new String[]{"total_duration", "total_time", "total_calorie"});
        sportTypeQueryKeys.put(numValueOf, new String[]{"total_duration", "total_time", "total_calorie"});
        sportTypeQueryKeys.put(numValueOf2, new String[]{"total_duration", "total_time", "total_calorie"});
        sportTypeQueryKeys.put(numValueOf3, new String[]{"total_duration", "total_time", "total_calorie"});
    }

    public static int[] getSportTypeMap(int i) {
        return sportTypeMap.get(Integer.valueOf(i));
    }

    public static String[] getSportTypeQueryKeys(int i) {
        return sportTypeQueryKeys.get(Integer.valueOf(i));
    }
}
