package defpackage;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.huawei.hianalytics.core.storage.Event;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class vno {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f18676a = null;
    private static Method b = null;
    private static Method c = null;
    private static Method d = null;
    private static Object e = null;
    private static boolean g = false;
    private static Class<?> h;
    private static Class<?> i;
    private static Class<?> j;
    private static Map<Integer, String> f = new HashMap();
    private static Map<Integer, String> o = new HashMap();
    private static List<Integer> n = new ArrayList(10);

    static {
        try {
            f.put(0, "haptic.common.long_press");
            f.put(1, "haptic.common.threshold");
            f.put(2, "haptic.slide.type1");
            f.put(3, "haptic.slide.type2");
            f.put(4, "haptic.slide.type3");
            f.put(5, "haptic.slide.type4");
            f.put(6, "haptic.slide.type5");
            f.put(7, "haptic.slide.type6");
            f.put(8, "haptic.common.long_press1");
            f.put(9, "haptic.common.long_press2");
            f.put(10, "watchhaptic.crown.strength1");
            f.put(11, "watchhaptic.crown.strength2");
            f.put(12, "watchhaptic.crown.strength3");
            o.put(0, "haptic.common.long_press");
            o.put(1, "haptic.common.threshold");
            o.put(2, "haptic.control.time_scroll");
            o.put(3, "haptic.control.time_scroll");
            o.put(4, "haptic.control.time_scroll");
            o.put(5, "haptic.control.time_scroll");
            o.put(6, "haptic.control.time_scroll");
            o.put(7, "haptic.slide.type6");
            o.put(8, "haptic.common.long_press1");
            o.put(9, "haptic.common.long_press2");
            o.put(10, "watchhaptic.crown.strength1");
            o.put(11, "watchhaptic.crown.strength2");
            o.put(12, "watchhaptic.crown.strength3");
            Class<?> cls = Class.forName("com.huawei.android.os.VibratorEx");
            i = cls;
            if ("class com.huawei.android.os.VibratorEx".equals(cls.toString())) {
                e = i.newInstance();
                d = i.getMethod("isSupportHwVibrator", String.class);
                c = i.getMethod("setHwVibrator", String.class);
                f18676a = i.getMethod("stopHwVibrator", String.class);
                j = Class.forName("com.huawei.android.view.ViewEx");
                h = Class.forName("com.huawei.android.view.HapticFeedbackConstantsEx");
                Class<?> cls2 = j;
                Class<?> cls3 = Integer.TYPE;
                b = cls2.getMethod("performHwHapticFeedback", View.class, cls3, cls3);
                n.add(0, Integer.valueOf(e("HW_LONG_PRESS")));
                n.add(1, Integer.valueOf(e("HW_THRESHOLD")));
                n.add(2, Integer.valueOf(e("HW_SLIDE_1")));
                n.add(3, Integer.valueOf(e("HW_SLIDE_2")));
                n.add(4, Integer.valueOf(e("HW_SLIDE_3")));
                n.add(5, Integer.valueOf(e("HW_SLIDE_4")));
                n.add(6, Integer.valueOf(e("HW_SLIDE_5")));
                n.add(7, Integer.valueOf(e("HW_SLIDE_6")));
                n.add(8, Integer.valueOf(e("HW_LONG_PRESS1")));
                n.add(9, Integer.valueOf(e("HW_LONG_PRESS2")));
            } else {
                g = true;
                Log.e("HwVibrateUtil", "fail to reflect, class is proguard.");
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            Log.e("HwVibrateUtil", "class init failed.");
        } catch (Exception unused2) {
            Log.e("HwVibrateUtil", "Another exception failed.");
        }
    }

    public static boolean a(String str) {
        if (!g && str != null && e != null && c != null && b(str)) {
            try {
                c.invoke(e, str);
                return true;
            } catch (IllegalAccessException unused) {
                Log.e("HwVibrateUtil", "Call doVibrateEx IllegalAccessException Exception.");
            } catch (InvocationTargetException unused2) {
                Log.e("HwVibrateUtil", "Call doVibrateEx InvocationTargetException Exception.");
            }
        }
        return false;
    }

    private static boolean b(String str) {
        Object obj;
        Method method = d;
        if (method == null || (obj = e) == null) {
            return false;
        }
        try {
            Object objInvoke = method.invoke(obj, str);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            Log.e("HwVibrateUtil", "Call isSupportHwVibrator exception.");
            return false;
        }
    }

    private static int c(String str) {
        try {
            Object obj = h.getField(str).get(null);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return 0;
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            Log.e("HwVibrateUtil", "get field failed.");
            return 0;
        }
    }

    private static int e(String str) {
        if (g || h == null) {
            return 0;
        }
        return c(str);
    }

    private static boolean ezo_(View view, int i2, int i3) {
        if (b == null || i2 >= n.size() || i2 < 0 || !b(f.get(Integer.valueOf(i2)))) {
            return false;
        }
        try {
            b.invoke(null, view, n.get(i2), Integer.valueOf(i3));
            return true;
        } catch (IllegalAccessException unused) {
            Log.e("HwVibrateUtil", "Call doViewEx IllegalAccessException Exception.");
            return false;
        } catch (InvocationTargetException unused2) {
            Log.e("HwVibrateUtil", "Call doViewEx InvocationTargetException Exception.");
            return false;
        }
    }

    public static boolean ezp_(View view, int i2, int i3) {
        if (n.size() == 0 || !ezo_(view, i2, i3)) {
            return a(o.get(Integer.valueOf(i2)));
        }
        return true;
    }

    public static void d(String str, long j2) {
        String strC = c(str, j2);
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        Log.i("HwVibrateUtil", "The timeSpan when play haptic : " + SystemClock.uptimeMillis());
        ph.b().b(strC, 0);
    }

    private static String c(String str, long j2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONArray("PatternList").getJSONObject(0).getJSONArray("Pattern").getJSONObject(0).getJSONObject(Event.TAG).getJSONObject("Parameters");
            jSONObject2.put("Intensity", j2);
            jSONObject2.put("Frequency", 80);
            return jSONObject.toString();
        } catch (JSONException unused) {
            Log.w("HwVibrateUtil", "Json parse error or file not exist.");
            return "";
        }
    }
}
