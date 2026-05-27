package com.huawei.health.arkuix.engine;

import android.app.Application;
import android.content.res.Configuration;

/* JADX INFO: loaded from: classes.dex */
public interface StageDelegateApi {
    void changeConfiguration(Configuration configuration);

    void initStageApplication(Application application);
}
