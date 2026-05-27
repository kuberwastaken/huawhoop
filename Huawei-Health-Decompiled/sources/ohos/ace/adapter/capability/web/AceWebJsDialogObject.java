package ohos.ace.adapter.capability.web;

import android.webkit.JsResult;
import ohos.ace.adapter.ALog;

/* JADX INFO: loaded from: classes11.dex */
public class AceWebJsDialogObject {
    private static final String LOG_TAG = "AceWebJsDialogObject";
    private String message;
    private JsResult result;
    private String url;

    public AceWebJsDialogObject(String str, String str2, JsResult jsResult) {
        this.url = str;
        this.message = str2;
        this.result = jsResult;
    }

    public String getUrl() {
        return this.url;
    }

    public String getMessage() {
        return this.message;
    }

    public void confirm() {
        try {
            this.result.confirm();
        } catch (Exception unused) {
            ALog.e(LOG_TAG, "call confirm method failed");
        }
    }

    public void cancel() {
        try {
            this.result.cancel();
        } catch (Exception unused) {
            ALog.e(LOG_TAG, "call cancel method failed");
        }
    }
}
