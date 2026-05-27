package com.huawei.health.device.api;

import com.huawei.hihealth.HiAggregateOption;

/* JADX INFO: loaded from: classes4.dex */
public interface WeightDataUtilsApi {
    HiAggregateOption buildHiAggregateOption();

    int getFractionDigitForWeight(double d, int i);
}
