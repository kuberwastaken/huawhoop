package com.huawei.hms.network.base.common.trans;

import com.huawei.hms.framework.common.StringUtils;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class CounterOutputStream extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f5321a = new AtomicLong(0);

    @Override // java.io.OutputStream
    public void write(@Nonnull byte[] bArr, int i, int i2) {
        this.f5321a.addAndGet(i2);
    }

    @Override // java.io.OutputStream
    public void write(@Nonnull byte[] bArr) {
        this.f5321a.addAndGet(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f5321a.addAndGet(StringUtils.getBytes(String.valueOf(i)).length);
    }

    public long getLenth() {
        return this.f5321a.get();
    }
}
