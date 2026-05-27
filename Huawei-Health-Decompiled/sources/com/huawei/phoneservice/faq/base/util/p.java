package com.huawei.phoneservice.faq.base.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.text.TextUtilsCompat;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes6.dex */
public class p {
    public static void cjM_(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
    }

    public static void cjL_(Activity activity, boolean z, int i) {
        if (activity != null && z) {
            int i2 = Build.VERSION.SDK_INT;
            Window window = activity.getWindow();
            if (window == null) {
                return;
            }
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
            View decorView = window.getDecorView();
            if (decorView == null) {
                return;
            }
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility((i2 >= 29 && cjH_(activity)) ? systemUiVisibility & (-8193) : systemUiVisibility | 8192);
        }
    }

    public static void cjK_(Activity activity) {
        View viewFindViewById;
        if (activity == null || (viewFindViewById = activity.findViewById(R.id.content)) == null) {
            return;
        }
        View childAt = ((ViewGroup) viewFindViewById).getChildAt(0);
        if (childAt == null) {
            h.e("FaqUiUtils", "root view is null");
            return;
        }
        childAt.setFocusable(true);
        childAt.setFocusableInTouchMode(true);
        childAt.requestFocus();
        childAt.requestFocusFromTouch();
        childAt.setDefaultFocusHighlightEnabled(false);
    }

    public static void cjJ_(Activity activity, int[] iArr) {
        if (iArr == null || iArr.length <= 0 || cjI_(activity) || !d.d()) {
            return;
        }
        for (int i : iArr) {
            View viewFindViewById = activity.findViewById(i);
            if (viewFindViewById != null) {
                viewFindViewById.setPadding(0, viewFindViewById.getPaddingTop(), 0, viewFindViewById.getPaddingBottom());
            }
        }
    }

    public static boolean cjI_(Activity activity) throws Throwable {
        String str;
        int iIntValue;
        try {
            iIntValue = ((Integer) Class.forName("android.content.Intent").getMethod("getHwFlags", new Class[0]).invoke(activity.getIntent(), new Object[0])).intValue();
        } catch (ClassNotFoundException unused) {
            str = "isSplitActivity ClassNotFoundException";
            h.b("FaqUiUtils", str);
            iIntValue = 0;
        } catch (IllegalAccessException unused2) {
            str = "isSplitActivity IllegalAccessException";
            h.b("FaqUiUtils", str);
            iIntValue = 0;
        } catch (IllegalArgumentException unused3) {
            str = "isSplitActivity IllegalArgumentException";
            h.b("FaqUiUtils", str);
            iIntValue = 0;
        } catch (NoSuchMethodException unused4) {
            str = "isSplitActivity NoSuchMethodException";
            h.b("FaqUiUtils", str);
            iIntValue = 0;
        } catch (RuntimeException unused5) {
            str = "isSplitActivity RuntimeException";
            h.b("FaqUiUtils", str);
            iIntValue = 0;
        } catch (InvocationTargetException unused6) {
            str = "isSplitActivity InvocationTargetException";
            h.b("FaqUiUtils", str);
            iIntValue = 0;
        } catch (Exception unused7) {
            str = "isSplitActivity Exception";
            h.b("FaqUiUtils", str);
            iIntValue = 0;
        }
        return (iIntValue & 4) != 0;
    }

    public static boolean e(Context context) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(context.getResources().getConfiguration().locale) == 1;
    }

    public static int c(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static boolean cjH_(Activity activity) {
        return (activity == null || activity.getResources() == null || activity.getResources().getConfiguration() == null || (activity.getResources().getConfiguration().uiMode & 48) != 32) ? false : true;
    }
}
