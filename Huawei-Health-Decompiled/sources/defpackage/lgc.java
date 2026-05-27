package defpackage;

import health.compact.a.hwlogsmodel.ReleaseLogUtil;

/* JADX INFO: loaded from: classes6.dex */
public class lgc {
    public static void c(String str, int i, int i2) {
        ReleaseLogUtil.d("R_" + str, "ServiceId = ", Integer.valueOf(i), ", CommandId = ", Integer.valueOf(i2));
    }

    public static void d(String str, Object... objArr) {
        ReleaseLogUtil.d("R_" + str, objArr);
    }
}
