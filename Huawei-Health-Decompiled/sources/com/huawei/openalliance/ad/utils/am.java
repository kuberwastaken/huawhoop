package com.huawei.openalliance.ad.utils;

import android.content.Context;
import com.huawei.openalliance.ad.hq;

/* JADX INFO: loaded from: classes6.dex */
public class am {
    public static boolean d() {
        return co.a("com.hihonor.common.grs.HihonorGrsApp", "getIssueCountryCode", (Class<?>[]) new Class[]{Context.class});
    }

    public static boolean c() {
        return co.a("com.huawei.hms.framework.network.grs.GrsApp", "getIssueCountryCode", (Class<?>[]) new Class[]{Context.class});
    }

    public static boolean b() {
        try {
            Class.forName("com.hihonor.common.grs.HihonorGrsApi");
            return true;
        } catch (Throwable unused) {
            hq.c("GrsUtil", "check honor grs available error");
            return false;
        }
    }

    public static boolean a() {
        try {
            Class.forName("com.huawei.hms.framework.network.grs.GrsApi");
            return true;
        } catch (Throwable unused) {
            hq.c("GrsUtil", "check grs available error");
            return false;
        }
    }
}
