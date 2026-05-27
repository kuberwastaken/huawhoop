package com.huawei.health.knit.section.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.huawei.health.R;
import com.huawei.ui.commonui.R$color;

/* JADX INFO: loaded from: classes4.dex */
public class SectionMapMaskView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RectF f2762a;
    private Paint b;
    private PorterDuffXfermode c;
    private float d;
    private int e;

    public SectionMapMaskView(Context context) {
        super(context);
        this.f2762a = new RectF();
        this.b = new Paint();
        this.c = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.e = -1;
        a(context);
    }

    public SectionMapMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2762a = new RectF();
        this.b = new Paint();
        this.c = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.e = -1;
        a(context);
    }

    public SectionMapMaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2762a = new RectF();
        this.b = new Paint();
        this.c = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.e = -1;
        a(context);
    }

    private void a(Context context) {
        this.d = context.getResources().getDimension(R.dimen._2131362970_res_0x7f0a049a);
        this.e = context.getResources().getColor(R$color.colorSubBackground);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        float f = width;
        float height = getHeight();
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, f, height, null, 31);
        this.b.setStyle(Paint.Style.FILL_AND_STROKE);
        this.b.setStrokeWidth(0.0f);
        this.b.setAntiAlias(true);
        this.b.setColor(this.e);
        canvas.drawRect(0.0f, 0.0f, f, height, this.b);
        this.b.setXfermode(this.c);
        this.b.setColor(-16777216);
        this.f2762a.left = 2.0f;
        this.f2762a.right = width - 4;
        this.f2762a.top = 2.0f;
        this.f2762a.bottom = r1 - 4;
        RectF rectF = this.f2762a;
        float f2 = this.d;
        canvas.drawRoundRect(rectF, f2, f2, this.b);
        this.b.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }
}
