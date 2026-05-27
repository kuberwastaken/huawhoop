package com.huawei.health.trackprocess.api;

import android.content.Context;
import com.huawei.health.trackprocess.callback.PluginCloudTrackCallback;
import com.huawei.health.trackprocess.callback.PluginTrackMapCallback;
import defpackage.hra;
import defpackage.hrc;
import defpackage.hrd;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface PluginLocationApi {
    void getCloudTrack(PluginCloudTrackCallback pluginCloudTrackCallback);

    hrc getEphRequest(List<String> list);

    Map<String, String> getEphResponse(hra hraVar);

    int getOptimizedTrack(String str, String str2, boolean z, PluginTrackMapCallback pluginTrackMapCallback, boolean z2, String str3);

    void pluginRxnGenerateEphemeris();

    void pluginRxnNativeInit();

    void postMotionPath(List<hrd> list);

    void setContext(Context context);

    void setExtraData(boolean z, boolean z2, Context context, String str);

    void setSerCountry(String str);
}
