package com.huawei.sim.multisim.constants;

/* JADX INFO: loaded from: classes7.dex */
public enum CarrierType {
    CMCC(1),
    CUCC(2),
    CTCC(3);

    private int mType;

    CarrierType(int i) {
        this.mType = i;
    }

    public int getType() {
        return this.mType;
    }
}
