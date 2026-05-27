package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class rdu {

    @SerializedName("topicBackImgUrl")
    private String b;

    @SerializedName("totalPalyCount")
    private long c;

    @SerializedName("name")
    private String d;

    public String toString() {
        return "RecommendMoreTopic{name='" + this.d + "', topicBackImgUrl='" + this.b + "', totalPalyCount=" + this.c + '}';
    }
}
