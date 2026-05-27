package com.huawei.health.ecologydevice.fitness.datastruct;

/* JADX INFO: loaded from: classes4.dex */
public class BatteryStatus extends BaseRopeData {
    public BatteryStatus() {
        super(21);
    }

    public void setButteryStatus(int i) {
        this.mFitnessData.put(20017, Integer.valueOf(i));
    }
}
