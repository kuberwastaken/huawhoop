package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ggw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("questionnaire")
    private List<ggt> f13451a;

    @SerializedName("identifier")
    private int b;

    @SerializedName("sleep_info")
    private List<ggx> c;

    @SerializedName("user_info")
    private ghc d;

    public void d(int i) {
        this.b = i;
    }

    public void e(List<ggx> list) {
        this.c = list;
    }

    public void d(ghc ghcVar) {
        this.d = ghcVar;
    }

    public void d(List<ggt> list) {
        this.f13451a = list;
    }
}
