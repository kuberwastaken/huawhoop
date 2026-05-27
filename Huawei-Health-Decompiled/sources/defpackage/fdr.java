package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class fdr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12918a;
    private int b;
    private int c;
    private View.OnClickListener d;

    public int c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public int b() {
        return this.f12918a;
    }

    public View.OnClickListener ajv_() {
        return this.d;
    }

    private fdr(d dVar) {
        this.b = dVar.e;
        this.c = dVar.d;
        this.f12918a = dVar.f12919a;
        this.d = dVar.b;
    }

    /* JADX INFO: loaded from: classes10.dex */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f12919a;
        private View.OnClickListener b;
        private int d;
        private int e;

        public d a(int i) {
            this.e = i;
            return this;
        }

        public d d(int i) {
            this.d = i;
            return this;
        }

        public d e(int i) {
            this.f12919a = i;
            return this;
        }

        public d ajx_(View.OnClickListener onClickListener) {
            this.b = onClickListener;
            return this;
        }

        public fdr d() {
            return new fdr(this);
        }
    }
}
