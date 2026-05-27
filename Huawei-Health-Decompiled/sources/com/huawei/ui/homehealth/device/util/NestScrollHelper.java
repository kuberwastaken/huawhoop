package com.huawei.ui.homehealth.device.util;

import android.content.Context;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes7.dex */
public class NestScrollHelper {
    private static final float c = ViewConfiguration.getScrollFriction();
    private static final float d = (float) (Math.log(0.78d) / Math.log(0.9d));
    private float e;

    public NestScrollHelper(Context context) {
        this.e = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
    }

    private double b(double d2) {
        return Math.log((Math.abs(d2) * 0.3499999940395355d) / ((double) (c * this.e)));
    }

    private double c(double d2) {
        double d3 = d;
        return ((d3 - 1.0d) * Math.log(d2 / ((double) (c * this.e)))) / d3;
    }

    public double b(int i) {
        double dB = b(i);
        double d2 = d;
        return ((double) (c * this.e)) * Math.exp((d2 / (d2 - 1.0d)) * dB);
    }

    public double d(double d2) {
        return Math.abs(((Math.exp(c(d2)) * ((double) c)) * ((double) this.e)) / 0.3499999940395355d);
    }

    public double e(double d2) {
        return Math.exp(b(d2) / (((double) d) - 1.0d)) * 1000.0d;
    }
}
