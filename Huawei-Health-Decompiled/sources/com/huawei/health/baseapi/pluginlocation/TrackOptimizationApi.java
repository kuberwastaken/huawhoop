package com.huawei.health.baseapi.pluginlocation;

import android.content.Context;
import com.huawei.health.baseapi.pluginlocation.callback.HwPluginCloudTrackCallback;
import com.huawei.health.baseapi.pluginlocation.callback.HwPluginTrackMapCallback;
import defpackage.gao;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface TrackOptimizationApi {
    void getCloudTrack(HwPluginCloudTrackCallback hwPluginCloudTrackCallback);

    int getOptimizedTrack(String str, String str2, boolean z, HwPluginTrackMapCallback hwPluginTrackMapCallback, boolean z2, String str3);

    void postMotionPath(List<gao> list);

    void setExtraData(boolean z, boolean z2, Context context, String str);
}
