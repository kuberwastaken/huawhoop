package com.huawei.health.suggestion.ui.voice.helper;

import com.huawei.pluginfitnessadvice.TargetConfig;

/* JADX INFO: loaded from: classes5.dex */
public interface IntensityVoiceGuider {
    void broadcastLowerLimit();

    void broadcastNo();

    void broadcastNormal();

    void broadcastUpperLimit();

    void guide(TargetConfig targetConfig, float f);

    void reset();
}
