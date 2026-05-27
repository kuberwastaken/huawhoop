package health.compact.a;

import com.huawei.hwcommonmodel.application.BaseApplication;

/* JADX INFO: loaded from: classes2.dex */
public class WhiteBoxManager {
    private static final Object c = new Object();
    private static WhiteBoxManager e;

    public static WhiteBoxManager c() {
        WhiteBoxManager whiteBoxManager;
        synchronized (c) {
            if (e == null) {
                e = new WhiteBoxManager();
            }
            whiteBoxManager = e;
        }
        return whiteBoxManager;
    }

    public byte[] a(String str) {
        return HealthWhiteBoxManager.b(BaseApplication.getContext()).e(str);
    }

    public byte[] d(byte[] bArr) {
        return HealthWhiteBoxManager.b(BaseApplication.getContext()).c(bArr);
    }

    public String a(int i, int i2) {
        return HealthWhiteBoxManager.b(BaseApplication.getContext()).e(i, i2);
    }

    public byte[] b(int i, byte[] bArr, byte[] bArr2) {
        return HealthWhiteBoxManager.b(BaseApplication.getContext()).a(i, bArr, bArr2);
    }
}
