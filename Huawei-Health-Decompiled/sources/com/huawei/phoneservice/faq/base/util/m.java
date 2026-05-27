package com.huawei.phoneservice.faq.base.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.huawei.android.fsm.HwFoldScreenManagerEx;
import com.huawei.openalliance.ad.constant.Constants;

/* JADX INFO: loaded from: classes6.dex */
public class m {
    public static void cjG_(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.width = i;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static void cjF_(View view, int i, int i2) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.getMarginStart() != 0) {
                marginLayoutParams.setMarginStart(i);
            }
            if (marginLayoutParams.getMarginEnd() != 0) {
                marginLayoutParams.setMarginEnd(i2);
            }
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static void cjE_(Activity activity, int[] iArr, int i) {
        if (iArr == null || activity == null) {
            return;
        }
        int dimension = (int) activity.getResources().getDimension(i);
        for (int i2 : iArr) {
            View viewFindViewById = activity.findViewById(i2);
            if (viewFindViewById != null) {
                cjF_(viewFindViewById, dimension, dimension);
            }
        }
    }

    public static boolean c(Context context) {
        try {
            if (!e()) {
                return false;
            }
            if (HwFoldScreenManagerEx.getDisplayMode() != 1) {
                if (HwFoldScreenManagerEx.getDisplayMode() != 7) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            boolean z = context == null || context.getResources() == null || context.getResources().getConfiguration() == null;
            h.e("FaqTahitiUtils", "isPadOrTahitiDevice isNull:" + z);
            if (z) {
                return false;
            }
            float f = cjD_(context).widthPixels;
            float f2 = cjD_(context).heightPixels;
            return ((double) (Math.max(f, f2) / Math.min(f, f2))) < 1.33d && context.getResources().getConfiguration().smallestScreenWidthDp > 533;
        }
    }

    public static boolean e(Context context) {
        if (c(context)) {
            return true;
        }
        return d.d();
    }

    private static boolean e() {
        try {
            return HwFoldScreenManagerEx.isFoldable();
        } catch (Throwable unused) {
            h.e("FaqTahitiUtils", "get device foldAble error");
            return false;
        }
    }

    private static DisplayMetrics cjD_(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null) {
            ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }
}
