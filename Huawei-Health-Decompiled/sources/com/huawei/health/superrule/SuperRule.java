package com.huawei.health.superrule;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.huawei.operation.utils.Constants;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class SuperRule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3560a;
    private FireCallback<String> c;
    private WebView d;
    private boolean e = false;

    public SuperRule(Context context) {
        this.f3560a = context;
        WebView webView = new WebView(context);
        this.d = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.d.addJavascriptInterface(this, "jsbridge");
    }

    public void e(String str) {
        if (!this.e) {
            this.d.evaluateJavascript(d("node-rules.min.js"), null);
            this.d.evaluateJavascript(d("SuperRule.js"), null);
            this.e = true;
        }
        this.d.evaluateJavascript(str, null);
    }

    public void e(String str, FireCallback<String> fireCallback) {
        this.c = fireCallback;
        this.d.evaluateJavascript("javascript:fire(" + str + Constants.RIGHT_BRACKET_ONLY, null);
    }

    @JavascriptInterface
    public void setRuleResult(String str) {
        FireCallback<String> fireCallback = this.c;
        if (fireCallback != null) {
            fireCallback.onReceiveValue(str);
        }
    }

    private String d(String str) {
        String str2;
        try {
            InputStream inputStreamOpen = this.f3560a.getAssets().open(str);
            try {
                byte[] bArr = new byte[inputStreamOpen.available()];
                inputStreamOpen.read(bArr);
                str2 = new String(bArr, "utf8");
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException e) {
                        e = e;
                        Log.e("SuperRule", "assertFile2String() IOException" + e.getMessage());
                    }
                }
            } finally {
            }
        } catch (IOException e2) {
            e = e2;
            str2 = "";
        }
        return str2;
    }
}
