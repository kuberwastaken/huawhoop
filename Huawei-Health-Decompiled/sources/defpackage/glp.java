package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class glp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("baseConfig")
    private gls f13520a;

    @SerializedName("sportConfigs")
    private List<gls> b;

    @SerializedName("version")
    private String c;

    @SerializedName("template_id")
    private String e;

    public String d() {
        return this.c;
    }

    public gls c() {
        return this.f13520a;
    }

    public List<gls> b() {
        return this.b;
    }
}
