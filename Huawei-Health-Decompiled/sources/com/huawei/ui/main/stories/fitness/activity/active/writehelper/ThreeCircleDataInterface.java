package com.huawei.ui.main.stories.fitness.activity.active.writehelper;

import com.huawei.hihealth.HiHealthData;
import com.huawei.hwbasemgr.ResponseCallback;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface ThreeCircleDataInterface {
    void clearData();

    void requestAggregateData(long j, long j2, ResponseCallback<List<HiHealthData>> responseCallback);
}
