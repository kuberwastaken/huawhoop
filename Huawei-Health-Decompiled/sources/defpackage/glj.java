package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class glj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("language")
    private String f13515a;

    @SerializedName("moduleName")
    private String b;

    @SerializedName("timbre")
    private String d;

    @SerializedName("version")
    private List<Integer> e;

    public void b(List<Integer> list) {
        this.e = list;
    }

    public void d(String str) {
        this.f13515a = str;
    }
}
