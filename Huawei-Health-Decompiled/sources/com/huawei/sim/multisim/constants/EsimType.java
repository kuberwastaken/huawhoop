package com.huawei.sim.multisim.constants;

/* JADX INFO: loaded from: classes7.dex */
public enum EsimType {
    ONE_NUMBER_MULTISIM(1),
    STAND_ALONE_NUMBER(2);

    private int mType;

    EsimType(int i) {
        this.mType = i;
    }

    public int getType() {
        return this.mType;
    }
}
