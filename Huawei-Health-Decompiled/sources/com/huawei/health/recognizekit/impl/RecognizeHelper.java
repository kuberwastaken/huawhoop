package com.huawei.health.recognizekit.impl;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes9.dex */
public interface RecognizeHelper {

    public interface RecognizeListener {
        void onRecognized(String str);
    }

    void recognize(Bitmap bitmap);

    void release();
}
