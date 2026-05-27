package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class eqd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("commentTime")
    private String f12728a;

    @SerializedName("commentInfo")
    private String e;

    public String e() {
        return this.f12728a;
    }

    public String toString() {
        return "CommentInfoMap{mCommentTime=" + this.f12728a + ", mCommentInfo=" + this.e + "}";
    }
}
