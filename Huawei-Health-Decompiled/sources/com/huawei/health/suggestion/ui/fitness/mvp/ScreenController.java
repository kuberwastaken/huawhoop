package com.huawei.health.suggestion.ui.fitness.mvp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public interface ScreenController {

    /* JADX INFO: loaded from: classes2.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScreenControlType {
    }

    void setScreenOrientation(int i);
}
