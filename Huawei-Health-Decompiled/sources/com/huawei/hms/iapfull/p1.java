package com.huawei.hms.iapfull;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import com.huawei.secure.android.common.util.ScreenUtil;

/* JADX INFO: loaded from: classes5.dex */
public class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f4925a;

    @JavascriptInterface
    public void enableScreenshots() {
        Activity activity = this.f4925a;
        if (activity == null) {
            y0.a("JsThemeUtil", "enableScreenshots Activity is null");
        } else {
            ScreenUtil.enableScreenshots(activity);
        }
    }

    @JavascriptInterface
    public void disableScreenshots() {
        Activity activity = this.f4925a;
        if (activity == null) {
            y0.a("JsThemeUtil", "disableScreenshots Activity is null");
        } else {
            ScreenUtil.disableScreenshots(activity);
        }
    }

    public p1(Activity activity) {
        this.f4925a = activity;
    }
}
