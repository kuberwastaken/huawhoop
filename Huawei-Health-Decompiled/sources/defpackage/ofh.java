package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class ofh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("functionList")
    private List<ofe> f16338a;

    @SerializedName("resultDesc")
    private String c;

    @SerializedName("resultCode")
    private int e;

    public int c() {
        return this.e;
    }

    public List<ofe> e() {
        return this.f16338a;
    }

    public String toString() {
        return "FunctionEntranceResponse{mResultCode=" + this.e + ", mResultDesc=" + this.c + ", mFunctionList=" + this.f16338a + '}';
    }
}
