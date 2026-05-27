package com.huawei.health.plan.aicoach;

/* JADX INFO: loaded from: classes4.dex */
public enum SourceActionEnum {
    BODY_WEIGHT_DETAIL(1),
    FAT_LOSS_PLAN_DETAIL(2),
    EXERCISE_RECORD_DETAIL(3),
    TRAINING_PLAN_DETAIL(4),
    RUNNING_PAGE(5);

    private final int value;

    SourceActionEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
