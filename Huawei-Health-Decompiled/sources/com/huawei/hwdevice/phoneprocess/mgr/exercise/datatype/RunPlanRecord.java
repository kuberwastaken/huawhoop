package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import com.google.gson.annotations.SerializedName;
import defpackage.kqt;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class RunPlanRecord {

    @SerializedName("run_plan_record_count")
    private int runPlanRecordCount;
    private List<RunPlanRecordStruct> runPlanRecordStructList;

    public int getRunPlanRecordCount() {
        return ((Integer) kqt.e(Integer.valueOf(this.runPlanRecordCount))).intValue();
    }

    public void setRunPlanRecordCount(int i) {
        this.runPlanRecordCount = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public List<RunPlanRecordStruct> getRunPlanRecordStructList() {
        return (List) kqt.e(this.runPlanRecordStructList);
    }

    public void setRunPlanRecordStructList(List<RunPlanRecordStruct> list) {
        this.runPlanRecordStructList = (List) kqt.e(list);
    }
}
