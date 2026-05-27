package defpackage;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes7.dex */
public class rds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("headPhoto")
    private String f17306a;

    @SerializedName("lectureId")
    private String b;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String c;

    @SerializedName("name")
    private String d;

    @SerializedName("label")
    private String e;

    @SerializedName("qualification")
    private String i;

    public String d() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public String toString() {
        return "LecturerDaoBean{lectureId='" + this.b + "', name='" + this.d + "', headPhoto='" + this.f17306a + "', label='" + this.e + "', desc='" + this.c + "', qualification='" + this.i + "'}";
    }
}
