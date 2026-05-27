package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.util.Size;
import android.view.WindowManager;
import com.huawei.openalliance.ad.constant.Constants;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes8.dex */
public class vnf {
    private static final String c = "HwDeviceUtils";

    private static boolean a(Size size) {
        return size.getHeight() > 0 && Float.compare(((float) size.getWidth()) / ((float) size.getHeight()), 0.875f) >= 0;
    }

    public static boolean b() {
        String[] strArrSplit = c("ro.config.hw_fold_disp", "").split(",");
        try {
            if (strArrSplit.length == 9) {
                if (Integer.parseInt(strArrSplit[8]) / 100 == 3) {
                    return true;
                }
            }
        } catch (NumberFormatException unused) {
            Log.w(c, "number format Exception");
        }
        return false;
    }

    public static boolean c() {
        String[] strArrSplit = c("ro.config.hw_fold_disp", "").split(",");
        try {
            if (strArrSplit.length == 9) {
                if (Integer.parseInt(strArrSplit[8]) == 1) {
                    return true;
                }
            }
        } catch (NumberFormatException unused) {
            Log.e(c, "NumberFormatException!");
        }
        return false;
    }

    public static boolean d() {
        return (c("ro.config.hw_fold_disp", "").isEmpty() && c("persist.sys.fold.disp.size", "").isEmpty()) ? false : true;
    }

    public static boolean e() {
        return c("ro.build.characteristics", "") != null && c("ro.build.characteristics", "").equalsIgnoreCase("tablet");
    }

    public static boolean e(Context context) {
        return a(a(context));
    }

    private static Size a(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealSize(point);
        if (point.y < point.x) {
            return new Size(point.y, point.x);
        }
        return new Size(point.x, point.y);
    }

    private static String c(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
            return objInvoke instanceof String ? (String) objInvoke : str2;
        } catch (ClassNotFoundException e) {
            Log.w(c, "getProperty() : Get property failed. classNotFoundException:" + e.getMessage());
            return str2;
        } catch (IllegalAccessException e2) {
            Log.w(c, "getProperty() : Get property failed. illegalAccessException:" + e2.getMessage());
            return str2;
        } catch (NoSuchMethodException e3) {
            Log.w(c, "getProperty() : Get property failed. noSuchMethodException:" + e3.getMessage());
            return str2;
        } catch (InvocationTargetException e4) {
            Log.w(c, "getProperty() : Get property failed. invocationTargetException:" + e4.getMessage());
            return str2;
        }
    }
}
