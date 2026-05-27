package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class dhc implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("updateLog")
    private String f12245a;

    @SerializedName("fileSize")
    private long b;

    @SerializedName("versionId")
    private String e;

    public void a(String str) {
        this.e = str;
    }

    public void c(long j) {
        this.b = j;
    }

    public void d(String str) {
        this.f12245a = str;
    }
}
