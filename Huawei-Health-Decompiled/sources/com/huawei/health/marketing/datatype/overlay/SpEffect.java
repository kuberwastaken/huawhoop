package com.huawei.health.marketing.datatype.overlay;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SpEffect {
    private List<SpEffectButton> buttonList;
    private List<SpEffectFile> spEffectFileList;
    private String spEffectId;
    private String spEffectName;

    public String getSpEffectId() {
        return this.spEffectId;
    }

    public String getSpEffectName() {
        return this.spEffectName;
    }

    public List<SpEffectFile> getSpEffectFileList() {
        return this.spEffectFileList;
    }

    public List<SpEffectButton> getButtonList() {
        return this.buttonList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SpEffect{spEffectId='");
        sb.append(this.spEffectId);
        sb.append("', spEffectName='");
        sb.append(this.spEffectName);
        sb.append("', spEffectFileList=");
        List<SpEffectFile> list = this.spEffectFileList;
        sb.append(list == null ? " " : list.toString());
        sb.append(", buttonList=");
        List<SpEffectButton> list2 = this.buttonList;
        sb.append(list2 != null ? list2.toString() : " ");
        sb.append('}');
        return sb.toString();
    }
}
