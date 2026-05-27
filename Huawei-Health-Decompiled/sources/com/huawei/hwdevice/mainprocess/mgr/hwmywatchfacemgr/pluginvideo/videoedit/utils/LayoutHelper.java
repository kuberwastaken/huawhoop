package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videoedit.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.huawei.openalliance.ad.constant.Constants;
import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes6.dex */
public class LayoutHelper {
    public static final String TAG = "LayoutHelper";
    private static Context sContext;
    private static volatile NavigationBarHandler sNaviBarHandler;
    private static int sScreenHeight;
    private static int sScreenWidth;

    private LayoutHelper() {
    }

    public static void init(Context context) {
        sContext = context;
        updateDimensions(context);
        if (sNaviBarHandler == null) {
            sNaviBarHandler = new NavigationBarHandler(context);
        }
    }

    public static void updateDimensions(Context context) {
        if (context == null) {
            LogUtil.a(TAG, "updateDimensions context is null");
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealMetrics(displayMetrics);
        if (isPort()) {
            sScreenWidth = displayMetrics.widthPixels;
            sScreenHeight = displayMetrics.heightPixels;
        } else {
            sScreenWidth = displayMetrics.heightPixels;
            sScreenHeight = displayMetrics.widthPixels;
        }
    }

    public static int getNavigationBarHeight() {
        if (sNaviBarHandler != null) {
            return sNaviBarHandler.getHeight();
        }
        return 0;
    }

    public static int getScreenWidth() {
        return isPort() ? sScreenWidth : sScreenHeight;
    }

    public static int getScreenHeight() {
        return isPort() ? sScreenHeight : sScreenWidth;
    }

    public static boolean isPort() {
        Resources resources;
        Context context = sContext;
        return context == null || (resources = context.getResources()) == null || resources.getConfiguration().orientation == 1;
    }

    public static int getDimensPixelSize(int i) {
        Context context = sContext;
        if (context == null) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(i);
    }

    public static int getDimensPixelSize(Context context, int i) {
        if (context != null) {
            return context.getResources().getDimensionPixelSize(i);
        }
        Context context2 = sContext;
        if (context2 != null) {
            return context2.getResources().getDimensionPixelSize(i);
        }
        return 0;
    }

    public static String getString(Context context, int i) {
        if (context != null) {
            return context.getResources().getString(i);
        }
        Context context2 = sContext;
        if (context2 != null) {
            return context2.getResources().getString(i);
        }
        LogUtil.a(TAG, "getString context is null, return null");
        return null;
    }

    public static int getInteger(int i) {
        Context context = sContext;
        if (context == null) {
            return 0;
        }
        return context.getResources().getInteger(i);
    }
}
