package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class RideAnalogCadence implements TimeSequence, Serializable {
    private static final long serialVersionUID = 8979016614637808866L;

    @SerializedName(HwExerciseConstants.EXTEND_CYCLE_ANALOG_CADENCE)
    private int mAnalogCadence;

    @SerializedName("time")
    private long mTime;

    public int getAnalogCadence() {
        return this.mAnalogCadence;
    }

    public void setAnalogCadence(int i) {
        this.mAnalogCadence = i;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.mTime;
    }

    public String toString() {
        return "RideAnalogCadence [time=" + this.mTime + ", analogCadence=" + this.mAnalogCadence + "]";
    }
}
