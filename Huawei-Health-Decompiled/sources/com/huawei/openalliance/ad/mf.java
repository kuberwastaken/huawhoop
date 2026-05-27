package com.huawei.openalliance.ad;

import android.media.AudioManager;

/* JADX INFO: loaded from: classes6.dex */
public class mf {
    public static float a(AudioManager audioManager, boolean z) {
        if (audioManager == null) {
            return 0.0f;
        }
        float streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(1);
        int streamVolume2 = audioManager.getStreamVolume(3);
        if (streamVolume == 0 || z || streamMaxVolume <= 1.0E-8f) {
            return 0.0f;
        }
        return streamVolume2 / streamMaxVolume;
    }
}
