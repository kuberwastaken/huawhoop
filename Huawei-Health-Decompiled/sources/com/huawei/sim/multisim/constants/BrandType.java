package com.huawei.sim.multisim.constants;

/* JADX INFO: loaded from: classes7.dex */
public enum BrandType {
    HUAWEI(1),
    THIRD(2),
    DEFAULT(3);

    private int mType;

    BrandType(int i) {
        this.mType = i;
    }

    public int getType() {
        return this.mType;
    }
}
