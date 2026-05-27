package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mga implements Serializable {
    private static final long serialVersionUID = -5886031711168296004L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("heartRateEnd")
    private float f15616a;

    @SerializedName("heartRateHigh")
    private float b;

    @SerializedName("heartRateStart")
    private float c;

    @SerializedName("heartRateIndex")
    private int d;

    @SerializedName("heartRateLow")
    private float e;

    public mga(int i, float f, float f2, float f3, float f4) {
        this.d = i;
        this.c = f;
        this.b = f2;
        this.f15616a = f3;
        this.e = f4;
    }

    public float c() {
        return this.b;
    }

    public float b() {
        return this.e;
    }

    public float a() {
        return this.c;
    }

    public float e() {
        return this.f15616a;
    }

    public String toString() {
        return "tp=h_r_a;index=" + this.d + ";start=" + this.c + ";high=" + this.b + ";end=" + this.f15616a + ";low=" + this.e + ";" + System.lineSeparator();
    }
}
