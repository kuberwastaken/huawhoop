package com.amap.api.col.p0003sl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class ll extends lr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ByteArrayOutputStream f1218a;

    public ll() {
        this.f1218a = new ByteArrayOutputStream();
    }

    public ll(lr lrVar) {
        super(lrVar);
        this.f1218a = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.p0003sl.lr
    protected final byte[] a(byte[] bArr) {
        byte[] byteArray = this.f1218a.toByteArray();
        try {
            this.f1218a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f1218a = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.p0003sl.lr
    public final void b(byte[] bArr) {
        try {
            this.f1218a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
