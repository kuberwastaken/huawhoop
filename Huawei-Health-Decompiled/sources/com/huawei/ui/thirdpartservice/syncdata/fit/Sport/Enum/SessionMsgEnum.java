package com.huawei.ui.thirdpartservice.syncdata.fit.Sport.Enum;

import com.huawei.ui.thirdpartservice.syncdata.fit.FitEncoder.FitDesign;

/* JADX INFO: loaded from: classes8.dex */
public enum SessionMsgEnum {
    SPORT(5, FitDesign.FieldType.ENUM),
    SUB_SPORT(6, FitDesign.FieldType.ENUM),
    TOTAL_ELAPSED_TIME(7, FitDesign.FieldType.UINT32),
    TOTAL_TIMER_TIME(8, FitDesign.FieldType.UINT32),
    TOTAL_DISTANCE(9, FitDesign.FieldType.UINT32),
    TOTAL_CALORIES(11, FitDesign.FieldType.UINT16),
    START_TIME(2, FitDesign.FieldType.UINT32),
    AVG_SPEED(14, FitDesign.FieldType.UINT16),
    MAX_SPEED(15, FitDesign.FieldType.UINT16),
    AVG_HEART_RATE(16, FitDesign.FieldType.UINT8),
    AVG_CADENCE(18, FitDesign.FieldType.UINT8),
    AVG_STROKE_CADENCE(41, FitDesign.FieldType.UINT32),
    TOTAL_CYCLES(10, FitDesign.FieldType.UINT32);

    private final int num;
    private final FitDesign.FieldType type;

    SessionMsgEnum(int i, FitDesign.FieldType fieldType) {
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
