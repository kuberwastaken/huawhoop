package defpackage;

import com.huawei.operation.OpAnalyticsConstants;
import com.huawei.wearengine.device.Device;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class wrs extends JSONObject {
    public wrs(String str) throws JSONException {
        super(str);
    }

    private wrs() throws JSONException {
        this("{}");
    }

    public static String a(Device device) {
        if (device == null) {
            return "";
        }
        try {
            Field declaredField = device.getClass().getDeclaredField("mReservedness");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(device);
            return obj instanceof String ? (String) obj : "";
        } catch (IllegalAccessException unused) {
            wrm.b("DeviceJson", "getJsonFromDevice catch IllegalAccessException");
            return "";
        } catch (NoSuchFieldException unused2) {
            wrm.b("DeviceJson", "getJsonFromDevice catch NoSuchFieldException");
            return "";
        }
    }

    public String e() {
        Object objOpt = opt("device_extra");
        return objOpt instanceof String ? (String) objOpt : "";
    }

    public void c(String str) {
        try {
            put("device_extra", str);
        } catch (JSONException unused) {
            wro.e("DeviceJson", "setExtra catch JSONException");
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f18879a = "";
        private String c = "";
        private boolean e = false;
        private String d = "";

        public c a(String str) {
            this.f18879a = str;
            return this;
        }

        public c d(String str) {
            this.c = str;
            return this;
        }

        public c d(boolean z) {
            this.e = z;
            return this;
        }

        public c e(String str) {
            this.d = str;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public wrs b() {
            wrs wrsVar = null;
            try {
                wrs wrsVar2 = new wrs();
                try {
                    wrsVar2.put("device_reservedness", this.f18879a);
                    wrsVar2.put(OpAnalyticsConstants.DEVICE_SOFT_VERSION, this.c);
                    wrsVar2.put("device_is_support_ota", this.e);
                    wrsVar2.put("device_extra", this.d);
                    return wrsVar2;
                } catch (JSONException unused) {
                    wrsVar = wrsVar2;
                    wrm.e("DeviceJson", "build catch JSONException");
                    return wrsVar;
                }
            } catch (JSONException unused2) {
            }
        }
    }
}
