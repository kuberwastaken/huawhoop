package com.huawei.maps.offlinedata.consts;

import com.huawei.pluginfitnessadvice.FitWorkout;

/* JADX INFO: loaded from: classes6.dex */
public enum a {
    IS_SUPPORT_OFFLINE_MAP(1, 201),
    IS_SUPPORT_CONTOUR_MAP(2, 202),
    IS_SUPPORT_AUTO_DOWNLOAD_MAP(3, FitWorkout.CATEGORY_REAL_SCENE);

    private final int d;
    private final int e;

    a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public int a() {
        return this.e;
    }
}
