package com.huawei.secure.android.common.detect;

import android.os.Build;
import com.huawei.android.os.SystemPropertiesEx;
import com.huawei.secure.android.common.detect.utils.d;

/* JADX INFO: loaded from: classes11.dex */
public class DeviceDetect {
    public static boolean isFProjectDevice() {
        boolean zA = d.a("hw_sc.product.useBrandCust", false);
        if (zA) {
            return zA;
        }
        try {
            return SystemPropertiesEx.getBoolean("hw_sc.product.useBrandCust", false);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isHonorDevice() {
        return Build.MANUFACTURER.equalsIgnoreCase("HONOR");
    }

    public static boolean isHuaweiDevice() {
        return Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") || isFProjectDevice();
    }

    public static boolean isHuaweiOrHonorDevice() {
        return isHonorDevice() || isHuaweiDevice();
    }
}
