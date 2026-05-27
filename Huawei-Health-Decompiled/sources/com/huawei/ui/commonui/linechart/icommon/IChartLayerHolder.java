package com.huawei.ui.commonui.linechart.icommon;

import com.huawei.ui.commonui.linechart.HwHealthChartHolder;
import com.huawei.ui.commonui.linechart.common.DataInfos;
import com.huawei.ui.commonui.linechart.common.HwHealthBaseBarLineDataSet;
import com.huawei.ui.commonui.linechart.common.HwHealthBaseEntry;
import com.huawei.ui.commonui.linechart.common.HwHealthBaseScrollBarLineChart;

/* JADX INFO: loaded from: classes7.dex */
public interface IChartLayerHolder<T extends HwHealthBaseBarLineDataSet<? extends HwHealthBaseEntry>, C extends HwHealthBaseScrollBarLineChart> {

    public interface DataTypeFilter {
        boolean isAccept(DataInfos dataInfos);
    }

    T addDataLayer(C c, HwHealthChartHolder.e eVar);

    T addDataLayer(C c, DataInfos dataInfos);

    T addDataLayer(C c, T t, HwHealthChartHolder.e eVar);

    T fakeDataLayer(HwHealthChartHolder.e eVar);

    void rmDataLayer(C c, T t);

    void spetifiyDataTypeUnit(DataTypeFilter dataTypeFilter, String str);
}
