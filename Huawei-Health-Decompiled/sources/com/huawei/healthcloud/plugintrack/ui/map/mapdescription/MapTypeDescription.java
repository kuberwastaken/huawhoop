package com.huawei.healthcloud.plugintrack.ui.map.mapdescription;

/* JADX INFO: loaded from: classes5.dex */
public class MapTypeDescription {
    private MapType d = MapType.MAP_TYPE_SATELLITE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3902a = false;
    private byte[] e = null;
    private byte[] c = null;

    public enum MapType {
        MAP_TYPE_NORMAL,
        MAP_TYPE_SATELLITE,
        MAP_TYPE_NIGHT,
        MAP_TYPE_NAVI,
        MAP_TYPE_CUSTOM,
        DEFAULT_MAP_THREE_D
    }

    public MapTypeDescription a(boolean z) {
        this.f3902a = z;
        return this;
    }

    public MapTypeDescription b(byte[] bArr) {
        this.e = d(bArr);
        return this;
    }

    public MapType c() {
        return this.d;
    }

    public MapTypeDescription d(MapType mapType) {
        this.d = mapType;
        return this;
    }

    private byte[] d(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[i];
        }
        return bArr2;
    }
}
