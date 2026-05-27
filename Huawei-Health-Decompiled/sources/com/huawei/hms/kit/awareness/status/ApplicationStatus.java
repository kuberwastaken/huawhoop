package com.huawei.hms.kit.awareness.status;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes10.dex */
public interface ApplicationStatus {
    public static final int RUNNING = 1;
    public static final int SILENT = 0;
    public static final int UNKNOWN = -1;

    /* JADX INFO: loaded from: classes2.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ApplicationStatusDef {
    }

    int getStatus();
}
