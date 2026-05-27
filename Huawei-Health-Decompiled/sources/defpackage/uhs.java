package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes11.dex */
public class uhs implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("count")
    private int f18304a;

    @SerializedName("timemills")
    private long e;

    public uhs(int i, long j) {
        this.f18304a = i;
        this.e = j;
    }

    public int b() {
        return this.f18304a;
    }

    public void a(int i) {
        this.f18304a = i;
    }

    public long d() {
        return this.e;
    }

    public void a(long j) {
        this.e = j;
    }
}
