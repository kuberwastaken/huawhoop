package defpackage;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.Log;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartRateThresholdConfig;

/* JADX INFO: loaded from: classes7.dex */
public class peo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f16659a;
    private float b;
    private float c;
    private float d;
    private float f;
    private float g;
    private float i;
    private float j;
    private Matrix e = new Matrix();
    private int m = 40;
    private int h = HeartRateThresholdConfig.HEART_RATE_LIMIT;

    public void e(float f, float f2, float f3, float f4) {
        this.f16659a = f;
        this.c = f2;
        this.b = f3;
        this.d = f4;
    }

    public void c(float f, float f2, float f3, float f4) {
        this.g = f;
        this.j = f2;
        this.f = f3;
        this.i = f4;
    }

    public void e(int i, int i2) {
        this.m = i;
        this.h = i2;
    }

    public void c() {
        this.e.reset();
        float[] fArr = {0.0f, this.h, 501.0f, this.m};
        this.e.postTranslate(-this.f16659a, -this.b);
        this.e.mapPoints(fArr);
        Log.i("ChartContentTransform", "matrix anchor(postTranslate -mDataAreaMinX,-mDataAreaMinY):" + fArr[0] + " " + fArr[1] + " " + fArr[2] + " " + fArr[3]);
        this.e.postScale(1.0f, -1.0f);
        this.e.mapPoints(fArr);
        Log.i("ChartContentTransform", "matrix anchor(postScale 1 -1):" + fArr[0] + " " + fArr[1] + " " + fArr[2] + " " + fArr[3]);
        float f = this.d - this.b;
        this.e.postTranslate(0.0f, f);
        this.e.mapPoints(fArr);
        Log.i("ChartContentTransform", "matrix anchor(postTranslate 0 dataAreaHeight):" + fArr[0] + " " + fArr[1] + " " + fArr[2] + " " + fArr[3]);
        this.e.postScale((this.j - this.g) / (this.c - this.f16659a), (this.i - this.f) / f);
        this.e.mapPoints(fArr);
        Log.i("ChartContentTransform", "matrix anchor(postScale drawingAreaWidth/dataAreaWidth drawingAreaHeight/dataAreaHeight):" + fArr[0] + " " + fArr[1] + " " + fArr[2] + " " + fArr[3]);
    }

    public void a(float[] fArr) {
        this.e.mapPoints(fArr);
    }

    public void cKv_(RectF rectF) {
        this.e.mapRect(rectF);
    }
}
