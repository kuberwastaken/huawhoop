package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.ble.BleConstants;

/* JADX INFO: loaded from: classes10.dex */
public class cve {

    @SerializedName("audioBeginTime")
    long b;

    @SerializedName("isNonsense")
    boolean d;

    @SerializedName(BleConstants.KEY_PATH)
    String e;

    public String b() {
        return this.e;
    }

    public boolean e() {
        return this.d;
    }

    public long d() {
        return this.b;
    }

    public String toString() {
        return "SleepMonitorShare{path='" + this.e + "', isNonsense=" + this.d + ", audioBeginTime=" + this.b + '}';
    }
}
