package com.huawei.ads.adsrec;

import com.huawei.ads.adsrec.bean.RelationScore;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IDsRelationCallback {
    float getRelationCoL(String str);

    List<RelationScore> getRelationScore(JSONObject jSONObject);

    boolean isSupportRelateRank();
}
