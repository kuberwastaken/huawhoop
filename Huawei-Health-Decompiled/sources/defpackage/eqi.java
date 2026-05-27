package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class eqi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("dataType")
    private String f12733a;

    @SerializedName("dataDetails")
    private List<String> c;

    @SerializedName("dimensionId")
    private String e;

    public String toString() {
        return "DimensionDetail{mDimensionId=" + this.e + ", mDataType=" + this.f12733a + ", mDataDetailList=" + this.c + "}";
    }
}
