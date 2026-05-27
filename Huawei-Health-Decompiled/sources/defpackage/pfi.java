package defpackage;

import android.content.Context;
import android.graphics.Typeface;

/* JADX INFO: loaded from: classes7.dex */
public class pfi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f16675a;
    private float b = 1.0f;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private float i;
    private float j;
    private int k;
    private int l;
    private boolean m;
    private CharSequence n;
    private float o;
    private int r;
    private Typeface s;
    private float t;

    public boolean g() {
        return this.m;
    }

    public void c(boolean z) {
        this.m = z;
    }

    public float h() {
        float f = this.o;
        return f <= 0.0f ? pla.b(this.l) : f;
    }

    public void c(int i) {
        this.l = i;
    }

    public int b(Context context) {
        int i = this.f;
        return i == 0 ? pla.c(context, this.k) : i;
    }

    public void b(int i) {
        this.k = i;
    }

    public float b() {
        return this.b;
    }

    public Typeface cLO_() {
        return this.s;
    }

    public CharSequence c() {
        return this.n;
    }

    public void e(CharSequence charSequence) {
        this.n = charSequence;
    }

    public float i() {
        float f = this.t;
        return f == 0.0f ? pla.b(this.r) : f;
    }

    public int e(Context context) {
        int i = this.d;
        return i == 0 ? pla.c(context, this.c) : i;
    }

    public void a(int i) {
        this.d = i;
    }

    public float e() {
        float f = this.f16675a;
        return f <= 0.0f ? pla.b(this.e) : f;
    }

    public void e(float f) {
        this.f16675a = f;
    }

    public float d() {
        float f = this.j;
        return f == 0.0f ? pla.b(this.g) : f;
    }

    public void c(float f) {
        this.j = f;
    }

    public float a() {
        float f = this.i;
        return f <= 0.0f ? pla.b(this.h) : f;
    }

    public void a(float f) {
        this.i = f;
    }

    public String toString() {
        return "TextData{mIsBelow=" + this.m + ", mSize=" + this.o + ", mSizeId=" + this.l + ", mColor=" + this.f + ", mColorId=" + this.k + ", mAlpha=" + this.b + ", mTypeface=" + this.s + ", mContent=" + ((Object) this.n) + ", mVerticalOffset=" + this.t + ", mVerticalOffsetId=" + this.r + ", mBackgroundColor=" + this.d + ", mBackgroundColorId=" + this.c + ", mBackgroundHeight=" + this.f16675a + ", mBackgroundHeightId=" + this.e + ", mBackgroundVerticalOffset=" + this.j + ", mBackgroundVerticalOffsetId=" + this.g + ", mBackgroundRoundCornerRadius=" + this.i + ", mBackgroundRoundCornerRadiusId=" + this.h + '}';
    }
}
