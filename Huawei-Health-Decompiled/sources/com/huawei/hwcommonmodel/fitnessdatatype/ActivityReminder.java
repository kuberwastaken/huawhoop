package com.huawei.hwcommonmodel.fitnessdatatype;

import defpackage.kqt;

/* JADX INFO: loaded from: classes5.dex */
public class ActivityReminder {
    private boolean isEnable = true;
    private int startTime = 2048;
    private int endTime = 5376;
    private int interval = 60;
    private int cycle = 127;

    public boolean isEnabled() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.isEnable))).booleanValue();
    }

    public void setEnabled(boolean z) {
        this.isEnable = ((Boolean) kqt.e(Boolean.valueOf(z))).booleanValue();
    }

    public int getInterval() {
        return ((Integer) kqt.e(Integer.valueOf(this.interval))).intValue();
    }

    public void setInterval(int i) {
        this.interval = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getStartTime() {
        return ((Integer) kqt.e(Integer.valueOf(this.startTime))).intValue();
    }

    public void setStartTime(int i) {
        this.startTime = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getEndTime() {
        return ((Integer) kqt.e(Integer.valueOf(this.endTime))).intValue();
    }

    public void setEndTime(int i) {
        this.endTime = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getCycle() {
        return ((Integer) kqt.e(Integer.valueOf(this.cycle))).intValue();
    }

    public void setCycle(int i) {
        this.cycle = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "ActivityReminder{enable=" + this.isEnable + ", interval=" + this.interval + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", cycle=" + this.cycle + '}';
    }
}
