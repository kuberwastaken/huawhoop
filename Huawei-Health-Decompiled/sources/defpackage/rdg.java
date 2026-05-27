package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class rdg {

    @SerializedName("audioUrl")
    private String b;

    @SerializedName("audioDuration")
    private long c;

    @SerializedName("audioId")
    private String e;

    public String a() {
        return this.e;
    }

    public String b() {
        return this.b;
    }

    public long d() {
        return this.c;
    }

    public String toString() {
        return "AudioDaoBean{audioId='" + this.e + "', audioUrl='" + this.b + "', audioDuration=" + this.c + '}';
    }
}
