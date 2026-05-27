package defpackage;

import com.huawei.health.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes8.dex */
public class uhk {
    private static final HashMap<Integer, Integer> b;
    private static final HashMap<Integer, Integer> c;

    static {
        HashMap<Integer, Integer> map = new HashMap<>();
        c = map;
        HashMap<Integer, Integer> map2 = new HashMap<>();
        b = map2;
        map.put(1000, 20210605);
        map.put(1001, 20210606);
        map.put(1002, 20210606);
        map.put(1003, 20210606);
        map.put(1004, 20210606);
        map.put(1005, 20210606);
        map.put(1006, 20210606);
        map.put(1007, 20210606);
        map2.put(0, Integer.valueOf(R.string._2130845089_res_0x7f021da1));
        map2.put(1, Integer.valueOf(R.string._2130845090_res_0x7f021da2));
        map2.put(2, Integer.valueOf(R.string._2130845091_res_0x7f021da3));
        map2.put(3, Integer.valueOf(R.string._2130845092_res_0x7f021da4));
    }

    public static HashMap<Integer, Integer> d() {
        return c;
    }

    public static HashMap<Integer, Integer> b() {
        return b;
    }
}
