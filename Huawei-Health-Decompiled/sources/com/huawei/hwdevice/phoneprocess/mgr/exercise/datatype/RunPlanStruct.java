package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import defpackage.kqt;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class RunPlanStruct {
    private static final int DEFAULE_VALUE = 0;

    @SerializedName("run_plan_date")
    private long mRunPlanDate;

    @SerializedName("run_plan_distance")
    private int mRunPlanDistance;

    @SerializedName("run_plan_name")
    private String mRunPlanName;

    @SerializedName("run_plan_repeats")
    private int mRunPlanRepeats;

    @SerializedName("run_plan_train_effect")
    private int mRunPlanTrainEffect;

    @SerializedName(HwExerciseConstants.JSON_NAME_WORKOUT_RUN_PLAY_ID)
    private int mRunPlanWorkoutId;
    private List<TrainingStruct> trainingStructList;

    public String getRunPlanName() {
        return (String) kqt.e(this.mRunPlanName);
    }

    public void setRunPlanName(String str) {
        this.mRunPlanName = (String) kqt.e(str);
    }

    public long getRunPlanDate() {
        return ((Long) kqt.e(Long.valueOf(this.mRunPlanDate))).longValue();
    }

    public void setRunPlanDate(long j) {
        this.mRunPlanDate = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public int getRunPlanWorkoutId() {
        return ((Integer) kqt.e(Integer.valueOf(this.mRunPlanWorkoutId))).intValue();
    }

    public void setRunPlanWorkoutId(int i) {
        this.mRunPlanWorkoutId = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getRunPlanTrainEffect() {
        return ((Integer) kqt.e(Integer.valueOf(this.mRunPlanTrainEffect))).intValue();
    }

    public void setRunPlanTrainEffect(int i) {
        this.mRunPlanTrainEffect = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getRunPlanRepeats() {
        return ((Integer) kqt.e(Integer.valueOf(this.mRunPlanRepeats))).intValue();
    }

    public void setRunPlanRepeats(int i) {
        this.mRunPlanRepeats = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getRunPlanDistance() {
        return ((Integer) kqt.e(Integer.valueOf(this.mRunPlanDistance))).intValue();
    }

    public void setRunPlanDistance(int i) {
        this.mRunPlanDistance = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public List<TrainingStruct> getTrainingStructList() {
        return (List) kqt.e(this.trainingStructList);
    }

    public void setTrainingStructList(List<TrainingStruct> list) {
        this.trainingStructList = (List) kqt.e(list);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(0);
        stringBuffer.append(this.mRunPlanName);
        stringBuffer.append(this.mRunPlanDate);
        stringBuffer.append(this.mRunPlanTrainEffect);
        stringBuffer.append(this.mRunPlanRepeats);
        stringBuffer.append(this.mRunPlanDistance);
        List<TrainingStruct> list = this.trainingStructList;
        if (list != null) {
            Iterator<TrainingStruct> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().toString());
            }
        }
        return stringBuffer.toString();
    }
}
