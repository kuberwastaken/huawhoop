package ohos.ace.adapter.capability.web;

import android.webkit.JsPromptResult;
import ohos.ace.adapter.ALog;

/* JADX INFO: loaded from: classes11.dex */
public class AceWebJsPromptObject {
    private static final String LOG_TAG = "AceWebJsPromptObject";
    private String defaultValue;
    private String message;
    private JsPromptResult result;
    private String url;

    public AceWebJsPromptObject(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        this.url = str;
        this.message = str2;
        this.defaultValue = str3;
        this.result = jsPromptResult;
    }

    public String getUrl() {
        return this.url;
    }

    public String getMessage() {
        return this.message;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void cancel() {
        try {
            this.result.cancel();
        } catch (Exception unused) {
            ALog.e(LOG_TAG, "call cancel method failed");
        }
    }

    public void confirm() {
        try {
            this.result.confirm();
        } catch (Exception unused) {
            ALog.e(LOG_TAG, "call confirm method failed");
        }
    }

    public void confirm(String str) {
        try {
            this.result.confirm(str);
        } catch (Exception unused) {
            ALog.e(LOG_TAG, "call confirm method failed");
        }
    }
}
