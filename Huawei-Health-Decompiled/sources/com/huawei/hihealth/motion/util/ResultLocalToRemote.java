package com.huawei.hihealth.motion.util;

import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.health.IResultCallback;
import com.huawei.hihealth.motion.IFlushResult;

/* JADX INFO: loaded from: classes.dex */
public class ResultLocalToRemote extends IResultCallback.Stub {
    private IFlushResult d;

    public ResultLocalToRemote(IFlushResult iFlushResult) {
        this.d = iFlushResult;
    }

    @Override // com.huawei.health.IResultCallback
    public void onSuccess(Bundle bundle) throws RemoteException {
        IFlushResult iFlushResult = this.d;
        if (iFlushResult != null) {
            iFlushResult.onSuccess(bundle);
        }
    }

    @Override // com.huawei.health.IResultCallback
    public void onFailed(Bundle bundle) throws RemoteException {
        IFlushResult iFlushResult = this.d;
        if (iFlushResult != null) {
            iFlushResult.onFailed(bundle);
        }
    }

    @Override // com.huawei.health.IResultCallback
    public void onServiceException(Bundle bundle) throws RemoteException {
        IFlushResult iFlushResult = this.d;
        if (iFlushResult != null) {
            iFlushResult.onServiceException(bundle);
        }
    }
}
