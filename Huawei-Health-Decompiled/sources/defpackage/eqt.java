package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class eqt {

    @SerializedName("dataDetails")
    private List<String> b;

    @SerializedName("dataType")
    private String e;

    public String toString() {
        return "MainTargetSubDataDetail{mDataType=" + this.e + ", mDataDetailsList=" + this.b + "}";
    }
}
