package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes7.dex */
class per {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private peq f16660a;
    private Paint b = new Paint();
    private Paint c = new Paint();
    private Path d;

    per(peq peqVar) {
        this.f16660a = peqVar;
        this.b.setColor(Color.argb(51, 255, 255, 255));
        this.c.setColor(Color.argb(25, 255, 255, 255));
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setPathEffect(new DashPathEffect(new float[]{10.0f, 10.0f}, 0.0f));
        float fB = pet.b(0.25f);
        this.b.setStrokeWidth(fB < 1.0f ? 1.0f : fB);
        this.d = new Path();
    }

    public void cKA_(Canvas canvas) {
        float[] fArr = new float[5];
        RectF rectFCKB_ = this.f16660a.cKB_();
        for (int i = 0; i < 5; i++) {
            fArr[i] = rectFCKB_.top + (((rectFCKB_.bottom - rectFCKB_.top) / 4) * i);
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (i2 == 0 || 4 == i2) {
                canvas.drawLine(rectFCKB_.left, fArr[i2], rectFCKB_.right, fArr[i2], this.b);
            } else {
                this.d.reset();
                this.d.moveTo(rectFCKB_.left, fArr[i2]);
                this.d.lineTo(rectFCKB_.right, fArr[i2]);
                canvas.drawPath(this.d, this.c);
            }
        }
    }
}
