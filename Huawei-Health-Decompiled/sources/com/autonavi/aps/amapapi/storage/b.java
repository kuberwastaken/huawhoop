package com.autonavi.aps.amapapi.storage;

import com.amap.api.col.p0003sl.kf;
import com.amap.api.col.p0003sl.kg;
import com.amap.api.location.AMapLocation;

/* JADX INFO: loaded from: classes3.dex */
@kf(a = "c")
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @kg(a = "a2", b = 6)
    private String f1622a;

    @kg(a = "a3", b = 5)
    private long b;

    @kg(a = "a4", b = 6)
    private String c;
    private AMapLocation d;

    public final AMapLocation a() {
        return this.d;
    }

    public final void a(AMapLocation aMapLocation) {
        this.d = aMapLocation;
    }

    public final String b() {
        return this.c;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final String c() {
        return this.f1622a;
    }

    public final void b(String str) {
        this.f1622a = str;
    }

    public final long d() {
        return this.b;
    }

    public final void a(long j) {
        this.b = j;
    }
}
