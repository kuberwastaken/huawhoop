package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class ceo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("pairMode")
    private int f614a;

    @SerializedName("isUseSynergy")
    private boolean b;

    @SerializedName("isConnectNewPhone")
    private boolean c;

    @SerializedName("isCompatibleDevice")
    private boolean d;

    @SerializedName("identify")
    private String e;

    public String b() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public boolean d() {
        return this.d;
    }

    public void e(boolean z) {
        this.d = z;
    }

    public boolean e() {
        return this.c;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public int a() {
        return this.f614a;
    }

    public void b(int i) {
        this.f614a = i;
    }
}
