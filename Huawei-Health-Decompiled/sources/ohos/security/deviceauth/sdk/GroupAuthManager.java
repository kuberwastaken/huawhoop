package ohos.security.deviceauth.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
public interface GroupAuthManager {
    int authDevice(long j, String str, DeviceAuthCallback deviceAuthCallback);

    void destroyService();

    int initService(Context context, String str);

    int processData(long j, byte[] bArr, DeviceAuthCallback deviceAuthCallback);
}
