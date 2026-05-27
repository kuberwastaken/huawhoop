package com.huawei.hianalytics.visual;

import com.huawei.openalliance.ad.constant.Constants;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4072a;
    public long b = System.currentTimeMillis();

    public j0(String str) {
        this.f4072a = str;
    }

    public static j0 a() {
        return new j0(UUID.randomUUID().toString().replaceAll(Constants.LINK, ""));
    }
}
