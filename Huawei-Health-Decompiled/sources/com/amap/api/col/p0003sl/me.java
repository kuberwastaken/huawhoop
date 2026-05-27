package com.amap.api.col.p0003sl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class me {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    mg f1285a;
    private ByteBuffer b;

    me(int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        this.b = byteBufferAllocate;
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        this.f1285a = new mg(this.b);
    }

    public final me a() {
        this.f1285a.a(this.b);
        return this;
    }
}
