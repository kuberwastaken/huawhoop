package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class foq implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("timeZone")
    private String f13063a;

    @SerializedName("motionPathStartTime")
    private long b;

    @SerializedName("huid")
    private String c;

    @SerializedName("minTime")
    private long d;

    @SerializedName("num")
    private int e;

    public long d() {
        return this.d;
    }

    public int a() {
        return this.e;
    }

    public String e() {
        return this.c;
    }

    public String toString() {
        return "ParticipateUserInfo{timeZone='" + this.f13063a + "', motionPathStartTime=" + this.b + ", minTime=" + this.d + ", num=" + this.e + ", huid=" + this.c + '}';
    }
}
