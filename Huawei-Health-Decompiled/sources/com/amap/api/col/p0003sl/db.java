package com.amap.api.col.p0003sl;

import androidx.media3.extractor.text.ttml.TtmlNode;

/* JADX INFO: loaded from: classes3.dex */
public enum db {
    STYLE_ELEMENT_LABELFILL_OLD("labels.text.fill", 0),
    STYLE_ELEMENT_LABELSTROKE_OLD("labels.text.stroke", 1),
    STYLE_ELEMENT_GEOMETRYSTROKE_OLD("geometry.stroke", 2),
    STYLE_ELEMENT_GEOMETRYFILL_OLD("geometry.fill", 3),
    STYLE_ELEMENT_LABELFILL("textFillColor", 0),
    STYLE_ELEMENT_LABELSTROKE("textStrokeColor", 1),
    STYLE_ELEMENT_GEOMETRYSTROKE("strokeColor", 2),
    STYLE_ELEMENT_GEOMETRYFILL("fillColor", 3),
    STYLE_ELEMENT_GEOMETRYFILL1("color", 3),
    STYLE_ELEMENT_GEOMETRYFILL2("textureName", 3),
    STYLE_ELEMENT_BACKGROUNDFILL(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, 4),
    STYLE_ELEMENT_VISIBLE("visible", 5);

    private String m;
    private int n;

    db(String str, int i) {
        this.m = str;
        this.n = i;
    }

    private String a() {
        return this.m;
    }

    public static int a(String str) {
        for (db dbVar : values()) {
            if (dbVar.a().equals(str)) {
                return dbVar.n;
            }
        }
        return -1;
    }
}
