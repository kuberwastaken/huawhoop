package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes5.dex */
public class kxf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("switchStatus")
    private String[] f14979a;

    @SerializedName("modifiedTime")
    private String b;

    @SerializedName("modifyClient")
    private String d;

    public void d(String str) {
        this.d = str;
    }

    public String a() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String[] b() {
        return this.f14979a;
    }

    public void a(String[] strArr) {
        this.f14979a = strArr;
    }
}
