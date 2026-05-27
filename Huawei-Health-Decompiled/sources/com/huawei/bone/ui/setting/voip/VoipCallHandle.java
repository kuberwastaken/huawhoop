package com.huawei.bone.ui.setting.voip;

import android.app.Notification;
import android.os.Bundle;
import android.os.Handler;
import defpackage.bzk;

/* JADX INFO: loaded from: classes10.dex */
public interface VoipCallHandle {
    public static final String TAG = "VoipCallHandle";
    public static final String TAG_RELEASE = "Notify_VoipCallHandle";

    boolean isPushVoipCalling(bzk bzkVar, Handler handler, Bundle bundle, Notification notification, boolean z);
}
