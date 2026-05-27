package com.tencent.open.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.WindowManager;
import com.huawei.openalliance.ad.constant.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f11873a;
    private static String b;

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f11873a)) {
            return f11873a;
        }
        if (context == null) {
            return "";
        }
        f11873a = "";
        WindowManager windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        if (windowManager != null) {
            f11873a = windowManager.getDefaultDisplay().getWidth() + "x" + windowManager.getDefaultDisplay().getHeight();
        }
        return f11873a;
    }

    public static String a() {
        return Locale.getDefault().getLanguage();
    }
}
