package com.huawei.ui.commonui.viewpager.pagetransformer;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes7.dex */
public class OverlayLayerPageTransformer implements ViewPager.PageTransformer {
    private final c b;

    public OverlayLayerPageTransformer(c cVar) {
        if (cVar == null) {
            LogUtil.b("OverlayLayerPageTransformer", "OverlayLayerPageTransformer builder is null");
            this.b = new c();
        } else {
            this.b = cVar;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        float fB;
        float fA;
        int iCompare = Float.compare(f, 0.0f);
        if (iCompare == -1 || iCompare == 0) {
            view.setClickable(true);
            view.setVisibility(0);
            view.setTranslationX(0.0f);
            float fAbs = 1.0f - (Math.abs(f) * 0.5f);
            view.setAlpha(fAbs);
            view.setScaleX(fAbs);
            view.setScaleY(fAbs);
            return;
        }
        view.setClickable(false);
        int iC = this.b.c();
        int iCompare2 = Float.compare(f, iC - 1);
        int width = view.getWidth();
        float fE = this.b.e();
        if (iCompare2 == 1 && Float.compare(f, iC) == -1) {
            view.setVisibility(0);
            double d = fE;
            float fFloor = (float) (Math.floor(f - 1.0f) * d);
            view.setTranslationX(((-width) * f) + fFloor + ((1.0f - (f % ((int) f))) * (((float) (Math.floor(f) * d)) - fFloor)));
            view.setAlpha((float) Math.max(Math.pow(this.b.d(), f * f * f), 0.10000000149011612d));
        } else if (iCompare2 == 0 || iCompare2 == -1) {
            view.setVisibility(0);
            view.setTranslationX(((-width) * f) + (fE * f));
            view.setAlpha((float) Math.max(Math.pow(this.b.d(), f * f * f), 0.10000000149011612d));
        } else {
            view.setAlpha(0.0f);
        }
        if (width > 0) {
            float f2 = width;
            fB = (f2 - (this.b.b() * f)) / f2;
        } else {
            fB = 0.0f;
        }
        int height = view.getHeight();
        if (height > 0) {
            float f3 = height;
            fA = (f3 - (this.b.a() * f)) / f3;
        } else {
            fA = 0.0f;
        }
        if (fB > 0.0f && fA > 0.0f) {
            view.setScaleX(fB);
            view.setScaleY(fA);
            return;
        }
        if (fB <= 0.0f) {
            if (fA <= 0.0f) {
                LogUtil.b("OverlayLayerPageTransformer", "transformPage scaleX ", Float.valueOf(fB), " scaleY ", Float.valueOf(fA), " position ", Float.valueOf(f), " view ", view);
                return;
            }
            fB = fA;
        }
        view.setScaleX(fB);
        view.setScaleY(fB);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9359a;
        private int b;
        private int c;
        private int d;
        private float e;

        private c() {
            this.d = 3;
            this.f9359a = 100;
            this.c = 100;
            this.b = 100;
            this.e = 0.5f;
        }

        public c(int i) {
            this.f9359a = 100;
            this.c = 100;
            this.b = 100;
            this.e = 0.5f;
            this.d = i;
        }

        public int c() {
            return this.d;
        }

        public int e() {
            return this.f9359a;
        }

        public c e(int i) {
            this.f9359a = i;
            return this;
        }

        public int b() {
            return this.c;
        }

        public c d(int i) {
            this.c = i;
            return this;
        }

        public int a() {
            return this.b;
        }

        public c c(int i) {
            this.b = i;
            return this;
        }

        public float d() {
            return this.e;
        }

        public c c(float f) {
            this.e = f;
            return this;
        }
    }
}
