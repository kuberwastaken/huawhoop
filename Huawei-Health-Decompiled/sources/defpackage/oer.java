package defpackage;

import com.huawei.pluginmgr.filedownload.PullHealthBiListener;
import com.huawei.pluginmgr.filedownload.PullListener;

/* JADX INFO: loaded from: classes.dex */
public class oer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PullHealthBiListener f16327a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private String h;
    private PullListener i;
    private boolean j;
    private String k;
    private int l;
    private int m;
    private String n;
    private String o;

    public String a() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String b() {
        return this.e;
    }

    public void a(String str) {
        this.e = str;
    }

    public int h() {
        return this.m;
    }

    public void d(int i) {
        this.m = i;
    }

    public String f() {
        return this.f;
    }

    public void j(String str) {
        this.f = str;
    }

    public int o() {
        return this.l;
    }

    public void a(int i) {
        this.l = i;
    }

    public void e(PullListener pullListener) {
        this.i = pullListener;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public boolean d() {
        return this.g;
    }

    public void c(boolean z) {
        this.j = z;
    }

    public boolean g() {
        return this.j;
    }

    public void g(String str) {
        this.k = str;
    }

    public String l() {
        return this.k;
    }

    public String k() {
        return this.n;
    }

    public void h(String str) {
        this.n = str;
    }

    public String c() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public String j() {
        return this.h;
    }

    public void d(String str) {
        this.h = str;
    }

    public String e() {
        return this.b;
    }

    public void e(String str) {
        this.b = str;
    }

    public String i() {
        return this.o;
    }

    public void i(String str) {
        this.o = str;
    }

    protected void b(oeu oeuVar) {
        int i;
        PullListener pullListener = this.i;
        if (pullListener != null) {
            pullListener.onPullingChange(this, oeuVar);
        }
        if (oeuVar == null || (i = oeuVar.i()) == 0 || i == -8) {
            return;
        }
        oet.c().e(this);
    }

    public void e(PullHealthBiListener pullHealthBiListener) {
        this.f16327a = pullHealthBiListener;
    }

    protected void b(int i, String str) {
        PullHealthBiListener pullHealthBiListener = this.f16327a;
        if (pullHealthBiListener != null) {
            pullHealthBiListener.onPullHealthBiCalling(i, str, this);
        }
    }
}
