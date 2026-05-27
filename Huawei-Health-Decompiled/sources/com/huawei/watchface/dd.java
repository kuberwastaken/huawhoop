package com.huawei.watchface;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import com.huawei.watchface.utils.HwLog;
import huawei.android.hwcolorpicker.HwColorPicker;

/* JADX INFO: loaded from: classes8.dex */
public class dd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f11491a;
    private int b;
    private int c;
    private int d;
    private int e;
    private float[] f;
    private float[] g;
    private float[] h;
    private float[] i;

    public dd(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.b = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.c = height;
        this.f11491a = new int[this.b * height];
        HwLog.i("AreaAveragingUtil", "AreaAveragingUtil() bitmap : { mSrcWidth：" + this.b + ", mSrcHeight:" + this.c + "}");
        int[] iArr = this.f11491a;
        int i = this.b;
        bitmap.getPixels(iArr, 0, i, 0, 0, i, this.c);
    }

    public Bitmap a(int i, int i2) {
        this.d = i;
        this.e = i2;
        int i3 = this.b;
        this.g = new float[i3];
        this.h = new float[i3];
        this.i = new float[i3];
        this.f = new float[i3];
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        a(0, this.b, this.c, bitmapCreateBitmap);
        HwLog.i("AreaAveragingUtil", "getScaledBitmap() bitmap : {width:" + i + ", height:" + i2 + "}");
        return bitmapCreateBitmap;
    }

    private void a(int i, int i2, int i3, Bitmap bitmap) {
        int i4 = this.e;
        int i5 = i;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i + i3) {
            float fB = 0.0f;
            if (i6 == 0) {
                for (int i8 = 0; i8 < this.d; i8++) {
                    if (i8 < this.b) {
                        this.f[i8] = 0.0f;
                        this.g[i8] = 0.0f;
                        this.h[i8] = 0.0f;
                        this.i[i8] = 0.0f;
                    }
                }
                i6 = this.c;
            }
            int i9 = i4 < i6 ? i4 : i6;
            int i10 = i2;
            float fD = 0.0f;
            float fE = 0.0f;
            int i11 = this.b;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            float fC = 0.0f;
            while (i12 < i10) {
                if (i13 == 0) {
                    i13 = this.d;
                    fB = b(i12, i5);
                    fC = c(i12, i5);
                    fD = d(i12, i5);
                    fE = e(i12, i5);
                    if (fB != 255.0f) {
                        float f = fB / 255.0f;
                        fC *= f;
                        fD *= f;
                        fE *= f;
                    }
                }
                int i15 = i7;
                int i16 = i13 < i11 ? i13 : i11;
                float f2 = i16 * i9;
                float[] fArr = this.f;
                fArr[i14] = fArr[i14] + (f2 * fB);
                float[] fArr2 = this.g;
                fArr2[i14] = fArr2[i14] + (f2 * fC);
                float[] fArr3 = this.h;
                fArr3[i14] = fArr3[i14] + (f2 * fD);
                float[] fArr4 = this.i;
                fArr4[i14] = fArr4[i14] + (f2 * fE);
                i13 -= i16;
                if (i13 == 0) {
                    i12++;
                }
                i11 -= i16;
                if (i11 == 0) {
                    i14++;
                    i11 = this.b;
                }
                i10 = i2;
                i7 = i15;
            }
            int i17 = i7;
            i6 -= i9;
            if (i6 == 0) {
                i7 = i17;
                do {
                    a(i7, bitmap);
                    i7++;
                    i4 -= i9;
                    if (i4 < i9) {
                        break;
                    }
                } while (i9 == this.c);
            } else {
                i4 -= i9;
                i7 = i17;
            }
            if (i4 == 0) {
                i4 = this.e;
                i5++;
            }
        }
    }

    private void a(int i, Bitmap bitmap) {
        float f;
        float f2 = this.b * this.c;
        for (int i2 = 0; i2 < this.b; i2++) {
            int iRound = Math.round(this.f[i2] / f2);
            int i3 = 255;
            if (iRound <= 0) {
                f = f2;
                iRound = 0;
            } else if (iRound >= 255) {
                f = f2;
                iRound = 255;
            } else {
                f = this.f[i2] / 255.0f;
            }
            int iRound2 = Math.round(this.g[i2] / f);
            if (iRound2 < 0) {
                iRound2 = 0;
            }
            if (iRound2 > 255) {
                iRound2 = 255;
            }
            int iRound3 = Math.round(this.h[i2] / f);
            if (iRound3 < 0) {
                iRound3 = 0;
            }
            if (iRound3 > 255) {
                iRound3 = 255;
            }
            int iRound4 = Math.round(this.i[i2] / f);
            if (iRound4 < 0) {
                iRound4 = 0;
            }
            if (iRound4 <= 255) {
                i3 = iRound4;
            }
            a(bitmap, i2, i, (iRound << 24) + (iRound2 << 16) + (iRound3 << 8) + i3);
        }
    }

    private void a(Bitmap bitmap, int i, int i2, int i3) {
        this.f11491a[(this.b * i2) + i] = i3;
        if (i >= this.d || i2 >= this.e) {
            return;
        }
        bitmap.setPixel(i, i2, i3);
    }

    private int b(int i, int i2) {
        return (this.f11491a[(i2 * this.b) + i] & (-16777216)) >>> 24;
    }

    private int c(int i, int i2) {
        return (this.f11491a[(i2 * this.b) + i] & HwColorPicker.MASK_RESULT_STATE) >>> 16;
    }

    private int d(int i, int i2) {
        return (this.f11491a[(i2 * this.b) + i] & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8;
    }

    private int e(int i, int i2) {
        return this.f11491a[(i2 * this.b) + i] & 255;
    }
}
