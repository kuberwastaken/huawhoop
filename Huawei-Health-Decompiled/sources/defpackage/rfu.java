package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class rfu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("cacheTime")
    protected long f17327a;

    public long b() {
        return this.f17327a;
    }

    public void c(long j) {
        this.f17327a = j;
    }

    public boolean d() {
        return this.f17327a != 0;
    }
}
