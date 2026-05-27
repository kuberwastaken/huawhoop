package com.huawei.hihealthservice.healthtrend;

import com.huawei.hihealth.data.listener.HealthTrendListener;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface HealthTrendApi {
    void getHealthTrend(List<String> list, int[] iArr, int i, HealthTrendListener healthTrendListener);
}
