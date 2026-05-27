package com.huawei.hihealth.motion.util;

import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.health.IStepDataReport;
import com.huawei.hihealth.motion.ICommonReport;

/* JADX INFO: loaded from: classes.dex */
public class StepLocalToRemoteProxy extends IStepDataReport.Stub {
    private ICommonReport c;

    public ICommonReport getSelf() {
        return this.c;
    }

    public StepLocalToRemoteProxy(ICommonReport iCommonReport) {
        this.c = iCommonReport;
    }

    public boolean isScameLocalCallback(ICommonReport iCommonReport) {
        return this.c == iCommonReport;
    }

    @Override // com.huawei.health.IStepDataReport
    public void report(Bundle bundle) throws RemoteException {
        ICommonReport iCommonReport = this.c;
        if (iCommonReport != null) {
            iCommonReport.report(bundle);
        }
    }
}
