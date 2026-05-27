package defpackage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class dhe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("icon")
    private String f12247a;

    @Expose(serialize = false)
    private long b;

    @SerializedName("content")
    private String c;

    @SerializedName("iconDark")
    private String d;

    @Expose(serialize = false)
    private boolean e;

    @Expose(serialize = false)
    private int f;

    @Expose(serialize = false)
    private long g;

    @SerializedName("routerUrl")
    private String h;

    @SerializedName("title")
    private String i;

    @Expose(serialize = false)
    private String j;

    public String e() {
        return this.i;
    }

    public void j(String str) {
        this.i = str;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.f12247a = str;
    }

    public void e(String str) {
        this.h = str;
    }

    public String b() {
        return this.j;
    }

    public void d(String str) {
        this.j = str;
    }

    public boolean h() {
        return this.e;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public int c() {
        return this.f;
    }

    public void b(int i) {
        this.f = i;
    }

    public long d() {
        return this.g;
    }

    public void a(long j) {
        this.g = j;
    }

    public long a() {
        return this.b;
    }

    public void e(long j) {
        this.b = j;
    }

    public void a(String str) {
        this.d = str;
    }
}
