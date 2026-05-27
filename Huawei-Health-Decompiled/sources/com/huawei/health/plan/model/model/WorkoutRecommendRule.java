package com.huawei.health.plan.model.model;

/* JADX INFO: loaded from: classes10.dex */
public class WorkoutRecommendRule {
    private String mRuleDate;
    private String mRuleName;

    public WorkoutRecommendRule(String str, String str2) {
        this.mRuleName = str;
        this.mRuleDate = str2;
    }

    public String getRuleName() {
        return this.mRuleName;
    }

    public void setRuleName(String str) {
        this.mRuleName = str;
    }

    public String getRuleDate() {
        return this.mRuleDate;
    }

    public void setRuleDate(String str) {
        this.mRuleDate = str;
    }
}
