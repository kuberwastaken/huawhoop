package com.huawei.health.ecologydevice.fitness.datastruct;

import defpackage.dwe;

/* JADX INFO: loaded from: classes4.dex */
public class RopeExtendedSingleData extends BaseRopeData {
    private static final int HEART_RATE_PARA_LENGTH = 3;

    public byte[] getHeartRateByteArray() {
        if (this.mCode != 0) {
            return null;
        }
        byte[] bArr = new byte[3];
        dwe.c(bArr, this.mCommand, 0);
        dwe.c(bArr, this.mCode, 1);
        dwe.c(bArr, this.mPara[0], 2);
        return bArr;
    }
}
