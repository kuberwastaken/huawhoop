package com.huawei.openalliance.ad.utils;

import android.os.Build;
import com.huawei.openalliance.ad.hq;
import javax.net.ssl.SSLContext;

/* JADX INFO: loaded from: classes6.dex */
public class cs {
    public static SSLContext a() {
        String str;
        if (Build.VERSION.SDK_INT >= 29) {
            hq.a("SSLContextUtil", "use tls 1.3");
            str = "TLSv1.3";
        } else {
            hq.a("SSLContextUtil", "use tls 1.2");
            str = "TLSv1.2";
        }
        return SSLContext.getInstance(str);
    }
}
