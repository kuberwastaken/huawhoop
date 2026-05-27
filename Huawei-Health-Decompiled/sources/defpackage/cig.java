package defpackage;

import com.huawei.haf.application.BaseApplication;
import health.compact.a.HealthWhiteBoxManager;

/* JADX INFO: loaded from: classes3.dex */
public class cig {
    public static byte[] d(byte[] bArr) {
        return HealthWhiteBoxManager.b(BaseApplication.a()).c(bArr);
    }

    public static String e(int i, int i2) {
        return HealthWhiteBoxManager.b(BaseApplication.a()).e(i, i2);
    }
}
