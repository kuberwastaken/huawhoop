package com.huawei.ui.commonui.linechart.model;

import com.huawei.ui.commonui.linechart.common.DataLayerType;

/* JADX INFO: loaded from: classes7.dex */
public interface MultiDataBarModel {
    float getCeil();

    float getCeil(DataLayerType dataLayerType);

    void put(DataLayerType dataLayerType, float f);
}
