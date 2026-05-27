package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class olo implements Serializable {
    private static final long serialVersionUID = 5896619171447527539L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("model")
    private List<String> f16433a;

    @SerializedName("version")
    private String c;

    @SerializedName("supportArV2")
    private int d;

    public String b() {
        return this.c;
    }

    public List<String> e() {
        return this.f16433a;
    }

    public void d(int i) {
        this.d = i;
    }
}
