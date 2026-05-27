package com.huawei.healthcloud.plugintrack.runningroute.utils;

import com.huawei.health.R;

/* JADX INFO: loaded from: classes10.dex */
public enum MapInfoEnum {
    MAP_GAODE(1, "com.autonavi.minimap", R.string._2130837694_res_0x7f0200be),
    MAP_TENCENT(2, "com.tencent.map", R.string._2130846229_res_0x7f022215),
    MAP_BAIDU(3, "com.baidu.BaiduMap", R.string._2130846228_res_0x7f022214);

    private int mId;
    private String mMapPackage;
    private int mNameId;

    MapInfoEnum(int i, String str, int i2) {
        this.mId = i;
        this.mMapPackage = str;
        this.mNameId = i2;
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public String getMapPackage() {
        return this.mMapPackage;
    }

    public void setMapPackage(String str) {
        this.mMapPackage = str;
    }

    public int getNameId() {
        return this.mNameId;
    }

    public void setNameId(int i) {
        this.mNameId = i;
    }
}
