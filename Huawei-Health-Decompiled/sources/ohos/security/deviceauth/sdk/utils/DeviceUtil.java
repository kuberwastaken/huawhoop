package ohos.security.deviceauth.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.Process;
import android.text.TextUtils;
import defpackage.ybi;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes8.dex */
public class DeviceUtil {
    private static final String BRAND_HARMONY = "harmony";
    private static final String CLASS_NAME_BUILDEX = "com.huawei.android.os.BuildEx";
    private static final String CLASS_NAME_DAS = "com.huawei.security.deviceauth.HwDeviceGroupManager";
    private static final String CLASS_NAME_PROPERTIES = "android.os.SystemProperties";
    private static final String EMUI_VERSION_PREFIX = "EmotionUI";
    private static final String EMUI_VERSION_PROP = "ro.build.version.emui";
    private static final String GROUP_AUTH_PERMISSION = "com.huawei.permission.ACCESS_HW_GROUP_AUTH_SERVICE";
    private static final String GROUP_AUTH_SERVICE_NAME = "com.huawei.securityserver.HwDeviceGroupAuthService";
    private static final String GROUP_AUTH_SERVICE_PACKAGE_NAME = "com.huawei.securityserver";
    private static final String GROUP_MANAGE_PERMISSION = "com.huawei.permission.ACCESS_DEVICE_GROUP_MANAGER";
    private static final int MAIN_USER = 0;
    private static final String MANUFACTURER_HONOR = "HONOR";
    private static final String MANUFACTURER_PROP = "ro.product.manufacturer";
    private static final String METHOD_NAME_DAS = "processRequestData";
    private static final String OS_PKG_ANDROID = "android";
    private static final String OS_PKG_HWEXT = "androidhwext";
    private static final int PER_USER_RANGE = 100000;
    private static final String TAG = "DeviceUtil";
    private static final boolean IS_BUILD_EX_SUPPORTED = isEmuiBuildExSupported();
    private static final boolean IS_HUAWEI_SYSTEM = isHuaweiSystem();
    private static final boolean IS_SYSTEM_SERVICE_SUPPORTED = isHichain3Supported();
    private static String sUdid = "";

    private DeviceUtil() {
    }

    public static boolean isSystemServiceSupported(Context context) {
        if (IS_SYSTEM_SERVICE_SUPPORTED && isExistGroupAuthService(context) && isHaveAccessPermission(context)) {
            ybi.e(TAG, "Support using the system service capabilities.");
            return true;
        }
        ybi.e(TAG, "Support using the native service capabilities.");
        return false;
    }

    public static String getUdid() {
        StringBuilder sb = new StringBuilder("getUdid ");
        String str = sUdid;
        sb.append(str.substring(0, Math.min(4, str.length())));
        sb.append("****");
        ybi.e(TAG, sb.toString());
        return sUdid;
    }

    public static void setUdid(String str) {
        if (str == null) {
            ybi.d(TAG, "setUdid: udid is null");
            return;
        }
        StringBuilder sb = new StringBuilder("setUdid ");
        String str2 = sUdid;
        sb.append(str2.substring(0, Math.min(4, str2.length())));
        sb.append("****");
        ybi.e(TAG, sb.toString());
        sUdid = str;
    }

    private static boolean isExistGroupAuthService(Context context) {
        if (context == null) {
            ybi.d(TAG, "isExistGroupAuthService: context is null");
            return false;
        }
        Intent intent = new Intent();
        intent.setClassName(GROUP_AUTH_SERVICE_PACKAGE_NAME, GROUP_AUTH_SERVICE_NAME);
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            ybi.d(TAG, "isExistGroupAuthService: PackageManager is null");
            return false;
        }
        if (packageManager.resolveService(intent, 0) == null) {
            ybi.e(TAG, "isExistGroupAuthService: groupAuthService is not exist");
            return false;
        }
        ybi.e(TAG, "isExistGroupAuthService: groupAuthService is exist");
        return true;
    }

    private static boolean isHaveAccessPermission(Context context) {
        if (context == null) {
            ybi.d(TAG, "isHaveAccessPermission: context is null");
            return false;
        }
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            ybi.e(TAG, "isHaveAccessPermission: can not get callerPackageName");
            return false;
        }
        if (!checkCallerPermission(context, packageName, GROUP_MANAGE_PERMISSION)) {
            ybi.d(TAG, "caller not has group manage permission, callerPackageName:" + packageName);
            return false;
        }
        if (!checkCallerPermission(context, packageName, GROUP_AUTH_PERMISSION)) {
            ybi.d(TAG, "caller not has group auth permission, callerPackageName:" + packageName);
            return false;
        }
        ybi.e(TAG, "isHaveAccessPermission: caller has access permission");
        return true;
    }

    private static boolean isHichain3Supported() {
        if (!IS_HUAWEI_SYSTEM) {
            ybi.e(TAG, "Non-Huawei and non-Harmony, use the native service capabilities.");
            return false;
        }
        try {
            Class.forName(CLASS_NAME_DAS).getMethod(METHOD_NAME_DAS, Long.TYPE, byte[].class);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            ybi.e(TAG, "Old version, use the native service capabilities.");
        }
        if (Process.myUid() / 100000 == 0) {
            ybi.e(TAG, "New version in main user, use the system service capabilities.");
            return true;
        }
        ybi.e(TAG, "New version in sub user, use the native service capabilities.");
        return false;
    }

    private static boolean isHuaweiSystem() {
        return isEmuiSystem() || isHarmonySystem();
    }

    private static boolean isEmuiSystem() {
        if (isHonorSystem()) {
            ybi.e(TAG, "This is Honor system.");
            return false;
        }
        if (!IS_BUILD_EX_SUPPORTED) {
            ybi.e(TAG, "BuildEx is not supported.");
            return false;
        }
        String systemProperties = getSystemProperties(EMUI_VERSION_PROP);
        if (TextUtils.isEmpty(systemProperties)) {
            ybi.d(TAG, "Cannot get EMUI version.");
            return false;
        }
        return systemProperties.contains(EMUI_VERSION_PREFIX);
    }

    private static boolean isHonorSystem() {
        return "HONOR".equals(getSystemProperties(MANUFACTURER_PROP));
    }

    private static boolean isHarmonySystem() {
        if (isHonorSystem()) {
            ybi.e(TAG, "This is Honor system.");
            return false;
        }
        try {
            Object objInvoke = Class.forName("com.huawei.system.BuildEx").getDeclaredMethod("getOsBrand", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return BRAND_HARMONY.equals(objInvoke);
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            ybi.d(TAG, "Unexpected exception.");
        }
        return false;
    }

    private static boolean isSystemExitPermission(Context context, String str) {
        PermissionInfo permissionInfo;
        try {
            permissionInfo = context.getPackageManager().getPermissionInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            ybi.b("cannot found permission: " + str, new Object[0]);
            permissionInfo = null;
        }
        if (permissionInfo == null) {
            return false;
        }
        ybi.e(TAG, "android res: " + "android".equals(permissionInfo.packageName) + " hwext res: " + OS_PKG_HWEXT.equals(permissionInfo.packageName));
        return "android".equals(permissionInfo.packageName) || OS_PKG_HWEXT.equals(permissionInfo.packageName);
    }

    private static boolean hasPermission(Context context, String str) {
        return context != null && (context.checkSelfPermission(str) == 0 || !isSystemExitPermission(context, str));
    }

    private static String getSystemProperties(String str) {
        if (TextUtils.isEmpty(str)) {
            ybi.d(TAG, "Input parameter is empty.");
            return "";
        }
        try {
            Object objInvoke = Class.forName(CLASS_NAME_PROPERTIES).getDeclaredMethod("get", String.class, String.class).invoke(null, str, "");
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            ybi.d(TAG, "Get system properties failed.");
        }
        return "";
    }

    private static boolean isEmuiBuildExSupported() {
        try {
            Class.forName(CLASS_NAME_BUILDEX);
            return true;
        } catch (ClassNotFoundException unused) {
            ybi.e(TAG, "BuildEx is not supported.");
            return false;
        }
    }

    private static boolean checkCallerPermission(Context context, String str, String str2) {
        if (context == null) {
            ybi.d(TAG, "checkCallerPermission: context is null");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            ybi.d(TAG, "Can not get package manager");
            return false;
        }
        if (packageManager.checkPermission(str2, str) == 0) {
            return true;
        }
        ybi.d(TAG, "NO_PERMISSION : need permission " + str2);
        return false;
    }
}
