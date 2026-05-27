package com.huawei.hms.ads;

/* JADX INFO: loaded from: classes5.dex */
public class VideoConfiguration {
    int autoPlayNetwork;
    boolean isMute;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4471a = 0;
        boolean b = true;

        private boolean a(int i) {
            return (i == 2 || i == 0 || i == 1) ? false : true;
        }

        public Builder setMute(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setAutoPlayNetwork(int i) {
            if (a(i)) {
                this.f4471a = -1;
                return this;
            }
            this.f4471a = i;
            return this;
        }

        public VideoConfiguration build() {
            return new VideoConfiguration(this);
        }
    }

    public boolean isMute() {
        return this.isMute;
    }

    public int getAutoPlayNetwork() {
        return this.autoPlayNetwork;
    }

    public VideoConfiguration(Builder builder) {
        this.autoPlayNetwork = 0;
        this.isMute = true;
        this.autoPlayNetwork = builder.f4471a;
        this.isMute = builder.b;
    }

    public VideoConfiguration() {
        this.autoPlayNetwork = 0;
        this.isMute = true;
    }
}
