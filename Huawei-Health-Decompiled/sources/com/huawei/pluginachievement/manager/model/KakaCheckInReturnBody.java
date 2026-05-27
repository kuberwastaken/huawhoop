package com.huawei.pluginachievement.manager.model;

/* JADX INFO: loaded from: classes7.dex */
public class KakaCheckInReturnBody {
    private int mConDays;
    private int mKaka;
    private int mKakaSum;

    public int getKaka() {
        return this.mKaka;
    }

    public void setKaka(int i) {
        this.mKaka = i;
    }

    public int getConDays() {
        return this.mConDays;
    }

    public void setConDays(int i) {
        this.mConDays = i;
    }

    public int getKakaSum() {
        return this.mKakaSum;
    }

    public void setKakaSum(int i) {
        this.mKakaSum = i;
    }

    public String toString() {
        return "KakaCheckInReturnBody{conDays=" + this.mConDays + ", kaka=" + this.mKaka + ", kakaSum='" + this.mKakaSum + "'}";
    }
}
