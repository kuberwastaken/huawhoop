package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class bpf extends bot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("cfgVersion")
    private int f443a;

    @SerializedName("joinTime")
    private int b;

    @SerializedName("challengeStatus")
    private int c;

    @SerializedName("cfgUpgradeTime")
    private int d;

    @SerializedName("joinStatus")
    private int e;

    @SerializedName("kakaMakeup")
    private int f;

    public void d(int i) {
        this.d = i;
    }

    public void b(int i) {
        this.c = i;
    }

    public void a(int i) {
        this.e = i;
    }

    public void c(int i) {
        this.b = i;
    }

    public int b() {
        return this.d;
    }

    public int e() {
        return this.c;
    }

    public int d() {
        return this.b;
    }

    @Override // defpackage.bot
    public String toString() {
        return "HealthModelSyncResponse{cfgUpgradeTime=" + this.d + ", cfgVersion=" + this.f443a + ", challengeStatus=" + this.c + ", joinStatus=" + this.e + ", joinTime=" + this.b + ", kakaMakeup=" + this.f + "}";
    }
}
