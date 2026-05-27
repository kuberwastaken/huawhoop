package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class dto {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("fat")
    private float f12418a;

    @SerializedName("extensionUnits")
    private List<dtr> b;

    @SerializedName("count")
    private int c;

    @SerializedName("carbohydrate")
    private float d;

    @SerializedName("foodId")
    private String e;

    @SerializedName("foodName")
    private String f;

    @SerializedName("protein")
    private float g;

    @SerializedName("kilocalorie")
    private int h;

    @SerializedName("imageUrl")
    private String i;

    @SerializedName("gi")
    private float j;

    @SerializedName("unit")
    private String l;

    public String e() {
        return this.e;
    }

    public String j() {
        return this.l;
    }

    public int c() {
        return this.c;
    }

    public float d() {
        return this.d;
    }

    public float i() {
        return this.g;
    }

    public float a() {
        return this.f12418a;
    }

    public List<dtr> b() {
        return this.b;
    }

    public String toString() {
        return "Food{mFoodId=" + this.e + ", mFoodName=" + this.f + ", mImageUrl=" + this.i + ", mUnit=" + this.l + ", mCount=" + this.c + ", mKilocalorie=" + this.h + ", mCarbohydrate=" + this.d + ", mProtein=" + this.g + ", mFat=" + this.f12418a + ", mGi=" + this.j + ", mExtensionUnits=" + this.b + '}';
    }
}
