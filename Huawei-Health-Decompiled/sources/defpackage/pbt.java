package defpackage;

import androidx.media3.datasource.cache.CacheDataSink;

/* JADX INFO: loaded from: classes7.dex */
public class pbt {
    private int e = 1;
    private int i = 60;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16612a = 170;
    private int b = CacheDataSink.DEFAULT_BUFFER_SIZE;
    private int g = 110;
    private int d = 720;
    private int h = 5;
    private int c = 20;

    public boolean c(int i, int i2, int i3) {
        if (i < 0 || i > 2 || i2 < 30 || i2 > 200 || i3 < 100 || i3 > 300) {
            return false;
        }
        this.e = i;
        this.i = i2;
        this.f16612a = i3;
        return true;
    }

    public boolean e(int[] iArr) {
        if (iArr == null || iArr.length != 5) {
            return false;
        }
        for (int i : iArr) {
            if (i <= 0) {
                return false;
            }
        }
        this.b = iArr[0];
        this.g = iArr[1];
        this.d = iArr[2];
        this.h = iArr[3];
        this.c = iArr[4];
        return true;
    }

    public int[] b() {
        return new int[]{this.e, this.i, this.f16612a, this.b, this.g, this.d, this.h, this.c};
    }
}
