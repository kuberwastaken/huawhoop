package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class bow implements Comparable<bow> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("startTime")
    private int f437a;

    @SerializedName("endTime")
    private int b;

    @SerializedName("id")
    private int c;

    @SerializedName("timestamp")
    private long e;

    public String toString() {
        return "HealthModelChallengeRecord{mStartTime=" + this.f437a + ", mEndTime=" + this.b + ", mId=" + this.c + ", mTimeStamp=" + this.e + '}';
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(bow bowVar) {
        return this.b - bowVar.b;
    }
}
