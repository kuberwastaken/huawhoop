package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.ble.BleConstants;

/* JADX INFO: loaded from: classes10.dex */
public class iat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(BleConstants.SPORT_TYPE)
    private int f14031a;

    @SerializedName("simpleContent")
    private String b;

    @SerializedName("contentPath")
    private String d;

    public int a() {
        return this.f14031a;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.b;
    }

    public String toString() {
        return "DivingModel{contentPath='" + this.d + "', sportType=" + this.f14031a + ", simpleContent='" + this.b + "'}";
    }
}
