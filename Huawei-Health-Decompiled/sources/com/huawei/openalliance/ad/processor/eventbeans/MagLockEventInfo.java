package com.huawei.openalliance.ad.processor.eventbeans;

/* JADX INFO: loaded from: classes11.dex */
public class MagLockEventInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f7709a;
    private String b;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f7710a;
        private String b;

        public Builder setPosition(String str) {
            this.b = str;
            return this;
        }

        public Builder setFailReason(Integer num) {
            this.f7710a = num;
            return this;
        }

        public MagLockEventInfo build() {
            return new MagLockEventInfo(this);
        }
    }

    public String b() {
        return this.b;
    }

    public Integer a() {
        return this.f7709a;
    }

    private MagLockEventInfo(Builder builder) {
        this.f7709a = builder.f7710a;
        this.b = builder.b;
    }
}
