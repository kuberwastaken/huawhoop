package com.huawei.health.plan.api;

import com.huawei.basefitnessadvice.callback.UiCallback;
import defpackage.frp;
import defpackage.frr;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface HealthPlanApi {
    void createPlan(frr frrVar, UiCallback<Object> uiCallback);

    List<Object> getSchedulesByCalendar(frp frpVar, boolean z);
}
