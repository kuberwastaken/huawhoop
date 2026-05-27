package com.huawei.health.tradeservice.cloud;

import com.huawei.trade.datatype.ChallengeInfo;

/* JADX INFO: loaded from: classes5.dex */
public class DeviceCertChallengeRsp extends BaseRsp {
    private ChallengeInfo challengeInfo;

    public ChallengeInfo getChallengeInfo() {
        return this.challengeInfo;
    }

    public void setChallengeInfo(ChallengeInfo challengeInfo) {
        this.challengeInfo = challengeInfo;
    }
}
