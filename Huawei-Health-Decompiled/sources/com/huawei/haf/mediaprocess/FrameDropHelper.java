package com.huawei.haf.mediaprocess;

import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes.dex */
public class FrameDropHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2167a;
    private boolean b;
    private int c;
    private int d;
    private int e;

    public FrameDropHelper(int i, int i2) {
        this.b = true;
        this.c = i;
        this.e = i2;
        if (i <= i2) {
            LogUtil.d("FrameDropHelper", "srcFrameRate:", Integer.valueOf(i), " dstFrameRate:", Integer.valueOf(i2), "，not support frame interpolation");
            this.b = false;
        }
    }

    public boolean e(int i) {
        if (!this.b) {
            return false;
        }
        if (i == 0) {
            this.f2167a++;
            return false;
        }
        float f = (r7 - this.e) / this.c;
        int i2 = this.d;
        int i3 = this.f2167a + i2;
        if (i3 != 0) {
            float f2 = i3;
            z = Math.abs((((float) (i2 + 1)) / f2) - f) < Math.abs((((float) i2) / ((float) (i3 + 1))) - f);
            if (z) {
                this.d++;
            } else {
                this.f2167a++;
            }
            LogUtil.a("FrameDropHelper", "current frame drop rate:", Float.valueOf(this.d / f2), " target frame drop rate:", Float.valueOf(f));
        }
        return z;
    }
}
