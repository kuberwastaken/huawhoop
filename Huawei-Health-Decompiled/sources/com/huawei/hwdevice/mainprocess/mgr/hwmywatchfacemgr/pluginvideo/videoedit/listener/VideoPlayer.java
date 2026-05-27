package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videoedit.listener;

import android.view.Surface;

/* JADX INFO: loaded from: classes6.dex */
public interface VideoPlayer {
    void clean();

    int getCurrentPosition();

    void pause();

    void reset();

    void resume();

    void seekTo(int i);

    VideoPlayer setDataPath(String str);

    VideoPlayer setPlaySpeed(float f);

    VideoPlayer setSeekTime(int i);

    VideoPlayer setSurface(Surface surface);

    VideoPlayer setVolume(float f);

    void start();

    void stop();
}
