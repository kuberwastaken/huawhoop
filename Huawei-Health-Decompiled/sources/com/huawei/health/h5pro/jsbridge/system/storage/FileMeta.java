package com.huawei.health.h5pro.jsbridge.system.storage;

/* JADX INFO: loaded from: classes4.dex */
public class FileMeta {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2476a;
    public String b;
    public String c;
    public boolean d;
    public String e;
    public long h;
    public String i;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2477a;
        public String b;
        public String c;
        public String d;
        public boolean e = true;
        public long f;
        public String h;

        public Builder size(long j) {
            this.f = j;
            return this;
        }

        public Builder path(String str) {
            this.h = str;
            return this;
        }

        public Builder noExist() {
            this.e = false;
            return this;
        }

        public Builder name(String str) {
            this.b = str;
            return this;
        }

        public Builder mimeType(String str) {
            this.c = str;
            return this;
        }

        public Builder dateAdded(long j) {
            this.f2477a = j;
            return this;
        }

        public FileMeta build() {
            return new FileMeta(this);
        }

        public Builder absolutePath(String str) {
            this.d = str;
            return this;
        }
    }

    public boolean isExist() {
        return this.d;
    }

    public long getSize() {
        return this.h;
    }

    public String getPath() {
        return this.i;
    }

    public String getName() {
        return this.c;
    }

    public String getMimeType() {
        return this.e;
    }

    public long getDateAdded() {
        return this.f2476a;
    }

    public String getAbsolutePath() {
        return this.b;
    }

    public FileMeta(Builder builder) {
        this.i = builder.h;
        this.c = builder.b;
        this.b = builder.d;
        this.h = builder.f;
        this.e = builder.c;
        this.f2476a = builder.f2477a;
        this.d = builder.e;
    }
}
