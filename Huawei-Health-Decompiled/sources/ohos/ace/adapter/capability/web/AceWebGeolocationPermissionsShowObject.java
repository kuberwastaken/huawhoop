package ohos.ace.adapter.capability.web;

import android.webkit.GeolocationPermissions;
import ohos.ace.adapter.ALog;

/* JADX INFO: loaded from: classes11.dex */
public class AceWebGeolocationPermissionsShowObject {
    private static final String LOG_TAG = "AceWebGeolocationPermissionsShowObject";
    private GeolocationPermissions.Callback callback;
    private boolean isIncognitoMode;
    private String origin;

    public AceWebGeolocationPermissionsShowObject(String str, GeolocationPermissions.Callback callback, boolean z) {
        this.origin = str;
        this.callback = callback;
        this.isIncognitoMode = z;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void invoke(String str, boolean z, boolean z2) {
        try {
            if (this.isIncognitoMode) {
                this.callback.invoke(str, z, false);
            } else {
                this.callback.invoke(str, z, z2);
            }
        } catch (Exception unused) {
            ALog.e(LOG_TAG, "call invoke method failed");
        }
    }
}
