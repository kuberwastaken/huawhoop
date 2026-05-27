package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class bot {

    @SerializedName("resultCode")
    private int b;

    @SerializedName("currentVersion")
    private long c;

    public int a() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public String toString() {
        return "HealthModelBaseResponse{mResultCode=" + this.b + ", currentVersion=" + this.c + "}";
    }
}
