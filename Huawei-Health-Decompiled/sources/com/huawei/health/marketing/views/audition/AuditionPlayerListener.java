package com.huawei.health.marketing.views.audition;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes4.dex */
public interface AuditionPlayerListener {
    void onCompletion(MediaPlayer mediaPlayer);

    void onPlayerPause();

    void onPlayerStart();

    void onPrepared(MediaPlayer mediaPlayer);
}
