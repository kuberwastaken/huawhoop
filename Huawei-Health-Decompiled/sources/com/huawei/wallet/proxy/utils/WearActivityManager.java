package com.huawei.wallet.proxy.utils;

import android.app.Activity;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class WearActivityManager {
    private static List<Activity> d = new ArrayList();

    public static void fku_(Activity activity) {
        synchronized (WearActivityManager.class) {
            d.add(activity);
        }
    }

    public static void b(String str) {
        synchronized (WearActivityManager.class) {
            if (!TextUtils.isEmpty(str)) {
                for (Activity activity : d) {
                    if (str.equals(activity.getClass().getName())) {
                        activity.finish();
                    }
                }
            }
        }
    }
}
