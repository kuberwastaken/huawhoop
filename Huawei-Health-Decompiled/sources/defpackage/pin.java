package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class pin {

    @SerializedName("cityCenterLatLng")
    pip c;

    @SerializedName("detailAddress")
    String d;

    @SerializedName("cityName")
    String e;

    public String e() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public String a() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public pip d() {
        return this.c;
    }

    public void b(pip pipVar) {
        this.c = pipVar;
    }
}
