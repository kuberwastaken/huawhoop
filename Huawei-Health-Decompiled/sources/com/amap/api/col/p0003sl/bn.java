package com.amap.api.col.p0003sl;

/* JADX INFO: loaded from: classes3.dex */
@kf(a = "update_item_download_info")
class bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @kg(a = "mAdcode", b = 6)
    private String f856a;

    @kg(a = "fileLength", b = 5)
    private long b;

    @kg(a = "splitter", b = 2)
    private int c;

    @kg(a = "startPos", b = 5)
    private long d;

    @kg(a = "endPos", b = 5)
    private long e;

    public bn() {
        this.f856a = "";
        this.b = 0L;
        this.c = 0;
        this.d = 0L;
        this.e = 0L;
    }

    public bn(String str, long j, int i, long j2, long j3) {
        this.f856a = str;
        this.b = j;
        this.c = i;
        this.d = j2;
        this.e = j3;
    }

    public static String a(String str) {
        return "mAdcode='" + str + "'";
    }
}
