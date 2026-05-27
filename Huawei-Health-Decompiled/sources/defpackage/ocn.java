package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.ad.constant.JsbMapKeyNames;

/* JADX INFO: loaded from: classes7.dex */
public class ocn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(JsbMapKeyNames.H5_LOC_LAT)
    private Double f16288a;

    @SerializedName("coordinate")
    private String b;

    @SerializedName("altitude")
    private Double c;

    @SerializedName("clientTime")
    private Long d;

    @SerializedName(JsbMapKeyNames.H5_LOC_LON)
    private Double e;

    @SerializedName("serverTime")
    private Long f;

    @SerializedName("type")
    private int i;

    public String d() {
        return this.b;
    }

    public void d(String str) {
        this.b = str;
    }

    public Double c() {
        return this.e;
    }

    public void c(Double d) {
        this.e = d;
    }

    public Double a() {
        return this.f16288a;
    }

    public void d(Double d) {
        this.f16288a = d;
    }

    public Double b() {
        return this.c;
    }

    public void a(Double d) {
        this.c = d;
    }

    public Long e() {
        return this.d;
    }

    public void c(Long l) {
        this.d = l;
    }

    public int h() {
        return this.i;
    }

    public void e(int i) {
        this.i = i;
    }
}
