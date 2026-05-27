package com.huawei.watchface;

import android.os.Looper;
import android.webkit.WebView;
import com.huawei.watchface.utils.HwLog;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class eb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11508a;
    private WebView b;

    public eb(WebView webView) {
        this.b = webView;
    }

    public String a() {
        if (this.b == null) {
            return "";
        }
        if (b()) {
            return this.b.getUrl();
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ei.a(new Runnable() { // from class: com.huawei.watchface.eb.1
            @Override // java.lang.Runnable
            public void run() {
                eb ebVar = eb.this;
                ebVar.a(ebVar.b.getUrl());
                countDownLatch.countDown();
            }
        });
        try {
            if (!countDownLatch.await(2000L, TimeUnit.MILLISECONDS)) {
                HwLog.w("SafeGetUrlUtil", "getUrlMethod time out!");
            }
        } catch (InterruptedException e) {
            HwLog.e("SafeGetUrlUtil", "getUrlMethod: InterruptedException " + HwLog.printException((Exception) e));
        }
        return this.f11508a;
    }

    public void a(String str) {
        this.f11508a = str;
    }

    public boolean b() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
