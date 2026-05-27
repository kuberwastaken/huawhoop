package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.trackprocess.model.GpsPoint;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fnm implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("punchNum")
    private int f13041a;

    @SerializedName("drawBoard")
    private fnp b;

    @SerializedName("rotationAngle")
    private double c;

    @SerializedName("cpRelations")
    private List<fnn> d;

    @SerializedName("cpGps")
    private List<GpsPoint> e;

    public List<GpsPoint> b() {
        return this.e;
    }

    public List<fnn> d() {
        return this.d;
    }

    public int c() {
        return this.f13041a;
    }

    public fnp e() {
        return this.b;
    }

    public String toString() {
        return "CpPoint{cpGps='" + this.e + ", cpRelations=" + this.d + ", rotationAngle=" + this.c + ", drawBoard=" + this.b + ", punchNum=" + this.f13041a + '}';
    }
}
