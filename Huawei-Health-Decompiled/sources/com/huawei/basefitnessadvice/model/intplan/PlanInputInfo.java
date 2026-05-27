package com.huawei.basefitnessadvice.model.intplan;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface PlanInputInfo {
    List<Integer> getBodyParts();

    int getExperience();

    int getGoalType();

    int getIsRunFlag();

    int getIsSkipRopeFlag();

    UserProfile getUserInfo();
}
