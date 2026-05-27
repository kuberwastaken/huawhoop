package com.huawei.health.plan.model.trainingplan;

/* JADX INFO: loaded from: classes4.dex */
public enum PlanStatusEnum {
    EXECUTION(1),
    TERMINATION(2),
    END(3);

    private final int value;

    PlanStatusEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
