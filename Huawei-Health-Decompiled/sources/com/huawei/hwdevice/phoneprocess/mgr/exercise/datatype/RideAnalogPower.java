package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class RideAnalogPower implements TimeSequence, Serializable {
    private static final long serialVersionUID = 6079019508607803294L;

    @SerializedName(HwExerciseConstants.EXTEND_CYCLE_ANALOG_POWER)
    private int mAnalogPower;
    private long mTime;

    public int getAnalogPower() {
        return this.mAnalogPower;
    }

    public void setAnalogPower(int i) {
        this.mAnalogPower = i;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.mTime;
    }

    public String toString() {
        return "RideAnalogPower [time=" + this.mTime + ", analogPowerValue=" + this.mAnalogPower + "]";
    }
}
