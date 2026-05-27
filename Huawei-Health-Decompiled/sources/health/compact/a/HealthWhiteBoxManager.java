package health.compact.a;

import android.content.Context;
import com.huawei.whitebox.NdkJniUtils;

/* JADX INFO: loaded from: classes2.dex */
public class HealthWhiteBoxManager {
    private static final Object b = new Object();
    private static HealthWhiteBoxManager d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f13754a;
    private NdkJniUtils c = new NdkJniUtils();

    private HealthWhiteBoxManager(Context context) {
        this.f13754a = context;
    }

    public static HealthWhiteBoxManager b(Context context) {
        HealthWhiteBoxManager healthWhiteBoxManager;
        synchronized (b) {
            if (d == null) {
                d = new HealthWhiteBoxManager(context);
            }
            healthWhiteBoxManager = d;
        }
        return healthWhiteBoxManager;
    }

    public byte[] e(String str) {
        if (!this.c.isAuthChecked()) {
            this.c.executeAuth(this.f13754a);
        }
        return this.c.encrypt(str);
    }

    public byte[] c(byte[] bArr) {
        if (!this.c.isAuthChecked()) {
            this.c.executeAuth(this.f13754a);
        }
        return this.c.decrypt(bArr);
    }

    public String e(int i, int i2) {
        if (!this.c.isAuthChecked()) {
            this.c.executeAuth(this.f13754a);
        }
        return this.c.getStorageInfo(i, i2);
    }

    public byte[] a(int i, byte[] bArr, byte[] bArr2) {
        if (!this.c.isAuthChecked()) {
            this.c.executeAuth(this.f13754a);
        }
        return this.c.b(i, bArr, bArr2);
    }
}
