package com.huawei.watchface;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes8.dex */
public class ff {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseArray<String> f11535a;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        f11535a = sparseArray;
        sparseArray.put(20001, "File info check fail");
        sparseArray.put(20002, "getDeviceInfoByBt() failed");
        sparseArray.put(20003, "Send watchface info to device failed");
        sparseArray.put(20004, "getSupportedClockCapability() failed -- exception msg");
        sparseArray.put(20005, "loadProperties() failed -- exception msg");
        sparseArray.put(20006, "updateWearStructListByXmlRes() failed -- exception msg");
        sparseArray.put(20007, "setBackgroundOptionalConfig() failed -- exception msg");
        sparseArray.put(20008, "createRoundedPngRes() failed -- exception msg");
    }

    public static String a(int i) {
        return f11535a.get(i);
    }
}
