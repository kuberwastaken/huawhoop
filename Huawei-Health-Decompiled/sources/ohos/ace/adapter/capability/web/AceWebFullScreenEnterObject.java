package ohos.ace.adapter.capability.web;

import android.webkit.WebChromeClient;
import ohos.ace.adapter.ALog;

/* JADX INFO: loaded from: classes11.dex */
public class AceWebFullScreenEnterObject {
    private static final String LOG_TAG = "AceWebFullScreenEnterObject";
    private WebChromeClient.CustomViewCallback mCallBack;
    private int videoHeight;
    private int videoWidth;

    public AceWebFullScreenEnterObject(int i, int i2) {
        this.videoWidth = i;
        this.videoHeight = i2;
    }

    public int widths() {
        return this.videoWidth;
    }

    public int heights() {
        return this.videoHeight;
    }

    public void setFullEnterRequestExitCallback(WebChromeClient.CustomViewCallback customViewCallback) {
        this.mCallBack = customViewCallback;
    }

    public void exitFullScreen() {
        try {
            WebChromeClient.CustomViewCallback customViewCallback = this.mCallBack;
            if (customViewCallback != null) {
                customViewCallback.onCustomViewHidden();
                this.mCallBack = null;
            }
        } catch (Exception unused) {
            ALog.w(LOG_TAG, "exitFullScreen Exception error");
        }
    }
}
