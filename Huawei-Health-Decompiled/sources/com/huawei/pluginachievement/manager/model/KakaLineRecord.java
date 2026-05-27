package com.huawei.pluginachievement.manager.model;

import defpackage.nof;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class KakaLineRecord extends nof {
    private KakaDelayInfo kakaDelayInfo;
    private List<KakaRecord> kakaLineRecords;
    private int totalNum;

    public KakaLineRecord() {
        super(6);
    }

    public List<KakaRecord> getKakaLineRecords() {
        return this.kakaLineRecords;
    }

    public void setKakaLineRecords(List<KakaRecord> list) {
        this.kakaLineRecords = list;
    }

    public void setTotalNum(int i) {
        this.totalNum = i;
    }

    public int getTotalNum() {
        return this.totalNum;
    }

    public KakaDelayInfo getKakaDelayInfo() {
        return this.kakaDelayInfo;
    }

    public void setKakaDelayInfo(KakaDelayInfo kakaDelayInfo) {
        this.kakaDelayInfo = kakaDelayInfo;
    }
}
