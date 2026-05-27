package com.huawei.ads.adsrec.db.table;

import com.huawei.ads.fund.anno.DataKeep;
import com.huawei.ads.fund.db.RecordBean;

/* JADX INFO: loaded from: classes3.dex */
@DataKeep
public class AdEventRecord extends RecordBean {
    private String clientRequestId;
    private String contentId;
    private long eventTime = System.currentTimeMillis();
    private String eventType;
    private int maxShowRatio;
    private String pkgName;
    private long showDuration;
    private String showId;
    private String slotId;

    @Override // com.huawei.ads.fund.db.Table
    public long getMaxStoreTime() {
        return 7776000000L;
    }

    public String toString() {
        return "AdEventRecord{pkgName='" + this.pkgName + "', slotId='" + this.slotId + "', contentId='" + this.contentId + "', showId='" + this.showId + "', showDuration=" + this.showDuration + ", maxShowRatio=" + this.maxShowRatio + ", eventType='" + this.eventType + "', eventTime=" + this.eventTime + ", clientRequestId=" + this.clientRequestId + '}';
    }

    public String h() {
        return this.slotId;
    }

    @Override // com.huawei.ads.fund.db.Table
    public String getExpireCleanWhereClause() {
        return "eventTime<?";
    }

    public String g() {
        return this.showId;
    }

    public void j(String str) {
        this.slotId = str;
    }

    public long j() {
        return this.showDuration;
    }

    public void a(String str) {
        this.showId = str;
    }

    public String d() {
        return this.pkgName;
    }

    public void e(String str) {
        this.pkgName = str;
    }

    public String e() {
        return this.eventType;
    }

    public void c(String str) {
        this.eventType = str;
    }

    public long c() {
        return this.eventTime;
    }

    public void d(String str) {
        this.contentId = str;
    }

    public void d(long j) {
        this.showDuration = j;
    }

    public String b() {
        return this.contentId;
    }

    public void b(String str) {
        this.clientRequestId = str;
    }

    public void e(long j) {
        this.eventTime = j;
    }

    public void a(int i) {
        this.maxShowRatio = i;
    }

    public String a() {
        return this.clientRequestId;
    }
}
