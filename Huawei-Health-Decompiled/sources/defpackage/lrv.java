package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

/* JADX INFO: loaded from: classes9.dex */
public class lrv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("photoHeight")
    private int f15421a;

    @SerializedName("compressionAlgorithm")
    private int b;

    @SerializedName("bezierCurvePoint")
    private d c;

    @SerializedName("cutout")
    private int d;
    private final int e = 1;

    @SerializedName("radius")
    private float[] f;

    @SerializedName("startPointY")
    private int g;

    @SerializedName("startPointX")
    private int h;

    @SerializedName("roundedCutType")
    private int i;

    @SerializedName("photoWidth")
    private int j;

    @SerializedName("watchType")
    private int o;

    public int e() {
        return 1;
    }

    public int c() {
        return this.b;
    }

    public int i() {
        return this.h;
    }

    public int h() {
        return this.g;
    }

    public int g() {
        return this.j - (e() * 2);
    }

    public int d() {
        return this.f15421a - (e() * 2);
    }

    public float[] j() {
        return this.f;
    }

    public int l() {
        return this.o;
    }

    public int b() {
        return this.d;
    }

    public d a() {
        return this.c;
    }

    public int f() {
        return this.i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ImageProcessParameters{compressionAlgorithm=");
        sb.append(this.b);
        sb.append(", startPointX=");
        sb.append(this.h);
        sb.append(", startPointY=");
        sb.append(this.g);
        sb.append(", photoWidth=");
        sb.append(this.j);
        sb.append(", photoHeight=");
        sb.append(this.f15421a);
        sb.append(", radian=");
        float[] fArr = this.f;
        sb.append(fArr != null ? Arrays.toString(fArr) : "[]");
        sb.append(", watchType=");
        sb.append(this.o);
        sb.append(", cutout=");
        sb.append(this.d);
        sb.append(", roundedCutType=");
        sb.append(this.i);
        sb.append('}');
        return sb.toString();
    }

    public static class d {

        @SerializedName("inPoint")
        private float[][] c;

        @SerializedName("outPoint")
        private float[][] e;

        public float[][] e() {
            return this.c;
        }

        public float[][] d() {
            return this.e;
        }
    }
}
