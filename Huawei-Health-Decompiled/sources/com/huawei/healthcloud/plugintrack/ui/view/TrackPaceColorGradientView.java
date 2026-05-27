package com.huawei.healthcloud.plugintrack.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.health.R;
import defpackage.mgx;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class TrackPaceColorGradientView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3941a;
    private LinearGradient b;
    private Paint c;
    private boolean d;
    private int[] e;
    private RectF g;

    public TrackPaceColorGradientView(Context context) {
        this(context, null);
    }

    public TrackPaceColorGradientView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackPaceColorGradientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = false;
        this.f3941a = context.getResources().getDimension(R.dimen._2131362622_res_0x7f0a033e);
        this.g = new RectF();
    }

    public void setColors(List<Integer> list) {
        if (mgx.d(list)) {
            return;
        }
        this.e = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.e[i] = list.get(i).intValue();
        }
    }

    public void setRadius(float f) {
        this.f3941a = f;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b();
        bpu_(canvas);
    }

    private void bpu_(Canvas canvas) {
        if (this.c == null) {
            return;
        }
        this.g.left = 0.0f;
        this.g.top = 0.0f;
        this.g.right = getWidth();
        this.g.bottom = getHeight();
        RectF rectF = this.g;
        float f = this.f3941a;
        canvas.drawRoundRect(rectF, f, f, this.c);
    }

    private void b() {
        int[] iArr = this.e;
        if (iArr == null || iArr.length == 0 || this.d) {
            return;
        }
        this.d = true;
        Paint paint = new Paint();
        this.c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.c.setPathEffect(new CornerPathEffect(this.f3941a));
        this.c.setAntiAlias(true);
        int[] iArr2 = this.e;
        if (iArr2.length > 1) {
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), this.e, (float[]) null, Shader.TileMode.MIRROR);
            this.b = linearGradient;
            this.c.setShader(linearGradient);
            return;
        }
        this.c.setColor(iArr2[0]);
    }
}
