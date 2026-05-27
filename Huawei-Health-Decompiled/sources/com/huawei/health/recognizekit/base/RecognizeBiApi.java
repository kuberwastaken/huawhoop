package com.huawei.health.recognizekit.base;

/* JADX INFO: loaded from: classes9.dex */
public interface RecognizeBiApi {
    void onAlbumEvent(String str);

    void onEnterEvent(int i, String str);

    void onRecognizeEvent(boolean z);

    void onRecognizeResultEvent(boolean z, boolean z2);

    void onTipsEvent(String str);
}
