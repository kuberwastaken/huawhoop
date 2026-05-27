package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.util.Size;
import android.view.WindowManager;
import com.huawei.openalliance.ad.constant.Constants;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes8.dex */
public class vmi {
    private static final String e = "HwDeviceUtils";

    public static boolean a() {
        String strA = a("ro.build.characteristics", "default");
        return strA != null && strA.equalsIgnoreCase("tablet");
    }

    public static boolean b(Context context) {
        return evB_(evA_(context));
    }

    public static boolean c() {
        String[] strArrSplit = a("ro.config.hw_fold_disp", "").split(",");
        try {
            if (strArrSplit.length == 9) {
                if (Integer.parseInt(strArrSplit[8]) / 100 == 3) {
                    return true;
                }
            }
        } catch (NumberFormatException unused) {
            Log.w(e, "number format Exception");
        }
        return false;
    }

    private static boolean evB_(Size size) {
        return size != null && Float.compare(((float) size.getWidth()) / ((float) size.getHeight()), 0.875f) >= 0;
    }

    private static Size evA_(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealSize(point);
        if (point.y < point.x) {
            return new Size(point.y, point.x);
        }
        return new Size(point.x, point.y);
    }

    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
            return objInvoke instanceof String ? (String) objInvoke : str2;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            Log.w(e, "getProperty() : Get property failed.");
            return str2;
        }
    }
}
