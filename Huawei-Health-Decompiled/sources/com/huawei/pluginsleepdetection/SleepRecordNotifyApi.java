package com.huawei.pluginsleepdetection;

import android.content.Context;

/* JADX INFO: loaded from: classes7.dex */
public interface SleepRecordNotifyApi {
    void cancelAlarm();

    void closeNotification();

    String getCacheKey();

    boolean isInTimeRange();

    void pullUpAlarm(Context context);

    void showNotification(Context context);
}
