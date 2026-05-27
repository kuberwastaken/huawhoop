package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import defpackage.kqt;

/* JADX INFO: loaded from: classes6.dex */
public class RunPlanRecordStruct {

    @SerializedName("paceIndexCount")
    private int mPaceIndexCount = -1;

    @SerializedName("run_plan_index_count")
    private int mRunPlanIndexCount;

    @SerializedName(HwExerciseConstants.JSON_NAME_WORKOUT_RUN_PLAY_RECORD_ID)
    private int mRunPlanRecordId;

    @SerializedName(HwExerciseConstants.JSON_NAME_WORKOUT_RUN_PLAY_ID)
    private int mRunPlanWorkoutId;

    public int getRunPlanWorkoutId() {
        return ((Integer) kqt.e(Integer.valueOf(this.mRunPlanWorkoutId))).intValue();
    }

    public void setRunPlanWorkoutId(int i) {
        this.mRunPlanWorkoutId = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getRunPlanRecordId() {
        return ((Integer) kqt.e(Integer.valueOf(this.mRunPlanRecordId))).intValue();
    }

    public void setRunPlanRecordId(int i) {
        this.mRunPlanRecordId = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getRunPlanIndexCount() {
        return ((Integer) kqt.e(Integer.valueOf(this.mRunPlanIndexCount))).intValue();
    }

    public void setRunPlanIndexCount(int i) {
        this.mRunPlanIndexCount = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getPaceIndexCount() {
        return ((Integer) kqt.e(Integer.valueOf(this.mPaceIndexCount))).intValue();
    }

    public void setPaceIndexCount(int i) {
        this.mPaceIndexCount = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }
}
