package com.huawei.health.sportservice.download.cloud;

import android.content.Context;
import com.huawei.basefitnessadvice.callback.UiCallback;
import defpackage.glf;
import defpackage.glj;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface VoiceDataApi {
    void getVoiceBroadcastList(Context context, List<glj> list, UiCallback<List<glf>> uiCallback);
}
