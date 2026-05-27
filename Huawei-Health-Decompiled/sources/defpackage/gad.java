package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class gad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("commonUse")
    private String f13356a = "FAMILY_SPACE";

    @SerializedName("operation")
    private String b;

    @SerializedName("devId")
    private String d;

    @SerializedName("pushUdid")
    private String e;

    public gad() {
    }

    public gad(String str, String str2, String str3) {
        this.d = str;
        this.b = str2;
        this.e = str3;
    }

    public String toString() {
        return "{devId=" + this.d + ", commonUse=" + this.f13356a + ", operation=" + this.b + ", pushUdid=" + this.e + '}';
    }
}
