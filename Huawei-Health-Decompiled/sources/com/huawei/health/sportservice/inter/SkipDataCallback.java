package com.huawei.health.sportservice.inter;

import defpackage.mqp;

/* JADX INFO: loaded from: classes10.dex */
public interface SkipDataCallback {
    void onBreakTimesChanges(int i);

    void onContinuousJumpTimesChanges(int i);

    void onFootPointChanges(mqp mqpVar);

    void onSkipNumberChanges(int i);

    void onSkipSpeedChanges(float f);

    void onStatusChanges(int i);
}
