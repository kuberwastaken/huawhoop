package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class rdw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("resultCode")
    private String f17308a;

    @SerializedName("totalCount")
    private int b;

    @SerializedName("resultDesc")
    private String d;

    @SerializedName("duration")
    private long e;

    public String d() {
        return this.f17308a;
    }

    public String c() {
        return this.d;
    }

    public long e() {
        return this.e;
    }

    public String toString() {
        return "UserAccumulatedPlayDurationRsp{resultCode='" + this.f17308a + "', resultDesc='" + this.d + "', duration='" + this.e + "', totalCount='" + this.b + "'}";
    }
}
