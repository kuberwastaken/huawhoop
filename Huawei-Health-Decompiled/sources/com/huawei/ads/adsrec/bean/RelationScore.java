package com.huawei.ads.adsrec.bean;

import com.huawei.ads.fund.anno.DataKeep;

/* JADX INFO: loaded from: classes3.dex */
@DataKeep
public class RelationScore {
    private String contentId;
    private double intentScore;
    private double mergedScore;
    private double score;

    public double a() {
        return this.score;
    }

    public double e() {
        return this.mergedScore;
    }

    public double b() {
        return this.intentScore;
    }

    public String c() {
        return this.contentId;
    }

    public RelationScore(RelationScore relationScore) {
        this.contentId = relationScore.c();
        this.score = relationScore.a();
        this.intentScore = relationScore.b();
        this.mergedScore = relationScore.e();
    }

    public RelationScore() {
    }
}
