package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class cxg {

    @SerializedName("systemTimeZone")
    private String c;

    @SerializedName("systemLanguage")
    private String d;

    public String a() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    public String e() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }
}
