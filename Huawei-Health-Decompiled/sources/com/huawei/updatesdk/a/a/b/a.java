package com.huawei.updatesdk.a.a.b;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes8.dex */
public final class a {
    private static final a b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue<byte[]> f11303a = new ArrayDeque(0);

    public byte[] a() {
        byte[] bArrPoll;
        synchronized (this.f11303a) {
            bArrPoll = this.f11303a.poll();
        }
        return bArrPoll == null ? new byte[65536] : bArrPoll;
    }

    public void a(byte[] bArr) {
        if (bArr.length == 65536) {
            synchronized (this.f11303a) {
                b(bArr);
            }
        }
    }

    private void b(byte[] bArr) {
        if (this.f11303a.size() >= 32 || this.f11303a.offer(bArr)) {
            return;
        }
        com.huawei.updatesdk.a.a.c.a.a.a.a("ByteArrayPool", "releaseBytes false");
    }

    public static a b() {
        return b;
    }

    private a() {
    }
}
