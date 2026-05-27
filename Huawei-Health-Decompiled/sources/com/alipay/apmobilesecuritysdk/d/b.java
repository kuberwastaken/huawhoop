package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.h;
import com.huawei.openalliance.ad.constant.JsbMapKeyNames;
import defpackage.kn;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class b {
    public static Map<String, String> a(Context context, Map<String, String> map) {
        HashMap map2;
        synchronized (b.class) {
            map2 = new HashMap();
            String strD = kn.d(map, "tid", "");
            String strD2 = kn.d(map, "utdid", "");
            String strD3 = kn.d(map, JsbMapKeyNames.H5_USER_ID, "");
            String strD4 = kn.d(map, "appName", "");
            String strD5 = kn.d(map, "appKeyClient", "");
            String strD6 = kn.d(map, "tmxSessionId", "");
            String strF = h.f(context);
            String strD7 = kn.d(map, "sessionId", "");
            map2.put("AC1", strD);
            map2.put("AC2", strD2);
            map2.put("AC3", "");
            map2.put("AC4", strF);
            map2.put("AC5", strD3);
            map2.put("AC6", strD6);
            map2.put("AC7", com.alipay.apmobilesecuritysdk.c.b.a(context));
            map2.put("AC8", strD4);
            map2.put("AC9", strD5);
            if (kn.b(strD7)) {
                map2.put("AC10", strD7);
            }
        }
        return map2;
    }
}
