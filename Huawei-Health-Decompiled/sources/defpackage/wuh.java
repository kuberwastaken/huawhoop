package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.wearengine.monitor.MonitorItem;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class wuh {
    private static Map<String, Integer> b = null;
    private static volatile int c = -1;
    private static volatile int e;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        b = concurrentHashMap;
        concurrentHashMap.put("device_get_bonded_device_ex", 2);
        b.put("p2p_send_extra", 2);
        b.put("p2p_get_device_app_version_code", 4);
        b.put("device_get_hi_link_device_id", 2);
        b.put(MonitorItem.MONITOR_CHARGE_STATUS.getName(), 2);
        b.put(MonitorItem.MONITOR_ITEM_LOW_POWER.getName(), 2);
        b.put(MonitorItem.MONITOR_POWER_STATUS.getName(), 2);
        b.put(MonitorItem.MONITOR_ITEM_SLEEP.getName(), 2);
        b.put(MonitorItem.MONITOR_ITEM_SPORT.getName(), 2);
        b.put(MonitorItem.MONITOR_ITEM_WEAR.getName(), 2);
        b.put(MonitorItem.MONITOR_ITEM_HEART_RATE_ALARM.getName(), 2);
        b.put("monitor_query", 2);
        b.put("notify_notify", 2);
        b.put("sensor", 2);
        b.put("auth_pre_start_auth", 2);
        b.put("p2p_cancel_file_transfer", 5);
        b.put("wear_user_status", 6);
        b.put("motion_sensor", 6);
        b.put("device_get_all_bonded_device", 6);
        b.put("is_support_ota", 7);
        b.put("device_get_common_device", 8);
        b.put("set_frequency_type", 8);
        b.put("p2p_send_file_transfer_way_report", 9);
        b.put("query_device_capability", 10);
        b.put(PluginPayAdapter.KEY_DEVICE_INFO_SN, 12);
        b.put("powerMode", 13);
    }

    public static void b(int i) {
        c = i;
    }

    public static int c() {
        if (e != 0) {
            return e;
        }
        e = b();
        return e;
    }

    public static boolean d(String str) {
        wrm.d("ApiLevelUtil", "isServiceSupport apiName:" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int iIntValue = b.get(str) == null ? 0 : b.get(str).intValue();
        if (iIntValue == 0) {
            wrm.e("ApiLevelUtil", "isServiceSupport inputApiLevel is null");
            return false;
        }
        wrm.d("ApiLevelUtil", "isServiceSupport serviceApiLevel: " + c + ", minSupportApiLevel:" + iIntValue);
        return c >= iIntValue;
    }

    private static int b() {
        Context contextD = wut.d();
        PackageManager packageManager = contextD.getPackageManager();
        if (packageManager == null) {
            wrm.e("ApiLevelUtil", "getMetaDataApiLevel PackageManager is null");
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(contextD.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                int i = applicationInfo.metaData.getInt("com.huawei.wearengine.sdk.api_level");
                wrm.d("ApiLevelUtil", "getMetaDataApiLevel apiLevel:" + i);
                return i;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            wrm.b("ApiLevelUtil", "getMetaDataApiLevel PackageManager.NameNotFoundException");
        }
        return 0;
    }
}
