package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class mwg {

    @SerializedName("startTime")
    private String c;

    @SerializedName("runDuration")
    private long d;

    public void a(String str) {
        this.c = str;
    }

    public void b(long j) {
        this.d = j;
    }

    public String toString() {
        return "AliveInfo{mStartTime=" + this.c + ", mRunDuration=" + this.d + '}';
    }
}
