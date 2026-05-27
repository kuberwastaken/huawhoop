package com.huawei.pluginachievement.report.bean;

import com.huawei.pluginachievement.report.constant.EnumAnnualType;

/* JADX INFO: loaded from: classes7.dex */
public class AnnualReportReward extends AnnualData {
    private String medalIdList;

    public AnnualReportReward() {
        super(EnumAnnualType.REPORT_REWARD.value());
    }

    public void saveMedalIdList(String str) {
        this.medalIdList = str;
    }

    public String toString() {
        return "AnnualReportReward{medalIdList='" + this.medalIdList + "'}";
    }
}
