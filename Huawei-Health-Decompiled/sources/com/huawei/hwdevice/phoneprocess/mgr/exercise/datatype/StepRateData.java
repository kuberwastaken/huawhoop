package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import defpackage.kqt;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class StepRateData implements Serializable {
    private static final long serialVersionUID = -1186336294220451546L;
    private int setpRate;
    private long time;

    public StepRateData() {
    }

    public StepRateData(long j, int i) {
        this.time = j;
        this.setpRate = i;
    }

    public long getTime() {
        return ((Long) kqt.e(Long.valueOf(this.time))).longValue();
    }

    public void setTime(long j) {
        this.time = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public int getStepRate() {
        return ((Integer) kqt.e(Integer.valueOf(this.setpRate))).intValue();
    }

    public void setStepRate(int i) {
        this.setpRate = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "StepRateData [time=" + this.time + ", stepRate=" + this.setpRate + "]";
    }
}
