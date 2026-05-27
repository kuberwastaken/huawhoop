package com.huawei.healthcloud.plugintrack.model;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwlogsmodel.LogUtil;
import defpackage.mgx;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class PostureJudgeBean implements Serializable {
    private static final String GOOD = "good";
    private static final int MAX_VALUE = 50000;
    private static final int MIN_VALUE = 0;
    private static final String NORMAL = "normal";
    private static final String PERFECT = "perfect";
    private static final String POOR = "poor";
    private static final String SUBOPTIMAL = "suboptimal";
    private static final String TAG = "Track_PostureJudgeBean";
    private static final long serialVersionUID = 2324322170929969061L;

    @SerializedName("paceList")
    private List<d> mPaceJudgeList;

    @SerializedName("type")
    private String mType;

    public String getType() {
        return this.mType;
    }

    public List<d> getPaceList() {
        return this.mPaceJudgeList;
    }

    public static class d implements Serializable {
        private static final long serialVersionUID = -101120795072465394L;

        @SerializedName("judgeDataList")
        Map<String, List<Float>> b = new HashMap();

        @SerializedName("pace")
        List<Integer> d;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Map<String, List<Float>> map = this.b;
            if (map == null) {
                LogUtil.a(PostureJudgeBean.TAG, "map is null");
                return "";
            }
            for (Map.Entry<String, List<Float>> entry : map.entrySet()) {
                if (entry == null || entry.getValue() == null) {
                    return "";
                }
                sb.append("Key = ");
                sb.append(entry.getKey());
                sb.append(", Value = ");
                sb.append(entry.getValue().size());
            }
            return "PaceJudge{pace=" + this.d + ", list=" + ((Object) sb) + '}';
        }

        public int e() {
            List<Integer> list = this.d;
            if (list == null || list.size() != 2 || this.d.get(0) == null) {
                return 0;
            }
            return this.d.get(0).intValue();
        }

        public List<Float> b() {
            ArrayList arrayList = new ArrayList();
            Map<String, List<Float>> map = this.b;
            if (map == null) {
                LogUtil.b(PostureJudgeBean.TAG, "getJudgeList,map is null");
                return arrayList;
            }
            int i = 0;
            for (Map.Entry<String, List<Float>> entry : map.entrySet()) {
                if (entry != null && !mgx.e((Collection<?>) entry.getValue(), 1)) {
                    if (PostureJudgeBean.PERFECT.equals(entry.getKey()) && entry.getValue().get(0).floatValue() == 0.0f) {
                        i = 1;
                    }
                    float fFloatValue = entry.getValue().get(i).floatValue();
                    if (Math.abs(fFloatValue - 50000.0f) >= 1.0E-7d && Math.abs(fFloatValue - 0.0f) >= 1.0E-7d) {
                        arrayList.add(Float.valueOf(fFloatValue));
                    }
                }
            }
            Collections.sort(arrayList);
            return arrayList;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<d> list = this.mPaceJudgeList;
        if (list == null) {
            return "";
        }
        for (d dVar : list) {
            if (dVar != null) {
                sb.append(dVar.toString());
            }
        }
        return "Judge{type='" + this.mType + "', list=" + ((Object) sb) + '}';
    }
}
