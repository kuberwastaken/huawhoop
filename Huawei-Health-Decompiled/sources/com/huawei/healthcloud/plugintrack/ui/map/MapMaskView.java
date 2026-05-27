package com.huawei.healthcloud.plugintrack.ui.map;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.huawei.health.R;

/* JADX INFO: loaded from: classes10.dex */
public class MapMaskView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f3901a;
    private int b;
    private RectF c;
    private PorterDuffXfermode d;
    private float e;

    public MapMaskView(Context context) {
        super(context);
        this.c = new RectF();
        this.f3901a = new Paint();
        this.d = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.b = -1;
        a(context);
    }

    public MapMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new RectF();
        this.f3901a = new Paint();
        this.d = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.b = -1;
        a(context);
    }

    public MapMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new RectF();
        this.f3901a = new Paint();
        this.d = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.b = -1;
        a(context);
    }

    private void a(Context context) {
        this.e = context.getResources().getDimension(R.dimen._2131362010_res_0x7f0a00da);
        this.b = context.getResources().getColor(R.color._2131296700_res_0x7f0901bc);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        float f = width;
        float height = getHeight();
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, f, height, null, 31);
        this.f3901a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f3901a.setStrokeWidth(0.0f);
        this.f3901a.setAntiAlias(true);
        this.f3901a.setColor(this.b);
        canvas.drawRect(0.0f, 0.0f, f, height, this.f3901a);
        this.f3901a.setXfermode(this.d);
        this.f3901a.setColor(-16777216);
        this.c.left = 2.0f;
        this.c.right = width - 4;
        this.c.top = 2.0f;
        this.c.bottom = r1 - 4;
        RectF rectF = this.c;
        float f2 = this.e;
        canvas.drawRoundRect(rectF, f2, f2, this.f3901a);
        this.f3901a.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }
}
