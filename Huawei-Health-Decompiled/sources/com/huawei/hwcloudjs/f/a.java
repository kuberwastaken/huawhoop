package com.huawei.hwcloudjs.f;

import android.text.TextUtils;
import android.webkit.WebView;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes5.dex */
final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String[] f6420a;
    final /* synthetic */ WebView b;
    final /* synthetic */ CountDownLatch c;

    @Override // java.lang.Runnable
    public void run() {
        d.c("DeviceUtils", "webView getUrl", true);
        this.f6420a[0] = this.b.getUrl();
        if (TextUtils.isEmpty(this.f6420a[0])) {
            d.b("DeviceUtils", "webView getUrl isEmpty", true);
        }
        this.c.countDown();
    }

    a(String[] strArr, WebView webView, CountDownLatch countDownLatch) {
        this.f6420a = strArr;
        this.b = webView;
        this.c = countDownLatch;
    }
}
