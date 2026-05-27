package com.huawei.operation.utils;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.haf.common.exception.ExceptionUtils;
import health.compact.a.CommonUtil;
import health.compact.a.hwlogsmodel.ReleaseLogUtil;

/* JADX INFO: loaded from: classes6.dex */
public class PhoneInfoUtils {
    private static final String MESSAGE_HW_PHONE = "HW";
    private static final String MESSAGE_OTHER_PHONE = "3RD";
    private static final String RELEASE_LOG_TAG = "R_PhoneInfoUtils";

    private PhoneInfoUtils() {
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getPhoneType() {
        return "huawei".equalsIgnoreCase(Build.MANUFACTURER) ? MESSAGE_HW_PHONE : MESSAGE_OTHER_PHONE;
    }

    public static String getHuaweiManufaturerOrEmui() {
        return ("huawei".equalsIgnoreCase(Build.MANUFACTURER) || CommonUtil.bf()) ? MESSAGE_HW_PHONE : MESSAGE_OTHER_PHONE;
    }

    public static String getTerminalMarketingName() {
        String marketingName = getMarketingName();
        return !TextUtils.isEmpty(marketingName) ? marketingName : Build.MODEL;
    }

    private static String getMarketingName() {
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, "ro.config.marketing_name");
            if (objInvoke != null && (objInvoke instanceof String)) {
                return (String) objInvoke;
            }
        } catch (ClassCastException e) {
            ReleaseLogUtil.a(RELEASE_LOG_TAG, ExceptionUtils.a(e));
        } catch (Exception e2) {
            ReleaseLogUtil.a(RELEASE_LOG_TAG, "getMarketingName Exception", ExceptionUtils.a(e2));
        }
        return "";
    }
}
