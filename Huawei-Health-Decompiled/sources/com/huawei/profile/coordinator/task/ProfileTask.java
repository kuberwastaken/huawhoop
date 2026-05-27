package com.huawei.profile.coordinator.task;

import android.content.Context;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ProfileTask implements Runnable {
    public abstract String getName();

    public abstract void setContext(Context context);
}
