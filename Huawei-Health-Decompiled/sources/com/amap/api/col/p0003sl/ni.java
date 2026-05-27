package com.amap.api.col.p0003sl;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ni implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1299a;
    public String b;
    public int c;
    public int d;
    public long e;
    public long f;
    public int g;
    public boolean h;
    public boolean i;

    @Override // 
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract ni clone();

    public ni() {
        this.f1299a = "";
        this.b = "";
        this.c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.i = true;
    }

    public ni(boolean z, boolean z2) {
        this.f1299a = "";
        this.b = "";
        this.c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.h = z;
        this.i = z2;
    }

    public final int b() {
        return a(this.f1299a);
    }

    public final int c() {
        return a(this.b);
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            ns.a(e);
            return 0;
        }
    }

    public final void a(ni niVar) {
        this.f1299a = niVar.f1299a;
        this.b = niVar.b;
        this.c = niVar.c;
        this.d = niVar.d;
        this.e = niVar.e;
        this.f = niVar.f;
        this.g = niVar.g;
        this.h = niVar.h;
        this.i = niVar.i;
    }

    public String toString() {
        return "AmapCell{mcc=" + this.f1299a + ", mnc=" + this.b + ", signalStrength=" + this.c + ", asulevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newapi=" + this.i + '}';
    }
}
