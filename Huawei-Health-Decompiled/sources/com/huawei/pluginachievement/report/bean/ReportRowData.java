package com.huawei.pluginachievement.report.bean;

import com.huawei.hihealthservice.old.model.OldToNewMotionPath;

/* JADX INFO: loaded from: classes7.dex */
public class ReportRowData extends ReportDataBean {
    private float mMaxPaddle;
    private float mMaxPaddleTimes;

    public ReportRowData(int i) {
        super(OldToNewMotionPath.SPORT_TYPE_ROW_MACHINE, i, 2007);
    }

    public void setMaxPaddle(float f) {
        this.mMaxPaddle = f;
    }

    public float getMaxPaddle() {
        return this.mMaxPaddle;
    }

    public void setMaxPaddleTimes(float f) {
        this.mMaxPaddleTimes = f;
    }

    public float getMaxPaddleTimes() {
        return this.mMaxPaddleTimes;
    }
}
