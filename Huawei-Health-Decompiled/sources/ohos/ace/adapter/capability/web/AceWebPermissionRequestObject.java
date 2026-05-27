package ohos.ace.adapter.capability.web;

import android.net.Uri;
import android.webkit.PermissionRequest;
import ohos.ace.adapter.ALog;

/* JADX INFO: loaded from: classes11.dex */
public class AceWebPermissionRequestObject {
    private static final String LOG_TAG = "AceWebPermissionRequestObject";
    private static final int RESOURCESID_ONE = 1;
    private static final int RESOURCESID_TWO = 2;
    private PermissionRequest request;

    public AceWebPermissionRequestObject(PermissionRequest permissionRequest) {
        this.request = permissionRequest;
    }

    public void deny() {
        try {
            this.request.deny();
        } catch (Exception unused) {
            ALog.e(LOG_TAG, "call deny method failed");
        }
    }

    public String getOrigin() {
        Uri origin = this.request.getOrigin();
        return origin != null ? origin.toString() : "";
    }

    public int getResources() {
        int i = 0;
        for (String str : this.request.getResources()) {
            if ("android.webkit.resource.VIDEO_CAPTURE".equals(str)) {
                i |= 1;
            } else if ("android.webkit.resource.AUDIO_CAPTURE".equals(str)) {
                i |= 2;
            }
        }
        return i;
    }

    public void grant(int i) {
        try {
            PermissionRequest permissionRequest = this.request;
            permissionRequest.grant(permissionRequest.getResources());
        } catch (Exception unused) {
            ALog.e(LOG_TAG, "call grant method failed");
        }
    }
}
