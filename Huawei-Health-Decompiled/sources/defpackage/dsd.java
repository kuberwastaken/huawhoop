package defpackage;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class dsd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mDeviceIdentify")
    private String f12393a;

    @SerializedName("mEarPhoneClose")
    private int b;

    @SerializedName("mDeviceStatus")
    private int c = -1;

    @SerializedName("mEarphoneConnectState")
    private int d = 255;

    @SerializedName("mDeviceName")
    private String e;

    @SerializedName("mEarphoneIgnore")
    private int g;

    public String c() {
        return this.f12393a;
    }

    public void e(String str) {
        this.f12393a = str;
    }

    public String d() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public int e() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public int b() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public int f() {
        return this.g;
    }

    public void e(int i) {
        this.g = i;
    }

    public int a() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof dsd)) {
            return false;
        }
        dsd dsdVar = (dsd) obj;
        return TextUtils.equals(this.f12393a, dsdVar.f12393a) && TextUtils.equals(this.e, dsdVar.e);
    }

    public int hashCode() {
        return Objects.hash(this.f12393a, this.e);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EarPhoneInfo{mDeviceIdentify='");
        sb.append(this.f12393a.substring(r1.length() - 3));
        sb.append("', mDeviceName='");
        sb.append(this.e);
        sb.append("', mDeviceStatus=");
        sb.append(this.c);
        sb.append(", mEarPhoneClose=");
        sb.append(this.b);
        sb.append(", mEarphoneIgnore=");
        sb.append(this.g);
        sb.append(", mEarphoneConnectState=");
        sb.append(this.d);
        sb.append('}');
        return sb.toString();
    }
}
