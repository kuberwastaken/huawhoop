package com.amap.api.col.p0003sl;

import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public enum jq {
    MIUI(iy.c("IeGlhb21p")),
    Flyme(iy.c("IbWVpenU")),
    RH(iy.c("IaHVhd2Vp")),
    ColorOS(iy.c("Ib3Bwbw")),
    FuntouchOS(iy.c("Idml2bw")),
    SmartisanOS(iy.c("Mc21hcnRpc2Fu")),
    AmigoOS(iy.c("IYW1pZ28")),
    EUI(iy.c("IbGV0dg")),
    Sense(iy.c("EaHRj")),
    LG(iy.c("EbGdl")),
    Google(iy.c("IZ29vZ2xl")),
    NubiaUI(iy.c("IbnViaWE")),
    Other("");

    private String n;
    private int o;
    private String p;
    private String q;
    private String r = Build.MANUFACTURER;

    jq(String str) {
        this.n = str;
    }

    public final String a() {
        return this.n;
    }

    public final void a(int i) {
        this.o = i;
    }

    public final String b() {
        return this.p;
    }

    public final void a(String str) {
        this.p = str;
    }

    public final void b(String str) {
        this.q = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.o + ", versionName='" + this.q + "',ma=" + this.n + "',manufacturer=" + this.r + "'}";
    }
}
