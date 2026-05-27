package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class knn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("passedScopes")
    private String f14773a;

    @SerializedName("latestAuditStatus")
    private int c;

    @SerializedName("betaScopes")
    private String e;

    public String toString() {
        return "AppAuditInfo{latestAuditStatus=" + this.c + ", passedScopes='" + this.f14773a + "', betaScopes='" + this.e + "'}";
    }
}
