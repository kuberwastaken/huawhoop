package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class tyq {

    @SerializedName("memberHuid")
    private String b;

    @SerializedName("postId")
    private String e;

    public String e() {
        return this.e;
    }

    public String toString() {
        return "MemberPostId{mMemberHuid='" + this.b + "', mPostId='" + this.e + "'}";
    }
}
