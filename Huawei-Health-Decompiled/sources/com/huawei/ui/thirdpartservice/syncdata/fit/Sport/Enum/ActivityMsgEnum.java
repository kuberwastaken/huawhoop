package com.huawei.ui.thirdpartservice.syncdata.fit.Sport.Enum;

import com.huawei.ui.thirdpartservice.syncdata.fit.FitEncoder.FitDesign;

/* JADX INFO: loaded from: classes8.dex */
public enum ActivityMsgEnum {
    TIMESTAMP(253, FitDesign.FieldType.UINT32),
    LOCAL_TIMESTAMP(5, FitDesign.FieldType.UINT32);

    private final int num;
    private final FitDesign.FieldType type;

    ActivityMsgEnum(int i, FitDesign.FieldType fieldType) {
        this.num = i;
        this.type = fieldType;
    }

    public int getNum() {
        return this.num;
    }

    public FitDesign.FieldType getType() {
        return this.type;
    }
}
