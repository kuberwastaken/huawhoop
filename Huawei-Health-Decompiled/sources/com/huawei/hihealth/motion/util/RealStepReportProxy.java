package com.huawei.hihealth.motion.util;

import android.os.RemoteException;
import com.huawei.health.IRealStepDataReport;
import com.huawei.hihealth.motion.RealStepCallback;

/* JADX INFO: loaded from: classes.dex */
public class RealStepReportProxy extends IRealStepDataReport.Stub {
    private RealStepCallback e;

    public RealStepReportProxy(RealStepCallback realStepCallback) {
        this.e = realStepCallback;
    }

    @Override // com.huawei.health.IRealStepDataReport
    public void report(int i, int i2) throws RemoteException {
        RealStepCallback realStepCallback = this.e;
        if (realStepCallback != null) {
            realStepCallback.onReport(i, i2);
        }
    }
}
