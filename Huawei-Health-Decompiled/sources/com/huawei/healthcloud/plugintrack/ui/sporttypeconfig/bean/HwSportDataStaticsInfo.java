package com.huawei.healthcloud.plugintrack.ui.sporttypeconfig.bean;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class HwSportDataStaticsInfo {

    @SerializedName("itemType")
    private String mItemType;

    @SerializedName("requestData")
    private List<HwStaticsRequestData> mRequestData;

    public String getStaticsType() {
        return this.mItemType;
    }

    public List<HwStaticsRequestData> getStaticsRequestData() {
        return this.mRequestData;
    }

    public Map<String, String> getItemDataTypeStringMap() {
        HashMap map = new HashMap();
        for (HwStaticsRequestData hwStaticsRequestData : this.mRequestData) {
            if (hwStaticsRequestData != null) {
                map.put(hwStaticsRequestData.getDataType(), hwStaticsRequestData.getRequestDataString());
            }
        }
        return map;
    }
}
