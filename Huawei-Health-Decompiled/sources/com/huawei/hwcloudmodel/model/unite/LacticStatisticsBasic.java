package com.huawei.hwcloudmodel.model.unite;

/* JADX INFO: loaded from: classes11.dex */
public class LacticStatisticsBasic {
    private int lastLthrHr;
    private int lastLthrPace;

    public int getLastLthrPace() {
        return this.lastLthrPace;
    }

    public void setLastLthrPace(int i) {
        this.lastLthrPace = i;
    }

    public int getLastLthrHr() {
        return this.lastLthrHr;
    }

    public void setLastLthrHr(int i) {
        this.lastLthrHr = i;
    }

    public String toString() {
        return "LacticStatisticsBasic{lastLthrHr=" + this.lastLthrHr + ", lastLthrPace=" + this.lastLthrPace + '}';
    }
}
