package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: classes8.dex */
public final class e {
    public static c i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11946a;
    public int b;
    public String c;
    public String d;
    public String e;
    public int f;
    public f g;
    public String h;

    public final String toString() {
        return "{result=" + this.f11946a + ", type=" + this.b + ", ret_code='" + this.c + "', apikey='" + this.d + "', seq='" + this.e + "', setTime=" + this.f + ", err_info=" + this.g + ", sdk_v='" + this.h + "', access_process=" + i + '}';
    }

    public static c a() {
        if (i == null) {
            i = new c();
        }
        return i;
    }
}
