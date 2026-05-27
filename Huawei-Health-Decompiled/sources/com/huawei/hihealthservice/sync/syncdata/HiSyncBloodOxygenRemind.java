package com.huawei.hihealthservice.sync.syncdata;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class HiSyncBloodOxygenRemind {

    @SerializedName("bloodOxygenRemind")
    private int bloodOxygenRemind;

    public HiSyncBloodOxygenRemind(int i) {
        this.bloodOxygenRemind = i;
    }

    public double getBloodOxygenRemind() {
        return this.bloodOxygenRemind;
    }
}
