package com.huawei.hms.ads.jsb;

/* JADX INFO: loaded from: classes5.dex */
public class JsbConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4514a;
    private String b;
    private String c;
    private boolean d;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f4515a = true;
        private String b;
        private String c;
        private boolean d;

        public final Builder initGrs(String str, String str2) {
            this.b = str;
            this.c = str2;
            return this;
        }

        public final Builder initGrs(String str) {
            this.b = str;
            return this;
        }

        public final Builder enableUserInfo(boolean z) {
            this.f4515a = z;
            return this;
        }

        public final Builder enableLog(boolean z) {
            this.d = z;
            return this;
        }

        public final JsbConfig build() {
            return new JsbConfig(this);
        }
    }

    public boolean d() {
        return this.d;
    }

    public String c() {
        return this.c;
    }

    public String b() {
        return this.b;
    }

    public boolean a() {
        return this.f4514a;
    }

    private JsbConfig(Builder builder) {
        this.f4514a = true;
        this.f4514a = builder.f4515a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
    }
}
