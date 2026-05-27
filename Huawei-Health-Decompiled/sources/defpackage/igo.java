package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.ble.BleConstants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class igo implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("distanceType")
    private int f14105a;

    @SerializedName("sortType")
    private int b;

    @SerializedName("pathClass")
    private int c;

    @SerializedName("pathType")
    private int d;
    private fnj e;

    @SerializedName(BleConstants.SPORT_TYPE)
    private int g;

    @SerializedName("themeType")
    private int h;

    public igo() {
        this.g = 258;
        this.b = 1;
        this.d = 0;
        this.f14105a = 0;
        this.h = 0;
        this.c = 0;
    }

    public igo(int i) {
        this.g = 258;
        this.b = 1;
        this.d = 0;
        this.f14105a = 0;
        this.h = 0;
        this.c = i;
    }

    public int e() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public int b() {
        return this.f14105a;
    }

    public fnj c() {
        return this.e;
    }

    public void b(fnj fnjVar) {
        this.e = fnjVar;
    }

    public void d(int i) {
        this.b = i;
    }

    public void c(int i) {
        this.d = i;
    }

    public void b(int i) {
        this.f14105a = i;
    }

    public int g() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }

    public int a() {
        return this.c;
    }

    public void e(int i) {
        this.c = i;
    }

    public boolean i() {
        return this.f14105a == 0 && this.d == 0;
    }

    public int h() {
        return this.g;
    }
}
