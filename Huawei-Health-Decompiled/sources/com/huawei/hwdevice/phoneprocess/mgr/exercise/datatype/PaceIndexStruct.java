package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import defpackage.kqt;

/* JADX INFO: loaded from: classes6.dex */
public class PaceIndexStruct {
    private int paceIndex;
    private int recordId;

    public int getRecordId() {
        return ((Integer) kqt.e(Integer.valueOf(this.recordId))).intValue();
    }

    public void setRecordId(int i) {
        this.recordId = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getPaceIndex() {
        return ((Integer) kqt.e(Integer.valueOf(this.paceIndex))).intValue();
    }

    public void setPaceIndex(int i) {
        this.paceIndex = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }
}
