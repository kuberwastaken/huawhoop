package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class nyv {

    @SerializedName("mContent")
    private String d;

    @SerializedName("mTitle")
    private String e;

    public nyv(String str, String str2) {
        this.e = str;
        this.d = str2;
    }

    public String b() {
        return this.e;
    }

    public String d() {
        return this.d;
    }
}
