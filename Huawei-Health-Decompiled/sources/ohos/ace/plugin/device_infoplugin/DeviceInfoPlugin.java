package ohos.ace.plugin.device_infoplugin;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.huawei.hms.hihealth.data.DeviceInfo;
import com.huawei.openalliance.ad.constant.Constants;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceInfoPlugin {
    private static final String CLASS_SYSTEM_PROPERTIES = "android.os.SystemProperties";
    private static final String LOG_TAG = "DeviceInfoPlugin";
    private Context context;

    public String getHardwareProfile(String str) {
        return str;
    }

    protected native void nativeInit();

    public DeviceInfoPlugin(Context context) {
        new DeviceInfoPlugin(context, true);
        this.context = context;
    }

    public DeviceInfoPlugin(Context context, boolean z) {
        if (z) {
            nativeInit();
        }
        this.context = context;
    }

    public String getOSFullName(String str) {
        return "Android " + Build.VERSION.RELEASE;
    }

    public String getManufacture(String str) {
        return Build.MANUFACTURER;
    }

    public String getDeviceType(String str) {
        if (this.context.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv")) {
            return Constants.TV_SUFFIX;
        }
        UiModeManager uiModeManager = (UiModeManager) this.context.getSystemService("uimode");
        if (uiModeManager != null && uiModeManager.getCurrentModeType() == 4) {
            return Constants.TV_SUFFIX;
        }
        String deviceTypeByResourceConfiguration = getDeviceTypeByResourceConfiguration();
        return (deviceTypeByResourceConfiguration == null || DeviceInfo.STR_TYPE_UNKNOWN.equals(deviceTypeByResourceConfiguration)) ? getDeviceTypeByPhysicalSize() : deviceTypeByResourceConfiguration;
    }

    public String getBrand(String str) {
        return Build.BRAND;
    }

    public String getMarketName(String str) {
        return Build.PRODUCT;
    }

    public String getProductSeries(String str) {
        return Build.DEVICE;
    }

    public String getProductModel(String str) {
        return Build.MODEL;
    }

    public String getProductModelAlias(String str) {
        return Build.MODEL;
    }

    public String getSoftwareModel(String str) {
        return Build.MODEL;
    }

    public String getHardwareModel(String str) {
        return Build.BOARD;
    }

    public String getBootLoaderVersion(String str) {
        return Build.BOOTLOADER;
    }

    public String getAbiList(String str) {
        return String.join(",", Build.SUPPORTED_ABIS);
    }

    public String getDisplayVersion(String str) {
        return Build.VERSION.RELEASE;
    }

    public String getIncrementalVersion(String str) {
        return Build.VERSION.INCREMENTAL;
    }

    public int getFirstApiVersion(int i) {
        int property = getProperty("persist.product.firstapiversion", -1);
        if (property != -1) {
            return property;
        }
        setProperty("persist.product.firstapiversion", Integer.toString(i));
        return i;
    }

    private String getProperty(String str, String str2) {
        return getProp(str, str2);
    }

    private int getProperty(String str, int i) {
        try {
            return Integer.parseInt(getProp(str, Integer.toString(i)));
        } catch (NumberFormatException e) {
            Log.e(LOG_TAG, "Failed to get property name: " + str + " exception: " + e.toString());
            return i;
        }
    }

    private static int setProperty(String str, String str2) {
        Object objInvoke = invoke(CLASS_SYSTEM_PROPERTIES, "set", new Class[]{String.class, String.class}, str, str2);
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return -1;
    }

    private static String getProp(String str, String str2) {
        Object objInvoke = invoke(CLASS_SYSTEM_PROPERTIES, "get", new Class[]{String.class, String.class}, str, str2);
        return objInvoke instanceof String ? (String) objInvoke : str2;
    }

    private static Object invoke(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Class<?> cls = Class.forName(str);
            return cls.getDeclaredMethod(str2, clsArr).invoke(cls, objArr);
        } catch (ClassNotFoundException e) {
            e = e;
            Log.e(LOG_TAG, "invoke " + e.getClass().getSimpleName());
            return null;
        } catch (IllegalAccessException e2) {
            e = e2;
            Log.e(LOG_TAG, "invoke " + e.getClass().getSimpleName());
            return null;
        } catch (IllegalArgumentException e3) {
            e = e3;
            Log.e(LOG_TAG, "invoke " + e.getClass().getSimpleName());
            return null;
        } catch (NoSuchMethodException e4) {
            e = e4;
            Log.e(LOG_TAG, "invoke " + e.getClass().getSimpleName());
            return null;
        } catch (SecurityException e5) {
            e = e5;
            Log.e(LOG_TAG, "invoke " + e.getClass().getSimpleName());
            return null;
        } catch (InvocationTargetException e6) {
            e = e6;
            Log.e(LOG_TAG, "invoke " + e.getClass().getSimpleName());
            return null;
        } catch (Exception e7) {
            Log.e(LOG_TAG, "unknown Exception in invoke");
            e7.printStackTrace();
            return null;
        }
    }

    private String getDeviceTypeByResourceConfiguration() {
        int i = this.context.getResources().getConfiguration().smallestScreenWidthDp;
        return i == 0 ? DeviceInfo.STR_TYPE_UNKNOWN : i >= 600 ? "tablet" : "phone";
    }

    private String getDeviceTypeByPhysicalSize() {
        WindowManager windowManager = (WindowManager) this.context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        if (windowManager == null) {
            return DeviceInfo.STR_TYPE_UNKNOWN;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        double dSqrt = Math.sqrt(Math.pow(((double) displayMetrics.widthPixels) / ((double) displayMetrics.xdpi), 2.0d) + Math.pow(((double) displayMetrics.heightPixels) / ((double) displayMetrics.ydpi), 2.0d));
        return (dSqrt < 3.0d || dSqrt > 6.9d) ? (dSqrt <= 6.9d || dSqrt > 18.0d) ? DeviceInfo.STR_TYPE_UNKNOWN : "tablet" : "phone";
    }
}
