package com.huawei.wisecloud.drmclient.utils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
public enum AESAlgo {
    AES_128_GCM(1, "AES/GCM/NoPadding"),
    AES_128_CBC(2, "AES/CBC/PKCS5Padding");

    private static final Map<Integer, String> PREFERRED_ALGS_AES = new HashMap();
    private String algoName;
    private int id;

    static {
        for (AESAlgo aESAlgo : EnumSet.allOf(AESAlgo.class)) {
            PREFERRED_ALGS_AES.put(Integer.valueOf(aESAlgo.id), aESAlgo.algoName);
        }
    }

    AESAlgo(int i, String str) {
        this.id = i;
        this.algoName = str;
    }

    public static String getAlgoName(int i) {
        return PREFERRED_ALGS_AES.get(Integer.valueOf(i));
    }

    public static Set<Integer> getAlgoNameList() {
        return PREFERRED_ALGS_AES.keySet();
    }
}
