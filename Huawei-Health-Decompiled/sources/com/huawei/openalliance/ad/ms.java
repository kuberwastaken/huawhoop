package com.huawei.openalliance.ad;

import com.iab.omid.library.huawei.adsession.media.Position;
import com.iab.omid.library.huawei.adsession.media.VastProperties;

/* JADX INFO: loaded from: classes6.dex */
public class ms {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7526a = mc.a("com.iab.omid.library.huawei.adsession.media.VastProperties");
    private final boolean b = false;
    private final boolean c;
    private final VastProperties d;
    private final mr e;
    private Float f;

    public VastProperties b() {
        return this.d;
    }

    public static boolean a() {
        return f7526a;
    }

    public static ms a(float f, boolean z, mr mrVar) {
        Position positionA;
        return new ms(f, z, mrVar, (mrVar == null || !a() || (positionA = mr.a(mrVar)) == null) ? null : VastProperties.createVastPropertiesForSkippableMedia(f, z, positionA));
    }

    private ms(float f, boolean z, mr mrVar, VastProperties vastProperties) {
        this.f = Float.valueOf(0.0f);
        this.f = Float.valueOf(f);
        this.c = z;
        this.e = mrVar;
        this.d = vastProperties;
    }
}
