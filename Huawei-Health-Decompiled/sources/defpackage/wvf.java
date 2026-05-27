package defpackage;

import com.huawei.health.ecologydevice.ui.measure.fragment.device.DeviceCategoryFragment;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.operation.OpAnalyticsConstants;

/* JADX INFO: loaded from: classes8.dex */
public class wvf {
    public static String h(String str) {
        return wve.b(str, "getReservedness", "device_reservedness");
    }

    public static String b(String str) {
        return wve.b(str, "getCapability", "device_capability");
    }

    public static String a(String str) {
        return wve.b(str, "getBasicInfo", "device_basic_info");
    }

    public static String i(String str) {
        return wve.b(str, "getIdentify", "device_identify");
    }

    public static String l(String str) {
        return wve.b(str, "getWearEngineDeviceId", "device_wear_engine_device_id");
    }

    public static String m(String str) {
        return wve.b(str, "getSoftwareVersion", OpAnalyticsConstants.DEVICE_SOFT_VERSION);
    }

    public static boolean k(String str) {
        return wve.c(str, "getSupportOTA", "device_is_support_ota");
    }

    public static String d(String str) {
        return wve.b(str, "getExtra", "device_extra");
    }

    public static int j(String str) {
        return wve.c(str, "getP2pCapability", "device_p2p_capability", 2);
    }

    public static int g(String str) {
        return wve.c(str, "getMonitorCapability", "device_monitor_capability", 2);
    }

    public static int f(String str) {
        return wve.c(str, "getNotifyCapability", "device_notify_capability", 2);
    }

    public static int o(String str) {
        return wve.c(str, "getSensorCapability", "device_sensor_capability", 2);
    }

    public static String c(String str) {
        return wve.b(str, "getDeviceCategory", PluginPayAdapter.DEVICE_CATEGORY);
    }

    public static int e(String str) {
        if (wuh.d("powerMode")) {
            return wve.c(str, "getDeviceType", DeviceCategoryFragment.DEVICE_TYPE, -1);
        }
        return -1;
    }
}
