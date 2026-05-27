package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import defpackage.kqt;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class WorkRecordIndexPaceMapList {
    private int paceIndex = -1;
    List<WorkoutRecordPaceMap> paceMapList;

    @SerializedName(HwExerciseConstants.JSON_NAME_WORKOUT_RECORD_ID)
    private int workoutRecordId;

    public void setWorkoutRecordId(int i) {
        this.workoutRecordId = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getWorkoutRecordId() {
        return ((Integer) kqt.e(Integer.valueOf(this.workoutRecordId))).intValue();
    }

    public void setPaceIndex(int i) {
        this.paceIndex = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getPaceIndex() {
        return ((Integer) kqt.e(Integer.valueOf(this.paceIndex))).intValue();
    }

    public void setPaceMapList(List<WorkoutRecordPaceMap> list) {
        this.paceMapList = (List) kqt.e(list);
    }

    public List<WorkoutRecordPaceMap> getPaceMapList() {
        return (List) kqt.e(this.paceMapList);
    }
}
