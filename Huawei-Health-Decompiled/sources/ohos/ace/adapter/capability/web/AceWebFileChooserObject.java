package ohos.ace.adapter.capability.web;

import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import ohos.ace.adapter.ALog;

/* JADX INFO: loaded from: classes11.dex */
public class AceWebFileChooserObject {
    private static final String LOG_TAG = "AceWebFileChooserObject";
    private WebChromeClient.FileChooserParams fileChooserParams;
    private ValueCallback<Uri[]> filePathCallback;

    public AceWebFileChooserObject(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        this.filePathCallback = valueCallback;
        this.fileChooserParams = fileChooserParams;
    }

    public String getTitle() {
        return this.fileChooserParams.getTitle() != null ? this.fileChooserParams.getTitle().toString() : "open file";
    }

    public int getMode() {
        return this.fileChooserParams.getMode();
    }

    public String[] getAcceptType() {
        return this.fileChooserParams.getAcceptTypes();
    }

    public boolean isCapture() {
        return this.fileChooserParams.isCaptureEnabled();
    }

    public void handleFileList(String[] strArr) {
        Uri[] uriArr = new Uri[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            uriArr[i] = Uri.parse(strArr[i]);
        }
        try {
            this.filePathCallback.onReceiveValue(uriArr);
        } catch (Exception unused) {
            ALog.e(LOG_TAG, "call onReceiveValue method failed");
        }
    }
}
