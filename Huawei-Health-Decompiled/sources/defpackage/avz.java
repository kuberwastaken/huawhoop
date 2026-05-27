package defpackage;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.constant.WatchFaceConstant;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes10.dex */
public class avz {
    private static String b = null;
    private static String d = "";
    private static String f;
    private static String h;
    private static String j;
    private static List<String> g = Collections.emptyList();
    private static boolean e = false;
    private static int m = 466;
    private static int o = 466;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f364a = -1.0f;
    private static String i = WatchFaceConstant.TEMPLATES_CIRCLE_NAME;
    private static boolean c = true;

    public static void e(String str) {
        h = str;
        Log.i("GeneratorConfig", "set model path: " + h);
    }

    public static String c() throws awb {
        String str = h;
        if (str != null) {
            return str;
        }
        throw new awb("not configured");
    }

    public static void d(String str) {
        j = str;
        Log.i("GeneratorConfig", "set template path: " + j);
    }

    public static String a() throws awb {
        String str = j;
        if (str != null) {
            return str;
        }
        throw new awb("not configured");
    }

    public static void c(String str) {
        i = str;
        Log.i("GeneratorConfig", "set template name: " + i);
    }

    public static String d() {
        return i;
    }

    public static void d(int i2, int i3) {
        m = i2;
        o = i3;
        Log.i("GeneratorConfig", "set watch size: " + m + "*" + o);
    }

    public static int i() {
        return m;
    }

    public static int j() {
        return o;
    }

    public static float e() {
        return f364a;
    }

    public static String b() {
        return d;
    }

    public static void e(boolean z) {
        c = z;
        Log.i("GeneratorConfig", "set supported clock coloring: " + c);
    }

    public static boolean f() {
        return c;
    }

    public static void c(List<Integer> list) {
        g = (List) list.stream().map(new Function() { // from class: awa
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.toString(((Integer) obj).intValue());
            }
        }).collect(Collectors.toList());
        Log.i("GeneratorConfig", "set supported clocks: " + g);
    }

    public static boolean b(String str) {
        if (g.isEmpty()) {
            return true;
        }
        return g.contains(str);
    }

    public static boolean h() {
        return e;
    }

    public static boolean g() {
        boolean z = !TextUtils.equals(j, f);
        if (z) {
            f = j;
        }
        boolean z2 = !TextUtils.equals(i, b);
        if (z2) {
            b = i;
        }
        return z || z2;
    }
}
