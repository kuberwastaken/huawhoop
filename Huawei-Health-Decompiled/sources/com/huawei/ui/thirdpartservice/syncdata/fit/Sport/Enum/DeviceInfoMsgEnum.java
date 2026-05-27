package com.huawei.ui.thirdpartservice.syncdata.fit.Sport.Enum;

import com.huawei.ui.thirdpartservice.syncdata.fit.FitEncoder.FitDesign;

/* JADX INFO: loaded from: classes11.dex */
public enum DeviceInfoMsgEnum {
    TIMESTAMP(253, FitDesign.FieldType.UINT32),
    DEVICE_INDEX(0, FitDesign.FieldType.UINT8),
    MANUFACTURE(2, FitDesign.FieldType.UINT16),
    PRODUCT(4, FitDesign.FieldType.UINT16),
    PRODUCT_NAME(27, FitDesign.FieldType.STRING);

    private final int num;
    private final FitDesign.FieldType type;

    DeviceInfoMsgEnum(int i, FitDesign.FieldType fieldType) {
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
