package com.huawei.phoneservice.faq.base;

/* JADX INFO: loaded from: classes6.dex */
public enum b {
    INIT_FAIL(-1, "NO INITIALIZED"),
    PARAMETER_ERROR(1, "PARAMETER EMPTY "),
    NO_ADDRESS(2, "NO ADDRESS "),
    NO_MODULE(3, "NO MODULE"),
    NO_GRS_ADDRESS(4, "NO GRS ADDRESS"),
    NO_ADDRESS_SERVICE(5, "NO ADDRESS BY SERVICE ERROR"),
    NO_MODULE_SERVICE(6, "NO MODULE BY SERVICE ERROR"),
    INIT_AGAIN(7, "INIT_AGAIN"),
    INIT_SUCCESS(0, "INIT SUCCESS");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8514a;
    private String b;

    public boolean c() {
        int i = this.f8514a;
        return i == 0 || i == 3;
    }

    public String b() {
        return this.b;
    }

    public int a() {
        return this.f8514a;
    }

    b(int i, String str) {
        this.f8514a = i;
        this.b = str;
    }
}
