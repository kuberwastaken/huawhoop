package defpackage;

import android.graphics.drawable.Drawable;
import com.huawei.ui.commonui.R$color;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class piv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f16721a;
    private float b;
    private Drawable c;
    private Drawable d;
    private int e;
    private int f;
    private int g;
    private int i;
    private float k;
    private float l;
    private float m;
    private String n;
    private final List<String> j = new ArrayList();
    private final List<Integer> h = new ArrayList();

    public piv(boolean z) {
        this.f16721a = z;
        if (z) {
            this.e = R$color.circle_scale_mini_cursor;
        }
        this.g = R$color.circle_scale_ring_start;
        this.i = R$color.circle_scale_ring_center;
        this.f = R$color.circle_scale_ring_end;
    }

    public boolean l() {
        return this.f16721a;
    }

    public int e() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public int f() {
        return this.g;
    }

    public int d() {
        return this.i;
    }

    public int g() {
        return this.f;
    }

    public void b(int i) {
        this.g = i;
        this.i = i;
        this.f = i;
    }

    public void a(int i, int i2, int i3) {
        this.g = i;
        this.i = i2;
        this.f = i3;
    }

    public float a() {
        return this.b;
    }

    public void d(float f) {
        this.b = f;
    }

    public float o() {
        return this.k;
    }

    public float h() {
        return this.l;
    }

    public void b(float f, float f2) {
        this.k = f;
        this.l = f2;
    }

    public String n() {
        return this.n;
    }

    public void c(String str) {
        this.n = str;
    }

    public List<String> i() {
        return this.j;
    }

    public void e(List<String> list) {
        this.j.clear();
        this.j.addAll(list);
    }

    public List<Integer> j() {
        return this.h;
    }

    public void c(List<Integer> list) {
        this.h.clear();
        this.h.addAll(list);
    }

    public float m() {
        return this.m;
    }

    public void a(float f) {
        this.m = f;
    }

    public Drawable cQr_() {
        return this.d;
    }

    public void cQt_(Drawable drawable) {
        this.d = drawable;
    }

    public Drawable cQs_() {
        return this.c;
    }

    public void cQu_(Drawable drawable) {
        this.c = drawable;
    }

    public String toString() {
        return "CircleScaleRulerData{mIsMini=" + this.f16721a + ", mMiniCursorColor=" + this.e + ", mRingStartColor=" + this.g + ", mRingCentreColor=" + this.i + ", mRingEndColor=" + this.f + ", mCursorAngle=" + this.b + ", mScopeStartAngle=" + this.k + ", mScopeEndAngle=" + this.l + ", mScopeText=" + this.n + ", mRulerTextList=" + this.j + ", mRulerHighlightIndexList=" + this.h + ", mZoomScale=" + this.m + ", mBackground=" + this.d + ", mCursor=" + this.c + '}';
    }
}
