package com.huawei.hmf.orb.aidl;

import android.app.PendingIntent;
import com.huawei.hmf.annotation.NamedMethod;

/* JADX INFO: loaded from: classes10.dex */
public interface IRemoteActivity {
    public static final String Uri = "com.huawei.hmf.orb.aidl.IRemoteActivity";

    @NamedMethod("getActivity")
    PendingIntent getActivity(int i);
}
