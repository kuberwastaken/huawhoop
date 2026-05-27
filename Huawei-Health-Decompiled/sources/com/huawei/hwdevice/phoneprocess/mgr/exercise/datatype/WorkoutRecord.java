package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import com.google.gson.annotations.SerializedName;
import defpackage.kqt;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class WorkoutRecord {

    @SerializedName("workout_record_count")
    private int workoutRecordCount;
    private List<WorkoutRecordStruct> workoutRecordStructList;

    public int getWorkoutRecordCount() {
        return ((Integer) kqt.e(Integer.valueOf(this.workoutRecordCount))).intValue();
    }

    public void setWorkoutRecordCount(int i) {
        this.workoutRecordCount = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public List<WorkoutRecordStruct> getWorkoutRecordStructList() {
        return (List) kqt.e(this.workoutRecordStructList);
    }

    public void setWorkoutRecordStructList(List<WorkoutRecordStruct> list) {
        this.workoutRecordStructList = (List) kqt.e(list);
    }
}
