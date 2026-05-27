package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class bpb extends box {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("startTime")
    private long f441a;

    @SerializedName("endTime")
    private long b;

    @SerializedName("version")
    private long e;

    @Override // defpackage.box, com.huawei.networkclient.IRequest
    public String getUrl() {
        return null;
    }

    public void e(long j) {
        this.e = j;
    }

    public void b(long j) {
        this.f441a = j;
    }

    public void c(long j) {
        this.b = j;
    }
}
