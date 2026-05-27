package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class eqg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("detailComment")
    private String f12731a;

    @SerializedName("dimensionComments")
    private Map<String, String> b;

    @SerializedName("doctorInfo")
    private String c;

    @SerializedName("summaryComment")
    private String e;

    public String b() {
        return this.e;
    }

    public String toString() {
        return "CommentInfo{mDoctorInfo=" + this.c + ", mSummaryComment=" + this.e + ", mDetailComment=" + this.f12731a + ", mDimensionComments=" + this.b + "}";
    }
}
