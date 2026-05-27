package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class sea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("resultCode")
    private int f17675a;

    @SerializedName("resultDesc")
    private String d;

    public int e() {
        return this.f17675a;
    }

    public String d() {
        return this.d;
    }

    public String toString() {
        return "ThreeCircleTaskBaseResponse{resultCode=" + this.f17675a + ", resultDesc=" + this.d + '}';
    }
}
