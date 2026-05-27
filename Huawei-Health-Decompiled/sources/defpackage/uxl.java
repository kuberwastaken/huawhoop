package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class uxl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("activityId")
    private final String f18504a;

    @SerializedName("level")
    private final int b;

    @SerializedName("joinStatus")
    private final int d;

    @SerializedName("joinTime")
    private final long e;

    public String b() {
        return this.f18504a;
    }

    public int e() {
        return this.d;
    }

    public String toString() {
        return "UserActivityInfo{activityId='" + this.f18504a + "', level=" + this.b + ", joinStatus=" + this.d + ", joinTime=" + this.e + '}';
    }
}
