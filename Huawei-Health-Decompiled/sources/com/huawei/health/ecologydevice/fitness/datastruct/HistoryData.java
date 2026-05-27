package com.huawei.health.ecologydevice.fitness.datastruct;

import defpackage.dvy;

/* JADX INFO: loaded from: classes4.dex */
public class HistoryData extends BaseRopeData {
    public static final int DATA_TYPE_HAS_MORE = 0;
    public static final int DATA_TYPE_HISTORY_ITEM = 1;

    public HistoryData() {
        super(20);
    }

    public dvy getHistoryDataItem() {
        Object obj = this.mFitnessData.get(1);
        if (obj instanceof dvy) {
            return (dvy) obj;
        }
        return null;
    }

    public void setHistoryDataItem(dvy dvyVar) {
        this.mFitnessData.put(1, dvyVar);
    }

    public boolean getHasMoreData() {
        Object obj = this.mFitnessData.get(0);
        return (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
    }

    public void setHasMoreData(boolean z) {
        this.mFitnessData.put(0, Boolean.valueOf(z));
    }

    @Override // com.huawei.health.device.datatype.AbstractFitnessData
    public void clearData() {
        super.clearData();
    }

    public String toString() {
        return "getHasMoreData: " + getHasMoreData() + " HistoryDataItem:" + getHistoryDataItem();
    }
}
