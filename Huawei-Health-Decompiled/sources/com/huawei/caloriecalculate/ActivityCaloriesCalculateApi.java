package com.huawei.caloriecalculate;

import defpackage.bzm;
import defpackage.bzr;

/* JADX INFO: loaded from: classes.dex */
public interface ActivityCaloriesCalculateApi {
    double calculateCalories(long j);

    double calculateCalories(long j, bzm bzmVar);

    double calculateCaloriesFromSteps(long j, int i);

    float calculateCaloriesOnlyStep(long j);

    long calculateDurationByCalories(float f, int i, int i2);

    double calculateTotalCalories(long j, bzm bzmVar);

    double calculateTotalCaloriesFromSteps(long j, int i);

    void initCalculateCalories(long j, int i);

    void initUserInfo(bzr bzrVar);
}
