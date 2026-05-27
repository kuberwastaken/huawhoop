package com.huawei.hms.framework.network.cache;

/* JADX INFO: loaded from: classes5.dex */
public final class Cache {
    private final String directory;
    private final long maxSize;

    public Cache(String str, long j) {
        this.directory = str;
        this.maxSize = j;
    }

    public String getDirectory() {
        return this.directory;
    }

    public long getMaxSize() {
        return this.maxSize;
    }
}
