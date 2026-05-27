package defpackage;

import android.util.Log;
import com.huawei.openalliance.ad.constant.Constants;
import java.io.IOError;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.acl.NotOwnerException;
import java.sql.SQLException;
import java.util.ConcurrentModificationException;
import java.util.MissingResourceException;

/* JADX INFO: loaded from: classes.dex */
public class nni {
    private static boolean b = false;
    private static boolean e = false;

    static {
        try {
            Field field = Log.class.getField("HWLog");
            Field field2 = Log.class.getField("HWModuleLog");
            e = field.getBoolean(null);
            boolean z = field2.getBoolean(null);
            b = z;
            e = e || (z && Log.isLoggable("LogUtils", 3));
            Log.i("LogUtils", "HwDebug:" + e + " HwModuleDebug:" + b);
        } catch (IllegalAccessException e2) {
            Log.e("LogUtils", "error:getLogField--IllegalAccessException" + d(e2));
        } catch (IllegalArgumentException e3) {
            Log.e("LogUtils", "error:getLogField--IllegalArgumentException" + d(e3));
        } catch (NoSuchFieldException e4) {
            Log.e("LogUtils", "error:getLogField--NoSuchFieldException" + d(e4));
        }
    }

    public static void d(String str, String str2) {
        Log.i("PictureSecuritySDK", str + " info:" + str2);
    }

    public static void e(String str, String str2) {
        Log.w("PictureSecuritySDK", str + " warn: " + str2);
    }

    public static void b(String str, String str2) {
        Log.e("PictureSecuritySDK", str + " error:" + str2);
    }

    public static void c(String str, String str2, Throwable th) {
        Log.e("PictureSecuritySDK", str + " error:" + str2 + Constants.LINK + d(th));
    }

    public static String d(Throwable th) {
        if (th == null) {
            return "null Throwable";
        }
        if (th instanceof Exception) {
            if ((th instanceof IOException) || th.toString().contains("IOException") || th.toString().contains("FileNotFoundException") || (th instanceof MissingResourceException) || (th instanceof NotOwnerException) || (th instanceof ConcurrentModificationException) || (th instanceof SQLException) || th.toString().contains("InsufficientResourcesException")) {
                return th.getClass().getSimpleName();
            }
        } else if (th instanceof Error) {
            if ((th instanceof IOError) || th.toString().contains("IOException") || th.toString().contains("IOError") || th.toString().contains("FileNotFoundException") || (th instanceof OutOfMemoryError) || (th instanceof StackOverflowError)) {
                return th.getClass().getSimpleName();
            }
        } else if (th.toString().contains("IOException") || th.toString().contains("IOError") || th.toString().contains("FileNotFoundException")) {
            return th.getClass().getSimpleName();
        }
        return th.toString();
    }
}
