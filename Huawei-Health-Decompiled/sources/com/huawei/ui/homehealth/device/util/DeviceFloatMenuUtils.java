package com.huawei.ui.homehealth.device.util;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.huawei.openalliance.ad.constant.Constants;

/* JADX INFO: loaded from: classes7.dex */
public class DeviceFloatMenuUtils {
    private static View d = null;
    public static boolean e = false;

    /* JADX INFO: loaded from: classes11.dex */
    public interface MenuClickListener {
        void setOnClick(int i);
    }

    public static void b(Context context) {
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).removeView(d);
        e = false;
    }
}
