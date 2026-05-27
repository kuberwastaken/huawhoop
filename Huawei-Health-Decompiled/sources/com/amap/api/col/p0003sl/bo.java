package com.amap.api.col.p0003sl;

/* JADX INFO: loaded from: classes3.dex */
@kf(a = "update_item_file")
class bo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @kg(a = "mAdcode", b = 6)
    private String f857a;

    @kg(a = "file", b = 6)
    private String b;

    public bo() {
        this.f857a = "";
        this.b = "";
    }

    public bo(String str, String str2) {
        this.f857a = str;
        this.b = str2;
    }

    public final String a() {
        return this.b;
    }

    public static String a(String str) {
        return "mAdcode='" + str + "'";
    }
}
