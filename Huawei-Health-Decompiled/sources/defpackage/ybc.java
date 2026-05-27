package defpackage;

import android.content.Context;
import com.huawei.security.deviceauth.HichainAuthManager;
import ohos.security.deviceauth.sdk.DeviceAuthCallback;
import ohos.security.deviceauth.sdk.GroupAuthManager;

/* JADX INFO: loaded from: classes8.dex */
public class ybc implements GroupAuthManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HichainAuthManager f19223a;

    @Override // ohos.security.deviceauth.sdk.GroupAuthManager
    public void destroyService() {
    }

    ybc() {
    }

    @Override // ohos.security.deviceauth.sdk.GroupAuthManager
    public int processData(long j, byte[] bArr, DeviceAuthCallback deviceAuthCallback) {
        HichainAuthManager hichainAuthManager = this.f19223a;
        if (hichainAuthManager != null) {
            return hichainAuthManager.processAuthData(a(deviceAuthCallback), j, bArr) ? 0 : -1;
        }
        ybi.d("PlatformGroupAuthManager", "instance is null");
        return -1;
    }

    @Override // ohos.security.deviceauth.sdk.GroupAuthManager
    public int authDevice(long j, String str, DeviceAuthCallback deviceAuthCallback) {
        HichainAuthManager hichainAuthManager = this.f19223a;
        if (hichainAuthManager == null) {
            ybi.d("PlatformGroupAuthManager", "instance is null");
            return -1;
        }
        return hichainAuthManager.authDevice(a(deviceAuthCallback), j, str);
    }

    @Override // ohos.security.deviceauth.sdk.GroupAuthManager
    public int initService(Context context, String str) {
        HichainAuthManager hichainAuthManager = HichainAuthManager.getInstance(context);
        this.f19223a = hichainAuthManager;
        if (hichainAuthManager != null) {
            return 0;
        }
        ybi.d("PlatformGroupAuthManager", "instance is null");
        return -1;
    }

    private HichainAuthManager.HichainAuthCallback a(final DeviceAuthCallback deviceAuthCallback) {
        if (deviceAuthCallback == null) {
            return null;
        }
        return new HichainAuthManager.HichainAuthCallback() { // from class: ohos.security.deviceauth.sdk.PlatformGroupAuthManager$1
            public void onFinish(long j, int i, String str) {
                deviceAuthCallback.onFinish(j, i, str);
            }

            public void onError(long j, int i, int i2, String str) {
                deviceAuthCallback.onError(j, i, i2, str);
            }

            public boolean onTransmit(long j, byte[] bArr) {
                return deviceAuthCallback.onTransmit(j, bArr);
            }

            public String onRequest(long j, int i, String str) {
                return deviceAuthCallback.onRequest(j, i, str);
            }

            public void onSessionKeyReturned(long j, byte[] bArr) {
                deviceAuthCallback.onSessionKeyReturned(j, bArr);
            }
        };
    }
}
