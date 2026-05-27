package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import com.google.gson.annotations.SerializedName;
import defpackage.kqt;

/* JADX INFO: loaded from: classes6.dex */
public class RunPlanParameter {

    @SerializedName("run_plan_algorithm_type")
    private int runPlanAlgorithmType;

    @SerializedName("run_plan_algorithm_version")
    private String runPlanAlgorithmVersion;

    @SerializedName("run_plan_sign")
    private String runPlanSign;

    @SerializedName("run_plan_sync_size")
    private int runPlanSyncSize;

    @SerializedName("run_plan_sync_size_pre")
    private int runPlanSyncSizePre;

    @SerializedName("run_plan_sync_size_sub")
    private int runPlanSyncSizeSub;

    @SerializedName("run_plan_total_sign")
    private String runPlanTotalSign;

    public int getRunPlanSyncSizeSub() {
        return ((Integer) kqt.e(Integer.valueOf(this.runPlanSyncSizeSub))).intValue();
    }

    public void setRunPlanSyncSizeSub(int i) {
        this.runPlanSyncSizeSub = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getRunPlanSyncSizePre() {
        return ((Integer) kqt.e(Integer.valueOf(this.runPlanSyncSizePre))).intValue();
    }

    public void setRunPlanSyncSizePre(int i) {
        this.runPlanSyncSizePre = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String getRunPlanTotalSign() {
        return (String) kqt.e(this.runPlanTotalSign);
    }

    public void setRunPlanTotalSign(String str) {
        this.runPlanTotalSign = (String) kqt.e(str);
    }

    public String getRunPlanSign() {
        return (String) kqt.e(this.runPlanSign);
    }

    public void setRunPlanSign(String str) {
        this.runPlanSign = (String) kqt.e(str);
    }

    public int getRunPlanAlgorithmType() {
        return ((Integer) kqt.e(Integer.valueOf(this.runPlanAlgorithmType))).intValue();
    }

    public void setRunPlanAlgorithmType(int i) {
        this.runPlanAlgorithmType = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String getRunPlanAlgorithmVersion() {
        return (String) kqt.e(this.runPlanAlgorithmVersion);
    }

    public void setRunPlanAlgorithmVersion(String str) {
        this.runPlanAlgorithmVersion = (String) kqt.e(str);
    }

    public int getRunPlanSyncSize() {
        return ((Integer) kqt.e(Integer.valueOf(this.runPlanSyncSize))).intValue();
    }

    public void setRunPlanSyncSize(int i) {
        this.runPlanSyncSize = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }
}
