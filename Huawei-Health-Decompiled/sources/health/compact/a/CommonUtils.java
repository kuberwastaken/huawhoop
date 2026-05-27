package health.compact.a;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import com.huawei.haf.application.BaseApplication;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.Constants;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class CommonUtils {
    protected CommonUtils() {
    }

    public static int i(String str) {
        return e(str, 0);
    }

    public static int e(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        String strTrim = str.trim();
        try {
            return Integer.parseInt(strTrim);
        } catch (NumberFormatException e) {
            LogUtil.d("HAF_CommonUtil", "getInteger ex=", e.getMessage());
            return (int) a(strTrim, i, true);
        }
    }

    public static float g(String str) {
        return c(str, 0.0f);
    }

    public static float c(String str, float f) {
        return TextUtils.isEmpty(str) ? f : a(str.trim(), f, false);
    }

    private static float a(String str, float f, boolean z) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            if (!z) {
                LogUtil.d("HAF_CommonUtil", "getFloat ex=", e.getMessage());
            }
            return f;
        }
    }

    public static double a(String str) {
        return c(str, 0.0d);
    }

    public static double c(String str, double d) {
        if (TextUtils.isEmpty(str)) {
            return d;
        }
        try {
            return Double.valueOf(str.trim()).doubleValue();
        } catch (NumberFormatException e) {
            LogUtil.d("HAF_CommonUtil", "getDouble ex=", e.getMessage());
            return d;
        }
    }

    public static long j(String str) {
        return e(str, 0L);
    }

    public static long e(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        try {
            return Long.parseLong(str.trim());
        } catch (NumberFormatException e) {
            LogUtil.d("HAF_CommonUtil", "getLong ex=", e.getMessage());
            return j;
        }
    }

    public static long b(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.parseLong(str.trim(), i);
        } catch (NumberFormatException e) {
            LogUtil.d("HAF_CommonUtil", "getLongByRadix ex=", e.getMessage());
            return 0L;
        }
    }

    public static int d(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str.trim(), i);
        } catch (NumberFormatException e) {
            LogUtil.d("HAF_CommonUtil", "getIntegerByRadix ex=", e.getMessage());
            return 0;
        }
    }

    public static ActivityManager zc_() {
        Object systemService = BaseApplication.a().getSystemService("activity");
        if (systemService instanceof ActivityManager) {
            return (ActivityManager) systemService;
        }
        return null;
    }

    public static WindowManager zk_() {
        Object systemService = BaseApplication.a().getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        if (systemService instanceof WindowManager) {
            return (WindowManager) systemService;
        }
        return null;
    }

    public static ConnectivityManager ze_() {
        Object systemService = BaseApplication.a().getSystemService("connectivity");
        if (systemService instanceof ConnectivityManager) {
            return (ConnectivityManager) systemService;
        }
        return null;
    }

    public static TelephonyManager zj_() {
        Object systemService = BaseApplication.a().getSystemService("phone");
        if (systemService instanceof TelephonyManager) {
            return (TelephonyManager) systemService;
        }
        return null;
    }

    public static PowerManager zh_() {
        Object systemService = BaseApplication.a().getSystemService("power");
        if (systemService instanceof PowerManager) {
            return (PowerManager) systemService;
        }
        return null;
    }

    public static AlarmManager zd_() {
        Object systemService = BaseApplication.a().getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (systemService instanceof AlarmManager) {
            return (AlarmManager) systemService;
        }
        return null;
    }

    public static LocationManager zf_() {
        Object systemService = BaseApplication.a().getSystemService("location");
        if (systemService instanceof LocationManager) {
            return (LocationManager) systemService;
        }
        return null;
    }

    public static SensorManager zi_() {
        Object systemService = BaseApplication.a().getSystemService("sensor");
        if (systemService instanceof SensorManager) {
            return (SensorManager) systemService;
        }
        return null;
    }

    public static NotificationManager zg_() {
        Object systemService = BaseApplication.a().getSystemService(RemoteMessageConst.NOTIFICATION);
        if (systemService instanceof NotificationManager) {
            return (NotificationManager) systemService;
        }
        return null;
    }

    public static String f(String str) {
        File filesDir = BaseApplication.a().getFilesDir();
        if (!TextUtils.isEmpty(str)) {
            filesDir = new File(filesDir, str);
        }
        String path = filesDir.getPath();
        if (path.endsWith(File.separator)) {
            return path;
        }
        return path + File.separator;
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return BaseApplication.d();
        }
        return (BaseApplication.d() + str).intern();
    }
}
