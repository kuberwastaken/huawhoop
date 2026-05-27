package com.huawei.ui.main.stories.history.adapter.monthdatashower;

import android.content.Context;
import com.huawei.healthcloud.plugintrack.ui.sporttypeconfig.bean.HwSportTypeInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface MonthDataShower {
    String getMainMonthData();

    int getSportType();

    String getUnit();

    void setBaseInformation(Map<String, Double> map, HwSportTypeInfo hwSportTypeInfo, Context context);
}
