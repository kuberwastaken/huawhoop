package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.os.Build;
import android.util.Base64;
import com.huawei.agconnect.apms.Agent;
import com.huawei.openalliance.ad.constant.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lib.android.paypal.com.magnessdk.c;
import lib.android.paypal.com.magnessdk.log.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class xuv {
    public static String c(String str) {
        return str.replaceAll(".debug", "").replaceAll(".release", "");
    }

    public static boolean d(String str) {
        return str != null && !str.isEmpty() && a(str) && str.length() <= 36 && str.length() >= 30;
    }

    public static Map<String, String> d(Context context) throws Exception {
        if (context == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("X-PAYPAL-RESPONSE-DATA-FORMAT", "NV");
        map.put("X-PAYPAL-REQUEST-DATA-FORMAT", "NV");
        map.put("X-PAYPAL-SERVICE-VERSION", "1.0.0");
        map.put("Content-Type", "application/x-www-form-urlencoded");
        c(map, context);
        return map;
    }

    static boolean a(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9-]*$");
    }

    static boolean d(Object obj) {
        if (obj == null) {
            return true;
        }
        return obj instanceof String ? ((String) obj).isEmpty() : obj instanceof Long ? ((Long) obj).longValue() == 0 : !(obj instanceof Integer) || ((Integer) obj).intValue() == 0;
    }

    public static Map<String, String> e(Context context) throws Exception {
        if (context == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("Content-Type", "application/json");
        c(map, context);
        return map;
    }

    public static List<String> b(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(String.valueOf(jSONArray.get(i)));
            }
        }
        return arrayList;
    }

    public static boolean a(List<String> list, String str) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static void d(Class<?> cls, Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                a.d(cls.getClass(), 3, e);
            }
        }
    }

    static JSONObject c(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject.has(next)) {
                try {
                    jSONObject.put(next, jSONObject2.opt(next));
                } catch (JSONException e) {
                    a.d(xuv.class, 3, e);
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject fEI_(Sensor sensor) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(c.d.e.NAME.toString(), sensor.getName());
        jSONObject.put(c.d.e.VENDOR.toString(), sensor.getVendor());
        jSONObject.put(c.d.e.POWER.toString(), String.format("%.8f", Float.valueOf(sensor.getPower())));
        jSONObject.put(c.d.e.VERSION.toString(), String.valueOf(sensor.getVersion()));
        jSONObject.put(c.d.e.RESOLUTION.toString(), String.format("%.8f", Float.valueOf(sensor.getResolution())));
        jSONObject.put(c.d.e.MAX_RANGE.toString(), String.format("%.8f", Float.valueOf(sensor.getMaximumRange())));
        jSONObject.put(c.d.e.FIFO_MAX_EVENT_COUNT.toString(), String.valueOf(sensor.getFifoMaxEventCount()));
        return jSONObject;
    }

    public static JSONArray c(Object obj) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(obj);
        return jSONArray;
    }

    private static Map<String, String> c(Map<String, String> map, Context context) throws Exception {
        String str = Build.VERSION.RELEASE;
        String str2 = Build.MODEL;
        String packageName = context.getPackageName();
        String strA = a(context);
        if (!d((Object) "5.5.1.release")) {
            map.put("comp_version", "5.5.1.release");
        }
        if (!d((Object) str)) {
            map.put("os_version", str);
        }
        if (!d((Object) Agent.OS_NAME)) {
            map.put("os_type", Agent.OS_NAME);
        }
        if (!d((Object) str2)) {
            map.put("device_model", str2);
        }
        if (!d((Object) packageName)) {
            map.put("app_id", packageName);
        }
        if (!d((Object) strA)) {
            map.put("app_version", strA);
        }
        return map;
    }

    public static List<Integer> e(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add((Integer) jSONArray.get(i));
            }
        }
        return arrayList;
    }

    public static String e(Boolean[] boolArr) {
        String str;
        if (boolArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Boolean bool : boolArr) {
            if (bool.booleanValue()) {
                str = "1";
            } else if (!bool.booleanValue()) {
                str = "0";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static String e(boolean z) {
        return z ? UUID.randomUUID().toString() : UUID.randomUUID().toString().replaceAll(Constants.LINK, "");
    }

    static String b(String str) throws UnsupportedEncodingException {
        return new String(Base64.decode(str, 2), "UTF-8");
    }

    public static String a(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
    }

    private xuv() {
    }
}
