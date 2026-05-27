package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class cbs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("deviceType")
    public String f564a;

    @SerializedName("h5EntryDefaultImg")
    public String b;

    @SerializedName("bluetoothType")
    public String c;

    @SerializedName("name")
    public String d;

    @SerializedName("uuid")
    public String e;

    @SerializedName("versionInfo")
    public cbq g;

    @SerializedName("kindId")
    public String i;

    public void c(String str) {
        this.d = str;
    }

    public void b(String str) {
        this.e = str;
    }

    public void g(String str) {
        this.i = str;
    }

    public void e(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.f564a = str;
    }

    public void c(cbq cbqVar) {
        this.g = cbqVar;
    }

    public void a(String str) {
        this.b = str;
    }
}
