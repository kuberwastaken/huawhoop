package defpackage;

import android.text.TextUtils;
import com.huawei.haf.common.utils.CollectionUtils;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class mmp {
    private static final Map<String, String> b;

    static {
        HashMap map = new HashMap();
        b = map;
        map.put("<C1>", ParsedFieldTag.GOAL);
        map.put("<C2>", "target");
        map.put("<H1>", "heart");
        map.put("<S1>", "step");
        map.put("<S2>", "pace");
        map.put("<S3>", "climb");
        map.put("<S4>", "floor");
        map.put("<S5>", "active");
        map.put("<S6>", "calorie");
        map.put("<S7>", "distance");
        map.put("<S8>", "intensity");
    }

    public static Object[] b(Object... objArr) {
        if (CollectionUtils.b(objArr)) {
            return objArr;
        }
        for (Map.Entry<String, String> entry : b.entrySet()) {
            for (int i = 0; i < objArr.length; i++) {
                String strValueOf = String.valueOf(objArr[i]);
                if (!TextUtils.isEmpty(strValueOf)) {
                    objArr[i] = strValueOf.replaceAll("(?i)" + entry.getValue(), entry.getKey());
                }
            }
        }
        return objArr;
    }
}
