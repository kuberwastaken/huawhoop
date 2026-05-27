package com.huawei.ui.thirdpartservice.syncdata.fit.Sport.Enum;

import com.huawei.ui.thirdpartservice.syncdata.fit.FitEncoder.FitDesign;

/* JADX INFO: loaded from: classes8.dex */
public enum FileIdMsgEnum {
    TYPE(0, FitDesign.FieldType.ENUM),
    MANUFACTURE(1, FitDesign.FieldType.UINT16),
    PRODUCT(2, FitDesign.FieldType.UINT16),
    TIME_CREATED(4, FitDesign.FieldType.UINT32);

    private final int num;
    private final FitDesign.FieldType type;

    FileIdMsgEnum(int i, FitDesign.FieldType fieldType) {
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
