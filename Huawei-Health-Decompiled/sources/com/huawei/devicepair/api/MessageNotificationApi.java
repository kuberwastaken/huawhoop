package com.huawei.devicepair.api;

import android.content.Context;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import defpackage.cbv;
import defpackage.cby;

/* JADX INFO: loaded from: classes3.dex */
public interface MessageNotificationApi {
    void enabledAppNotification(Context context, cby cbyVar);

    boolean isAppNotificationEnabled(Context context, cby cbyVar);

    boolean isMessagePermission(Context context);

    boolean isSupportNotify(String str);

    void queryApplicationInfoList(Context context, String str, IBaseResponseCallback iBaseResponseCallback);

    int queryMessageNotificationStatus();

    cbv queryNotificationRemind(String str);

    cby setApplicationNotificationStatus(Context context, String str, String str2, int i);

    int setMessageNotificationStatus(Context context, String str, int i);

    boolean setNotificationRemindStatus(Context context, int i, int i2);
}
