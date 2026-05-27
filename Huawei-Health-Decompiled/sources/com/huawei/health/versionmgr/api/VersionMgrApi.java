package com.huawei.health.versionmgr.api;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes5.dex */
public interface VersionMgrApi {
    void autoCheckAppNewVersionService();

    void checkScaleNewVersionService(String str, String str2, String str3, boolean z, String str4);

    void deleteMessage();

    void doManualCheckAppNewVersion();

    void downloadAppPackage();

    String getAppCheckNewVersionCode();

    boolean getBandOtaStatus(Context context);

    String getLastCheckTime();

    String getUpdateUrl(boolean z);

    boolean haveNewAppVersion(Context context);

    void installApk();

    boolean isCanAutoCheckNewVersion();

    boolean isDeviceOtaUpdating(String str);

    boolean isNewVersionFileExist();

    boolean isOtherDeviceOtaUpdating(String str);

    void makeMessage(Context context);

    void resetBandUpdate(String str);

    void resetBandUpdate(String str, String str2);

    void showNewVersionDialog(Context context, Intent intent);
}
