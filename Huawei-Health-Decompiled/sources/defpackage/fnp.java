package defpackage;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;
import com.huawei.health.trackprocess.model.GpsPoint;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class fnp implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("height")
    private double f13044a;

    @SerializedName(TtmlNode.CENTER)
    private GpsPoint b;

    @SerializedName("lu")
    private GpsPoint c;

    @SerializedName("ld")
    private GpsPoint d;

    @SerializedName("rd")
    private GpsPoint e;

    @SerializedName("rotationAngle")
    private double f;

    @SerializedName("width")
    private double h;

    @SerializedName("ru")
    private GpsPoint j;

    public double b() {
        return this.h;
    }

    public double e() {
        return this.f;
    }

    public GpsPoint c() {
        return this.b;
    }

    public String toString() {
        return "DrawBoard{width=" + this.h + ", height=" + this.f13044a + ", rotationAngle=" + this.f + ", center=" + this.b + ", leftUp=" + this.c + ", leftBottom=" + this.d + ", rightUp=" + this.j + ", rightBottom=" + this.e + '}';
    }
}
