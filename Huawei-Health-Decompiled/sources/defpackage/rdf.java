package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class rdf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("topicBackImgUrl")
    private String f17298a;

    @SerializedName("topicId")
    private int b;

    @SerializedName("playTime")
    private long c;

    @SerializedName("playedCount")
    private int d;

    @SerializedName("topicName")
    private String e;

    @SerializedName("workoutCount")
    private int f;

    public String toString() {
        return "AudioTopicBehavior{topicId=" + this.b + ", topicName='" + this.e + "', topicBackImgUrl='" + this.f17298a + "', playTime=" + this.c + ", workoutCount=" + this.f + ", playedCount=" + this.d + '}';
    }
}
