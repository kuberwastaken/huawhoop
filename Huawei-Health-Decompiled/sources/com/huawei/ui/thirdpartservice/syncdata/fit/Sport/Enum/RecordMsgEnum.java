package com.huawei.ui.thirdpartservice.syncdata.fit.Sport.Enum;

import com.huawei.ui.thirdpartservice.syncdata.fit.FitEncoder.FitDesign;

/* JADX INFO: loaded from: classes8.dex */
public enum RecordMsgEnum {
    TIMESTAMP(253, FitDesign.FieldType.UINT32),
    POSITION_LAT(0, FitDesign.FieldType.SINT32),
    POSITION_LONG(1, FitDesign.FieldType.SINT32),
    ALTITUDE(2, FitDesign.FieldType.UINT16),
    SPEED(6, FitDesign.FieldType.UINT16),
    HEART_RATE(3, FitDesign.FieldType.UINT8),
    CADENCE(4, FitDesign.FieldType.UINT8),
    DISTANCE(5, FitDesign.FieldType.UINT32),
    POWER(7, FitDesign.FieldType.UINT16);

    private final int num;
    private final FitDesign.FieldType type;

    RecordMsgEnum(int i, FitDesign.FieldType fieldType) {
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
