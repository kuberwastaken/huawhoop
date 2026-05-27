package com.huawei.hms.network.embedded;

/* JADX INFO: loaded from: classes10.dex */
public class m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5562a;
    public int b = g2.n;
    public int c = g2.n;
    public boolean d;

    public String toString() {
        return "Host:" + this.f5562a + ", Port:" + this.b + ", AlternatePort:" + this.c + ", Enable:" + this.d;
    }

    public void setPort(int i) {
        this.b = i;
    }

    public void setHost(String str) {
        this.f5562a = str;
    }

    public void setEnableQuic(boolean z) {
        this.d = z;
    }

    public void setAlternatePort(int i) {
        this.c = i;
    }

    public int getPort() {
        return this.b;
    }

    public String getHost() {
        return this.f5562a;
    }

    public boolean getEnableQuic() {
        return this.d;
    }

    public int getAlternatePort() {
        return this.c;
    }
}
