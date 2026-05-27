package defpackage;

import android.content.Context;
import ohos.security.deviceauth.sdk.DeviceAuthCallback;
import ohos.security.deviceauth.sdk.GroupAuthManager;
import ohos.security.deviceauth.sdk.NativeDas;

/* JADX INFO: loaded from: classes8.dex */
class ybe implements GroupAuthManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f19224a;
    private boolean b = false;

    ybe() {
    }

    @Override // ohos.security.deviceauth.sdk.GroupAuthManager
    public int initService(Context context, String str) {
        if (this.b) {
            return 0;
        }
        if (!NativeDas.isLibraryLoaded()) {
            ybi.d("NativeGroupAuthManager", "The local library was not loaded successfully, the service could not be initialized.");
            return -1;
        }
        if (context == null || context.getFilesDir() == null) {
            ybi.d("NativeGroupAuthManager", "initService: Invalid context.");
            return -1;
        }
        int iInitService = NativeDas.initService(context.getFilesDir().getPath(), str);
        if (iInitService != 0) {
            ybi.d("NativeGroupAuthManager", "initService: Init group manager service failed.");
            return iInitService;
        }
        long gaInstance = NativeDas.getGaInstance();
        this.f19224a = gaInstance;
        if (gaInstance == 0) {
            ybi.d("NativeGroupAuthManager", "initService: Get instance of ga failed.");
            return -1;
        }
        this.b = true;
        return 0;
    }

    @Override // ohos.security.deviceauth.sdk.GroupAuthManager
    public void destroyService() {
        if (this.b) {
            NativeDas.destroyService();
            this.b = false;
        }
    }

    @Override // ohos.security.deviceauth.sdk.GroupAuthManager
    public int processData(long j, byte[] bArr, DeviceAuthCallback deviceAuthCallback) {
        if (!this.b) {
            ybi.d("NativeGroupAuthManager", "The service is not started. Please call the initService first.");
            return -1;
        }
        return NativeDas.processGaData(this.f19224a, j, bArr, deviceAuthCallback);
    }

    @Override // ohos.security.deviceauth.sdk.GroupAuthManager
    public int authDevice(long j, String str, DeviceAuthCallback deviceAuthCallback) {
        if (!this.b) {
            ybi.d("NativeGroupAuthManager", "The service is not started. Please call the initService first.");
            return -1;
        }
        return NativeDas.authDevice(this.f19224a, j, str, deviceAuthCallback);
    }
}
