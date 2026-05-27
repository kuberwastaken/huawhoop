package defpackage;

import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ohos.ace.plugin.taskmanagerplugin.EventType;

/* JADX INFO: loaded from: classes5.dex */
public class kba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<Integer, String> f14577a;

    static {
        HashMap map = new HashMap();
        f14577a = map;
        map.put(0, "success");
        f14577a.put(1, EventType.FAILED);
        f14577a.put(4, "api state exception");
        f14577a.put(5, "device exception");
        f14577a.put(150, "device not connected");
        f14577a.put(2, "param invalid");
        f14577a.put(3, "data validator error");
        f14577a.put(7, AuthInternalPickerConstant.PARAM_ERROR);
        f14577a.put(25, "screen locked error");
        f14577a.put(1001, "permission exception");
        f14577a.put(Integer.valueOf(HiHealthStatusCodes.USER_OF_BETA_APP_EXCEED_RANGE), "beta scope permission exception");
        f14577a.put(1002, "scope exception");
        f14577a.put(1003, "user privacy denied error");
        f14577a.put(1004, "network exception");
        f14577a.put(1005, "bluetooth not enabled");
        f14577a.put(1006, "location permission denied");
        f14577a.put(1007, "storage permission denied");
        f14577a.put(1008, "HealthKit data sharing not enabled");
        f14577a.put(1009, "token expired");
        f14577a.put(1021, "Transaction too large");
        f14577a.put(201, "healthy living unsubscribed");
        f14577a.put(30, "Health application need to be updated");
        f14577a.put(31, "HiHealthKit service was disconnected");
        f14577a.put(32, "HMS version must be later than or equal to 5.1.0.300");
        f14577a.put(1022, "Failed to synchronize data");
        f14577a.put(153, "device is not supported");
        f14577a.put(1023, "timeout");
        f14577a.put(1024, "business not need to be executed");
        f14577a.put(1025, "device storage permission denied");
    }

    public static String b(int i) {
        String str = f14577a.get(Integer.valueOf(i));
        return str == null ? "UNKNOWN_ERROR" : str;
    }

    public static List c(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(b(i));
        return arrayList;
    }
}
