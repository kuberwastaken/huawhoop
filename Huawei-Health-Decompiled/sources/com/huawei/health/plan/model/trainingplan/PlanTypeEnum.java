package com.huawei.health.plan.model.trainingplan;

/* JADX INFO: loaded from: classes4.dex */
public enum PlanTypeEnum {
    TRAINING_PLAN_3_KILOMETERS(1),
    TRAINING_PLAN_5_KILOMETERS(2),
    TRAINING_PLAN_10_KILOMETERS(3),
    TRAINING_PLAN_HALF(4),
    TRAINING_PLAN_FULL(5),
    TRAINING_PLAN_MINI(6),
    TRAINING_PLAN_CUSTOM_EVENT(7),
    TRAINING_PLAN_HEALTH(11),
    TRAINING_PLAN_MUSIC(12),
    TRAINING_PLAN_CITY(13),
    TRAINING_PLAN_STAY_FIT(14),
    TRAINING_PLAN_ENERGY_RECOVERY(15),
    TRAINING_PLAN_HABIT_FORMATION(16),
    TRAINING_PLAN_CARDIOPULMONARY(17);

    private final int value;

    PlanTypeEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
