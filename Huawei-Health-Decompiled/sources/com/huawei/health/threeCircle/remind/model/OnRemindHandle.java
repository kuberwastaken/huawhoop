package com.huawei.health.threeCircle.remind.model;

import android.os.Bundle;
import defpackage.hqj;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface OnRemindHandle {
    void destroy();

    boolean isActiveTrigger();

    void onTrigger(Bundle bundle, Map<String, Integer> map, hqj hqjVar);

    void onTrigger(Map<String, Integer> map, hqj hqjVar);

    void registerAlarm();
}
