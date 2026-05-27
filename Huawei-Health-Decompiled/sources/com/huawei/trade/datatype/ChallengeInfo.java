package com.huawei.trade.datatype;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class ChallengeInfo {

    @SerializedName("challenge")
    private String challenge;

    @SerializedName("generateTime")
    private long generateTime;

    public String getChallenge() {
        return this.challenge;
    }

    public long getGenerateTime() {
        return this.generateTime;
    }
}
