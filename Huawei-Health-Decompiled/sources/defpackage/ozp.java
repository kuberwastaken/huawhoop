package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ozp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("data")
    private ozm f16576a;

    @SerializedName("cardId")
    private int b;

    @SerializedName("domains")
    private List<String> c = new ArrayList();

    @SerializedName("cardType")
    private String d;

    @SerializedName("cardErrorCode")
    private int e;

    @SerializedName("timeScope")
    private String f;

    @SerializedName("featureName")
    private String h;

    @SerializedName("generationTime")
    private long i;

    public int a() {
        return this.b;
    }

    public String c() {
        return this.f;
    }

    public String e() {
        return this.d;
    }

    public ozm b() {
        return this.f16576a;
    }

    public String toString() {
        return "DomainCard{mCardErrorCode=" + this.e + ", mCardId=" + this.b + ", mGenerationTime=" + this.i + ", mFeatureName=" + this.h + ", mTimeScope=" + this.f + ", mCardType=" + this.d + ", mDomainsList=" + this.c + ", mData=" + this.f16576a + '}';
    }
}
