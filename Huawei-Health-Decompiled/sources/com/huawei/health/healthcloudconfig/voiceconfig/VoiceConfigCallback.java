package com.huawei.health.healthcloudconfig.voiceconfig;

import defpackage.eqf;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface VoiceConfigCallback {
    void onFailure(String str, String str2);

    default void onProgress(long j, long j2, boolean z, String str) {
    }

    void onSuccess(String str, List<eqf> list);
}
