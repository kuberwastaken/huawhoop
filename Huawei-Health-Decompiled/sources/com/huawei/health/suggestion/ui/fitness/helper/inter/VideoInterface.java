package com.huawei.health.suggestion.ui.fitness.helper.inter;

import android.net.Uri;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface VideoInterface {
    VideoInterface next();

    VideoInterface pause();

    VideoInterface pre();

    VideoInterface release();

    VideoInterface repeat();

    void saveCurrent(int i);

    VideoInterface setAssetSources(String... strArr);

    VideoInterface setAudioAssetSources(List<String> list);

    VideoInterface setMediaSources(Uri... uriArr);

    VideoInterface setRawSources(Integer... numArr);

    VideoInterface setSdSources(String... strArr);

    VideoInterface start();

    VideoInterface stop();

    VideoInterface videoContinue();
}
