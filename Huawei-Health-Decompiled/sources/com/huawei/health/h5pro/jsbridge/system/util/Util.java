package com.huawei.health.h5pro.jsbridge.system.util;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface Util {
    JSONObject deviceInfo(Context context);

    boolean isAppInstalled(Context context, String str);
}
