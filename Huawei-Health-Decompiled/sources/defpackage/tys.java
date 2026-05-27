package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class tys {

    @SerializedName("memberHuid")
    private String b;

    @SerializedName("messageType")
    private String d;

    public String e() {
        return this.b;
    }

    public String d() {
        return this.d;
    }

    public String toString() {
        return "PendingMessageInfo{memberHuid='" + this.b + "', messageType='" + this.d + "'}";
    }
}
