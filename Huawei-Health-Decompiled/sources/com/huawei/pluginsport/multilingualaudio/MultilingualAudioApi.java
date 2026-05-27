package com.huawei.pluginsport.multilingualaudio;

import defpackage.omf;
import defpackage.omj;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface MultilingualAudioApi {
    List<String> getScenarioAudioPaths(String str, omf omfVar);

    void init(omj omjVar);

    default boolean isInitSuccess() {
        return false;
    }

    void release();
}
