package com.huawei.health.marketing.datatype.overlay;

import com.huawei.health.marketing.datatype.templates.BaseTemplate;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class OverlayTemplate extends BaseTemplate {
    private int interactiveEffect;
    private String linkValue;
    private List<Picture> pictureList;
    private String spEffectId;
    private Map<String, SpEffect> spEffectMap;
    private int triggerAction;

    public List<Picture> getPictureList() {
        return this.pictureList;
    }

    public int getTriggerAction() {
        return this.triggerAction;
    }

    public int getInteractiveEffect() {
        return this.interactiveEffect;
    }

    public String getLinkValue() {
        return this.linkValue;
    }

    public String getSpEffectId() {
        return this.spEffectId;
    }

    public Map<String, SpEffect> getSpEffectMap() {
        return this.spEffectMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OverlayTemplate{pictureList=");
        List<Picture> list = this.pictureList;
        sb.append(list == null ? " " : list.toString());
        sb.append(", triggerAction=");
        sb.append(this.triggerAction);
        sb.append(", interactiveEffect=");
        sb.append(this.interactiveEffect);
        sb.append(", linkValue='");
        sb.append(this.linkValue);
        sb.append("', spEffectId='");
        sb.append(this.spEffectId);
        sb.append("', spEffectMap=");
        Map<String, SpEffect> map = this.spEffectMap;
        sb.append(map != null ? map.toString() : " ");
        sb.append('}');
        return sb.toString();
    }
}
