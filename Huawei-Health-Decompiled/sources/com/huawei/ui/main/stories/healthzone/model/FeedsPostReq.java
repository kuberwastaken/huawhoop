package com.huawei.ui.main.stories.healthzone.model;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hwcloudmodel.model.CloudCommonRequest;
import com.huawei.operation.ble.BleConstants;

/* JADX INFO: loaded from: classes8.dex */
public class FeedsPostReq extends CloudCommonRequest {

    @SerializedName("cursor")
    private String cursor;

    @SerializedName(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)
    private int direction;

    @SerializedName(BleConstants.LIMIT)
    private int limit;

    @SerializedName("tmpLang")
    private int tmpLang;

    public void setPostLimit(int i) {
        this.limit = i;
    }

    public void setDataCursor(String str) {
        this.cursor = str;
    }

    public void setPageDirection(int i) {
        this.direction = i;
    }

    public void setTmpLang(int i) {
        this.tmpLang = i;
    }
}
