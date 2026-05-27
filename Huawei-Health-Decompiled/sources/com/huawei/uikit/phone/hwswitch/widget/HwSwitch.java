package com.huawei.uikit.phone.hwswitch.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.huawei.health.R;

/* JADX INFO: loaded from: classes8.dex */
public class HwSwitch extends com.huawei.uikit.hwswitch.widget.HwSwitch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11292a;
    private int b;
    private int d;
    private Paint e;

    public HwSwitch(Context context) {
        this(context, null);
    }

    @Override // com.huawei.uikit.hwswitch.widget.HwSwitch, android.widget.Switch, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        super.onDraw(canvas);
        if (isFocused() && this.c != null && hasWindowFocus()) {
            Rect bounds = this.c.getBounds();
            this.e.setStrokeWidth(this.b);
            int i = bounds.left;
            int i2 = this.f11292a;
            int i3 = bounds.top;
            int i4 = this.d;
            RectF rectF = new RectF(i - i2, i3 - i4, bounds.right + i2, bounds.bottom + i4);
            float f = ((bounds.bottom - bounds.top) / 2) + this.d;
            canvas.drawRoundRect(rectF, f, f, this.e);
        }
    }

    public HwSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100778_res_0x7f06046a);
    }

    private void c() {
        setDefaultFocusHighlightEnabled(false);
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setColor(getFocusedPathColor());
        this.d = (int) getResources().getDimension(R.dimen._2131364549_res_0x7f0a0ac5);
        this.b = (int) getResources().getDimension(R.dimen._2131364548_res_0x7f0a0ac4);
        a();
    }

    public HwSwitch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        c();
    }

    protected void a() {
        this.f11292a = (int) (getResources().getDimension(R.dimen._2131364547_res_0x7f0a0ac3) - (getResources().getDimension(R.dimen._2131364553_res_0x7f0a0ac9) / 24.0f));
    }
}
