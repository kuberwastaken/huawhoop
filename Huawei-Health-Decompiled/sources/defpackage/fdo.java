package defpackage;

import android.text.SpannableString;

/* JADX INFO: loaded from: classes4.dex */
public class fdo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12915a;
    private int b;
    private SpannableString c;
    private String d;
    private String e;
    private int h;
    private boolean i;
    private int j;

    public int h() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }

    public SpannableString ajs_() {
        return this.c;
    }

    public void ajt_(SpannableString spannableString) {
        this.c = spannableString;
    }

    public int d() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }

    public void e(int i) {
        this.j = i;
    }

    public String b() {
        return this.d;
    }

    public void a(String str) {
        this.d = str;
    }

    public int a() {
        return this.f12915a;
    }

    public void c(int i) {
        this.f12915a = i;
    }

    public String c() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public boolean j() {
        return this.i;
    }

    public void b(boolean z) {
        this.i = z;
    }

    public String toString() {
        return "SectionActiveTrendBean{mType=" + this.h + ", mComparedPrompt='" + ((Object) this.c) + "', mCurrentValue=" + this.b + ", mGoalValue=" + this.j + ", mComparedTopContent='" + this.e + "', mComparedValue=" + this.f12915a + ", mComparedTopContent='" + this.e + "'}";
    }
}
