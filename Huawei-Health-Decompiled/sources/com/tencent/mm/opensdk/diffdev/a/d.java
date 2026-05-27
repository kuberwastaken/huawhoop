package com.tencent.mm.opensdk.diffdev.a;

/* JADX INFO: loaded from: classes11.dex */
public enum d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11844a;

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.f11844a;
    }

    public int a() {
        return this.f11844a;
    }

    d(int i) {
        this.f11844a = i;
    }
}
