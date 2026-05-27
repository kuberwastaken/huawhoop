package com.huawei.health.algorithm.api;

import android.app.Activity;
import com.huawei.health.breathe.bean.BreatheBean;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import defpackage.cva;

/* JADX INFO: loaded from: classes3.dex */
public interface BreathTrainApi {
    void breathControl(cva cvaVar, int i, IBaseResponseCallback iBaseResponseCallback);

    int canFinish(Activity activity);

    int getJanusDeviceConnect();

    void insert(BreatheBean breatheBean);

    void registerBreatheCallback(BreatheWearAppInterface breatheWearAppInterface);
}
