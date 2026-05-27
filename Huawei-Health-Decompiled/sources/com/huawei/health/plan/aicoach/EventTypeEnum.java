package com.huawei.health.plan.aicoach;

import androidx.media3.extractor.text.ttml.TtmlNode;

/* JADX INFO: loaded from: classes10.dex */
public enum EventTypeEnum {
    START("start"),
    END(TtmlNode.END),
    GENERATE("generate");

    private final String type;

    EventTypeEnum(String str) {
        this.type = str;
    }

    public String getType() {
        return this.type;
    }
}
