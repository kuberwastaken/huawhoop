package com.huawei.openplatform.abl.log.util;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public abstract class d {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            Log.w("ReflectAPI", "class not found for " + str);
            return false;
        }
    }
}
