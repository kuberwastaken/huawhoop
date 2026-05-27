package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fqo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("title")
    private String f13097a;

    @SerializedName("guideText")
    private String b;

    @SerializedName("buttons")
    private List<fqj> c;

    @SerializedName("showLock")
    private boolean e;

    public String a() {
        return this.b;
    }

    public List<fqj> e() {
        return this.c;
    }
}
