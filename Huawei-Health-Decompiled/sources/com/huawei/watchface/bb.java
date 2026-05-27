package com.huawei.watchface;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;
import com.huawei.watchface.utils.HwLog;

/* JADX INFO: loaded from: classes8.dex */
public class bb extends az {
    private Bitmap l;
    private Canvas m;

    public bb(Bitmap bitmap) {
        super(bitmap);
        this.i = FitnessSleepType.HW_FITNESS_WAKE;
        this.l = Bitmap.createBitmap(this.i, this.i, Bitmap.Config.ARGB_8888);
        this.m = new Canvas(this.l);
    }

    @Override // com.huawei.watchface.az
    public void a(Point point) {
        if (point == null) {
            HwLog.e("RadialKaleidoscopeView", "trajectoryPoint is null.");
        } else {
            super.a(point);
            a(this.e, this.m, this.l, this.d, this.c);
        }
    }
}
