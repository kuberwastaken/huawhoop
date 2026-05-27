package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class gie implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mNeedMirror")
    private boolean f13469a;

    @SerializedName("mSelectIcon")
    private int b;

    @SerializedName("mName")
    private String c;

    @SerializedName("mNameAndUnit")
    private String d;

    @SerializedName("mDetailItemType")
    private String e;

    @SerializedName("mUnit")
    private String i;

    @SerializedName("mValue")
    private String j;

    public gie() {
    }

    public gie(String str, String str2, String str3, String str4, String str5) {
        this.e = str;
        this.c = str2;
        this.j = str3;
        this.i = str4;
        this.d = str5;
        this.f13469a = false;
    }

    public String d() {
        return this.e;
    }

    public void d(String str) {
        this.e = str;
    }

    public String b() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public String i() {
        return this.j;
    }

    public void c(String str) {
        this.j = str;
    }

    public String c() {
        return this.i;
    }

    public void b(String str) {
        this.i = str;
    }

    public String a() {
        return this.d;
    }

    public void e(String str) {
        this.d = str;
    }

    public int e() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }

    public boolean j() {
        return this.f13469a;
    }

    public void c(boolean z) {
        this.f13469a = z;
    }

    public String toString() {
        return "SportsShareDetailBean{mDetailItemType='" + this.e + "', mName='" + this.c + "', mValue=" + this.j + ", mUnit=" + this.i + ", mNameAndUnit=" + this.d + ", mSelectIcon=" + this.b + ", mNeedMirror=" + this.f13469a + '}';
    }
}
