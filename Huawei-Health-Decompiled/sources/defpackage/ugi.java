package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class ugi extends pew {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("serviceId")
    private int f18297a;

    @SerializedName("labelDisplayName")
    private String b;

    @SerializedName("labelName")
    private String c;

    @SerializedName("userDisable")
    private int e;

    public ugi() {
    }

    public ugi(int i, String str, String str2, int i2) {
        this.f18297a = i;
        this.c = str;
        this.b = str2;
        this.e = i2;
    }

    public int i() {
        return this.f18297a;
    }

    public String j() {
        return this.c;
    }

    public String f() {
        return this.b;
    }

    public int l() {
        return this.e;
    }

    public void e(int i) {
        this.e = i;
    }

    @Override // defpackage.pew
    public String c() {
        return this.b;
    }
}
