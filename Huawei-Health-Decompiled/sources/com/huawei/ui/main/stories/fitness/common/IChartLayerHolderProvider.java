package com.huawei.ui.main.stories.fitness.common;

import com.huawei.ui.commonui.linechart.icommon.IChartLayerHolder;

/* JADX INFO: loaded from: classes2.dex */
public interface IChartLayerHolderProvider<T extends IChartLayerHolder> {
    T acquireChartLayerHolder();
}
