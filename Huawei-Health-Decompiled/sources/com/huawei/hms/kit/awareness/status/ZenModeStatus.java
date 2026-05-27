package com.huawei.hms.kit.awareness.status;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes10.dex */
public interface ZenModeStatus {
    public static final int UNKNOWN = -1;
    public static final int ZEN_MODE_OFF = 0;
    public static final int ZEN_MODE_ON = 1;

    /* JADX INFO: loaded from: classes2.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ZenModeStatusDef {
    }

    boolean isZenModeOn();
}
