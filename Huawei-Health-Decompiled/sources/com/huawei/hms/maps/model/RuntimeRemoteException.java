package com.huawei.hms.maps.model;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public final class RuntimeRemoteException extends RuntimeException {
    public RuntimeRemoteException(String str) {
        super(str);
    }

    public RuntimeRemoteException(RemoteException remoteException) {
        super(remoteException);
    }
}
