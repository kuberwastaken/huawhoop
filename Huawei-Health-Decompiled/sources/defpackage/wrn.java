package defpackage;

import com.huawei.hms.kit.awareness.barrier.internal.e.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class wrn {
    private static Map<Integer, String> c;

    static {
        HashMap map = new HashMap();
        c = map;
        map.put(0, "Success");
        c.put(1, "Generic error");
        c.put(2, "Health app not exist");
        c.put(3, "Health app not login");
        c.put(4, "Health app unbound device");
        c.put(5, "Invalid argument");
        c.put(6, "Server remote binder is null");
        c.put(7, "User unauthorized in health");
        c.put(8, "Scope unauthorized");
        c.put(9, "User unauthorized in wear engine");
        c.put(10, "Invalid file");
        c.put(11, "Too much receivers");
        c.put(12, "Internal error");
        c.put(13, "Device version is not supported");
        c.put(14, "Health version is low");
        c.put(15, "Health does not has permission to start");
        c.put(16, "Device is not connected");
        c.put(17, "Device uuid is invalid");
        c.put(18, "Interface is not supported");
        c.put(200, "Watch app not exist");
        c.put(201, "Watch app not running");
        c.put(202, "Watch app running");
        c.put(203, "Other error");
        c.put(204, "Phone app not exist");
        c.put(205, "Phone app exist");
        c.put(206, "Fail");
        c.put(Integer.valueOf(a.w), "Success");
        c.put(300, "Sensor Watch Wear Off");
        c.put(301, "Sensor Watch Lead Off");
        c.put(302, "Sensor Watch User Stop");
        c.put(303, "Sensor Watch Sensor Used");
        c.put(304, "Sensor Not Abilites");
        c.put(Integer.valueOf(a.A), "Send Offline Msg Success");
        c.put(19, "Service Timeout");
        c.put(20, "Power mode changing");
    }

    public static String c(int i) {
        return c.containsKey(Integer.valueOf(i)) ? c.get(Integer.valueOf(i)) : "Generic error";
    }

    public static int d(String str) {
        int i;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            wrm.b("WearEngineErrorCode", "NumberFormatException");
            i = 1;
        }
        if (c.containsKey(Integer.valueOf(i))) {
            return i;
        }
        return 1;
    }
}
