package com.huawei.haf.mediaprocess;

import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes.dex */
public class VideoProgress {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f2172a;
    private Float b;
    private float c;
    private VideoProgressListener d;
    private int e;
    private int i;

    public void c(long j) {
        if (this.d == null) {
            return;
        }
        Float f = this.b;
        if (f != null) {
            j = (long) (j * f.floatValue());
        }
        int i = this.e - this.i;
        if (i != 0) {
            float f2 = (j / 1000.0f) / i;
            this.f2172a = f2;
            float fMax = Math.max(f2, 0.0f);
            this.f2172a = fMax;
            float fMin = Math.min(fMax, 1.0f);
            this.f2172a = fMin;
            this.d.onProgress((fMin + this.c) / 2.0f);
            LogUtil.a("VideoProgress", "mEncodeProgress:", Float.valueOf(this.f2172a));
        }
    }

    public void c(float f) {
        this.c = f;
        VideoProgressListener videoProgressListener = this.d;
        if (videoProgressListener != null) {
            videoProgressListener.onProgress((this.f2172a + f) / 2.0f);
        }
        LogUtil.a("VideoProgress", "mAudioProgress:", Float.valueOf(this.c));
    }
}
