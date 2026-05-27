package com.huawei.wisecloud.drmclient.utils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public enum HmacAlgo {
    DEFAULT(0, "HmacSHA256"),
    HMACSHA256(1, "HmacSHA256");

    private static final Map<Integer, String> PREFERRED_ALGS = new HashMap();
    private String algoName;
    private int id;

    static {
        for (HmacAlgo hmacAlgo : EnumSet.allOf(HmacAlgo.class)) {
            PREFERRED_ALGS.put(Integer.valueOf(hmacAlgo.id), hmacAlgo.algoName);
        }
    }

    HmacAlgo(int i, String str) {
        this.id = i;
        this.algoName = str;
    }

    public static String getAlgoName(int i) {
        return PREFERRED_ALGS.get(Integer.valueOf(i));
    }
}
