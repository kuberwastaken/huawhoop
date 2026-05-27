package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.la;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ks extends la {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f1187a;
    private Map<String, String> b;

    @Override // com.amap.api.col.p0003sl.la
    public final Map<String, String> getRequestHead() {
        return null;
    }

    public ks(byte[] bArr, Map<String, String> map) {
        this.f1187a = bArr;
        this.b = map;
        setDegradeAbility(la.a.SINGLE);
        setHttpProtocol(la.c.HTTPS);
    }

    @Override // com.amap.api.col.p0003sl.la
    public final Map<String, String> getParams() {
        return this.b;
    }

    @Override // com.amap.api.col.p0003sl.la
    public final byte[] getEntityBytes() {
        return this.f1187a;
    }

    @Override // com.amap.api.col.p0003sl.la
    public final String getURL() {
        return "https://adiu.amap.com/ws/device/adius";
    }
}
