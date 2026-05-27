package com.huawei.hms.kit.awareness.b;

import com.huawei.hms.kit.awareness.AwarenessStatusCodes;

/* JADX INFO: loaded from: classes5.dex */
public class HHG extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f5007a = 7982983303014510118L;

    public HHG(String str) {
        super(str);
    }

    public HHG(int i, String str) {
        super("Error Code: " + i + " Desc: " + str);
    }

    public HHG(int i) {
        super("Error Code: " + i + " Desc: " + AwarenessStatusCodes.getMessage(i));
    }
}
