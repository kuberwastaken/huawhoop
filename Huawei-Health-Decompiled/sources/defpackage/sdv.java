package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class sdv extends sea {

    @SerializedName("newAdd")
    private int b;

    public int a() {
        return this.b;
    }

    @Override // defpackage.sea
    public String toString() {
        return "ThreeCircleNewPointsResponse{resultCode=" + e() + ", resultDesc=" + d() + ", newAdd=" + this.b + '}';
    }
}
