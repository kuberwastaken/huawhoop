package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.network.embedded.k;

/* JADX INFO: loaded from: classes7.dex */
public class ofe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("functionName")
    private String f16337a;

    @SerializedName("functionId")
    private String c;

    @SerializedName(k.g)
    private int e;

    public String c() {
        return this.c;
    }

    public int b() {
        return this.e;
    }

    public String toString() {
        return "FunctionEntranceInfo{mFunctionId=" + this.c + ", mFunctionName=" + this.f16337a + ", mEnable=" + this.e + '}';
    }
}
