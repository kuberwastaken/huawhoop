package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.hq;

/* JADX INFO: loaded from: classes6.dex */
public abstract class bm {
    public static void a(Context context, int i, String str) {
        if (i < 4) {
            i = 4;
        }
        if (TextUtils.isEmpty(str)) {
            str = da.a(context);
            if (TextUtils.isEmpty(str)) {
                hq.c("LogTool", "enable log failed, due to root path is null");
                return;
            }
        }
        hq.a(i, str, "HiAd");
    }

    public static void a(Context context) {
        a(context, 4, null);
    }
}
