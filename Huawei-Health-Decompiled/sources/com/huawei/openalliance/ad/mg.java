package com.huawei.openalliance.ad;

import com.iab.omid.library.huawei.adsession.AdSessionConfiguration;

/* JADX INFO: loaded from: classes6.dex */
public class mg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7511a = mc.a("com.iab.omid.library.huawei.adsession.AdSessionConfiguration");
    private AdSessionConfiguration b;

    public AdSessionConfiguration b() {
        return this.b;
    }

    public static boolean a() {
        return f7511a;
    }

    public static mg a(mi miVar, ml mlVar, mm mmVar, mm mmVar2, boolean z) {
        if (f7511a) {
            return new mg(miVar, mlVar, mmVar, mmVar2, z);
        }
        return null;
    }

    private mg(mi miVar, ml mlVar, mm mmVar, mm mmVar2, boolean z) {
        this.b = null;
        if (mi.a() && ml.a() && mm.a()) {
            this.b = AdSessionConfiguration.createAdSessionConfiguration(mi.a(miVar), ml.a(mlVar), mm.a(mmVar), mm.a(mmVar2), z);
        }
    }
}
