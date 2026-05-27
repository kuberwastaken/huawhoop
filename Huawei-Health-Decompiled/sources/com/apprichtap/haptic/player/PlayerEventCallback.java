package com.apprichtap.haptic.player;

/* JADX INFO: loaded from: classes3.dex */
public interface PlayerEventCallback {
    default void onError(int i) {
    }

    void onPlayerStateChanged(int i);

    void onSeekCompleted(int i);
}
