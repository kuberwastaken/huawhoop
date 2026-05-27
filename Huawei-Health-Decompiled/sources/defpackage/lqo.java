package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class lqo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("rawContactUid")
    private String f15405a;

    @SerializedName("rawContactFeature")
    private String b;

    @SerializedName("rawContactId")
    private int c;

    @SerializedName("sortLetter")
    private String d;

    public lqo(int i, String str, String str2, String str3) {
        this.c = i;
        this.f15405a = str;
        this.b = str2;
        this.d = str3;
    }

    public String e() {
        return this.f15405a;
    }

    public String b() {
        return this.b;
    }

    public int a() {
        return this.c;
    }

    public String toString() {
        return "SimpleContactBean{rawContactId=" + this.c + ", rawContactUid='" + this.f15405a + "', rawContactFeature='" + this.b + "'}";
    }

    public String c() {
        return this.d;
    }
}
