package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class ssv implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("deviceName")
    private String f17822a;

    @SerializedName("deviceUniqueCode")
    private String b;
    private Object c;

    @SerializedName("productId")
    private String d;

    @SerializedName("deviceModel")
    private String e;

    @SerializedName("type")
    private int h;

    public Object a() {
        return this.c;
    }

    public void b(Object obj) {
        this.c = obj;
    }

    public int d() {
        return this.h;
    }

    public void e(int i) {
        this.h = i;
    }

    public void d(String str) {
        this.d = str;
    }

    public String e() {
        return this.f17822a;
    }

    public void c(String str) {
        this.f17822a = str;
    }

    public String c() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String toString() {
        return "DataOriginListItem{mType=" + this.h + ", mProductId='" + this.d + "', mDeviceName='" + this.f17822a + "', mDeviceModel='" + this.e + "', mDeviceUniqueCode='" + this.b + "', mExtraInfo=" + this.c + '}';
    }
}
