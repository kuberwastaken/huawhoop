package defpackage;

import android.text.SpannableString;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class fds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f12920a;
    private a b;
    private float c;
    private a d;
    private View.OnClickListener e;
    private int f;
    private b g;
    private final c[] h = new c[3];
    private boolean i;
    private View.OnClickListener j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12921a;
        public String b;
        public int c;
        public String d;
        public View.OnClickListener e;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12922a;
        public String b;
        public boolean c;
        public String d;
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SpannableString f12923a;
        public int[] b;
        public int[] c;
        public String d;
        public View.OnClickListener e;
        public int f;
        public int g;
        public int i;
        public int j;
    }

    public float a() {
        return this.c;
    }

    public void d(float f) {
        this.c = f;
    }

    public float d() {
        return this.f12920a;
    }

    public a c() {
        return this.d;
    }

    public void c(a aVar) {
        this.d = aVar;
    }

    public a e() {
        return this.b;
    }

    public void e(a aVar) {
        this.b = aVar;
    }

    public c a(int i) {
        if (i > 2) {
            return new c();
        }
        return this.h[i];
    }

    public void a(int i, c cVar) {
        this.h[i] = cVar;
    }

    public void e(float f) {
        this.f12920a = f;
    }

    public void d(boolean z) {
        this.i = z;
    }

    public boolean h() {
        return this.i;
    }

    public View.OnClickListener ajo_() {
        return this.e;
    }

    public void ajq_(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public b j() {
        return this.g;
    }

    public void c(b bVar) {
        this.g = bVar;
    }

    public int g() {
        return this.f;
    }

    public void e(int i) {
        this.f = i;
    }

    public View.OnClickListener ajp_() {
        return this.j;
    }

    public void ajr_(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public String toString() {
        return "SectionActiveThreeCircleBean{, mDistance=" + this.c + ", mClimbs=" + this.f12920a + ", mIsSupportFloor=" + this.i + ", mPushesVal=" + this.f + '}';
    }
}
