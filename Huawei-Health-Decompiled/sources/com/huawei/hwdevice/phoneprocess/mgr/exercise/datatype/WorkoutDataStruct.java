package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import defpackage.kqt;

/* JADX INFO: loaded from: classes6.dex */
public class WorkoutDataStruct {
    private DataHeader dataHeader;

    @SerializedName(HwExerciseConstants.WORKOUT_DATA_INDEX)
    private int workoutDataIndex;

    @SerializedName(HwExerciseConstants.JSON_NAME_WORKOUT_RECORD_ID)
    private int workoutRecordId;

    public int getWorkoutRecordId() {
        return ((Integer) kqt.e(Integer.valueOf(this.workoutRecordId))).intValue();
    }

    public void setWorkoutRecordId(int i) {
        this.workoutRecordId = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getWorkoutDataIndex() {
        return ((Integer) kqt.e(Integer.valueOf(this.workoutDataIndex))).intValue();
    }

    public void setWorkoutDataIndex(int i) {
        this.workoutDataIndex = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public DataHeader getDataHeader() {
        return (DataHeader) kqt.e(this.dataHeader);
    }

    public void setDataHeader(DataHeader dataHeader) {
        this.dataHeader = (DataHeader) kqt.e(dataHeader);
    }
}
