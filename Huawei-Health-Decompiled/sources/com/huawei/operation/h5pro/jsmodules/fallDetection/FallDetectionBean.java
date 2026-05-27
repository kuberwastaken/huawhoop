package com.huawei.operation.h5pro.jsmodules.fallDetection;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.ad.db.bean.UserCloseRecord;

/* JADX INFO: loaded from: classes6.dex */
public class FallDetectionBean {

    @SerializedName(FallDetectionConstant.EXTRA_FALL_DETECTION_SWITCH)
    private int fallDetectionSwitch;

    @SerializedName(UserCloseRecord.TIME_STAMP)
    private long timeStamp;

    public int getFallDetectionSwitch() {
        return this.fallDetectionSwitch;
    }

    public void setFallDetectionSwitch(int i) {
        this.fallDetectionSwitch = i;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public String toString() {
        return "FallDetectionBean{fallDetectionSwitch=" + this.fallDetectionSwitch + ", timeStamp=" + this.timeStamp + '}';
    }
}
