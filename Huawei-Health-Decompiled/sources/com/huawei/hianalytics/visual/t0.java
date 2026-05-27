package com.huawei.hianalytics.visual;

import android.webkit.JavascriptInterface;
import com.huawei.hianalytics.core.log.HiLog;

/* JADX INFO: loaded from: classes5.dex */
public class t0 {
    @JavascriptInterface
    public void haVisualizedLog(String str) {
        HiLog.d("HAWebViewVisualInterface_JS", str);
    }
}
