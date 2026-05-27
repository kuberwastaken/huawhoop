package com.huawei.health.ecologydevice.fitness.datastruct;

import com.huawei.hwsmartinteractmgr.data.SmartMsgConstant;

/* JADX INFO: loaded from: classes4.dex */
public class RopeTrainingStatusData extends BaseRopeData {
    public RopeTrainingStatusData() {
        super(24);
    }

    public void setDeviceTrainingStatus(int i) {
        this.mFitnessData.put(Integer.valueOf(SmartMsgConstant.MSG_TYPE_SLEEP_USER), Integer.valueOf(i));
    }
}
