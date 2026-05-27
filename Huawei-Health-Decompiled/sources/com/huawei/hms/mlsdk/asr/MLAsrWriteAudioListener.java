package com.huawei.hms.mlsdk.asr;

import android.os.Bundle;

/* JADX INFO: loaded from: classes5.dex */
public interface MLAsrWriteAudioListener {
    void onError(int i, String str);

    void onResults(Bundle bundle);

    void onStartListening();
}
