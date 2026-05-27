package com.huawei.android.appbundle.remote;

import android.os.IBinder;

/* JADX INFO: loaded from: classes10.dex */
public interface RemoteCall<T> {
    T asInterface(IBinder iBinder);
}
