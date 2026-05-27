package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import com.google.gson.annotations.SerializedName;
import defpackage.kqt;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class RunPlanInfo {

    @SerializedName("run_plan_sign")
    private String runPlanSign;

    @SerializedName("run_plan_start_date")
    private long runPlanStartDate;
    private List<RunPlanStruct> runPlanStructList;

    @SerializedName("run_plan_total_sign")
    private String runPlanTotalSign;

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

    public long getRunPlanStartDate() {
        return ((Long) kqt.e(Long.valueOf(this.runPlanStartDate))).longValue();
    }

    public void setRunPlanStartDate(long j) {
        this.runPlanStartDate = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public List<RunPlanStruct> getRunPlanStructList() {
        return (List) kqt.e(this.runPlanStructList);
    }

    public void setRunPlanStructList(List<RunPlanStruct> list) {
        this.runPlanStructList = (List) kqt.e(list);
    }
}
