package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class rdp {

    @SerializedName("detailPng")
    private String b;

    @SerializedName("backPng")
    private String d;

    @SerializedName("listPng")
    private String e;

    public String a() {
        return this.b;
    }

    public String e() {
        return this.e;
    }

    public String toString() {
        return "PictureDaoBean{detailPng='" + this.b + "', backPng='" + this.d + "', listPng='" + this.e + "'}";
    }
}
