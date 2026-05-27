package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import com.google.gson.annotations.SerializedName;
import defpackage.kqt;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class SportReminder {

    @SerializedName("distance_info")
    private long distanceInfo;

    @SerializedName("hr_status_info")
    private int hrStatusInfo;

    @SerializedName("hr_value_info")
    private int hrValueInfo;

    @SerializedName("reminder_type")
    private int reminderType;

    @SerializedName("run_phrase_number")
    private int runPhraseNumber;

    @SerializedName("run_phrase_variable")
    private List<Integer> runPhraseVariable;

    @SerializedName("sport_type")
    private int sportType;

    @SerializedName("time_info")
    private long timeInfo;

    public int getSportType() {
        return ((Integer) kqt.e(Integer.valueOf(this.sportType))).intValue();
    }

    public void setSportType(int i) {
        this.sportType = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getReminderType() {
        return ((Integer) kqt.e(Integer.valueOf(this.reminderType))).intValue();
    }

    public void setReminderType(int i) {
        this.reminderType = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getRunPhraseNumber() {
        return ((Integer) kqt.e(Integer.valueOf(this.runPhraseNumber))).intValue();
    }

    public void setRunPhraseNumber(int i) {
        this.runPhraseNumber = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public List<Integer> getRunPhraseVariable() {
        return (List) kqt.e(this.runPhraseVariable);
    }

    public void setRunPhraseVariable(List<Integer> list) {
        this.runPhraseVariable = (List) kqt.e(list);
    }

    public long getDistanceInfo() {
        return ((Long) kqt.e(Long.valueOf(this.distanceInfo))).longValue();
    }

    public void setDistanceInfo(long j) {
        this.distanceInfo = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public long getTimeInfo() {
        return ((Long) kqt.e(Long.valueOf(this.timeInfo))).longValue();
    }

    public void setTimeInfo(long j) {
        this.timeInfo = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public int getHrValueInfo() {
        return ((Integer) kqt.e(Integer.valueOf(this.hrValueInfo))).intValue();
    }

    public void setHrValueInfo(int i) {
        this.hrValueInfo = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getHrStatusInfo() {
        return ((Integer) kqt.e(Integer.valueOf(this.hrStatusInfo))).intValue();
    }

    public void setHrStatusInfo(int i) {
        this.hrStatusInfo = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }
}
